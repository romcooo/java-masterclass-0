package com.roman.chapter12.sortedAndFurther;

import java.util.Map;

public class MainChallenge {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.5, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40,80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket rBasket = new Basket("Roman");

        reserveItem(rBasket, "car", 1);
        System.out.println(stockList);

        reserveItem(rBasket, "car", 1);
        reserveItem(rBasket, "car", 1);
        System.out.println(stockList);

        System.out.println("You paid " + rBasket.checkout() + " during checkout.");

        reserveItem(rBasket , "car", 2);
        rBasket.checkout();

        System.out.println("\n---------------");

        System.out.println("Should be empty:");
        System.out.println(rBasket);

        reserveItem(rBasket, "door", 2);
        System.out.println("\nshould have 2 doors:" + rBasket);
        System.out.println(stockList);

        unreserveItem(rBasket, "door", 1);
        System.out.println("\nshould have 1 door:" + rBasket);
        System.out.println(stockList);

        reserveItem(rBasket, "door", 3);
        System.out.println("\nshould have 4 doors:" + rBasket);
        System.out.println(stockList);

        unreserveItem(rBasket, "door", 1);
        System.out.println("\nshould have 3 doors:" + rBasket);
        reserveItem(rBasket, "door", 2);
        System.out.println("\nshould have 3 doors:" + rBasket);

        System.out.println(stockList);

        System.out.println("---------------");

        unreserveItem(rBasket, "vase", 1);
        System.out.println(rBasket);
        unreserveItem(rBasket, "door", 3);
        System.out.println(rBasket);
        reserveItem(rBasket, "cup", 1);
        System.out.println("\nShould have no doors, no vases and 1 cup" + rBasket);
        rBasket.checkout();
        System.out.println("\nShould be empty:" + rBasket);

        System.out.println("Total bought: 2 cars, 1 cup");
        System.out.println(stockList);


    }

    public static int reserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (stockList.reserveStock(item, quantity) != 0) {
            return (basket.addToBasket(stockItem, quantity));
//            return quantity;
        }

        System.out.println("There are no free items " + item + " in stock.");
        return 0;
    }

    public static int unreserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("Cannot unreserve " + item);
            return 0;
        }

        if (stockList.unreserveStock(item, quantity) != 0) {
            System.out.println("Attempting to remove " + quantity + " of " + item + " from basket.");
            return (basket.removeFromBasket(stockItem, quantity));
        }

        System.out.println("Cannot unreserve " + item);
        return 0;
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(stockList.sellStock(item, quantity) != 0) {
            return (basket.addToBasket(stockItem, quantity));
        }

        System.out.println("There are no items " + item + " in stock.");
        return 0;
    }
}
