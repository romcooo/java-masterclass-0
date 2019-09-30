package com.roman.chapter12.sortedAndFurther;

import java.util.*;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            if (inBasket - quantity <= 0) {
                list.remove(item);
                return 0;
            } else {
                list.put(item, inBasket - quantity);
                return inBasket - quantity;
            }
        }
        return 0;
    }

    public double checkout() {
        if (this.list.isEmpty()) {
            System.out.println("No items to check out.");
            return 0.0;
        }
        String s = "\nCheckout of basket " + name + ".\nTotal items: " + list.size() + ".\nContents:\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". Count in basket: " + item.getValue() + ".\n";
            totalCost += item.getKey().getPrice() * item.getValue();
            item.getKey().adjustStock(-item.getValue());
        }
        list.clear();
        System.out.println(s);
        return totalCost;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + " item" + (list.size() == 1 ? "" : "s") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " in basket.\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
