package launcher;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import filing.*;
import information.Admin;
import information.Passenger;
import information.Pilot;
import plane.Plane;
import plane.Route;


	public class Functions {
	static int indexOfPlane=0;
	static int indexofPilot=0;
	static int indexofAdmin=0;
	static int userBill=0;
	static Scanner sc;
	static int choice;
	static ArrayList<Plane> planes;
	static ArrayList<Route> routes;
	static ArrayList<Pilot> pilots;
	static ArrayList<Admin> admins;
	static ArrayList<Passenger> passengers;
	static ArrayList<Integer> indexes;
	static ArrayList<Integer> selectIndexes;
	static int selection=0;
	public static void run(){
		planes = new ArrayList<>();
		routes = new ArrayList<>();
		pilots = new ArrayList<>();
		admins = new ArrayList<>();
		passengers = new ArrayList<>();
		indexes = new ArrayList<>();
		getDataFromFile();
	}
	public static void getDataFromFile() {
		selectIndexes = new ArrayList<>();
		ArrayList<ArrayList<String>> info = new ArrayList();
		info = FileReading.readAllData("Available Plane");
		for(int i=0;i<info.size();i++) {
			planes.add(new Plane(info.get(i).get(0),info.get(i).get(1),info.get(i).get(2),Integer.parseInt(info.get(i).get(3)),Integer.parseInt(info.get(i).get(4)),Integer.parseInt(info.get(i).get(5)),Integer.parseInt(info.get(i).get(6)),Boolean.parseBoolean(info.get(i).get(7))));
		}
		info = FileReading.readAllData("Available Pilot");
		for(int i=0;i<info.size();i++) {
			pilots.add(new Pilot(info.get(i).get(0),info.get(i).get(1),info.get(i).get(2),info.get(i).get(3),info.get(i).get(4),info.get(i).get(5),info.get(i).get(6),info.get(i).get(7),Integer.parseInt(info.get(i).get(8)),Boolean.parseBoolean(info.get(i).get(9))));
		}
		info = FileReading.readAllData("Routes");
		for(int i=0;i<info.size();i++) {
			routes.add(new Route(info.get(i).get(0),info.get(i).get(1),Integer.parseInt(info.get(i).get(2)),Integer.parseInt(info.get(i).get(3)),Integer.parseInt(info.get(i).get(4)),Integer.parseInt(info.get(i).get(5)),Integer.parseInt(info.get(i).get(6)),Integer.parseInt(info.get(i).get(7)),Integer.parseInt(info.get(i).get(8)),Integer.parseInt(info.get(i).get(9)),Integer.parseInt(info.get(i).get(10)))); // creating routes objects
			routes.get(routes.size()-1).setPlane(planes.get(Integer.parseInt(info.get(i).get(11))));
			routes.get(routes.size()-1).setPilot(pilots.get(Integer.parseInt(info.get(i).get(12))));
//			System.out.println(routes.get(routes.size()-1).getPlane().getFirstSeats());
		}
		info = FileReading.readAllData("Admin Information");
		for(int i=0;i<info.size();i++) {
			admins.add(new Admin(info.get(i).get(0),info.get(i).get(1),info.get(i).get(2),info.get(i).get(3),info.get(i).get(4),info.get(i).get(5),info.get(i).get(6),info.get(i).get(7),info.get(i).get(8)));
		}
		
	}
	public static  void addNewPlane(String name,String id,String modelNo,int es,int bs ,int fs,int fuelCost) {
//		sc = new Scanner(System.in);
//		String name,id,modelNo;
//		int es,bs,fs,fuelCost;
		boolean availibility=true;
//		System.out.print("Enter Name: ");
//		name = sc.next();
//		System.out.print("Enter ID: ");
//		id = sc.next();
//		System.out.print("Model Number: ");
//		modelNo = sc.next();
//		System.out.print("Economy Seats: ");
//		es = sc.nextInt();
//		System.out.println("Business Seats: ");
//		bs = sc.nextInt();
//		System.out.print("First Seats: ");
//		fs = sc.nextInt();
//		System.out.println("Fuel Cost: ");
//		fuelCost = sc.nextInt();
		planes.add(new Plane(name, id, modelNo, es, bs, fs, fuelCost, availibility));
		Plane.writeData(planes, planes.size()-1);
		
	}
	public static void menu()
	{
		sc = new Scanner(System.in);
		System.out.println("1.Admin");
		System.out.println("2.User");
		System.out.println("3.Create new Admin: ");
		System.out.println("-1.Exit App");
		System.out.println("Enter your choice");
		choice = sc.nextInt();
		
		if (choice == 1)
		{
//			if(accessed())
//			adminMenu();
			
		}
		if (choice == 2)
		{
			userMenu();
		}
		if(choice == 3) {
//			Accounts(1);
		}
		if(choice == -1)
		{
			System.exit(0);
		}
	}
	public static boolean accessed(String usname, String password) {
		
		for(int i=0;i<admins.size();i++) {
			String usn = admins.get(i).getUsername();
			String pass = admins.get(i).getPassword();
			if(usn.equals(usname) && pass.equals(password)) {
				indexofAdmin=i;
//				System.out.println("Accessed!...");
				return true;
			}
		}
		System.out.println("Accessed Denied...");
		return false;
	}
	public static void adminMenu()
	{
		 {
		System.out.println("1.Add new PLane");
		System.out.println("2.Add new route");
		System.out.println("3.Time Table");
		System.out.println("7.Go back");
		System.out.println("Enter your choice");
		choice = sc.nextInt();
		
		if(choice == 1)
		{
//			addNewPlane();
			choice = 0;
			adminMenu();
		}
		else if(choice ==2) {
//			addNewRoute();
			choice=0;
		}
		else if (choice == 3) {
			timeTable();
			choice=0;
			adminMenu();
			
		}
		else if (choice == 7)
		{
			choice= 0;
			menu();
			
		}
	}
		
	}
	public static void userMenu(){
	sc = new Scanner(System.in);
	
	choice = 0;
	System.out.println("1. Book a Flight");
	System.out.println("7. Go back");
	System.out.println("Enter your choice");
	choice = sc.nextInt();
	if(choice == 1) {
//		Accounts(2);
		bookAFlight();
	}
	
	else if(choice == 7)
	{
		menu();
	}
	else
	{
		System.out.println("Choose Wisely!\nPass any key to Select again...");
		sc.next();
		userMenu();
	}
	
	
}
	public static void addNewRoute(String departure,String arrival,int hours,int mins,int date,int month,int year,int hoursOfFlight,int indexOfplane,int indexOfpilot)
{
//	sc= new Scanner(System.in);
//	String departure,arrival;
//	int hours,mins,date,month,year,hoursOfFlight=0;
//	/*
//	 * Taking all the required data from admin for Route
//	 */
//	System.out.print("Departure From: ");
//	departure= sc.nextLine();
//	System.out.print("Arriaval to: ");
//	arrival = sc.nextLine();
//	System.out.println("Duration of flight in hours: ");
//	hoursOfFlight = sc.nextInt();
//	System.out.println("Departure Time:\nhours: ");
//	hours = sc.nextInt();
//	System.out.println("mins: ");
//	mins = sc.nextInt();
//	System.out.println("Date of Departure: ");
//	date= sc.nextInt();
//	System.out.println("Month of Departure: ");
//	month= sc.nextInt();
//	System.out.println("Year of Departure: ");
//	year = sc.nextInt();
//	// Data been taken
	/*
	 * Assigning Plane for the Route
	 */
//	System.out.print("ASSIGNE PLANE: ");
//	System.out.println("\npass any key...");
//	sc.next();
	/*
	 * Assign function will display all the availebal planes and then let the admin pick one 
	 and return the index of selected plane
	 */
	indexOfPlane = indexOfplane;
	indexofPilot= indexOfpilot;
//	System.out.print("Assign Pilot: ");
//	System.out.println("\npass any key...");
//	sc.next();
	indexofPilot = assignPilot();
	routes.add(new Route(departure, arrival, hours, mins, date, month, year, hoursOfFlight,0,0,0));
	routes.get(routes.size()-1).setPlane(planes.get(indexOfPlane));
	routes.get(routes.size()-1).setPilot(pilots.get(indexofPilot));
	
	
	/*
	 * Setting availibility of plane and pilot and also refreshing data in both files
	 */
	planes.get(indexOfPlane).setAvailable(false);
	Plane.refreshData(planes);
	pilots.get(indexofPilot).setAvailable(false);
	Pilot.refreshData(pilots);
	
	/*
	 * Calculating prices of all tickets of each class
	 * Economy class Ticket will be 15% of Total plane expenses
	 * Business Class will be 35% of Total plane expenses
	 * First Class will be 50% of Total Plane expenses
	 */
	setPricesOfAllClasses(routes.size()-1);
	/*
	 * Writing all the data in Route File
	 */
	FileWriting.dataWrite(routes.get(routes.size()-1).toString(), "Routes");
	System.out.println("Route added Successfully");
	
	
	
	
}
	public static void setPricesOfAllClasses(int indexOfRoute) {
	int totalPriceOfTicket=0;
	totalPriceOfTicket = routes.get(routes.size()-1).getHoursOfFlight()*routes.get(indexOfRoute).getPlane().getFuelCost(); // total flight cost
	routes.get(routes.size()-1).getTicket().setPriceOfFirstClass((int)(totalPriceOfTicket*0.5f));     // pricing of tickets
	routes.get(routes.size()-1).getTicket().setPriceOfBusinessClass((int)(totalPriceOfTicket*0.35f));
	routes.get(routes.size()-1).getTicket().setPriceOfEconomyClass((int)(totalPriceOfTicket*0.15f));
	
}
	public static int assignPlane()
	{
//		sc= new Scanner(System.in);
//		int choice=0;
//		ArrayList<String> details = new ArrayList();
//		details.add("Name");
//		details.add("ID");
//		details.add("Model");
//		details.add("Economy");
//		details.add("Business");
//		details.add("First");
//		details.add("Fuel Cost");
//		details.add("Availabe");
//		ArrayList<ArrayList<String>> info = new ArrayList();
//		info = FileReading.readAllData("Available Plane");
//		for(int i=0;i<info.size();i++) {
//			System.out.print(i+1+") ");
//			for(int j=0;j<info.get(i).size();j++) {
//				System.out.println(details.get(j)+": "+info.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}
//		System.out.print("Enter Choice: ");
//		choice = sc.nextInt();
//		choice--;
//		if(planes.get(choice).isAvailable()==true) {
//			return choice;
//		}
//		else {
//			System.out.println("The plain is not availible at the moment...\nChoose others!\npass any jey to continue...");
//			sc.next();
//			assignPlane();
//		}
		return 0;
//		planes.add(new Plane(info.get(choice).get(0),info.get(choice).get(1),info.get(choice).get(2),Integer.parseInt(info.get(choice).get(3)),Integer.parseInt(info.get(choice).get(4)),Integer.parseInt(info.get(choice).get(5)),Integer.parseInt(info.get(choice).get(6)),Boolean.parseBoolean(info.get(choice).get(7))));
	}
	public static int  assignPilot(){
	ArrayList<String> details = new ArrayList();
//	details.add("Name");
//	details.add("Country");
//	details.add("City");
//	details.add("HouseNo");
//	details.add("StreetNo");
//	details.add("CNIC");
//	details.add("PhoneNumber");
//	details.add("EmpID");
//	details.add("Salary");
//	details.add("Availability");
//	ArrayList<ArrayList<String>> info = new ArrayList();
//	info = FileReading.readAllData("Available Pilot");
//	for(int i=0;i<info.size();i++) {
//		System.out.print(i+1+") ");
//		for(int j=0;j<info.get(i).size();j++) {
//			System.out.println(details.get(j)+": "+info.get(i).get(j)+" ");
//		}
//		System.out.println();
//	}
//	int choice = sc.nextInt();
//	choice--;
//	if(pilots.get(choice).isAvailable()==true) {
//		return choice;
//	}
//	else {
//		System.out.println("The pilot is not availible at the moment...\nChoose others!\npass any key to continue...");
//		sc.next();
//		assignPilot();
//	}
	return 0;
	}
	public static int getIndexOfPilot() {
		return indexofPilot;
	}
	public static int getIndexOfPlane() {
		return indexOfPlane;
	}
	public static void timeTable() {
		sc = new Scanner(System.in);
		for(int i=0;i<routes.size();i++) {
			System.out.println(i+1+") "+routes.get(i).getDate().getDate()+"/"+routes.get(i).getDate().getMonth()+"/"+routes.get(i).getDate().getYear()+"  FROM  "+routes.get(i).getDeparture()+"  TO  "+routes.get(i).getArrival()+"  AT  "+routes.get(i).getTime().getHours()+":"+routes.get(i).getTime().getMins()+"  ON PLANE  "+routes.get(i).getPlane().getPlaneName()+"  WITH PILOT  "+routes.get(i).getPilot().getName()+"\n");
		}
		System.out.println("Pass any key to continue....");
		sc.next();
	}
	public static void bookAFlight() {
		sc = new Scanner(System.in);
		System.out.print("From: ");
		String uFrom= sc.next();
		System.out.print("To: ");
		String uTo = sc.next();
		int numbring=0;
		boolean foundIt = false;
		for(int i=0;i<routes.size();i++) {
			String compareFrom = routes.get(i).getDeparture();
			String compareTo = routes.get(i).getArrival();
			if(compareFrom.equals(uFrom) && compareTo.equals(uTo)) {
				System.out.println(numbring+1+") "+routes.get(i).getDate().getDate()+"/"+routes.get(i).getDate().getMonth()+"/"+routes.get(i).getDate().getYear()+"  FROM  "+routes.get(i).getDeparture()+"  TO  "+routes.get(i).getArrival()+"  AT  "+routes.get(i).getTime().getHours()+":"+routes.get(i).getTime().getMins()+"  ON PLANE  "+routes.get(i).getPlane().getPlaneName()+"  WITH PILOT  "+routes.get(i).getPilot().getName()+"\n");
				selectIndexes.add(i);
				foundIt = true;
				numbring++;
			}
		}
		if(!foundIt) {
			System.out.println("There is no flight yet available from "+uFrom+" to "+uTo+" :(");
			System.exit(0);
		}
		selection = sc.nextInt();
		selection--;
		System.out.println("Book wali "+selectIndexes.get(selection));
//		selectTicketType(selectIndexes.get(selection));

		
	}
	public static void selectTicketType(int i,int numberOfTickets,int choice) {
//		System.out.println("--Select Ticket--");
//		System.out.println("1) First Class ("+routes.get(i).getTicket().getPriceOfFirstClass()+"/- per Ticket)");
//		System.out.println("2) Business Class ("+routes.get(i).getTicket().getPriceOfBusinessClass()+"/- per Ticket)");
//		System.out.println("3) Economy Class ("+routes.get(i).getTicket().getPriceOfEconomyClass()+"/- per Ticket)");
//		int choice = new Scanner(System.in).nextInt();
//		System.out.print("Number of Tickets: ");
//		int numberOfTickets = new Scanner(System.in).nextInt();
		
		switch(choice) {
		case 1:
			userBill += numberOfTickets*routes.get(i).getTicket().getPriceOfFirstClass();
			routes.get(i).getPlane().setFirstSeats(routes.get(i).getPlane().getFirstSeats() - numberOfTickets);
			break;
		case 2:
			userBill+= numberOfTickets*routes.get(i).getTicket().getPriceOfBusinessClass();
			routes.get(i).getPlane().setBusinessSeats(routes.get(i).getPlane().getBusinessSeats() - numberOfTickets);
			break;
		case 3: 
			userBill+= numberOfTickets*routes.get(i).getTicket().getPriceOfEconomyClass();
			routes.get(i).getPlane().setEconomySeats(routes.get(i).getPlane().getEconomySeats()  - numberOfTickets);
			break;
		}
		Plane.refreshData(planes);
//		System.out.println("[1] To Add More Tickets\n");
//		System.out.println("[2] To Finish");
//		if(new Scanner(System.in).nextInt() == 1) {
//			selectTicketType(i);
//		}
//		else {
//			System.out.println(userBill);
			makeBill(i);
//		}
	}
	public static void makeBill(int i) {
		
		String filepath="";
		File pdfile  = new File("Bill.pdf");
		FileOutputStream fileoutput=null;
		try {
			 fileoutput = new FileOutputStream(pdfile);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		filepath = pdfile.getAbsolutePath();
		File npdfile = new File(filepath);
		
		System.out.println("bill "+i);
		String data = "\t\t-Airline System-\n\n"+"NAME: "+passengers.get(0).getName()+"\nPLANE ID: "+routes.get(i).getPlane().getPlaneID()+"\nTo "+routes.get(i).getDeparture()+"\nFROM: "+routes.get(i).getArrival()+"\nTIME: "+routes.get(i).getTime().getHours()+":"+routes.get(i).getTime().getMins()+"\nDATE: "+routes.get(i).getDate().getDate()+"/"+routes.get(i).getDate().getMonth()+"/"+routes.get(i).getDate().getYear()+"\n\t\tTotal BILL: "+userBill;
		Document bill = new Document();
		try {
			PdfWriter.getInstance(bill,fileoutput);
			bill.open();
			bill.add(new Paragraph(data));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		bill.close();
		PdfReader pdfreader = null;
		try {
			pdfreader = new PdfReader("Bill.pdf");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int pages = pdfreader.getNumberOfPages();
		String contenOfFile= "";
		for(int k = 0; k<pages;k++)
		{
			try {
				contenOfFile = PdfTextExtractor.getTextFromPage(pdfreader, pages);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(contenOfFile);
		}
		
		pdfreader.close();
		
		try {
			Desktop.getDesktop().open(npdfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void Accounts(int i,String name,String country,String city,String houseNo,String streetNo,String cnic,String phoneNo,String useerName,String password) {
//		sc = new Scanner(System.in);
//		System.out.print("Name: ");
//		String name = sc.next();
//		System.out.print("Country: ");
//		String country = sc.next();
//		System.out.print("City: ");
//		String city = sc.next();
//		System.out.print("HouseNo: ");
//		String houseNo = sc.next();
//		System.out.print("StreetNo: ");
//		String streetNo = sc.next();
//		System.out.print("CNIC Number: ");
//		String cnic = sc.next();
//		System.out.print("Phone Number: ");
//		String phoneNo= sc.next();
		
		/*
		 * 1 for admin
		 * 2  for user
		 */
		
		switch(i) {
		case 1:
//			System.out.print("UserName: ");
//			String useerName = sc.next();
//			System.out.print("Password: ");
//			String password= sc.next();
			admins.add(new Admin(name, country, city, houseNo, streetNo, cnic, phoneNo, useerName, password));
			Admin.writeData(admins, admins.size()-1);
			break;
		case 2:
			passengers.add(new Passenger(name, country, city, houseNo, streetNo, cnic, phoneNo));
			break;
		}
		
		
	}
	public static ArrayList<Plane> getPlanes() {
		return planes;
	}
	public static void setPlanes(ArrayList<Plane> planes) {
		Functions.planes = planes;
	}
	public static ArrayList<Route> getRoutes() {
		return routes;
	}
	public static void setRoutes(ArrayList<Route> routes) {
		Functions.routes = routes;
	}
	public static ArrayList<Pilot> getPilots() {
		return pilots;
	}
	public static void setPilots(ArrayList<Pilot> pilots) {
		Functions.pilots = pilots;
	}
	public static int getIndexofPilot() {
		return indexofPilot;
	}
	public static int getIndexofAdmin() {
		return indexofAdmin;
	}
	public static int getUserBill() {
		return userBill;
	}
	public static Scanner getSc() {
		return sc;
	}
	public static int getChoice() {
		return choice;
	}
	public static ArrayList<Admin> getAdmins() {
		return admins;
	}
	public static ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	public static ArrayList<Integer> getIndexes() {
		return indexes;
	}
	public static int getSelection() {
		return selection;
	}
	public static ArrayList<Integer> getSelectIndexes() {
		return selectIndexes;
	}
	public static void setSelectIndexes(ArrayList<Integer> selectIndexes) {
		Functions.selectIndexes = selectIndexes;
	}
	
	
	
	
}








