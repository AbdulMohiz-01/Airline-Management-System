package plane;

import java.util.ArrayList;

import filing.FileWriting;
import information.Pilot;
import launcher.Functions;
import resources.Date;
import resources.Time;

public class Route {
	private String departure;
	private String arrival;
	private Time time;
	private Date date;
	private Ticket ticket;
	private Plane plane;
	private Pilot pilot;
	private int hoursOfFlight;
	public Route(String departure, String arrival,int hours, int mins,int date, int month, int year, int hoursOfFlight,int priceOfEconomyClass, int priceOfBusinessClass, int priceOfFirstClass) {
		this.departure = departure;
		this.arrival = arrival;
		this.time = new Time(hours,mins);
		this.date = new Date(date,month,year);
		this.ticket = new Ticket(priceOfEconomyClass,priceOfBusinessClass,priceOfFirstClass);
		this.hoursOfFlight = hoursOfFlight;
	}
	
	public int getHoursOfFlight() {
		return hoursOfFlight;
	}

	public void setHoursOfFlight(int hoursOfFlight) {
		this.hoursOfFlight = hoursOfFlight;
	}

	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public Pilot getPilot() {
		return pilot;
	}
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	
	public static  void writeData(ArrayList<Route> routes, int index) {
		String data = "\n"+routes.get(index).getDeparture()+","+routes.get(index).getArrival()+","+routes.get(index).getTime().getHours()+","+routes.get(index).getTime().getMins()+","+routes.get(index).getDate().getDate()+","+routes.get(index).getDate().getMonth()+","+routes.get(index).getDate().getYear()+","+routes.get(index).hoursOfFlight+","+routes.get(index).getTicket().getPriceOfEconomyClass()+","+routes.get(index).getTicket().getPriceOfBusinessClass()+","+routes.get(index).getTicket().getPriceOfFirstClass()+","+Functions.getIndexOfPlane()+","+Functions.getIndexOfPilot()+","+"\n";
		FileWriting.dataWrite(data, "Routes");
	}
	public static void refreshData(ArrayList<Route> routes) {
		String data = "";
		for(int i=0;i<routes.size();i++) {
			data = routes.get(i).getDeparture()+","+routes.get(i).getArrival()+","+routes.get(i).getTime().getHours()+","+routes.get(i).getTime().getMins()+","+routes.get(i).getDate().getDate()+","+routes.get(i).getDate().getMonth()+","+routes.get(i).getDate().getYear()+","+routes.get(i).hoursOfFlight+","+routes.get(i).getTicket().getPriceOfEconomyClass()+","+routes.get(i).getTicket().getPriceOfBusinessClass()+","+routes.get(i).getTicket().getPriceOfFirstClass()+","+Functions.getIndexOfPlane()+","+Functions.getIndexOfPilot()+","+"\n";
		}
		FileWriting.refreshData(data, "Routes");
	}
	@Override
	public String toString() {
		return departure+","+arrival+","+time.getHours()+","+time.getMins()+","+date.getDate()+","+date.getMonth()+","+date.getYear()+","+hoursOfFlight+","+ticket.getPriceOfEconomyClass()+","+ticket.getPriceOfBusinessClass()+","+ticket.getPriceOfFirstClass()+","+Functions.getIndexOfPlane()+","+Functions.getIndexOfPilot()+","+"\n";
				
	}
	
	
	
	
	

	
//	public float RouteTotalCost(int indexOfPlane,ArrayList<Plane> p)
//	{
//		return p.get(indexOfPlane).getFuelCost()*this.time.getHours();
//	}
}
