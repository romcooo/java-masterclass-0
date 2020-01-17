package com.romco.srp;

import java.util.ArrayList;
import java.util.List;

public class Journal {
    private List<String> entries;
    
    public Journal() {
        this.entries = new ArrayList<>();
    }
    
    public void addEntry(String text) {
        entries.add(text);
    }
    
    public void removeEntry(int index) {
        entries.remove(index);
    }
    
    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
    
}

class Demo {
    public static void main(String[] args) {
        Journal j = new Journal();
        j.addEntry("I cried");
        j.addEntry("I ate a bug");
        System.out.println(j);
    }
}