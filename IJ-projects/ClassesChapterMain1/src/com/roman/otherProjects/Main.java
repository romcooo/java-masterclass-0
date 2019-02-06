package com.roman.otherProjects;

public class Main {
    public static void main(String[] args) {

        XsdElement request = new XsdElement("setGetClientRequest");
        XsdElement client = new XsdElement("client");
        request.addChildElement(client);
        request.listAllChildElements();

        request.getChildElements().get(0).addChildElement(new XsdElement("clientDetail"));
        request.getChildElements().get(0).addChildElement(new XsdElement("contacts"));
        request.listAllChildElementsRecursive();

        request.getChildElements().get(0).getChildElements().get(0).addChildElement(new XsdElement("trustLevel"));
        request.getChildElements().get(0).getChildElements().get(0).addChildElement(new XsdElement("firstName"));
        request.getChildElements().get(0).getChildElements().get(0).addChildElement(new XsdElement("secondName"));
        request.getChildElements().get(0).getChildElements().get(1).addChildElement(new XsdElement("phone"));
        request.getChildElements().get(0).getChildElements().get(1).addChildElement(new XsdElement("email"));
        request.listAllChildElementsRecursive();

        request
                .getChildElementByName("client")
                .getChildElementByName("clientDetail")
                .addChildElement(new XsdElement("new"));
        request.listAllChildElementsRecursive();


        System.out.println(request.getName());
    }
}
