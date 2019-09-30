package com.roman.chapter12.sortedAndFurther;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            //check if we already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stocks on this item, adjust the quantity
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String itemName, int quantity) {
        StockItem inStock = list.getOrDefault(itemName, null);
        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0) ) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        else return 0;
    }

    public int reserveStock(String itemName, int quantity) {
        StockItem reservable = list.getOrDefault(itemName, null);
        if ((reservable != null) && (reservable.quantityReservable() >= quantity) && (quantity > 0) ) {
            reservable.adjustReservedStock(quantity);
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(String itemName, int quantity) {
        StockItem unreservable = list.getOrDefault(itemName, null);
        if ((unreservable != null) && (unreservable.quantityReservable() + quantity <= unreservable.quantityInStock())) {
            unreservable.adjustReservedStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There " + (stockItem.quantityInStock() == 1 ? "is " : "are ") + stockItem.quantityInStock() + " item" + ((stockItem.quantityInStock() == 1) ? "" : "s") + " in stock, of which "
                    + stockItem.quantityReservable() + (stockItem.quantityReservable() == 1 ? " is" : " are") + " reservable.\n"
                    + "Value of Items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value: " + totalCost;
    }
}
