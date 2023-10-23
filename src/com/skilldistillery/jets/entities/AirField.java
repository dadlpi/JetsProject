package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AirField {

	private List<Jet> fleet = new ArrayList<Jet>();

	public AirField() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
//				System.out.println("this is from the file: " + line);
				String[] planeParts = line.split(", ");
				if (planeParts[0].equals("Cargo")) {
					fleet.add(new CargoAirplane(planeParts[1], Integer.parseInt(planeParts[2]),
							Integer.parseInt(planeParts[3]), Integer.parseInt(planeParts[4])));
				} else if (planeParts[0].equals("Combat")) {
					fleet.add(new CombatAirplane(planeParts[1], Integer.parseInt(planeParts[2]),
							Integer.parseInt(planeParts[3]), Integer.parseInt(planeParts[4])));
				} else {
					fleet.add(new PassengerAirplane(planeParts[1], Integer.parseInt(planeParts[2]),
							Integer.parseInt(planeParts[3]), Integer.parseInt(planeParts[4])));
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void listFleet() {
		System.out.println(
				"Hanger, Airfield, Tarmac are getting Instantiated with the following Airplanes from the flyAllJets() method:");
//		System.out.println(fleet.get(1).getModelOfJet());
		for (Jet individualJet : fleet) {
			System.out.println(individualJet.toString());
		}
	}

	public void flyAllJets() {
		for (Jet individualJet : fleet) {
			System.out.print(individualJet.getModelOfJet() + " - ");
			individualJet.fly();
		}
	}

	public void fastestJetFind() {
		int trackerIndexOfFastest = 0;
		int basedIdxIterator = -1;
		int speedComparison = 0;
		for (Jet individualJet : fleet) {
			basedIdxIterator++;
			if (individualJet.getSpeedOfJet() > speedComparison) {
				speedComparison = individualJet.getSpeedOfJet();
				trackerIndexOfFastest = basedIdxIterator;
			}
		}
		System.out.println("your fastest jet is: " + fleet.get(trackerIndexOfFastest).toString());
	}

	public void longestRangeFind() {
		int trackerIndexOfFurthestRange = 0;
		int basedIdxIterator = -1;
		int rangeComparison = 0;
		for (Jet individualJet : fleet) {
			basedIdxIterator++;
			if (individualJet.getRangeOfFlight() > rangeComparison) {
				rangeComparison = individualJet.getRangeOfFlight();
				trackerIndexOfFurthestRange = basedIdxIterator;
			}
		}
		System.out.println("your lonest ranged jet is: " + fleet.get(trackerIndexOfFurthestRange).toString()
				+ "SPECIFICALLY WITH A FLIGHT RANGE OF" + fleet.get(trackerIndexOfFurthestRange).getRangeOfFlight()
				+ " miles in the air");
	}

	public void loadEmUp() {
		for (Jet individualJet : fleet) {
			if (individualJet instanceof CargoAirplane) {
				((CargoAirplane) individualJet).load();
				System.out.println(" which is a: " + individualJet.getModelOfJet());
			}
		}
	}

	public void fightEmAll() {
		for (Jet individualJet : fleet) {
			if (individualJet instanceof CombatAirplane) {
				((CombatAirplane) individualJet).fight();
				System.out.println(" which is a: " + individualJet.getModelOfJet());
			}
		}
	}
	
	public List<Jet> addJets(Scanner moreKeyBoardInput){
		int subMenuInput = 0;
		String nameOfJetModel;
		int speedOftheNewJet;
		int rangeOftheNewJet;
		int priceOftheNewJet;
		Jet newlyCreatedJet;
		System.out.println("You have selected to add more jets here");
		System.out.println(1 + ") Cargo");
		System.out.println(2 + ") Combat");
		System.out.println(3 + ") Passenger");
		System.out.println("##### make a numeric selection now #####");
		subMenuInput = moreKeyBoardInput.nextInt();
		
		if (subMenuInput == 1) {
			System.out.println("what is the Cargo airplane model name?");
			nameOfJetModel = moreKeyBoardInput.next();
			System.out.println("what is the Cargo airplane speed?");
			speedOftheNewJet = moreKeyBoardInput.nextInt();
			System.out.println("what is the Cargo airplane range?");
			rangeOftheNewJet = moreKeyBoardInput.nextInt();
			System.out.println("what is the Cargo airplane price?");
			priceOftheNewJet = moreKeyBoardInput.nextInt();
			newlyCreatedJet = new CargoAirplane(nameOfJetModel, speedOftheNewJet, rangeOftheNewJet, priceOftheNewJet);
			fleet.add(newlyCreatedJet);

		}
		else if (subMenuInput == 2) {
			System.out.println("what is the Combat airplane model name?");
			nameOfJetModel = moreKeyBoardInput.next();
			System.out.println("what is the Combat airplane speed?");
			speedOftheNewJet = moreKeyBoardInput.nextInt();
			System.out.println("what is the Combat airplane range?");
			rangeOftheNewJet = moreKeyBoardInput.nextInt();
			System.out.println("what is the Combat airplane price?");
			priceOftheNewJet = moreKeyBoardInput.nextInt();
			newlyCreatedJet = new CombatAirplane(nameOfJetModel, speedOftheNewJet, rangeOftheNewJet, priceOftheNewJet);
			fleet.add(newlyCreatedJet);
		}
		else if (subMenuInput == 3) {
			System.out.println("what is the Passgener airplane model name?");
			nameOfJetModel = moreKeyBoardInput.next();
			System.out.println("what is the Passgener airplane speed?");
			speedOftheNewJet = moreKeyBoardInput.nextInt();
			System.out.println("what is the Passgener airplane range?");
			rangeOftheNewJet = moreKeyBoardInput.nextInt();
			System.out.println("what is the Passgener airplane price?");
			priceOftheNewJet = moreKeyBoardInput.nextInt();
//			moreKeyBoardInput.nextLine(); //this clears the scanner cache after not using the line
			newlyCreatedJet = new PassengerAirplane(nameOfJetModel, speedOftheNewJet, rangeOftheNewJet, priceOftheNewJet);
			fleet.add(newlyCreatedJet);
		}
		else {
			System.err.println("this is not a valid selection for creating an airplane,\nyou are getting returned to the main menu");
		}
		
		return fleet;
		
	}
	
	public void removeJet(Scanner againMoreKeyboardInput) {
		int startingNumber = 1;
		if (fleet.size() > 0) {
			
		System.out.println("\nWhich Jet would you like to remove?");
		for (Jet individualJet : fleet) {
			System.out.println(startingNumber + " " + individualJet);
			startingNumber++;
		}
		System.out.println("### SELECT A NUMBER TO REMOVE A JET NOW ####");
		int userSelectedNumber = againMoreKeyboardInput.nextInt();
		fleet.remove((userSelectedNumber - 1));
		}
		else {
			System.out.println("there are no airplanes to remove");
		}
	}
	
	

}
