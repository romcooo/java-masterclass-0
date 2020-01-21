package com.romco.singleton;

class InnerStaticSingleton {
    
    private int data = 0;
    
    private InnerStaticSingleton() {
    }
    
    private static class SingletonInit {
        // nested class is referenced after the getInstance() is called
        private static final InnerStaticSingleton instance = new InnerStaticSingleton();
    }
    
    public static InnerStaticSingleton getInstance() {
        return SingletonInit.instance;
    }
}

public class InnerStaticSingletonDemo {
}
