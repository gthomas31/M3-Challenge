import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Problem2Model {
	
	// excel variables
	private int min, max;
	private String pageName;
	private int maxStations;
	
	// Route class
	Route route;
	
	// static variables
	private double electricRange; // depends on the kind of semitruck
	
	public Problem2Model(double miles) {
	route = new Route(miles);
	electricRange = 0;
	min = max = 0;
	pageName = "";
	maxStations = 0;
	}
	
	public ArrayList<Double> importExcel(String fileName, String pageName, int rowStart, int rowEnd, int column) throws IOException {
		ArrayList<Double> list = new ArrayList<Double>();
		XSSFWorkbook excelBook = new XSSFWorkbook(new FileInputStream(fileName));
		XSSFSheet excelSheet = excelBook.getSheet(pageName);
		for (int x = rowStart - 1; x < rowEnd; x++) {
			list.add(excelSheet.getRow(x).getCell(column).getNumericCellValue());
		}
		return list;
	}
	public void setTruckRange(int range) {
		electricRange = range;
	}
	public void setMinMax(int mi, int ma) {
		min = mi;
		max = ma;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public void setPageName(String name) {
		pageName = name;
	}
	public String getPageName() {
		return pageName;
	}
	public void setMaxStations (int m) {
		maxStations = m;
	}
	public int getMaxStations() {
		return maxStations;
	}
	public double getAverageArrayList(ArrayList<Double> list) {
		double sum = 0;
		for (int x = 0; x < list.size(); x++) {
			sum += list.get(x);
		}
		return sum / list.size();
	}
	// distance between stations dependent on electricRange()
	public double stationDistance() {
		double adjustedDistance = (double) (electricRange - electricRange * 0.20); // battery is most efficient between 20% and 80% capacity
			return adjustedDistance;

	}
	
	// the amount of stations that are needed along a route
	public int stationsNeeded() {
		return (int) (route.getMilesApart() / stationDistance()) + 1; // add one to round up instead of down
	}
	
	
	// the amount of chargers needed at each stations
	public ArrayList<Integer> chargersNeeded(int minNumber, int maxNumber, String pageName, int maxStations, double totalStops) throws IOException {
		int chargerAmount = 0;
		ArrayList<Integer> chargerAmountsPerStation = new ArrayList<Integer>();
		ArrayList<Double> miles = importExcel("corridor_data.xlsx", pageName, minNumber, maxNumber, 0);
		ArrayList<Double> AADTTValues = importExcel("corridor_data.xlsx", pageName, minNumber, maxNumber, 3);
		for (int x = 0; x <= stationsNeeded(); x++) {
			for (int y = 0; y < miles.size() - 1; y++) {
				if (stationDistance() * (x+1) > miles.get(y) && stationDistance() * (x+1) < miles.get(y+1)) {
					double AADTT = (AADTTValues.get(y) + AADTTValues.get(y+1)) / 2;
					chargerAmount = (int) ((AADTT / 96) * (totalStops / maxStations)); // formula for amount of chargers
					chargerAmountsPerStation.add(chargerAmount / 2); // dividing by two since charging takes 30 min and the value is for hours
				}
			}
		}
		return chargerAmountsPerStation;
	}
	
	public ArrayList<Integer> chargersNeededEnd(int minNumber, int maxNumber, String pageName, int maxStations, int adjustment, double totalStops) throws IOException {
		int chargerAmount = 0;
		ArrayList<Integer> chargerAmountsPerStation = new ArrayList<Integer>();
		ArrayList<Double> miles = importExcel("corridor_data.xlsx", pageName, minNumber, maxNumber, 0);
		ArrayList<Double> AADTTValues = importExcel("corridor_data.xlsx", pageName, minNumber, maxNumber, 3);
		for (int x = 0; x <= stationsNeeded(); x++) {
			for (int y = 0; y < miles.size() - 1; y++) {
				if (stationDistance() * (x+1) > miles.get(y) - (adjustment * stationDistance()) && stationDistance() * (x+1) < miles.get(y+1) - (adjustment * stationDistance())) {
					double AADTT = (AADTTValues.get(y) + AADTTValues.get(y+1)) / 2;
					chargerAmount = (int) ((AADTT / 96) * (totalStops / maxStations)); // formula for amount of chargers
					chargerAmountsPerStation.add(chargerAmount / 2); // dividing by two since charging takes 30 min and the value is for hours
				}
			}
		}
		return chargerAmountsPerStation;
	}
	
	public int chargersNeededUsingAverage (double average, int maxStations, double totalStops) { //used when the value of AADTT is not known for a state
		return (int) ((average / 96) * (totalStops / maxStations)) / 2;
	}
	
	public String toString() {
		String printOut = "Distance between locations: " + route.getMilesApart() + "\n";
		printOut += "Number of stations needed: " + stationsNeeded() + "\n";
		return printOut;
	}
}
