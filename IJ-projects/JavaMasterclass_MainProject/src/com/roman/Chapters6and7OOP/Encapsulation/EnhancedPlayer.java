package com.roman.Chapters6and7OOP.Encapsulation;

public class EnhancedPlayer {
    private String name;
    private int hitpoints = 100;
    private String weapon;

    public EnhancedPlayer(final String name, final int health, final String weapon) {
        this.name = name;
        if(health > 0 && health <= 100) {
            this.hitpoints = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.hitpoints -= damage;
        if (this.hitpoints <= 0) {
            System.out.println("Player knocked out");
        } else {
            System.out.println("Player reduced to " + hitpoints);
        }
    }

    public int getHealth() {
        return hitpoints;
    }
}
