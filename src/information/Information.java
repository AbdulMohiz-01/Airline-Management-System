package information;

public abstract class Information {
	private String name;
	private Address address;
	private String cnic;
	private String phoneNo;
	public Information(String name, String country, String city, String houseNo, String streetNo, String cnic, String phoneNo) {
		this.name = name;
		this.address = new Address(country, city, houseNo, streetNo);
		this.cnic = cnic;
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
	
}
