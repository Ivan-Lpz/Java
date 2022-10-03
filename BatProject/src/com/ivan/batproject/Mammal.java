package com.ivan.batproject;

public class Mammal {
	protected int energyLevel;  //Data Member

	
	
	//---CONSTRUCTOR--- FUNCTIONS
	
	public Mammal() {
		this.energyLevel = 100;  //This defines the energy level to 100
	}
	
	//OVERLOADED CONSTRUCTOR basically this will allow to give a mammal a custom energy level
//	public Mammal(int energy) {
//		this.energyLevel = energy;
//	}
	
	public void displayEnergy() {
		System.out.printf("this mammal has energy level :%d", this.energyLevel);
	}
	
	//GETTERS AND SETTERS

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
