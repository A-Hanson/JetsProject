package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier{

	

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}
	public CargoPlane(Jet jet) {
		super(jet.getModel(), jet.getSpeed(), jet.getRange(), jet.getPrice());
	}

	@Override
	public void loadCargo() {
		System.out.println("Forcing NCOs to round up soldiers to load...");
		System.out.println("Soldiers now on board, except for Kevin.");
		System.out.println(getModel() + " is now ready to fly.");
		
	}


	@Override
	public void fly() {
		System.out.println(getModel() + " slowly takes off and is now flying at " + (getSpeed() * 100.0) + " mph.");
		
	}

}
