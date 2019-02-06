package com.roman.otherProjects;

import java.util.ArrayList;

public class XsdElement {
    private final int DEFAULT_MINOCCURS = 0;
    private final int DEFAULT_MAXOCCURS = 1;

    ArrayList<XsdElement> childElements = new ArrayList<>();
    int minOccurs, maxOccurs, minLength, maxLength, length, fractionDigits, totalDigits, minInclusive, maxIncludive, minExclusive, maxExclusive;
    String name, type, pattern;

    //CONSTRUCTORS
    public XsdElement(String name) {
        this.name = name;
    }

    private XsdElement(final String name, final int minOccurs, final int maxOccurs) {
        this.name = name;
        this.minOccurs = minOccurs;
        this.maxOccurs = maxOccurs;
    }

    //GETTERS
    public ArrayList<XsdElement> getChildElements() {
        return childElements;
    }

    public XsdElement getChildElement(int index) {
        return childElements.get(index);
    }

    public String getName() {
        return name;
    }

    public int getMinOccurs() {
        return minOccurs;
    }

    public int getMaxOccurs() {
        return maxOccurs;
    }

    public int getIndexByName(String name) {
        for (XsdElement element:childElements) {
            if (element.getName().matches(name)) {
                return childElements.indexOf(element);
            }
        }
        return -1;
    }

    public XsdElement getChildElementByName(String name) {
        for (XsdElement element:childElements) {
            if (element.getName().matches(name)) {
                return element;
            }
        }
        return null;
    }

    //just to simplify, perhaps remove this later or rename the original to this
    public XsdElement getChild(String name) {
        return getChildElementByName(name);
    }

    //FUNCTIONS
    public ArrayList<XsdElement> addChildElement(XsdElement childElement) {
        this.childElements.add(childElement);
        return this.childElements;
    }

    public void listAllChildElements() {
        for (XsdElement element:childElements) {
            System.out.println(element.getName());
        }
    }

    public void listAllChildElementsRecursive() {
        listAllChildElementsRecursive(0);
    }

    public void listAllChildElementsRecursive(int recursionCount) {
        for (XsdElement element:childElements) {
            for(int i = 0; i < recursionCount; i++){
                System.out.print("\t");
            }
            System.out.print("."+element.getName());
            System.out.println();
            if (!element.getChildElements().isEmpty()) {
                element.listAllChildElementsRecursive(recursionCount+1);
            }

        }

    }

}
