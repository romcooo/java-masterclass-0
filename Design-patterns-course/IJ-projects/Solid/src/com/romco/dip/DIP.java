package com.romco.dip;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Triplet;

public class DIP {
}

enum RelationshipEnum {
    PARENT, CHILD, SIBLING;
}

class Person {
    public String name;
    
    public Person(String name) {
        this.name = name;
    }
}

class Relationship { // low level module
    private List<Triplet<Person, RelationshipEnum, Person>> relations = new ArrayList<>();
    
    public List<Triplet<Person, RelationshipEnum, Person>> getRelations() {
        return relations;
    }
    
    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, RelationshipEnum.PARENT, child));
        relations.add(new Triplet<>(child, RelationshipEnum.CHILD, parent));
    }
}

class Research {
    public Research(Relationship relationship) {
        List<Triplet<Person, RelationshipEnum, Person>> relations = relationship.getRelations();
        relations.stream()
                .filter(x -> x.getValue1() == RelationshipEnum.PARENT)
                .forEach(c -> System.out.println(c.getValue0().name + " has a child called " + c.getValue2().name));
    }
}

class Demo {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");
    
        Relationship relationship = new Relationship();
        relationship.addParentAndChild(parent, child1);
        relationship.addParentAndChild(parent, child2);
    
        Research research = new Research(relationship);
        
    }
}
