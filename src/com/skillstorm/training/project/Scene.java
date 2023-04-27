package com.skillstorm.training.project;

public class Scene {
	public static void printIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("SCENE INTRODUCTION");
		GameLogic.printSeperator(30);
		System.out.println("The year is 1365, in the time of the Magnarian Eclipse. "
				+ "\nIt is the 12th year of the Dritarian war fought ferrociously between the Dritarian and the invading Magnarian forces in which you have been in service of"
				+ "\nYou have been in the King's Army for 3 years. Orders have came down that your legion is to push North to replenish the ranks on the front."
				+ "\nThere's a rumor they've taken heavy casualties in the weeks since and you may be marching towards your death.. Are you ready for the adventure?");
		GameLogic.anythingToContinue();
	}

	public static void printFirst() {
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("STORY 1");
		GameLogic.printSeperator(30);
		System.out.println("After a short while the company begins to stir ");
		System.out.println("You see people walking quickly,packing gear, taking down tents and preparing to hit the road. "
				+ "\nDuring the break you hear a groan, quickly followed by one of your companions. "
				+ "\nBefore you kenw it, they are laying dead in a pool of their own blood. Out from the bush jumps a Dritarian warrior, in fact, now the company is now surrounded  by Dritarians!");
		GameLogic.anythingToContinue();
	}

	public static void printSecond() {
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("STORY 2");
		GameLogic.printSeperator(30);
		System.out.println("Carnage, Everyone around you either lies dead or dying. In the aftermath of the attack, though you fought bravely, you were no match for well placed ambush"
				+ "\nIt is their home, their rule and their turf. As the lone survivor, it is now up to you to complete the mission. "
				+ "\nA few kilometers north lies the front lines, s small outpost on a map marks the location of your rendevous point");
		GameLogic.anythingToContinue();
	}
	public static void printThird() {
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("STORY 3");
		GameLogic.printSeperator(30);
		System.out.println("As you leave the tower, you hear a noise in the woods...after further investiation it looks to be a small Dritarian scouting party");
		GameLogic.anythingToContinue();
	}

	public static void printEnd(Player player) {
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Congratulations, " + player.name + "!"
				+ "\nWith nothing left keeping you here, the only thing left to do is to report to the northern trenches. "
				+ "\nA few days on the path takes you to a place of complete desolation. You find a friendly camp. "
				+ "\nYou report to the commander and are told to make your way into the ranks. Orders are to push north tomorrow. Good night!");
		GameLogic.printSeperator(30);
		System.out.println("The game was developed by Daun Kim for Project 1.");
		System.out.println("Thank you for playing the game!");
		
	}

	public static void printCurrent(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void printScene(String string, int act) {
		// TODO Auto-generated method stub
		
	}
}
