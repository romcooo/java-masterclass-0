package com.roman.chapter7.Classes;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BankAccount acc1 = new BankAccount("12345", 123, "Roman", "asd@asd.com", "0905123123");

        acc1.withdrawFunds(120);
        acc1.depositFunds(430);
        acc1.withdrawFunds(1000);

        Integer intr = new Integer(123);
        System.out.println(intr);


    }
}
