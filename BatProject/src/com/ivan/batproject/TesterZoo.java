package com.ivan.batproject;

public class TesterZoo {
	public static void main(String[] args) {
//		Mammal mam1 = new Mammal();   This will create a new mammal
//		mam1.displayEnergy();
		
		Gorilla gorilla1 = new Gorilla(); //This will create a new gorilla 
		gorilla1.displayEnergy(); //Will display energy level from the function in line 12 in gorilla file
		gorilla1.throwBanana();	  //Will throw a banana from the function in line 6 in gorilla file 	
		gorilla1.throwBanana();
		gorilla1.throwBanana();
		gorilla1.displayEnergy();
		gorilla1.eatBanana();	  //Will eat a banana from the function in line 16 in gorilla file 
		gorilla1.eatBanana();
		gorilla1.displayEnergy();
		gorilla1.climbTree();	  //Will climb a tree from the function in line 21 in gorilla file
		gorilla1.displayEnergy();
		
		
		Bat bat1 = new Bat(300);
		bat1.displayEnergy();
		bat1.attackTown();
		bat1.attackTown();
		bat1.attackTown();
		bat1.displayEnergy();
		bat1.eatHuman();
		bat1.eatHuman();
		bat1.displayEnergy();
		bat1.fly();
		bat1.fly();
		bat1.displayEnergy();
		

	}

}
