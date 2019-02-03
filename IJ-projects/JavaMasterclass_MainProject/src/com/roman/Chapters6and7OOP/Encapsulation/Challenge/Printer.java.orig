package com.roman.Chapters6and7OOP.Encapsulation.Challenge;

public class Printer {
    private boolean isDuplex;
    private int pagesPrinted;
    private Toner tonerBlack;
    private Toner tonerRed;
    private Toner tonerGreen;
    private Toner tonerBlue;
    private int pagesInMagazine;

    public Printer(boolean isDuplex) {
        this(isDuplex, 0, 200);
    }

    private Printer(final boolean isDuplex, final int pagesPrinted, final int pagesInMagazine) {
        this.isDuplex = isDuplex;
        this.pagesPrinted = pagesPrinted;
        this.tonerBlack = new Toner("Black");
        this.tonerRed = new Toner("Red");
        this.tonerGreen = new Toner("Green");
        this.tonerBlue = new Toner("Blue");
        this.pagesInMagazine = pagesInMagazine;
    }

    public void fillToner(int amountToFill, String colour) {
        if (colour.toLowerCase().equals("black")) {
            tonerBlack.fill(amountToFill);
        } else if (colour.toLowerCase().equals("red")) {
            tonerRed.fill(amountToFill);
        } else if (colour.toLowerCase().equals("blue")) {
            tonerBlue.fill(amountToFill);
        } else if (colour.toLowerCase().equals("green")) {
            tonerGreen.fill(amountToFill);
        } else {
            System.out.println("No toner of chosen colour exists");
        }
    }

    public boolean printPage() {
        if (pagesInMagazine > 0 && tonerBlack.useToner()) {

            pagesPrinted += 1;
            pagesInMagazine -= 1;
            System.out.println("Page printed");
            return true;
        } else {
            if (pagesInMagazine <= 0) {
                System.out.println("No pages left in magazine. Please refill paper.");
            }
        }
        return false;
    }

    public void printPages(final int numberOfPages) {
        int usedPages = 0;
        System.out.println("----- Preparing to print "+numberOfPages+" pages.");
        for(int i = 0; i < numberOfPages; i++) {
            //if is duplex, reuse the page by removing the last page printed from the count
            if (this.isDuplex && (i % 2 == 1)) {
                pagesPrinted--;
                usedPages--;
            }
            if (!this.printPage()) {
                break;
            }
            usedPages++;
        }
        System.out.println("----- Total sheets of paper used during this printing: " + usedPages);
    }

    public void printTonerLevels() {
        System.out.println("----- Printer toner status:");
        tonerBlack.printColourAndLevel();
        tonerRed.printColourAndLevel();
        tonerGreen.printColourAndLevel();
        tonerBlue.printColourAndLevel();
    }

    public void emptyToners() {
        tonerBlack.emptyToner();
        tonerRed.emptyToner();
        tonerGreen.emptyToner();
        tonerBlue.emptyToner();
        System.out.println("----- All toners emptied");
    }

    public void printAmountOfPagesPrinted() {
        System.out.println("----- Total pages printed: "+pagesPrinted);
    }
}
