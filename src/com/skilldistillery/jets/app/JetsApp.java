package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApp {

	public static void main(String[] args) {
		JetsApp thisApplicationOfJets = new JetsApp();
		thisApplicationOfJets.launch();

	}

	public void launch() {
		AirField theRunwayHanger = new AirField();
		JetsApp anotherInstanceApplicationOfJets = new JetsApp();
		Scanner keyboardInput = new Scanner(System.in);
		while (true) {
			anotherInstanceApplicationOfJets.displayMenu();
			int storedOptedValue = keyboardInput.nextInt();

			if (storedOptedValue == 1) {
				theRunwayHanger.listFleet();
//				break;
			} else if (storedOptedValue == 2) {
				theRunwayHanger.flyAllJets();
			} else if (storedOptedValue == 3) {
				theRunwayHanger.fastestJetFind();
			} else if (storedOptedValue == 4) {
				theRunwayHanger.longestRangeFind();
			} else if (storedOptedValue == 5) {
				theRunwayHanger.loadEmUp();
			} else if (storedOptedValue == 6) {
				theRunwayHanger.fightEmAll();
			} else if (storedOptedValue == 7) {
				theRunwayHanger.addJets(keyboardInput);
//				System.out.println("outside of the method");
			} else if (storedOptedValue == 8) {
				theRunwayHanger.removeJet(keyboardInput);
			}
			  else if (storedOptedValue == 9) {
				System.out.println("thanks for using our airplane program, the program is now terminating, bye");
				break;
			} else {
				System.err.println("this is an invalid input, please select a valid selection");
			}
		}
	}

	public void displayMenu() {
		System.out.println("\n##### MENU OPTIONS, SELECT A NUMERIC FUNCTION 1 -9: #####");
		System.out.println("1 - List fleet\n" + "2 - Fly all jets\n" + "3 - View fastest jet\n"
				+ "4 - View jet with longest range\n" + "5 - Load all Cargo Jets\n" + "6 - Dogfight all Fighter Jets!\n"
				+ "7 - Add a jet to Fleet\n" + "8 - Remove a jet from Fleet\n" + "9 - Quit\n"
				+ "##### ENTER NUMERIC OPTION NOW #####");

	}

}
