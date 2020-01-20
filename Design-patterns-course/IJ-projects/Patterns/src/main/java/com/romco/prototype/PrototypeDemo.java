package com.romco.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.Arrays;

class Address implements Cloneable {
    public String streetName;
    public int houseNumber;
    
    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }
    
    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        // here it works because String and int can be copied like this
        return new Address(streetName, houseNumber);
    }
}

class Person implements Cloneable {
    public String[] names;
    public Address address;
    
    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // here it will not work, because we're copying references so it is not a proper deep copy
//        return new Person(names, address);
        return new Person(
                names.clone(),
                (Address) address.clone());
    }
}

class NewAddress {
    public String streetAddress, city, country;
    
    public NewAddress(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }
    
    public NewAddress(NewAddress address) {
        this(address.streetAddress, address.city, address.country);
    }
    
    @Override
    public String toString() {
        return "NewAddress{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {
    public String name;
    public NewAddress newAddress;
    
    public Employee(String name, NewAddress newAddress) {
        this.name = name;
        this.newAddress = newAddress;
    }
    
    public Employee(Employee other) {
        this.name = other.name;
        this.newAddress = new NewAddress(other.newAddress);
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", newAddress=" + newAddress +
                '}';
    }
}

class Table implements Serializable {
     public int stuff;
     public String whatever;
    
    public Table(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }
    
    @Override
    public String toString() {
        return "Table{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person john = new Person(new String[]{"John", "Smith"},
                                 new Address("London Road", 123));
        
        Person jane = (Person) john.clone();
    
        jane.names[0] = "Jane";
        jane.address.houseNumber = 124;
    
        Employee mark = new Employee("mark", new NewAddress("London Road", "London", "UK"));
        Employee nate = new Employee(mark);
        nate.name = "Nate";
    
        System.out.println(mark);
        System.out.println(nate);
    
        Table table = new Table(42, "life");
        Table table2 = SerializationUtils.roundtrip(table);
        
        table2.stuff = 11;
        
        System.out.println(table);
        System.out.println(table2);
    }
}
