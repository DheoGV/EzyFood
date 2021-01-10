package com.hfad.ezyfood.Item;

public class Item {
    private String name;
    private int quantity;
    private int price;
    private int history = -1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHistory() { return history; }

    public void setHistory(int historyId) { this.history = history; }

    public Item(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public Item(String name, int quantity, int price, int history) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.history = history;
    }
}
