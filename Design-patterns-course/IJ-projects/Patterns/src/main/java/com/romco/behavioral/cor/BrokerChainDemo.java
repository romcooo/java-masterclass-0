package com.romco.behavioral.cor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

//CQS
class Event<Args> {
    private int index = 0;
    private Map<Integer, Consumer<Args>> handlers = new HashMap<>();
    
    public int subscribe(Consumer<Args> handler) {
        int i = index;
        handlers.put(index, handler);
        index++;
        return i;
    }
    
    public void unsubscribe(int key) {
        handlers.remove(key);
    }

    public void fire(Args args) {
        for (Consumer<Args> handler : handlers.values()) {
            handler.accept(args);
        }
    }
}

class Query {
    public String creatureName;
    enum Argument {
        ATTACK, DEFENSE
    }
    public Argument argument;
    public int result;
    
    public Query(String creatureName, Argument argument, int result) {
        this.creatureName = creatureName;
        this.argument = argument;
        this.result = result;
    }
}

class Game2 {
    public Event<Query> queries = new Event<>();
    
}

class MyCreature {
    private Game2 game;
    public String name;
    public int baseAttack, baseDefense;
    
    public MyCreature(Game2 game, String name, int baseAttack, int baseDefense) {
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }
    
    
    public int getAttack() {
        Query q = new Query(name, Query.Argument.ATTACK, baseAttack);
        game.queries.fire(q);
        return q.result;
    }
    
    public int getDefense() {
        Query q = new Query(name, Query.Argument.DEFENSE, baseDefense);
        game.queries.fire(q);
        return q.result;
    }
    
    @Override
    public String toString() {
        return "MyCreature{" +
                "game=" + game +
                ", name='" + name + '\'' +
                ", attack=" + getAttack() +
                ", defense=" + getDefense() +
                '}';
    }
}

class MyCreatureModifier {
    protected Game2 game;
    protected MyCreature myCreature;
    
    public MyCreatureModifier(Game2 game, MyCreature myCreature) {
        this.game = game;
        this.myCreature = myCreature;
    }
    
}

class MyDoubleAttackModifier extends MyCreatureModifier implements AutoCloseable {
    private final int token;
    
    public MyDoubleAttackModifier(Game2 game, MyCreature myCreature) {
        super(game, myCreature);
        
        token = game.queries.subscribe(q -> {
            if (q.creatureName.equalsIgnoreCase(myCreature.name) && q.argument == Query.Argument.ATTACK) {
            q.result *= 2;
            }
        });
    }
    
    @Override
    public void close() {
        game.queries.unsubscribe(token);
    }
}

class MyIncreaseDefenseModifier extends MyCreatureModifier {
    public MyIncreaseDefenseModifier(Game2 game, MyCreature myCreature) {
        super(game, myCreature);
    
        game.queries.subscribe(q -> {
            if (q.creatureName.equalsIgnoreCase(myCreature.name) && q.argument == Query.Argument.DEFENSE) {
                q.result += 3;
            }
        });
    }
}



public class BrokerChainDemo {
    public static void main(String[] args) {
        Game2 game = new Game2();
        MyCreature gryffin = new MyCreature(game, "gryffin", 2, 2);
        System.out.println(gryffin);
    
        MyIncreaseDefenseModifier myIncreaseDefenseModifier = new MyIncreaseDefenseModifier(game, gryffin);
        System.out.println(gryffin);
        
        
    }
}
