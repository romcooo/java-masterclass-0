package com.roman.Chapter9.Interfaces.Challenge;

import java.util.ArrayList;
import java.util.List;

public class Character implements ISaveable {
    private String name, weapon, armour;
    private int hitPoints, locationX, locationY, combatAttack, combatDefense;
    private boolean alive;

    public Character(final String name) {
        this(name, null, null, 0, 0, 10, 5, 5, true);
    }

    public Character(final String name, final int hitPoints, final int combatAttack, final int combatDefense) {
        this(name, null, null, 0, 0, hitPoints, combatAttack, combatDefense, true);
    }

    private Character(final String name, final String weapon, final String armour, final int locationX, final int locationY, final int hitPoints, final int combatAttack, final int combatDefense, final boolean alive) {
        this.name = name;
        this.weapon = weapon;
        this.armour = armour;
        this.locationX = locationX;
        this.locationY = locationY;
        this.hitPoints = hitPoints;
        this.combatAttack = combatAttack;
        this.combatDefense = combatDefense;
        this.alive = alive;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean move(int x, int y) {
        this.locationX += x;
        this.locationY += y;
        System.out.println("Moved to position: X = " + this.locationX + ", Y = " + this.locationY);
        return true;
    }

    public void fight(Monster monster) {
        if (monster.getLocationX() == this.locationX && monster.getLocationY() == this.locationY) {
            System.out.println(this.name + " is attacking " + monster.getName() + ".");
            monster.attack(this.combatAttack);
            if (monster.isAlive()) {
                System.out.println(monster.getName() + " is attacking back!");
                this.attack(monster.getCombatAttack());
            }
        } else {
            System.out.println(this.name + " is too far from " + monster.getName() + " to fight it.");
        }
    }

    public void kill() {
        this.alive = false;
        System.out.println(this.name + " was killed.");
    }

    public void attack(int attack) {
        int damage = (attack - this.combatDefense);
        if (damage > 0) {
            this.hitPoints -= damage;
            System.out.println(this.name + " was dealt " + damage + " damage.");
            if (this.hitPoints <= 0) {
                this.kill();
            } else {
                System.out.println(this.name + " has " + this.hitPoints + " hit points left.");
            }
        } else {
            System.out.println(this.name + " successfully defended against the attack.");
        }
    }

    @Override
    public List<String> save() {
        List<String> toSave = new ArrayList<>();
        toSave.add(0, this.name);
        toSave.add(1, this.weapon);
        toSave.add(2, this.armour);
        toSave.add(3, Integer.toString(this.hitPoints));
        toSave.add(4, Integer.toString(this.locationX));
        toSave.add(5,Integer.toString(this.locationY));
        toSave.add(6, Integer.toString(this.combatAttack));
        toSave.add(7, Integer.toString(this.combatDefense));
        toSave.add(8, Boolean.toString(this.alive));
        System.out.println("=========CHARACTER SAVED");
        return toSave;
    }

    @Override
    public void load(final List<String> loader) {
        this.name = loader.get(0);
        this.weapon = loader.get(1);
        this.armour = loader.get(2);
        this.hitPoints = Integer.parseInt(loader.get(3));
        this.locationX = Integer.parseInt(loader.get(4));
        this.locationY = Integer.parseInt(loader.get(5));
        this.combatAttack = Integer.parseInt(loader.get(6));
        this.combatDefense = Integer.parseInt(loader.get(7));
        this.alive = Boolean.parseBoolean(loader.get(8));
        System.out.println("=========CHARACTER LOADED");
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", armour='" + armour + '\'' +
                ", hitPoints=" + hitPoints +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                ", combatAttack=" + combatAttack +
                ", combatDefense=" + combatDefense +
                ", alive=" + alive +
                '}';
    }
}
