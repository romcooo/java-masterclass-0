package com.roman.Encapsulation;

public class Player {
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println("Player knocked out");
        } else {
            System.out.println("Player reduced to " + health);
        }
    }

    public int healthRemaining() {
        return health;
    }

}
