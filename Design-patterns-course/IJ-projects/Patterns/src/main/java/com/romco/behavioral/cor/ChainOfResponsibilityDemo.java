package com.romco.behavioral.cor;

class Creature2 {
    public String name;
    public int attack, defense;
    
    public Creature2(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }
    
    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }
}

class CreatureModifier2 {
    protected Creature2 creature;
    protected CreatureModifier2 next;
    
    public CreatureModifier2(Creature2 creature) {
        this.creature = creature;
    }
    
    public void setNext(CreatureModifier2 next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.setNext(next);
        }
    }
    
    public void handle() {
        if (this.next != null) {
            this.next.handle();
        }
    }
}

class DoubleAttackModifier extends CreatureModifier2 {
    public DoubleAttackModifier(Creature2 creature) {
        super(creature);
    }
    
    @Override
    public void handle() {
        System.out.println("Doubling " + creature.name + "'s attack");
        creature.attack *= 2;
        super.handle();
    }
}

class IncreaseDefenseModifier extends CreatureModifier2 {
    public IncreaseDefenseModifier(Creature2 creature) {
        super(creature);
    }
    
    @Override
    public void handle() {
        System.out.println("Increasing " + creature.name + "'s defense");
        creature.defense += 3;
        super.handle();
    }
}

class DoubleDefenseModifier extends CreatureModifier2 {
    public DoubleDefenseModifier(Creature2 creature) {
        super(creature);
    }
    
    @Override
    public void handle() {
        System.out.println("Doubling " + creature.name + "'s defense");
        creature.defense *= 2;
        super.handle();
    }
}

public class ChainOfResponsibilityDemo {
    
    public static void main(String[] args) {
        Creature2 goblin = new Creature2("Goblin", 3, 3);
        System.out.println(goblin);
        CreatureModifier2 modifier = new CreatureModifier2(goblin);
        modifier.setNext(new DoubleAttackModifier(goblin));
        modifier.setNext(new IncreaseDefenseModifier(goblin));
        modifier.setNext(new DoubleDefenseModifier(goblin));
        modifier.handle();
        System.out.println(goblin);
    }
}
