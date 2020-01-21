package com.romco.singleton;

import java.util.HashMap;

enum Subsystem {
    PRIMARY,
    AUXILIARY,
    FALLBACK
}

class Printer {
    
    private static int instanceCount = 0;
    
    private static HashMap<Subsystem, Printer> instances = new HashMap<>();
    
    private Printer() {
        instanceCount++;
        System.out.println("A total of + " + instanceCount + " has been created so far.");
    }
    
    public static Printer get(Subsystem ss) {
        if (instances.containsKey(ss)) {
            System.out.println(ss + " already exists.");
            return instances.get(ss);
        } else {
            Printer newInstance = new Printer();
            instances.put(ss, newInstance);
            return newInstance;
        }
    }
}

public class MultitonDemo {
    public static void main(String[] args) {
        Printer main = Printer.get(Subsystem.PRIMARY);
        Printer auxiliary = Printer.get(Subsystem.AUXILIARY);
        Printer auxiliary2 = Printer.get(Subsystem.AUXILIARY);
        Printer fallback = Printer.get(Subsystem.FALLBACK);
    }
}
