package com.roman.Chapter8.ArrayLists.LessonNotes;

import java.util.ArrayList;

public class GroceryList {
//    private int[] myNumbers;
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

    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
    }

    public void removeGroceryItem(int position) {
        groceryList.remove(position);
    }

    public String findItem(String searchItem) {
        boolean exists = groceryList.contains(searchItem);
        if (exists) {
            return String.valueOf(groceryList.indexOf(searchItem));
        } else return "does not exist";
    }



}
