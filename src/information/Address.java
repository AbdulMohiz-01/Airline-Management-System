package information;

public class Address {
	private String country;
	private String city;
	private String houseNo;
	private String streetNo;
	public Address(String country, String city, String houseNo, String streetNo) {
		this.country = country;
		this.city = city;
		this.houseNo = houseNo;
		this.streetNo = streetNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	
	
}
