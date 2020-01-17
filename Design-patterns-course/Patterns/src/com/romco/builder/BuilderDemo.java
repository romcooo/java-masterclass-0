package com.romco.builder;

import java.util.ArrayList;

class HtmlElement {
    public String name, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();
    
    public HtmlElement() {
    }
    
    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }
    
    private String toStringImpl(int indentLevel) {
        return "asd";
    }
    
    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();
    
    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }
    
    public HtmlBuilder addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
        return this;
    }
    
    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }
    
    @Override
    public String toString() {
        return root.toString();
    }
}

class Person {
    public String name;
    public String position;
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    Person person = new Person();
    
    public SELF withName(String name) {
        person.name = name;
        return self();
    }
    
    public Person build() {
        return person;
    }
    
    protected SELF self() {
        return (SELF) this;
    }
    
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }
    
    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "hello")
                .addChild("li", "world");
        System.out.println(builder);
        
        EmployeeBuilder eb = new EmployeeBuilder();
        Person dmitri = eb
                .withName("dmitri")
                .worksAt("developer")
                .build();
    
        System.out.println(dmitri);
    }
    
}
