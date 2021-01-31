package com.skilldistillery.jets;

import java.util.InputMismatchException;
import java.util.Scanner;


public class JetsApplication {
	private AirField airField = new AirField();
	private static Scanner kb = new Scanner(System.in);
	private boolean keepGoing = true;

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
		kb.close();
	}
	
	private void launch() {
		int userChoice = 0;
		introMessage();
		while (keepGoing) {
			displayUserMenu();
			try {
				userChoice = kb.nextInt();
				kb.nextLine();
				System.out.println("Good choice! Loading selection now...");
				System.out.println("*-------------------------------------------*");
			} catch (InputMismatchException e) {
				System.out.println("Whoopsie, please try a number between 1 - 9.");
			}
			selectChoice(userChoice);
			
			
		}
		
	}
	private void selectChoice(int input) {
		System.out.println();
		switch (input) {
		case 1:
			airField.listTheFleet();
			break;
		case 2:
			chooseWhichJetToFly();
			break;
		case 3:
			airField.printFastestJet();
			break;
		case 4:
			airField.printLongestRangeJet();
			break;
		case 5:
			airField.loadAllTheCargoPlanes();
			break;
		case 6:
			airField.fightAllTheFighterJets();
			break;
		case 7:
			addJetToFleet();
			break;
		case 8:
			removeJetFromFleet();
			break;
		case 9:
			keepGoing = false;
			System.out.println("Goodbye, we'll bill you for the damages later.");
			System.out.println("*-------------------------------------------*");
			break;
		default:
			System.out.println("Did you enter a number between 1-9?");
		}
	}
	private void chooseWhichJetToFly() {
		String userChoice;
		for (Jet jet : airField.getFleet()) {
			System.out.println(jet.getModel());
		}
		System.out.println("-------");
		System.out.println("Which model do you want to fly?");
		System.out.println("Enter the model name or 'All' to fly them all!");
		try {
			userChoice = kb.nextLine();
			userChoice.trim();
			if ( userChoice.equalsIgnoreCase("all") ) {
				airField.flyTheFleet();
			} else {
				airField.flyIndividualJet(userChoice);
			}
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void addJetToFleet() {
		int typeOfJet = 0;
		try {
			System.out.println("Which type of Jet do you want to add?\n"
					+ "Enter 1 for a Cargo Plane and 2 for Fighter Jet.");
			typeOfJet = kb.nextInt();
			kb.nextLine();
			String model;
			System.out.print("What is the model of the jet? ");
			model = kb.nextLine();
			System.out.println();
			System.out.print("What is the speed of the jet? ");
			double speed = kb.nextDouble();
			kb.nextLine();
			System.out.println();
			System.out.print("What is the range of the jet? ");
			int range = kb.nextInt();
			kb.nextLine();
			System.out.println();
			System.out.print("What is the price of the jet? ");
			long price = kb.nextLong();
			kb.nextLine();
			Jet newJet = airField.addAJet(typeOfJet, model, speed, range, price);
			hireAPilot(newJet);
		}
		catch(InputMismatchException e) {
			System.out.println("Sorry, there seems to be an error with that value.");
		}
	}
	
	private void hireAPilot(Jet jet) {
		System.out.println("Would you like to hire a pilot for the aircraft or have one randomly assigned?");
		System.out.println("Enter 1 for hiring a pilot, 2 for a random assignment.");
		int userChoice = 0;
		
		try {
			userChoice = kb.nextInt();
			kb.nextLine();
			if (userChoice == 1) {
				airField.printAllAvailablePilots();
				String userPilotChoice;
				System.out.println("Please enter the name of the pilot you which to hire.");
				userPilotChoice = kb.nextLine();
				airField.assignPilotToJetChoice(jet, userPilotChoice);
			} else if (userChoice == 2) {
				airField.assignPilotsToJetsRandomly(jet);
				
			} else {
				System.out.println("Did you enter 1 or 2?");
			}
			System.out.println(jet.getPilot().getName() + " was hired to pilot this aircraft. They have a salary of $" + jet.getPilot().getSalary());
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void removeJetFromFleet() {
		String userSelection;
		airField.printAllTheJetModelsWithPrice();
		System.out.println("Which model jet do you want to sell?");
		userSelection = kb.nextLine();
		userSelection.trim();
		airField.removeAJet(userSelection);
	}
	
	private void displayUserMenu() {
		System.out.println("*-------------------------------------------*");
		System.out.println("Please enter the number for the activity you\n"
				+ "want to do.");
		System.out.println("1. List the fleet");
		System.out.println("2. Fly the aircrafts");
		System.out.println("3. View the fastest jet");
		System.out.println("4. View the jet with the longest range");
		System.out.println("5. Load all the Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a jet to the Fleet");
		System.out.println("8. Remove a jet from the Fleet");
		System.out.println("9. Quit");
	}
	
	private void introMessage() {
		System.out.println("*-------------------------------------------*");
		System.out.println("Hello and Welcome to Anna's Awesome AirField!");
		System.out.println("Feel free to look around and fly some of our\n"
						+ "world class aircrafts. Just don't crash!");
		System.out.println("*-------------------------------------------*");
	}

}
