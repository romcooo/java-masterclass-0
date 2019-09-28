package com.roman.chapter12.collectionsOverview;

import java.util.ArrayList;
import java.util.Collections;
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

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat>=0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    public void printSeats() {
        for (Seat seat:this.seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> {
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

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
         * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
         * <tt>y.compareTo(x)</tt> throws an exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
         * <tt>x.compareTo(z)&gt;0</tt>.
         *
         * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
         * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
         * all <tt>z</tt>.
         *
         * <p>It is strongly recommended, but <i>not</i> strictly required that
         * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
         * class that implements the <tt>Comparable</tt> interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         *
         * <p>In the foregoing description, the notation
         * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
         * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
         * <tt>0</tt>, or <tt>1</tt> according to whether the value of
         * <i>expression</i> is negative, zero or positive.
         *
         * @param  seatToCompare the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         *          is less than, equal to, or greater than the specified object.
         *
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException if the specified object's type prevents it
         *         from being compared to this object.
         */
        @Override
        public int compareTo(Seat seatToCompare) {
            return this.seatNumber.compareToIgnoreCase(seatToCompare.getSeatNumber());
        }

        public String getSeatNumber() {
            return getSeatNumber(false);
        }

        public String getSeatNumber(boolean verbose) {
            if (verbose) {
                System.out.println("Seat " + this.seatNumber + " is " + (this.reserved ? "" : "not ") + "reserved.");
            }
            return this.seatNumber;
        }
    }

}

