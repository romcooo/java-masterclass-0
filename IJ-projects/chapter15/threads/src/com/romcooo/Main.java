package com.romcooo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello from the main thread!");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        Thread anotherAnotherThread = new AnotherThread();
        anotherAnotherThread.start();

        new Thread() {
            public void run() {
                System.out.println("Hello from anon class");
            }
        }.start();

        System.out.println("Hello again from the main thread.");
    }
}
