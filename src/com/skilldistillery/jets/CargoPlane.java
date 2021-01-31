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
		String[] soldiers = {"Kevin", "Kyle", "Kent", "Kayla", "Kendra"};
		int index = (int) (Math.random() * (soldiers.length -1));
		String soldier = soldiers[index];
		System.out.println("Forcing NCOs to round up soldiers to load...");
		System.out.println("Soldiers now on board, except for " + soldier +". Typical.");
		System.out.println(getModel() + " is now ready to fly.");
		System.out.println();
		
	}


	@Override
	public void fly() {
		System.out.println(getModel() + " slowly takes off and is now flying at " + getSpeed() + " mph.");
		System.out.println();
	}

}
