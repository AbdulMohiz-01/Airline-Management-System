package plane;

import java.util.ArrayList;

import filing.FileWriting;
import information.Pilot;

public class Plane {
	private String planeName;
	private String planeID;
	private String modelNumber;
	private int economySeats;
	private int businessSeats;
	private int firstSeats;
	private int fuelCost;
	private boolean available;
	private Pilot pilot;
	
	public Plane(String planeName, String planeID, String modelNumber, int economySeats, int businessSeats,int firstSeats, int fuelCost,boolean Available) {
		this.planeName = planeName;
		this.planeID = planeID;
		this.modelNumber = modelNumber;
		this.economySeats = economySeats;
		this.businessSeats = businessSeats;
		this.firstSeats = firstSeats;
		this.fuelCost = fuelCost;
		this.available = Available;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public String getPlaneID() {
		return planeID;
	}
	public void setPlaneID(String planeID) {
		this.planeID = planeID;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public int getEconomySeats() {
		return economySeats;
	}
	public void setEconomySeats(int economySeats) {
		this.economySeats = economySeats;
	}
	public int getBusinessSeats() {
		return businessSeats;
	}
	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}
	public int getFirstSeats() {
		return firstSeats;
	}
	public void setFirstSeats(int firstSeats) {
		this.firstSeats = firstSeats;
	}
	public int getFuelCost() {
		return fuelCost;
	}
	public void setFuelCost(int fuelCost) {
		this.fuelCost = fuelCost;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean notAvailable) {
		this.available = notAvailable;
	}
	/*
	 * Type variable which is used in writeData function actually tells the weather the data needs to OverWrite or just write
	 * 0 for write
	 * 1 for overWrite
	 */
	public static void writeData(ArrayList<Plane> planes, int index) {
		String data= planes.get(index).getPlaneName()+","+planes.get(index).getPlaneID()+","+planes.get(index).getModelNumber()+","+planes.get(index).getEconomySeats()+","+planes.get(index).getBusinessSeats()+","+planes.get(index).getFirstSeats()+","+planes.get(index).getFuelCost()+","+planes.get(index).available+","+"\n";
			FileWriting.dataWrite(data, "Available Plane");
	}
	public static void refreshData(ArrayList<Plane> planes) {
		String data="";
		for(int i=0;i<planes.size();i++) {
			data+=planes.get(i).getPlaneName()+","+planes.get(i).getPlaneID()+","+planes.get(i).getModelNumber()+","+planes.get(i).getEconomySeats()+","+planes.get(i).getBusinessSeats()+","+planes.get(i).getFirstSeats()+","+planes.get(i).getFuelCost()+","+planes.get(i).available+","+"\n";
		}
		FileWriting.refreshData(data, "Available Plane");
	}
	public String displayData() {
		return "\n\nName: " + planeName + "\nID: " + planeID + "\nModelNumber: " + modelNumber
				+ "\nEconomySeats: " + economySeats + "\nBusinessSeats: " + businessSeats + "\nFirstSeats: " + firstSeats
				+ "\nFuelCost: " + fuelCost ;
	}
	
	
	
}
