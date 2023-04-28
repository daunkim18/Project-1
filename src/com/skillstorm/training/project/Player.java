package com.skillstorm.training.project;

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
	public Player(String name) {
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
		return (int) (Math.random() * (experiencept + numAttackSkill) + experiencept + 1 + numAttackSkill
				+ numDefendSkill + 1);
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return (int) (Math.random() * (experiencept + numAttackSkill) + experiencept + 1 + numAttackSkill
				+ numDefendSkill + 1);
	}

	public void chooseTrait() {
		GameController.clearConsole();
		GameController.printHeading("Choose a trait");
		System.out.println("1 " + attackSkill[numAttackSkill]);
		System.out.println("2 " + defendSkill[numDefendSkill]);

		// player choice
		int input = GameController.readInt("-> ", 2);
		GameController.clearConsole();

		// deal with both cases
		if (input == 1) {
			GameController.printHeading("You chose " + attackSkill[numAttackSkill]);
			numAttackSkill++;
		} else {
			GameController.printHeading("You chose " + defendSkill[numDefendSkill]);
			numDefendSkill++;
		}
		GameController.anythingToContinue();
	}

	public void reset() {
		// TODO Auto-generated method stub

	}

	public String visitShop() {
		// TODO Auto-generated method stub
		return null;
	}

}
