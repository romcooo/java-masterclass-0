package com.roman.chapter11.packages.example.game;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoints, locationX, locationY, combatAttack, combatDefense;
    private boolean alive;

    public Monster(final String name, final int hitPoints, final int combatAttack, final int combatDefense) {
        this(name, hitPoints, 0, 0, combatAttack, combatDefense, true);
    }

    public Monster(final String name, final int hitPoints, final int locationX, final int locationY, final int combatAttack, final int combatDefense, final boolean alive) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.locationX = locationX;
        this.locationY = locationY;
        this.combatAttack = combatAttack;
        this.combatDefense = combatDefense;
        this.alive = alive;
    }

    public boolean move(int x, int y) {
        if (this.alive) {
            this.locationX += x;
            this.locationY += y;
            System.out.println("Moved to position: X = " + this.locationX + ", Y = " + this.locationY);
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getCombatAttack() {
        return combatAttack;
    }

    public int getCombatDefense() {
        return combatDefense;
    }

    public boolean isAlive() {
        return alive;
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
        toSave.add(this.name);
        toSave.add(Integer.toString(this.hitPoints));
        toSave.add(Integer.toString(this.locationX));
        toSave.add(Integer.toString(this.locationY));
        toSave.add(Integer.toString(this.combatAttack));
        toSave.add(Integer.toString(this.combatDefense));
        toSave.add(Boolean.toString(this.alive));
        System.out.println("=========MONSTER SAVED");
        return toSave;
    }

    @Override
    public void load(final List<String> loader) {
        this.name = loader.get(0);
        this.hitPoints = Integer.parseInt(loader.get(1));
        this.locationX = Integer.parseInt(loader.get(2));
        this.locationY = Integer.parseInt(loader.get(3));
        this.combatAttack = Integer.parseInt(loader.get(4));
        this.combatDefense = Integer.parseInt(loader.get(5));
        this.alive = Boolean.parseBoolean(loader.get(6));
        System.out.println("=========MONSTER LOADED");
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                ", combatAttack=" + combatAttack +
                ", combatDefense=" + combatDefense +
                ", alive=" + alive +
                '}';
    }
}
