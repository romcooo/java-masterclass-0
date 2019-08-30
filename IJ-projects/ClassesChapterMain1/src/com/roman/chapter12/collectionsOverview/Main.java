package com.roman.chapter12.collectionsOverview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Janackovo", 5, 10);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.getSeats()); //shallow copy

        theatre.printSeats();
        printList(seatCopy);

        theatre.reserveSeat("A02");
        printList(seatCopy);

        seatCopy.get(1).getSeatNumber(true);
        theatre.getSeats().get(1).getSeatNumber(true);

        Collections.reverse(seatCopy);
        printList(seatCopy);

//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println(minSeat.getSeatNumber());
//        System.out.println(maxSeat.getSeatNumber());

//        sortList(seatCopy);
//        printList(seatCopy);

        List<Theatre.Seat> newList = new ArrayList<>(theatre.getSeats().size());
        newList.addAll(theatre.getSeats());
        Collections.copy(newList, seatCopy); //deep copy

        printList(newList);

        sortList(newList);

        printList(newList);
        printList(seatCopy);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("===========");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i=0; i < list.size(); i++) {
            for (int j=i+1; j < list.size(); j++) {
                if(list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }






}
