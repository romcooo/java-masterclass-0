package com.roman.OopMaster.Challenge.Test;

public class Main {
    public static void main(String[] args) {
        TestBurger test = new TestBurger("test", "bread", "meat", 1);
        test.showDetails();
        test.addAddition("1", 1);
        test.isFull();
        test.addAddition("2", 1);
        test.addAddition("3", 1);
        test.addAddition("4", 1);
        test.addAddition("5", 1);
        test.isFull();

        test.setMaxAdditions(5);
    }
}
