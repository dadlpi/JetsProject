package com.skilldistillery.jets.entities;

import java.text.DecimalFormat;

public class CombatAirplane extends Jet implements CombatReady{
	private final DecimalFormat df = new DecimalFormat("0.00");
	
	public CombatAirplane(String modelOfJet, int speedOfJet, int rangeOfFlight, int priceOfJet) {
		super(modelOfJet, speedOfJet, rangeOfFlight, priceOfJet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		double flightTimeInHours = (double)getRangeOfFlight()/(double)getSpeedOfJet();
		System.out.print("I am a CombatAirplane with a max mph speed of " + getSpeedOfJet() + " range of " + getRangeOfFlight() + " in flight miles which means I can be in the air for " );
		System.out.println( df.format(flightTimeInHours) + " hours until I run out of fuel and I cost $" + getPriceOfJet());
//		System.out.println("I am a CombatAirplane with a max mph speed of " + getSpeedOfJet());
		
	}

	@Override
	public void fight() {
		System.out.print("a fighting flyer " + getClass());
		// TODO Auto-generated method stub
		
	}

}
