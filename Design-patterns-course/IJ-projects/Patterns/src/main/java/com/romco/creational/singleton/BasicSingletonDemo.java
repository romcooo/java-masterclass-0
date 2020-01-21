package com.romco.singleton;

import java.io.*;

class BasicSingleton implements Serializable {
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    int value = 0;
    
    private BasicSingleton() {
    
    }
    
    public static BasicSingleton getInstance() {
        return INSTANCE;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    protected Object readResolve() {
        return INSTANCE;
    }
}

public class BasicSingletonDemo {
    static void saveToFile(BasicSingleton singleton,
                           String fileName) throws Exception {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             final ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }
    
    static BasicSingleton readFromFile(String fileName) throws Exception {
        try (final FileInputStream fileIn = new FileInputStream(fileName);
             final ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        }
    }
    
    public static void main(String[] args) throws Exception {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);
        
        String fileName = "singleton.bin";
        saveToFile(singleton, fileName);
    
        singleton.setValue(222);
        
        BasicSingleton singleton2 = readFromFile(fileName);
    
        System.out.println(singleton == singleton2);
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }
}
