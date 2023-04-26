package com.skillstorm.training.project;

public abstract class Character {
	public String name;
	public int maxhealthpt, healthpt, experiencept;
	
	//constructor
	public Character(String name, int maxhealthpt, int experiencept) {
		this.name = name;
		this.maxhealthpt = maxhealthpt;
		this.experiencept = experiencept;
		this.healthpt = maxhealthpt;
	}
	//method for every character
	public abstract int attack();
	public abstract int defend();
	
}
