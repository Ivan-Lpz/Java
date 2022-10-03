package com.ivan.batproject;

public class Gorilla extends Mammal {

	//FUNCTIONS 
	public void throwBanana() {
		this.setEnergyLevel(this.getEnergyLevel()-5); //must set 
		System.out.println("Throwing banana");
		
	}
	
	public void displayEnergy() {
		System.out.printf("this gorilla has energy level :%d\n", this.getEnergyLevel()); //"\n" will create a new line
	}
	
	public void eatBanana() {
		this.setEnergyLevel(this.getEnergyLevel()+10);
		System.out.printf("Yumm Banana\n");
	}
	
	public void climbTree() {
		this.setEnergyLevel(this.getEnergyLevel()-10);
		System.out.printf("Gorilla just climbed tree\n");
	}
	
	

}
