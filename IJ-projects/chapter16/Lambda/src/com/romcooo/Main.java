package com.romcooo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        new Thread(() -> System.out.println("printing from the runnable")).start();
//
//        new Thread(() -> {
//            System.out.println("asd");
//        }).start();

//        Concatenatable cnc = (s1, s2) -> {
//            String result =  s1.toLowerCase() + s2.toLowerCase();
//            return result;
//        };

//        Concatenatable cnc = (s1, s2) -> s1.toLowerCase() + s2.toLowerCase();
//        System.out.println(cnc.specialConcat("lol", "kappa"));
//
//        AnotherClass anotherClass = new AnotherClass();
//        anotherClass.doSomething();

        Employee john = new Employee("john doe", 30);
        Employee tim = new Employee("tim buchalka", 21);
        Employee jack = new Employee("jack hill", 40);
        Employee snow = new Employee("snow white", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        employees.forEach((employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        }));

//        for (Employee e : employees) {
//            System.out.println(e.getName());
//            System.out.println(e.getAge());
////            new Thread(() -> System.out.println(e.getAge())).start();
//        }

    }
}

class Employee {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("asd");
    }
}

interface Concatenatable {
    String specialConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        int i = 0;
//        i++;

        Concatenatable cc = (s1, s2) -> {
            System.out.println("lambda: " + getClass().getSimpleName());
            System.out.println("i in lambda: " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

//        int j = 0;
//        {
//            String s1 = "ce", s2 = "ww";
//            System.out.println("Nested: " + getClass().getSimpleName());
//            System.out.println("j nested: " + j);
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        }

        System.out.println("AnotherClass: " + getClass().getSimpleName());
        return cc.specialConcat("asd", "qwe");
    }
}