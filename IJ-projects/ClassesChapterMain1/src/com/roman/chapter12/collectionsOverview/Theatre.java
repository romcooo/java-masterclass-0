package com.roman.chapter12.collectionsOverview;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                this.seats.add(new Seat((row+String.format("%02d", seatNum))));
            }
        }
    }

    public void getSeats() {
        for (Seat seat:this.seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat number " + this.seatNumber + " reserved.");
                return true;
            } else {
                System.out.println("Cannot reserve seat number " + this.seatNumber);
                return false;
            }
        }
        public boolean cancelReservation() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Seat number " + this.seatNumber + " reservation cancelled.");
                return true;
            } else {
                System.out.println("No reservation exists for seat number " + this.seatNumber);
                return false;
            }
        }



        public String getSeatNumber() {
            return seatNumber;
        }
    }

}

