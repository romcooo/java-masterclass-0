package com.roman.Chapter8.ArrayLists.Challenge;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts;
    private String phoneName;

    public MobilePhone(final String phoneName) {
        this.phoneName = phoneName;
        this.contacts = new ArrayList<Contact>();
    }


    public void addContact(String name, String phoneNumber) {
        if (getIndexByName(name) < 0 && getIndexByPhoneNumber(phoneNumber) < 0) {
            this.contacts.add(new Contact(name, phoneNumber));
            System.out.println("Contact added.");
        } else {
            System.out.println("Contact with this name or number already exists.");
        }
    }

    public void removeContact(String name) {
        if (getIndexByName(name) >= 0) {
            Contact removedItem = this.contacts.remove(getIndexByName(name));
            System.out.println(removedItem.getName() + " was removed from the list.");
        } else {
            System.out.println("No contact with name "+name+" exists.");
        }
    }

    public void modifyContact(String name, String phoneNumber) {
        if (getIndexByName(name) >= 0) {
            this.contacts.get(getIndexByName(name)).setPhoneNumber(phoneNumber);
            System.out.println(name + " had phone number updated to " + phoneNumber);
        } else {
            System.out.println("No contact with name "+name+" exists.");
        }
    }

    public void printContacts() {
        System.out.println("Contact list of this phone:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("\t" + (i+1) + ". - " + contacts.get(i).getName() + " - " + contacts.get(i).getPhoneNumber());
        }
    }

    public void findContact(String property) {
        if (getIndexByName(property) >= 0) {
            Contact found = this.contacts.get(getIndexByName(property));
            System.out.println("Found by name: "+ found.getName() + " - " + found.getPhoneNumber());
            return;
        } else if (getIndexByPhoneNumber(property) >= 0) {
            Contact found = this.contacts.get(getIndexByPhoneNumber(property));
            System.out.println("Found by phone number: "+ found.getName() + " - " + found.getPhoneNumber());
            return;
        } else {
            System.out.println("No contact with such name nor number exists.");
        }
    }

    private int getIndexByName(String name) {
        for (Contact contact:contacts) {
//            System.out.println("looking through contacts, current name: " + contact.getName());
            if (contact.getName().toLowerCase().equals(name.toLowerCase())) {
                return contacts.indexOf(contact);
            }
        }
        return -1;
    }

    private int getIndexByPhoneNumber(String phoneNumber) {
        for (Contact contact:contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber))
                return contacts.indexOf(contact);
        }
        return -1;
    }

}
