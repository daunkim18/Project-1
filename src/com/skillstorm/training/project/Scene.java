package com.skillstorm.training.project;

public class Scene {
	private String description;
	private String[] choices;
	private int[] propertyRequirements;
	private String[] outcomes;

	public Scene(String description, String[] choices, int[] propertyRequirements, String[] outcomes) {
		this.description = description;
		this.choices = choices;
		this.setPropertyRequirements(propertyRequirements);
		this.setOutcomes(outcomes);
	}

	public void play(Player player) {
		System.out.println(description);
		for (int i = 0; i < choices.length; i++) {
			System.out.println((i + 1) + ". " + choices[i]);
		}
	}

	public int[] getPropertyRequirements() {
		return propertyRequirements;
	}

	public void setPropertyRequirements(int[] propertyRequirements) {
		this.propertyRequirements = propertyRequirements;
	}

	public String[] getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(String[] outcomes) {
		this.outcomes = outcomes;
	}
}
