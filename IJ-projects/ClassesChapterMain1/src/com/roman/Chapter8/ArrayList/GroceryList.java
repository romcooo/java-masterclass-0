package com.roman.Chapter8.ArrayList;

import java.util.ArrayList;

public class GroceryList {
    private int[] myNumbers;
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("Grocery List:");
        for(int i = 0; i<groceryList.size(); i++) {
            System.out.println(groceryList.get(i));

        }
    }

}
