package information;

import java.util.ArrayList;

import filing.FileWriting;
import plane.Plane;

public class Pilot extends Information{
	private String empID;
	private int salary;
	private boolean Available;

	public Pilot(String name, String country, String city, String houseNo, String streetNo, String cnic, String phoneNo,
			String empID, int salary, boolean notAvailable) {
		super(name, country, city, houseNo, streetNo, cnic, phoneNo);
		this.empID = empID;
		this.salary = salary;
		this.Available = notAvailable;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isAvailable() {
		return Available;
	}

	public void setAvailable(boolean notAvailable) {
		this.Available = notAvailable;
	}
	
	public static void refreshData(ArrayList<Pilot> pilots) {
		String data="";
		for(int i=0;i<pilots.size();i++) {
			data+=pilots.get(i).getName()+","+pilots.get(i).getAddress().getCountry()+","+pilots.get(i).getAddress().getCity()+","+pilots.get(i).getAddress().getHouseNo()+","+pilots.get(i).getAddress().getStreetNo()+","+pilots.get(i).getCnic()+","+pilots.get(i).getPhoneNo()+","+pilots.get(i).getEmpID()+","+pilots.get(i).getSalary()+","+pilots.get(i).Available+","+"\n";
		}
		FileWriting.refreshData(data, "Available Pilot");
	}
	
	public static void writeData(ArrayList<Pilot> pilots, int index) {
		
		String data = pilots.get(index).getName()+","+pilots.get(index).getAddress().getCountry()+","+pilots.get(index).getAddress().getCity()+","+pilots.get(index).getAddress().getHouseNo()+","+pilots.get(index).getAddress().getStreetNo()+","+pilots.get(index).getCnic()+","+pilots.get(index).getPhoneNo()+","+pilots.get(index).getEmpID()+","+pilots.get(index).getSalary()+","+pilots.get(index).Available+","+"\n";
		FileWriting.dataWrite(data, "Available Pilot");
	}
	
}
