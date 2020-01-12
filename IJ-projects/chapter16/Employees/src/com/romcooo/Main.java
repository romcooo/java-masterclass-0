package com.romcooo;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("john doe", 30);
        Employee tim = new Employee("tim buchalka", 21);
        Employee jack = new Employee("jack hill", 40);
        Employee snow = new Employee("snow white", 22);
        Employee red = new Employee("red ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        Function<Employee, String> getLastName = (employee -> employee.getName()
                                                                      .substring(employee.getName().indexOf(' ') + 1)
        );

        for (Employee employee : employees) {
            System.out.println(getLastName.apply(employee));
        }

        Function<Employee, String> getFirstName = (employee -> employee.getName()
                                                                       .substring(0, employee.getName().indexOf(' ')));

        Function<Employee, String> upperCase = (employee -> {
            System.out.println("uppercase executed");
            return employee.getName().toUpperCase();
        });

        Function<String, String> firstName = (name -> {
            System.out.println("firstName executed");
            return name.substring(0, name.indexOf(' '));
        });

        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(john));

        Function reverseChainedFunction = firstName.compose(upperCase);
        System.out.println(reverseChainedFunction.apply(john));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = s -> System.out.println(s.toUpperCase());
        Consumer<String> c2 = System.out::println;

        c1.andThen(c2).accept("Hello world!");

//        printEmployeesByAge(employees, "over 30:", employee -> employee.getAge() > 30);
//        printEmployeesByAge(employees, "under or 30:", employee -> employee.getAge() <= 30);
//        printEmployeesByAge(employees, "under 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge() < 25;
//            }
//        });
//
//        System.out.println("========");
//
//        IntPredicate greaterThan15 = i -> i > 15;
//        IntPredicate lesserThan100 = i -> i < 100;
//
//        int q = 20;
//        System.out.println(greaterThan15.and(lesserThan100).test(q));
//
//        Random random = new Random();
//        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(randomSupplier.get());
//        }
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {

        System.out.println(ageText);
        System.out.println("========");
        for (Employee employee : employees)
            if (ageCondition.test(employee))
                System.out.println(employee.getName());
    }
}
