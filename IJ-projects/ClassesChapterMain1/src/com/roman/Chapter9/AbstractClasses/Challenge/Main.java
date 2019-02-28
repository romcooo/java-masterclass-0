package com.roman.Chapter9.AbstractClasses.Challenge;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================");
        String string1 = "A 1st string";
        String string2 = "B 2nd string";
        String string3 = "E 3rd string";
        String string4 = "G 4th string";
        String string5 = "D 5th string";

        MyLinkedList myNewList = new MyLinkedList();
        myNewList.add(string1);
        myNewList.add(string2);
        myNewList.add(string3);
        myNewList.add(string4);
        myNewList.add(string5);

    }
}
