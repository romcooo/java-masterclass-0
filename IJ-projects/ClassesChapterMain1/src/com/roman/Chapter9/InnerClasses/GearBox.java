package com.roman.Chapter9.InnerClasses;

import java.util.ArrayList;



public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for (int i = 0; i < maxGears; i++) {
            addGear(i, i*5.3);
        }
    }

    public void operateClutch(boolean isIn) {
        this.clutchIsIn = isIn;
    }

    private void addGear(int number, double ratio) {
        if ((number > 0) && (number <= this.maxGears)) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear) {
        if ((newGear >= -1) && (newGear < this.gears.size()) && (this.clutchIsIn)) {
            this.currentGear = newGear;
            System.out.println("Gear changed to " + newGear);
        } else {
            System.out.println("Cannot change gear.");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if(clutchIsIn) {
            System.out.println("Vrroooom!");
            return 0.0d;
        }
        return revs * gears.get(currentGear).getRatio();
    }

    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(final int gearNumber, final double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed(int revs) {
            return revs*(this.ratio);
        }

        public double getRatio() {
            return ratio;
        }
    }
}
