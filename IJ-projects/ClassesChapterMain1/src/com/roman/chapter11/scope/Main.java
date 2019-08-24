package com.roman.chapter11.scope;

public class Main {
    public static void main(String[] args) {
        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.timesTwo();

        int publicVar = 2;

        System.out.println(publicVar);

        ScopeCheck.InnerClass inner = scopeInstance.new InnerClass();
        inner.timesTwo();
    }


}
