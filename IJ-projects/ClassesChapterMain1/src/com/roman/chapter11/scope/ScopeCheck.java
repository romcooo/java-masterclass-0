package com.roman.chapter11.scope;

import sun.reflect.generics.scope.Scope;

public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        System.out.println("Scope check created.");
    }

    public void timesTwo() {
        int privateVar = 2;
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " times two is " + i * privateVar);
        }
    }

    public class InnerClass {
        public int privateVar = 3;

        public InnerClass() {
            System.out.println("Inner class created, private var is " + privateVar);
        }

        public void timesTwo() {
            ScopeCheck.this.timesTwo(); //calls the parent class method
            for (int i = 0; i <= 10; i++) {
                System.out.println(i + " times two is " + i * ScopeCheck.this.privateVar);
            }
        }

    }

}
