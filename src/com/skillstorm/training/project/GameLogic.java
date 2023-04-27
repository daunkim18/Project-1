package com.skillstorm.training.project;

import java.util.Scanner;

public class GameLogic {
	static Scanner scanner = new Scanner(System.in);
	static Player player;
	public static boolean isRunning;

	public static String[] encounters = {"Battle", "Rest", "Shop" };
	public static String[] enemies = { "Dritarian Warrior", "Dritarian Ranger", "Dritarian Sorceror", "Dritarian Berserker" };

	// scene elements
	public static int place = 0, act = 1;
	public static String[] places = { "Magnarian War Camp", "The Road", "Rendesvous Point", "Friendly Magnarian Camp" };

	// method to get user input
	public static int readInt(String prompt, int userChoices) {
		int input;

		do {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(scanner.next());
			} catch (NumberFormatException e) {
				input = -1;
				System.out.println("Please enter an integer");
			}
		} while (input < 1 || input > userChoices);
		return input;
	}

	// method to clear out console
	public static void clearConsole() {
		for (int i = 0; i < 100; i++)
			System.out.println();
	}

	public static void printSeperator(int n) {
		for (int i = 0; i < 100; i++)
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

	// start game method
	public static void startGame() {
		boolean nameSet = false;
		String name;
		// print title screen
		clearConsole();
		printSeperator(40);
		printSeperator(30);
		System.out.println("     THE CAMPAIGN"
				+ "\n           /\\_/\\  \r\n"
				+ "     ____/ o o \\\r\n"
				+ "   /~____  =ø= / \r\n"
				+ "(______)__m_m) \r\n"
				+ "       \n    ADVENTURE ");
		System.out.println("\nCreated by Daun Kim");
		printSeperator(30);
		printSeperator(40);
		anythingToContinue();

		// get player name
		do {
			clearConsole();
			printHeading("What's your name?");
			name = scanner.next();
			// ask if he wants to correct his choice
			clearConsole();
			printHeading("Your name is " + name + ".\nIs that correct?");
			System.out.println("1. Yes! ");
			System.out.println("2. No! Change my name please");
			int input = readInt("-> ", 2);
			if (input == 1)
				nameSet = true;
		} while (!nameSet);

		// scene
		Scene.printIntro();

		// create new player object
		player = new Player(name);
		Scene.printFirst();

		// game loop can continue
		isRunning = true;

		// Start main game loop
		gameLoop();
		
		boolean playAgain = true;
		while (playAgain) {
			boolean nameSet1 = false;
			String name1;
			// print title screen
			// ...
			// game loop can continue
			isRunning = true;
			// Start main game loop
			gameLoop();
			// game has ended, ask user to play again
			clearConsole();
			printHeading("Congratulations! You have won the game!");
			System.out.println("Do you want to play again?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int input = readInt("-> ", 2);
			if (input == 2) {
				playAgain = false;
				Scene.printEnd(player);
			}
		}
	}

	// method changing values based on player experience points
	public static void changeVal() {
		if (player.experiencept >= 10 && act == 1) {
			act = 2;
			place = 2;
			Scene.printIntro();
			player.chooseTrait();
			Scene.printFirst();
			// enemy values
			enemies[0] = "Dritarian Warrior";
			enemies[1] = "Dritarian Ranger";
			enemies[2] = "Evil monster3";
			enemies[3] = "Evil monster4";
			enemies[4] = "Evil monster5";
			encounters[0] = "Battle 1";
			encounters[1] = "Battle 2";
			encounters[2] = "Battle 3";
			encounters[3] = "Battle 4";
			encounters[4] = "Battle 5";
			// fully recover player
			player.healthpt = player.maxhealthpt;
		} else if (player.experiencept >= 3 && act == 2) {
			act = 3;
			place = 1;
			Scene.printFirst();
			player.chooseTrait();
			Scene.printSecond();
		} else if (player.experiencept >= 3 && act == 3) {
			act = 4;
			place = 3;
			Scene.printSecond();
			player.chooseTrait();
			Scene.printThird();
			// fully recover player
			player.healthpt = player.maxhealthpt;
			finalBattle();
		} else if (player.experiencept >=3 && act == 4) {
			Scene.printEnd(player);
		}
	}

	private static void randomEncounter() {
		// TODO Auto-generated method stub
		int encounter = (int) (Math.random() * encounters.length);
		if (encounters[encounter].equals("Battle")) {
			randomBattle();
		} else if (encounters[encounter].equals("Rest")) {
			takeRest();
		} else {
			shop();
			Scene.printEnd(player);
		}
	}

	private static void continueJourney() {
		// TODO Auto-generated method stub
		changeVal();
		if (act != 4)
			randomEncounter();

	}

	// player character
	public static void charInfo() {
		clearConsole();
		printHeading("CHARACTER INFORMATION");
		System.out.println(player.name + "\tHealth Point: " + player.healthpt + "/" + player.maxhealthpt);
		printSeperator(20);

		// experience point and item
		System.out.println("Experience Point: " + player.experiencept + "\tGold: " + player.money);
		printSeperator(20);

		// medicine
		System.out.println("Number of Medicine: " + player.medicine);
		printSeperator(20);

		// chosen trait
		if (player.numAttackSkill > 0) {
			System.out.println("Offensive trait: " + player.attackSkill[player.numAttackSkill - 1]);
			printSeperator(20);
		}
		if (player.numDefendSkill > 0) {
			System.out.println("Defensive trait: " + player.defendSkill[player.numDefendSkill - 1]);
			printSeperator(20);
		}

		anythingToContinue();

	}

	// shop
	public static void shop() {
		clearConsole();
		printHeading("\nAt the rendevous point, you find a crumbling watch tower, a lone Magnarian soldier beckons you in"
						+ "\nI'm all that's left he says. If you need to resupply I have some goods. Take a look! ");
//		player.money = 5;
//		int price = (int) (Math.random() * (1 + player.money) );
//		System.out.println("The price is $" + price);
//		printSeperator(20);
//		// ask to buy
//		System.out.println("Do you want to buy one? \n1. Yes \n2. No thank you");
//		int input = readInt("-> ", 2);
//		if (input == 1);
//		// buy
//		clearConsole();
//		if (player.money >= price) {
//			printHeading("You bought the medicine for $" + price);
//			player.money++;
//			player.money -= price;
//		} else {
//			printHeading("You don't have enough money");
//			anythingToContinue();
//		}
		System.out.println("You went to a shop and purchased a health potion.");
		player.healthpt += 3;
		player.money -= 1;
		anythingToContinue();
	}

	// take rest
	public static void takeRest() {
		clearConsole();
//		// random drop
//		boolean addRest = (Math.random() * 5 + 1 <= 2.25);
//		int moneyEarned = (int) (Math.random() * enemy.experiencept);
//		if (addRest) {
//			player.restsLeft++;
//			System.out.println("You earned the chance to get additional rest!");
//		}
//		if (moneyEarned > 0)
//			player.money += moneyEarned;
//		System.out.println("You collect " + moneyEarned + " from the " + enemy.name + "'s corpse!");
//	}
//	anythingToContinue();
//	break;
		if (player.restsLeft >= 1) {
			printHeading(
					"Also if you need rest, " + "there's a bunk you can use in the back. Do you want to take a rest? ("
							+ player.restsLeft + "rests left");
			System.out.println("1. Yes 2. No. I'm good!");
			int input = readInt("->", 2);
			if (input == 1) {
				clearConsole();
				if (player.healthpt < player.maxhealthpt) {
					int hpRestored = (int) (Math.random() * (player.experiencept / 4 + 1) + 10);
					player.healthpt += hpRestored;
					if (player.healthpt > player.maxhealthpt)
						player.healthpt = player.maxhealthpt;
					System.out.println("You took a rest and are restored up to " + hpRestored + " health points");
					System.out.println(
							"You are now at  " + player.healthpt + "/" + player.maxhealthpt + " health points");
					player.restsLeft--;
				}
			} else
				System.out.println("You are at full health. You don't need to rest now!");
			anythingToContinue();
		}
	}

//	// random battle
	public static void randomBattle() {
		clearConsole();
		printHeading("You encountered a " + enemies[(int) (Math.random() * enemies.length)] + "!");
		anythingToContinue();

		battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.experiencept));
	}
	

	// battle method
	public static void battle(Enemy enemy) {
		while (true) {
			clearConsole();
			printHeading(enemy.name + "\nHealth Point: " + enemy.healthpt + "/" + enemy.maxhealthpt);
			printHeading(player.name + "\nHealth Point: " + player.healthpt + "/" + player.maxhealthpt);
			System.out.println("Choose an action: ");
			printSeperator(20);
			System.out.println("1. Fight");
			System.out.println("2. Take Rest/Medicine");
			System.out.println("3. Run away");
			int input = readInt("->", 3);
			if (input == 1) {
				// fight
				int damage = player.attack() - enemy.defend();
				int damageTook = enemy.attack() - player.defend();
				if (damageTook < 0) {
					damage -= damageTook / 2;
					damageTook = 0;
				}
				if (damage < 0)
					damage = 0;
				player.healthpt -= damageTook;
				enemy.healthpt -= damage;
				clearConsole();
				printHeading("BATTLE");
				System.out.println("You had " + damage + " damages to the " + enemy.name + ".");
				printSeperator(20);
				System.out.println("The " + enemy.name + " had " + damageTook + " damage to you");
				anythingToContinue();
				if (player.healthpt <= 0) {
					playerDied();
					break;
				} else if (enemy.healthpt <= 0) {
					// win
					clearConsole();
					System.out.println("You defeated " + enemy.name);
					// experience point up
					player.experiencept += enemy.experiencept;
					System.out.println("You earned " + enemy.experiencept + " experience points");
					anythingToContinue();
					break;
				}

			} else if (input == 2) {
				// use medicine
				clearConsole();
				if (player.medicine > 0 && player.healthpt < player.maxhealthpt) {
					// medicine question
					printHeading("Do you want to take medicine? (" + player.medicine + " left).");
					System.out.println("1. Yes \n 2. No");
					input = readInt("-> ", 2);
					if (input == 1) {
						player.healthpt = player.maxhealthpt;
						clearConsole();
						printHeading("You drank medicine. It restored your health back to " + player.maxhealthpt);
						anythingToContinue();
					}
				} else {
					// can't take medicine
					printHeading("You dont have any medicine or you're at full health");
					anythingToContinue();
				}
			} else {
				// run away
				clearConsole();
				if (act != 3) {
					// 35% chance to escape
					if (Math.random() * 10 + 1 <= 3.5) {
						printHeading("You ran away from " + enemy.name);
						anythingToContinue();
						break;
					} else {
						printHeading("You didn't manage to escape");
						int damageTook = enemy.attack();
						System.out.println("In your hurry you took " + damageTook + " damages");
						anythingToContinue();
						// alive?
						if (player.healthpt <= 0)
							playerDied();
					}
				} else {
					// can't escape
					printHeading("You can't escape the enemy");
					anythingToContinue();
				}
			}
		}

	}

	
	
	// print menu
	public static void printMenu() {
		clearConsole();
		printHeading(places[place]);
		System.out.println("Choose an action: ");
		printSeperator(20);
		System.out.println("1. Continue on your journey");
		System.out.println("2. Character Information");
		System.out.println("3. Exit the game");
	}

	// final battle
	public static void finalBattle() {
		battle(new Enemy("THE WORST ENEMY", 300));
		Scene.printEnd(player);
		isRunning = false;
	}

	

	// die
	public static void playerDied() {
		clearConsole();
		printHeading("You are dead! Your body now lies in an unmarked grave off the side of an unknown road.");
		printHeading("You earned " + player.experiencept + " points on your journey");
		System.out.println("Thanks for playing the game!");
		isRunning = false;
	}

	// main game loop
	public static void gameLoop() {
		while (isRunning) {
////			printMenu();
////			int input = readInt("-> ", 3);
////			if (input == 1)
////				continueJourney();
////			else if (input == 2)
////				charInfo();
////			else
////				isRunning = false;
////			System.out.println("You died! Thank you for playing the game. See you again!");
//			 charInfo();
//		        Scene.printCurrent(places[place]);
//		        continueJourney();
//		    }
//		    // call randomEncounter method before ending the game
//		    randomEncounter();
//		}
			// print current scene and player info
			Scene.printCurrent(places[place]);
			charInfo();

			// check for random encounters
			if (place == 1 && act == 1) {
				Scene.printFirst();
				continueJourney();
			} else if (place == 2 && act == 2) {
				Scene.printSecond();
				continueJourney();
			} else if (place == 3 && act == 3) {
				Scene.printThird();
				continueJourney();
			} else {
				finalBattle();
				isRunning = false;
				break;
			}
		}
	}


	}


