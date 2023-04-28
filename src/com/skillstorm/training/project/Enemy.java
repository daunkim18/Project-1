package com.skillstorm.training.project;

public class Enemy extends Character {

	int playerXp;

	public Enemy(String name, int playerXp) {
		super(name, (int) (Math.random() * playerXp + playerXp + 1), (int) (Math.random() * (playerXp + 1) + 1));
		this.playerXp = playerXp;
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return (int) (Math.random() * (playerXp + 1) + experiencept + 1);
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return (int) (Math.random() * (playerXp + 1) + experiencept + 1);
	}

}
