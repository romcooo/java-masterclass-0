package com.roman.Chapter9.AbstractClasses.Challenge;

public class Main {
    public static void main(String[] args) {
        Node myList = new Node(new String("a"));
        System.out.println("first item: " + myList.getValue().toString());
        myList.add(new String("b"));

        myList = myList.next();

        myList.add(new String("a"));
        System.out.println(myList.getValue().toString());

    }
}
