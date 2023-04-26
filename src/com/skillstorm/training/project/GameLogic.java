package com.skillstorm.training.project;

import java.util.Scanner;

public class GameLogic {
	static Scanner scanner = new Scanner(System.in);
	static Player player;
	public static boolean isRunning;
	
	//scene elements
	public static int place = 0, act;
	public static String[] places = {"Everland", "USA"};
	
	//method to get user input
	public static int readInt(String prompt, int userChoices) {
		int input;
		
		do {
			System.out.println(prompt);
			try {
				input =  Integer.parseInt(scanner.next());
			}catch(Exception e) {
				input = -1;
				System.out.println("Please enter an integer");
			}
		}while(input < 1 || input > userChoices);
		return input;
	}

	//method to clear out console
	public static void clearConsole() {
		for(int i = 0; i < 100; i++)
			System.out.println();
	}
	
	public static void printSeperator(int n) {
		for(int i = 0; i < 100; i++)
		System.out.print("-");
		System.out.println();
	}

	public static void printHeading(String title) {
		printSeperator(30);
		System.out.println(title);
		printSeperator(30);
	}
	
	public static void anythingToContinue() {
		System.out.println("Enter anything to continue");
		scanner.next();
		}
	
	//start game method
	public static void startGame() {
		boolean nameSet = false;
		String name;
		//print title screen
		clearConsole();
		printSeperator(40);
		printSeperator(30);
		System.out.println("The Campaign");
		System.out.println("Created by Daun Kim");
		printSeperator(30);
		printSeperator(40);
		anythingToContinue();
		
		//get player name
		do {
			clearConsole();
			printHeading("What's your name?");
			name =scanner.next();
					//ask if he wants to correct his choice
			clearConsole();
			printHeading("Your name is " + name + ".\nIs that correct?");
			System.out.println("1. Yes! ");
			System.out.println("2. No! Change my name please");
			int input  = readInt("-> " , 2);
			if(input == 1)
				nameSet = true;
		}while(!nameSet);
		
		//scene
		Scene.printIntro();
		
	//create new player object
		player = new Player(name);
		
		Scene.printFirst();
		
		
		isRunning = true; // game loop can continue
	//Start main game loop
		gameLoop();
		
	}
	
	public static void continueJourney() {
		
	}
	//player character
	public static void charInfo() {
		clearConsole();
		printHeading("CHARACTER INFORMATION");
		System.out.println(player.name + "\tHealth Point: " + player.healthpt + "/" + player.maxhealthpt);
		printSeperator(20);
		System.out.println("Experience Point: " + player.experiencept);
		printSeperator(20);
	
	//chosen trait
	if(player.numAttackSkill > 0) {
		System.out.println("Offensive trait: " + player.attackSkill[player.numAttackSkill - 1]);
		printSeperator(20);
	}
	if(player.numDefendSkill > 0) {
		System.out.println("Defensive trait: " + player.defendSkill[player.numDefendSkill - 1]);
		printSeperator(20);
		}

	anythingToContinue();
	
	}
	//print menu
	public static void printMenu() {
		clearConsole();
		printHeading(places[place]);
		System.out.println("Choose an action: ");
		printSeperator(20);
		System.out.println("1. Continue on your journey");
		System.out.println("2. Character Information");
		System.out.println("3. Exit the game");
	}
	
	
	//main game loop
	public static void gameLoop() {
		while(isRunning) {
			printMenu();
			int input = readInt("-> ", 3);
			if(input == 1)
				continueJourney();
			else if(input == 2)
				charInfo();
			else
			 isRunning = false;
				
		}
	}
}


