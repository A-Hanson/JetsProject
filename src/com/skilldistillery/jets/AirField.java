package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AirField {
	private List<Jet> fleet;
	private List<Pilot> staff;
	
	public AirField() {
		fleet = readJetsFromFile("jets.txt");
		assignJetsToType(fleet);
		staff = readPilotsFromFile("pilots.txt");
	}
	
//	private void assignPilots() {
//		Do later
//	}
	public void listTheFleet() {
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
	}
	
	public void flyTheFleet() {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}
	public void printFastestJet() {
		Jet fastJet = Collections.max(fleet, Comparator.comparing(f -> f.getSpeed()));
		System.out.println("The fastest jet is " + fastJet.getModel() + " with a speed of " + fastJet.getSpeed() + " miles per hour." );
	}
	
	public void printLongestRangeJet() {
		Jet longJet = Collections.max(fleet, Comparator.comparing(f -> f.getRange()));
		System.out.println("The longest range jet is " + longJet.getModel() + " with a range of " + longJet.getRange() + " miles.");
	}
	
	public void loadAllTheCargoPlanes() {
		List<CargoPlane> planesToPrint = new ArrayList<>();
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i).getClass().getSimpleName().equals("CargoPlane")) {
				planesToPrint.add((CargoPlane) fleet.get(i));
			}
		}
		for (CargoPlane cargoPlane : planesToPrint) {
			cargoPlane.loadCargo();
		}
	}
	
	public void fightAllTheFighterJets() {
		List<FighterJet> planesToPrint = new ArrayList<>();
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i).getClass().getSimpleName().equals("FighterJet")) {
				planesToPrint.add((FighterJet) fleet.get(i));
			}
		}
		for (FighterJet plane : planesToPrint) {
			plane.fight();
		}
	}
	
	public void addAJet(int i, String model, double speed, int range, long price) {
		switch (i) {
		case 0:
			fleet.add( new JetImplement(model, speed, range, price) );
			System.out.println("A new basic jet was added!");
			break;
		case 1:
			fleet.add( new CargoPlane(model, speed, range, price) );
			System.out.println("A new cargo plane was added!");
			break;
		case 2:
			fleet.add( new FighterJet(model, speed, range, price) );
			System.out.println("A new fighter jet was added!");
			break;
		default:
			System.out.println("Error in jet type selection, please try again");
		}
	}
	
	private List<Jet> assignJetsToType(List<Jet> jets) {
		for (int i = 0; i < jets.size(); i++) {
			if (i % 2 == 0) {
				FighterJet plane = new FighterJet(jets.get(i));
				jets.set(i, plane);
			} else {
				CargoPlane plane = new CargoPlane(jets.get(i));
				jets.set(i, plane);
			}
		}
		return jets;
	}
	
	private List<Jet> readJetsFromFile(String fileName){
		List<Jet> names = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(",");
				names.add( new JetImplement(tokens[0], 
						Double.parseDouble(tokens[1].trim()), 
						Integer.parseInt(tokens[2].trim()), 
						Long.valueOf(tokens[3].trim())) );
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading " + fileName + ": " + e.getMessage());
		}
		return names;
	}
	
	private List<Pilot> readPilotsFromFile(String fileName){
		List<Pilot> names = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(",");
				names.add( new Pilot(tokens[0], Integer.parseInt( tokens[1].trim() )) );
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading " + fileName + ": " + e.getMessage());
		}
		return names;
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
	
}
