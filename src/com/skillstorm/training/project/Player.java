package com.skillstorm.training.project;

import java.util.Scanner;

public class Player extends Character {

	// store number of skills
	public int numAttackSkill, numDefendSkill;

	// skill array
	public String[] attackSkill = { "Strength", "Dexterity", "Wisdom" };
	public String[] defendSkill = { "Armor", "Magic Shield", "Agility" };

	int money;
	int medicine;
	int restsLeft;

	// specific player constructor
	public Player (String name) {
		super(name, 5, 0);

		this.numAttackSkill = 0;
		this.numDefendSkill = 0;
		this.money = 10;
		this.restsLeft = 1;
		this.medicine = 5;
		// TODO Auto-generated constructor stub
		// player choose trait when creating a player
		chooseTrait();
	}

	
	@Override
	public int attack() {
		// TODO Auto-generated method 
		return (int) (Math.random()*(experiencept/4 + numAttackSkill*3 + 3) + experiencept/10 + numAttackSkill*2 + numDefendSkill +1);
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(experiencept/4+numAttackSkill*3 + 3)+ experiencept/10 + numAttackSkill*2 + numDefendSkill +1);
	}

	public void chooseTrait() {
		GameLogic.clearConsole();
		GameLogic.printHeading("Choose a trait");
		System.out.println("1 " + attackSkill[numAttackSkill]);
		System.out.println("2 " + defendSkill[numDefendSkill]);

		// player choice
		int input = GameLogic.readInt("-> ", 2);
		GameLogic.clearConsole();

		// deal with both cases
		if (input == 1) {
			GameLogic.printHeading("You chose " + attackSkill[numAttackSkill]);
			numAttackSkill++;
		} else {
			GameLogic.printHeading("You chose " + defendSkill[numDefendSkill]);
			numDefendSkill++;
		}
		GameLogic.anythingToContinue();
	}


	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
