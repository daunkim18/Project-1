package com.skillstorm.training.project;

public class Player {
    private int healthPoints;
    private int strength;
    private int wisdom;
    private int magic;
    private int experienceLevel;

    public Player(int healthPoints, int strength, int wisdom, int magic, int experienceLevel) {
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.wisdom = wisdom;
        this.magic = magic;
        this.experienceLevel = experienceLevel;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
