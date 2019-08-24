package com.roman.variousRecaps;

import java.util.Scanner;

class X{
    public X() {
        this.x = 1;
    }
    private int x;
    void x(int x) {
        for (this.x = 1; this.x <= 12; this.x++) {
            System.out.println(x + " * " + this.x + " = " + this.x*x);
        }

    }
    Scanner x() {
        return new Scanner(System.in);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Type in your number:");
        int x = new X().x().nextInt();
        new X().x(x);
    }
}

