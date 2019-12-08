package com.romcooo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        new Thread(() -> System.out.println("printing from the runnable")).start();

        new Thread(() -> {
            System.out.println("asd");
        }).start();

    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("asd");
    }
}