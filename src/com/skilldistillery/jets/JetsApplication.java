package com.skilldistillery.jets;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.activity.InvalidActivityException;

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
			} catch (InputMismatchException e) {
				System.out.println("Whoopsie, please try a number between 1 - 9.");
			}
			selectChoice(userChoice);
			if (userChoice == 9) {
				// figure out how to break the loop
			}
			
		}
		
	}
	private void selectChoice(int input) {
		System.out.println();
		switch (input) {
		case 1:
			airField.listTheFleet();
			break;
		case 2:
			airField.flyTheFleet();
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
			// TODO remove a jet from fleet
			break;
		case 9:
			keepGoing = false;
			System.out.println("Goodbye, we'll bill you for the damages later.");
			System.out.println("*-------------------------------------------*");
		default:
			System.out.println("Did you enter a number between 1-9?");
		}
	}
	private void addJetToFleet() {
		int typeOfJet = 0;
		System.out.println("Which type of Jet do you want to add?\n"
				+ "Enter 1 for a Cargo Plane and 2 for Fighter Jet.");
		typeOfJet = kb.nextInt();
		System.out.print("What is the model of the jet? ");
		String model = kb.nextLine();
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
		airField.addAJet(typeOfJet, model, speed, range, price);
	}
	
	private void displayUserMenu() {
		System.out.println("*-------------------------------------------*");
		System.out.println("Please enter the number for the activity you\n"
				+ "want to do.");
		System.out.println("1. List the fleet");
		System.out.println("2. Fly all the aircrafts");
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
