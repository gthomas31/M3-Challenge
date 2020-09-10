import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.ArrayList;

public class Problem2Output {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		double total = 0;
		ArrayList<Double> miles = new ArrayList<Double>(); // [SA to/from NO, MIN to/from CHI, BOS to/from HAR, JAX to/from DC, LA to/from SA]
		miles.add(543.3); miles.add(408.0); miles.add(390.4); miles.add(706.2); miles.add(381.9);
		
		// San Antonio to/from New Orleans
		System.out.println("--San Antonio to/from New Orleans--");
		Problem2Model modelSANO = new Problem2Model(miles.get(0));
		// Chanje V8100
		System.out.println("Chanje V8100:");
		modelSANO.setTruckRange(150);
		System.out.println(modelSANO);
		total += modelSANO.stationsNeeded();
		// Freightliner eCascadia
		System.out.println("Freightliner eCascadia:");
		modelSANO.setTruckRange(250);
		System.out.println(modelSANO);
		total += modelSANO.stationsNeeded();
		// Tesla Semi 300
		System.out.println("Tesla Semi 300:");
		modelSANO.setTruckRange(300);
		System.out.println(modelSANO);
		total += modelSANO.stationsNeeded();
		// Tesla Semi 500
		System.out.println("Tesla Semi 500:");
		modelSANO.setTruckRange(500);
		System.out.println(modelSANO);
		total += modelSANO.stationsNeeded();
		// Chargers Needed
		modelSANO.setTruckRange(150);
		System.out.println("Chargers Needed for each station: ");
		modelSANO.setMaxStations(modelSANO.stationsNeeded());
		modelSANO.setMinMax(11, 20);
		modelSANO.setPageName("SanAn_NOLA");
		//Stations
		System.out.println("Station 1: " + modelSANO.chargersNeeded(modelSANO.getMin(), modelSANO.getMax(), modelSANO.getPageName(), modelSANO.getMaxStations(), total).get(0));
		System.out.println("Station 2: " + modelSANO.chargersNeeded(modelSANO.getMin(), modelSANO.getMax(), modelSANO.getPageName(), modelSANO.getMaxStations(), total).get(1));
		for (int x = modelSANO.chargersNeeded(modelSANO.getMin(), modelSANO.getMax(), modelSANO.getPageName(), modelSANO.getMaxStations(), total).size() + 1; x <= modelSANO.getMaxStations(); x++) {
			System.out.println("Station " + x + ": " + modelSANO.chargersNeededUsingAverage(modelSANO.getAverageArrayList(modelSANO.importExcel("corridor_data.xlsx", modelSANO.getPageName(), modelSANO.getMin(), modelSANO.getMax(), 3)), modelSANO.getMaxStations(), total));
		}
		System.out.println("");
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		total = 0;
		// Minneapolis to/from Chicago
		System.out.println("--Minneapolis to/from Chicago--");
		Problem2Model modelMINCHI = new Problem2Model(miles.get(1));
		// Chanje V8100
		System.out.println("Chanje V8100:");
		modelMINCHI.setTruckRange(150);
		System.out.println(modelMINCHI);
		total += modelMINCHI.stationsNeeded();
		// Freightliner eCascadia
		System.out.println("Freightliner eCascadia:");
		modelMINCHI.setTruckRange(250);
		System.out.println(modelMINCHI);
		total += modelMINCHI.stationsNeeded();
		// Tesla Semi 300
		System.out.println("Tesla Semi 300:");
		modelMINCHI.setTruckRange(300);
		System.out.println(modelMINCHI);
		total += modelMINCHI.stationsNeeded();
		// Tesla Semi 500
		System.out.println("Tesla Semi 500:");
		modelMINCHI.setTruckRange(500);
		System.out.println(modelMINCHI);
		total += modelMINCHI.stationsNeeded();
		// Chargers Needed
		modelMINCHI.setTruckRange(150);
		System.out.println("Chargers Needed for each station: ");
		modelMINCHI.setMaxStations(modelMINCHI.stationsNeeded());
		modelMINCHI.setMinMax(12, 14);
		modelMINCHI.setPageName("Minn_Chi");
		//Stations
		for (int x = modelMINCHI.chargersNeeded(modelMINCHI.getMin(), modelMINCHI.getMax(), modelMINCHI.getPageName(), modelMINCHI.getMaxStations(), total).size() + 1; x <= modelMINCHI.getMaxStations(); x++) {
			System.out.println("Station " + x + ": " + modelMINCHI.chargersNeededUsingAverage(modelMINCHI.getAverageArrayList(modelMINCHI.importExcel("corridor_data.xlsx", modelMINCHI.getPageName(), modelMINCHI.getMin(), modelMINCHI.getMax(), 3)), modelMINCHI.getMaxStations(), total));
		}
		System.out.println("");
	
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		total = 0;
		// Boston to/from Harrisburg
		System.out.println("--Boston to/from Harrisburg--");
		Problem2Model modelBOSHAR = new Problem2Model(miles.get(2));
		// Chanje V8100
		System.out.println("Chanje V8100:");
		modelBOSHAR.setTruckRange(150);
		System.out.println(modelBOSHAR);
		total += modelBOSHAR.stationsNeeded();
		// Freightliner eCascadia
		System.out.println("Freightliner eCascadia:");
		modelBOSHAR.setTruckRange(250);
		System.out.println(modelBOSHAR);
		total += modelBOSHAR.stationsNeeded();
		// Tesla Semi 300
		System.out.println("Tesla Semi 300:");
		modelBOSHAR.setTruckRange(300);
		System.out.println(modelBOSHAR);
		total += modelBOSHAR.stationsNeeded();
		// Tesla Semi 500
		System.out.println("Tesla Semi 500:");
		modelBOSHAR.setTruckRange(500);
		System.out.println(modelBOSHAR);
		total += modelBOSHAR.stationsNeeded();
		// Chargers Needed
		modelBOSHAR.setTruckRange(150);
		System.out.println("Chargers Needed for each station: ");
		modelBOSHAR.setMaxStations(modelBOSHAR.stationsNeeded());
		modelBOSHAR.setMinMax(54, 76);
		modelBOSHAR.setPageName("Bos_Hburg");
		//Stations
		System.out.println("Station 1: " + modelBOSHAR.chargersNeededUsingAverage(modelBOSHAR.getAverageArrayList(modelBOSHAR.importExcel("corridor_data.xlsx", modelBOSHAR.getPageName(), modelBOSHAR.getMin(), modelBOSHAR.getMax(), 3)), modelBOSHAR.getMaxStations(), total));
		System.out.println("Station 2: " + modelBOSHAR.chargersNeededUsingAverage((6733.0 + 13821) / 2, modelBOSHAR.getMaxStations(), total));
		System.out.println("Station 3: " + modelBOSHAR.chargersNeededUsingAverage((7030.0 + 10368) / 2, modelBOSHAR.getMaxStations(), total));
		System.out.println("Station 4: " + modelBOSHAR.chargersNeededUsingAverage(modelBOSHAR.getAverageArrayList(modelBOSHAR.importExcel("corridor_data.xlsx", modelBOSHAR.getPageName(), modelBOSHAR.getMin(), modelBOSHAR.getMax(), 3)), modelBOSHAR.getMaxStations(), total));
		System.out.println(""); 
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		total = 0;
		// Jacksonville to/from Washington, DC
		System.out.println("--Jacksonville to/from Washington, DC--");
		Problem2Model modelJAXDC = new Problem2Model(miles.get(3));
		// Chanje V8100
		System.out.println("Chanje V8100:");
		modelJAXDC.setTruckRange(150);
		System.out.println(modelJAXDC);
		total += modelJAXDC.stationsNeeded();
		// Freightliner eCascadia
		System.out.println("Freightliner eCascadia:");
		modelJAXDC.setTruckRange(250);
		System.out.println(modelJAXDC);
		total += modelJAXDC.stationsNeeded();
		// Tesla Semi 300
		System.out.println("Tesla Semi 300:");
		modelJAXDC.setTruckRange(300);
		System.out.println(modelJAXDC);
		total += modelJAXDC.stationsNeeded();
		// Tesla Semi 500
		System.out.println("Tesla Semi 500:");
		modelJAXDC.setTruckRange(500);
		System.out.println(modelJAXDC);
		total += modelJAXDC.stationsNeeded();
		// Chargers Needed
		modelJAXDC.setTruckRange(150);
		System.out.println("Chargers Needed for each station: ");
		modelJAXDC.setMaxStations(modelJAXDC.stationsNeeded());
		modelJAXDC.setMinMax(15, 21);
		modelJAXDC.setPageName("Jax_DC");
		//Stations
		System.out.println("Station 1: " + modelJAXDC.chargersNeeded(modelJAXDC.getMin(), modelJAXDC.getMax(), modelJAXDC.getPageName(), modelJAXDC.getMaxStations(), total).get(0));
		System.out.println("Station 2: " + modelJAXDC.chargersNeededUsingAverage(modelJAXDC.getAverageArrayList(modelJAXDC.importExcel("corridor_data.xlsx", modelJAXDC.getPageName(), modelJAXDC.getMin(), modelJAXDC.getMax(), 3)), modelJAXDC.getMaxStations(), total));
		System.out.println("Station 3: " + modelJAXDC.chargersNeededUsingAverage((7450.0 + 7660) / 2, modelJAXDC.getMaxStations(), total));
		System.out.println("Station 4: " + modelJAXDC.chargersNeededUsingAverage((7480.0 + 7310) / 2, modelJAXDC.getMaxStations(), total));
		System.out.println("Station 5: " + modelJAXDC.chargersNeededUsingAverage((7469.0 + 15972) / 2, modelJAXDC.getMaxStations(), total));
		System.out.println("Station 6: " + modelJAXDC.chargersNeededUsingAverage(modelJAXDC.getAverageArrayList(modelJAXDC.importExcel("corridor_data.xlsx", modelJAXDC.getPageName(), modelJAXDC.getMin(), modelJAXDC.getMax(), 3)), modelJAXDC.getMaxStations(), total));
		System.out.println("");
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		total = 0;
		// Los Angeles to/from San Francisco
		System.out.println("--Los Angeles to/from San Francisco--");
		Problem2Model modelLASF = new Problem2Model(miles.get(4));
		// Chanje V8100
		System.out.println("Chanje V8100:");
		modelLASF.setTruckRange(150);
		System.out.println(modelLASF);
		total += modelLASF.stationsNeeded();
		// Freightliner eCascadia
		System.out.println("Freightliner eCascadia:");
		modelLASF.setTruckRange(250);
		System.out.println(modelLASF);
		total += modelLASF.stationsNeeded();
		// Tesla Semi 300
		System.out.println("Tesla Semi 300:");
		modelLASF.setTruckRange(300);
		System.out.println(modelLASF);
		total += modelLASF.stationsNeeded();
		// Tesla Semi 500
		System.out.println("Tesla Semi 500:");
		modelLASF.setTruckRange(500);
		System.out.println(modelLASF);
		total += modelLASF.stationsNeeded();
		// Chargers Needed
		modelLASF.setTruckRange(150);
		System.out.println("Chargers Needed for each station: ");
		modelLASF.setMaxStations(modelLASF.stationsNeeded());
		modelLASF.setMinMax(13, 50);
		modelLASF.setPageName("LA_SF");
		//Stations
		System.out.println("Station 1: " + modelLASF.chargersNeeded(modelLASF.getMin(), modelLASF.getMax(), modelLASF.getPageName(), modelLASF.getMaxStations(), total).get(0));
		System.out.println("Station 2: " + modelLASF.chargersNeeded(modelLASF.getMin(), modelLASF.getMax(), modelLASF.getPageName(), modelLASF.getMaxStations(), total).get(1));
		System.out.println("Station 3: " + modelLASF.chargersNeededUsingAverage(modelLASF.getAverageArrayList(modelLASF.importExcel("corridor_data.xlsx", modelLASF.getPageName(), modelLASF.getMin(), modelLASF.getMax(), 3)), modelLASF.getMaxStations(), total));
		System.out.println("Station 4: " + modelLASF.chargersNeededUsingAverage(modelLASF.getAverageArrayList(modelLASF.importExcel("corridor_data.xlsx", modelLASF.getPageName(), modelLASF.getMin(), modelLASF.getMax(), 3)), modelLASF.getMaxStations(), total));
		System.out.println("");
	}

}
