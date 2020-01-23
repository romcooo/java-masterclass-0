package com.romco.creational.singleton;

enum EnumSingleton {
    INSTANCE;
    
    private int value;
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
}

public class EnumSingletonDemo {
    public static void main(String[] args) {
        EnumSingleton q = EnumSingleton.INSTANCE;
    }
}
