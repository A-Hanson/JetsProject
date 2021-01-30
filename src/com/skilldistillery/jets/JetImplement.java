package com.skilldistillery.jets;

public class JetImplement extends Jet{

	public JetImplement(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println(getModel() + " takes off and is now flying at " + (getSpeed() * 100.0) + " mph.");
		
	}

	

}
