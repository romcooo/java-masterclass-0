package com.romco.behavioral.cor;

import java.util.ArrayList;
import java.util.List;

abstract class Creature
{
    public abstract int getAttack();
    public abstract int getDefense();
}

class Goblin extends Creature
{
    private Game game;
    public Goblin(Game game)
    {
        this.game = game;
        game.creatures.add(this);
    }
    
    @Override
    public int getAttack()
    {
        int attack = 1;
        if ((game.creatures.stream().anyMatch((c) -> c instanceof GoblinKing)) && !(this instanceof GoblinKing)) {
            attack++;
        }
        return attack;
    }
    
    @Override
    public int getDefense()
    {
        int defense = 1;
        defense += game.creatures.stream()
                .filter(creature -> creature instanceof Goblin)
                .count() - 1;
        return defense;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ": " +
                getAttack() +
                "/" +
                getDefense();
    }
}

class GoblinKing extends Goblin
{
    public GoblinKing(Game game)
    {
        super(game);
    }
    
    @Override
    public int getAttack() {
        return super.getAttack() + 2;
    }
    
    @Override
    public int getDefense() {
        return super.getDefense() + 2;
    }
}

enum Statistic
{
    ATTACK, DEFENSE
}

class Game
{
    public List<Creature> creatures = new ArrayList<>();
}

public class ChainOfResponsibilityChallenge {
    public static void main(String[] args) {
        Game game = new Game();
        Goblin goblin = new Goblin(game);
        game.creatures.forEach(System.out::println);
        System.out.println("===");
        Goblin goblin1 = new Goblin(game);
        game.creatures.forEach(System.out::println);
        System.out.println("===");
        GoblinKing goblinKing = new GoblinKing(game);
        game.creatures.forEach(System.out::println);
        System.out.println("===");
        Goblin goblin2 = new Goblin(game);
        game.creatures.forEach(System.out::println);
        System.out.println("=====");
        System.out.println(goblin.getAttack() + "/" + goblin.getDefense());
    }
}
