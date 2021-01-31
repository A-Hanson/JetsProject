package com.skilldistillery.jets;

public class Pilot {
	private String name;
	private double salary;
	private boolean available;
	
	
	public Pilot(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
		available = true;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	@Override
	public String toString() {
		return "Pilot [name=" + name + ", salary=" + salary + ", available=" + available + "]";
	}



	
	
}
