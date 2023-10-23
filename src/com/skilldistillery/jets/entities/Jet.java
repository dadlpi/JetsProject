package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String modelOfJet;
	private int speedOfJet;
	private int rangeOfFlight;
	private int priceOfJet;
//	private double flightTimeInHours;
	
	//NOTE abstract classes can have constructors
	
	public abstract void fly() ;

	public Jet(String modelOfJet, int speedOfJet, int rangeOfFlight, int priceOfJet) {
		super();
		this.modelOfJet = modelOfJet;
		this.speedOfJet = speedOfJet;
		this.rangeOfFlight = rangeOfFlight;
		this.priceOfJet = priceOfJet;
	}

	public String getModelOfJet() {
		return modelOfJet;
	}

	public void setModelOfJet(String modelOfJet) {
		this.modelOfJet = modelOfJet;
	}

	public int getSpeedOfJet() {
		return speedOfJet;
	}

	public void setSpeedOfJet(int speedOfJet) {
		this.speedOfJet = speedOfJet;
	}

	public int getRangeOfFlight() {
		return rangeOfFlight;
	}

	public void setRangeOfFlight(int rangeOfFlight) {
		this.rangeOfFlight = rangeOfFlight;
	}

	public int getPriceOfJet() {
		return priceOfJet;
	}

	public void setPriceOfJet(int priceOfJet) {
		this.priceOfJet = priceOfJet;
	}

	@Override
	public String toString() {
		return "Jet [modelOfJet=" + modelOfJet + ", speedOfJet=" + speedOfJet + ", rangeOfFlight=" + rangeOfFlight
				+ ", priceOfJet=" + priceOfJet + "]";
	}

	
	
}
