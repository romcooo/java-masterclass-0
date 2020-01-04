package com.romcooo;

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

        Concatenatable cnc = (s1, s2) -> s1.toLowerCase() + s2.toLowerCase();
        System.out.println(cnc.specialConcat("lol", "kappa"));

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