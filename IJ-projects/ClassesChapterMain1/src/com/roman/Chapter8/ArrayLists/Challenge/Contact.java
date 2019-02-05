package com.roman.Chapter8.ArrayLists.Challenge;

public class Contact {
    private String phoneNumber;
    private String name;

    public Contact(final String name, final String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
//        System.out.println("getting name");
        return name;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
