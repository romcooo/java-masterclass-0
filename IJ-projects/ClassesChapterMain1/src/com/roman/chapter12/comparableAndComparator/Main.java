package com.roman.chapter12.comparableAndComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Janackovo", 10, 24);

        if(theatre.reserveSeat("D12")) {
            System.out.println("Please, pay ");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber()
//                    + ", price is " + seat.getPrice()
            );
        }
        System.out.println();
        System.out.println("===========");
    }


}
