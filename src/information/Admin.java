package information;

import java.util.ArrayList;

import filing.FileReading;
import filing.FileWriting;

public class Admin extends Information{

	private String username;
	private String password;
	
	public Admin(String name, String country, String city, String houseNo, String streetNo, String cnic, String phoneNo,
			String username, String password) {
		super(name, country, city, houseNo, streetNo, cnic, phoneNo);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void writeData(ArrayList<Admin> admins , int index) {
		String data = admins.get(index).getName()+","+admins.get(index).getAddress().getCountry()+","+admins.get(index).getAddress().getCity()+","+admins.get(index).getAddress().getHouseNo()+","+admins.get(index).getAddress().getStreetNo()+","+admins.get(index).getCnic()+","+admins.get(index).getPhoneNo()+","+admins.get(index).getUsername()+","+admins.get(index).getPassword()+","+"\n";
		FileWriting.dataWrite(data,"Admin Information");
	}
	public static void refreshData(ArrayList<Admin> admins) {
		String data="";
		for(int index=0;index<admins.size();index++) {
			data += "\n"+admins.get(index).getName()+","+admins.get(index).getAddress().getCountry()+","+admins.get(index).getAddress().getCity()+","+admins.get(index).getAddress().getHouseNo()+","+admins.get(index).getAddress().getStreetNo()+","+admins.get(index).getCnic()+","+admins.get(index).getPhoneNo()+","+admins.get(index).getUsername()+","+admins.get(index).getPassword()+","+"\n";
		}
		FileWriting.refreshData(data, "Admin Information");
	}

	@Override
	public String toString() {
		return "\n\nName: "+super.getName()+"\nCountry: "+super.getAddress().getCountry()+"\nCity: "+super.getAddress().getCity()+"\nHouseNo: "+super.getAddress().getHouseNo()+"\nStreetNo: "+super.getAddress().getStreetNo()+"\nCINC: "+super.getCnic()+"\nPhoneNumber: "+super.getPhoneNo()+"\nUserName: "+getUsername();
	}
	
}
