package com.romcooo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello from the main thread!");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread 1 ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println("Hello from anon class");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Hello from anon class implementation of run()");
                try {
                    anotherThread.join(2000);

                    System.out.println("I waited for " + anotherThread.getName());
                } catch (InterruptedException e) {
                    System.out.println("I couldn't wait after all. I was interrupted.");
                }
            }
        });

        myRunnableThread.start();
        anotherThread.interrupt();

        System.out.println("Hello again from the main thread.");

    }
}
