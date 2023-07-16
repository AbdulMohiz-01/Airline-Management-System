package plane;

import java.util.ArrayList;

public  class Ticket {
	private int priceOfEconomyClass;
	private int priceOfBusinessClass;
	private int priceOfFirstClass;
	
	public Ticket(int priceOfEconomyClass, int priceOfBusinessClass, int priceOfFirstClass) {
		this.priceOfEconomyClass = priceOfEconomyClass;
		this.priceOfBusinessClass = priceOfBusinessClass;
		this.priceOfFirstClass = priceOfFirstClass;
	}

	public int getPriceOfEconomyClass() {
		return priceOfEconomyClass;
	}

	public void setPriceOfEconomyClass(int priceOfEconomyClass) {
		this.priceOfEconomyClass = priceOfEconomyClass;
	}

	public int getPriceOfBusinessClass() {
		return priceOfBusinessClass;
	}

	public void setPriceOfBusinessClass(int priceOfBusinessClass) {
		this.priceOfBusinessClass = priceOfBusinessClass;
	}

	public int getPriceOfFirstClass() {
		return priceOfFirstClass;
	}

	public void setPriceOfFirstClass(int priceOfFirstClass) {
		this.priceOfFirstClass = priceOfFirstClass;
	}
	
	

	
	
}
