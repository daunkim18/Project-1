package com.skillstorm.training.project;

public class Scene {
	public static void printIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("SCENE INTRODUCTION");
		GameLogic.printSeperator(30);
		System.out.println("The year is 1365, in the time of the Magnarian Eclipse.");
		GameLogic.anythingToContinue();
	}
	public static void printFirst() {
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("ACT I");
		GameLogic.printSeperator(30);
		System.out.println("After a short while the company begins to stir ");
		System.out.println("You see people walking quickly");
		System.out.println("Packing gear, taking down tents and preparing to hit the road");
		GameLogic.anythingToContinue();
	}
	public static void printSecond() {
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("ACT II");
		GameLogic.printSeperator(30);
		System.out.println("Narration: The year is 1365, in the time of the Magnarian Eclipse.");
		GameLogic.anythingToContinue();
	}
	public static void printEnd(Player player) {
		GameLogic.clearConsole();
		GameLogic.printSeperator(30);
		System.out.println("Congratulations, " + player.name + "! You defeated the enemy and saved the country!");
		GameLogic.printSeperator(30);
		System.out.println("The game was developed by Daun Kim for Project 1.");
		System.out.println("Thank you for playing the game!");
		GameLogic.anythingToContinue();
	}
}
