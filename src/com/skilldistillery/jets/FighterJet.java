package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}
	public FighterJet(Jet jet) {
		super(jet.getModel(), jet.getSpeed(), jet.getRange(), jet.getPrice());
	}

	@Override
	public void fight() {
		System.out.println(getModel() + " goes: Pew pew pew!");
		System.out.println("wwwwwwhhhhOOOOOOOOOshhhhhhh");
		System.out.println("No wonder is costs " + getPrice());
		
	}

	@Override
	public void fly() {
		System.out.println(getModel() + " explodes into action and is now flying at " + (getSpeed() * 100.0) + " mph.");
		
	}

	

}
