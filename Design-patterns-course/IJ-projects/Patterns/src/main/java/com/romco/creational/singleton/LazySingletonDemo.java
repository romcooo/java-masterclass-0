package com.romco.singleton;

import org.w3c.dom.ls.LSException;

class LazySingleton {
    private volatile static LazySingleton instance;
    private int i = 0;
    
    private LazySingleton() {
        System.out.println("lazy singleton initialization");
        i = 1;
    }
    
//    public synchronized static LazySingleton getInstance() {
//        if (instance == null) {
//            System.out.println("creating");
//            return instance = new LazySingleton();
//        }
//        System.out.println("existed");
//        return instance;
//    }
    
    public int getI() {
        return i;
    }
    
    // double-checked locking with a volatile instance - outdated
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    System.out.println("creating");
                    return instance = new LazySingleton();
                }
            }
        }
        System.out.println("existed");
        return instance;
    }
    
}

public class LazySingletonDemo {
    public static void main(String[] args) {
        System.out.println(LazySingleton.getInstance().getI());
        System.out.println("=====");
        
        LazySingleton s1 = LazySingleton.getInstance();
        System.out.println(s1.getI());
        s1 = LazySingleton.getInstance();
        System.out.println(s1.getI());
        System.out.println("=====");
        
        System.out.println(LazySingleton.getInstance().getI());
    }
}
