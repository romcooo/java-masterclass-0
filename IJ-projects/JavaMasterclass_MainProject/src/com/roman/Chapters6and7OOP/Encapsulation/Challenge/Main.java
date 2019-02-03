package com.roman.Chapters6and7OOP.Encapsulation.Challenge;

public class Main {
    public static void main(String[] args) {
/*
        Printer printer = new Printer(false);

        printer.printAmountOfPagesPrinted();

        printer.emptyToners();
        printer.printPages(1);

        printer.fillToner(5, "black");
        printer.printPages(7);

        printer.printAmountOfPagesPrinted();
*/

        Printer duplexPrinter = new Printer(true);

        duplexPrinter.emptyToners();

        duplexPrinter.fillToner(5, "black");
        duplexPrinter.printAmountOfPagesPrinted();
        duplexPrinter.printPages(3);
        duplexPrinter.printAmountOfPagesPrinted();
        System.out.println("Pages printed should be 2");

        duplexPrinter.printPages(2);
        duplexPrinter.printAmountOfPagesPrinted();
        System.out.println("Pages printed should be 3");

        duplexPrinter.printTonerLevels();

    }
}
