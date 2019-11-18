package com.romcooo;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running thread of name " + currentThread().getName());

        try {
            Thread.sleep(5000);
            System.out.println("3 seconds have passed");
        } catch (InterruptedException e) {
            System.out.println("Another thread woke me up");
        }


    }
}
