package com.roman.Chapter8.ArrayLists.Challenge;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts;
    private String phoneName;

    public MobilePhone(final String phoneName) {
        this.phoneName = phoneName;
        this.contacts = new ArrayList<>();
    }


    public boolean addContact(String name, String phoneNumber) {
        if (getIndexByName(name) < 0 && getIndexByPhoneNumber(phoneNumber) < 0) {
            this.contacts.add(new Contact(name, phoneNumber));
            System.out.println("Contact added.");
            return true;
        } else {
            System.out.println("Contact with this name or number already exists.");
            return false;
        }
    }

    public boolean removeContact(String name) {
        if (getIndexByName(name) >= 0) {
            Contact removedItem = this.contacts.remove(getIndexByName(name));
            System.out.println(removedItem.getName() + " was removed from the list.");
            return true;
        } else {
            System.out.println("No contact with name "+name+" exists.");
            return false;
        }
    }

    public boolean modifyContact(String name, String phoneNumber) {
        if (getIndexByName(name) >= 0) {
            this.contacts.get(getIndexByName(name)).setPhoneNumber(phoneNumber);
            System.out.println(name + " had phone number updated to " + phoneNumber);
            return true;
        } else {
            System.out.println("No contact with name "+name+" exists.");
            return false;
        }
    }

    public void printContacts() {
        System.out.println("Contact list of this phone:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("\t" + (i+1) + ". - " + contacts.get(i).getName() + " - " + contacts.get(i).getPhoneNumber());
        }
    }

    public Contact findContact(String property) {
        if (getIndexByName(property) >= 0) {
            Contact foundContact = this.contacts.get(getIndexByName(property));
            System.out.println("Found by name: "+ foundContact.getName() + " - " + foundContact.getPhoneNumber());
            return foundContact;
        } else if (getIndexByPhoneNumber(property) >= 0) {
            Contact foundContact = this.contacts.get(getIndexByPhoneNumber(property));
            System.out.println("Found by phone number: "+ foundContact.getName() + " - " + foundContact.getPhoneNumber());
            return foundContact;
        } else {
            System.out.println("No contact with such name nor number exists.");
            return null;
        }
    }

    public String findContactName(String property) {
        if (getIndexByName(property) >= 0) {
            Contact foundContact = this.contacts.get(getIndexByName(property));
            System.out.println("Found by name: "+ foundContact.getName() + " - " + foundContact.getPhoneNumber());
            return foundContact.getName();
        } else if (getIndexByPhoneNumber(property) >= 0) {
            Contact foundContact = this.contacts.get(getIndexByPhoneNumber(property));
            System.out.println("Found by phone number: "+ foundContact.getName() + " - " + foundContact.getPhoneNumber());
            return foundContact.getName();
        } else {
            System.out.println("No contact with such name nor number exists.");
            return null;
        }
    }

    public String findContactNumber(String property) {
        if (getIndexByName(property) >= 0) {
            Contact foundContact = this.contacts.get(getIndexByName(property));
            System.out.println("Found by name: "+ foundContact.getName() + " - " + foundContact.getPhoneNumber());
            return foundContact.getPhoneNumber();
        } else if (getIndexByPhoneNumber(property) >= 0) {
            Contact foundContact = this.contacts.get(getIndexByPhoneNumber(property));
            System.out.println("Found by phone number: "+ foundContact.getName() + " - " + foundContact.getPhoneNumber());
            return foundContact.getPhoneNumber();
        } else {
            System.out.println("No contact with such name nor number exists.");
            return null;
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
