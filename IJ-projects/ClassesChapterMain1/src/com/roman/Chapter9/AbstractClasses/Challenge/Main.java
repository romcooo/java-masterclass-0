package com.roman.Chapter9.AbstractClasses.Challenge;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================");
        String string1 = "A";
        String string2 = "B";
        String string3 = "C";
        String string4 = "D";
        String string5 = "E";
        String string6 = "F";

        MyLinkedList myNewList = new MyLinkedList();
        myNewList.add(string1);
        myNewList.add(string2);
        myNewList.add(string6);
        myNewList.add(string3);
        myNewList.add(string4);
        myNewList.add(string5);

        myNewList.remove(string1);
        myNewList.remove(string4);
        myNewList.remove(string2);
        myNewList.remove(string3);

        myNewList.add(string3);
        // tu mam C, E, F

        myNewList.remove(string5);
        myNewList.remove(string1); //toto nema ist
        myNewList.remove(string6);
        myNewList.remove(string3);

        myNewList.remove(string6); //toto nema ist

        System.out.println("=================BINARY SEARCH TREE=============");

        BinarySearchTree tree = new BinarySearchTree();
        String longString1 = "F, A, C, B, E, G, W";
        addSetToList(longString1, tree);

        /* TREE:
                        F
             A                    G
                  C                        W
                B   E
        */

        tree.printPathToItem("C");
        tree.printPathToItem("B");
        tree.printPathToItem("E");
        tree.printPathToItem("W");
        tree.printPathToItem("F");

        System.out.println("=========");
        tree.printOrdered();

        tree.remove("C");
        tree.printOrdered();
    }

    private static void addSetToList(String comaSeparatedStrings, MyListInterface list) {
        String[] values = comaSeparatedStrings.split(",");
        for (String value:values) {
            list.add(value.trim());
        }
    }
}
