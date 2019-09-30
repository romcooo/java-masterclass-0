package com.roman.chapter12.sortedAndFurther;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int quantityReservable;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
        this.quantityReservable = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.quantityReservable = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public int quantityReservable( ){
        return quantityReservable;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
            this.quantityReservable = newQuantity;
        } else {
            System.out.println("Operation would result in a quantity lower than 0.");
        }
    }

    public void adjustReservedStock(int quantity) {
        int newReservableQuantity = this.quantityReservable - quantity;
        if (newReservableQuantity >= 0 && newReservableQuantity <= this.quantityStock) {
            this.quantityReservable = newReservableQuantity;
        } else {
            System.out.println("Cannot adjust reserved stock below 0 or actual stock is lower than desired reservation.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering stockItem.equals()");
        if(obj == this) {
            return true;
        }

        if(obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
//        System.out.println("Entering stockItem.compareTo()");
        if (this == o) {
            return 0;
        }

        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ", price = " + this.price;
    }
}
