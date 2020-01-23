package com.romco.creational.singleton;

import java.io.File;

class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() throws Exception {
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }
    
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to create the singleton.");
        }
    }
    
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

public class StaticBlockSingletonDemo {

}
