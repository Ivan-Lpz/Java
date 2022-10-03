package com.ivan.batproject;

public class Bat extends Mammal {
	//OVERLOADED CONSTRUCTOR 
	public Bat(int energy) {
		this.energyLevel = energy;
	}
	
	
	
	//FUNCTIONS 
	public void fly() {
		this.setEnergyLevel(this.getEnergyLevel()-50);
		System.out.println("Flap Flap Bat Flys away");
	}
		
	public void displayEnergy() {
		System.out.printf("this bat has an energy level : %d\n", this.getEnergyLevel());
		
	}
	
	public void eatHuman() {
		this.setEnergyLevel(this.getEnergyLevel()+25);
		System.out.println("chomp-chomp human");
	}
	
	public void attackTown() {
		this.setEnergyLevel(this.getEnergyLevel()-100);
		System.out.println("attacking town");
	}

}
