package com.roman;

import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	byte firstByte = 1;
	byte secondByte = 41;
	byte newByte = (byte) (firstByte + secondByte);
//	System.out.println(newByte);
    //two ways of assigning a float
    float float1 = 5.4f;
    float float2 = (float) 5.4;
    double double1 = 3d;

    //get keyboard input for pounds, convert to kilos and print out
    Scanner keyboard = new Scanner(System.in);
    System.out.println("enter pounds:\n");
    double pounds1 = keyboard.nextDouble();
    double kilos1 = pounds1 * 0.453_592_37;
    System.out.println(kilos1);

    }
}
