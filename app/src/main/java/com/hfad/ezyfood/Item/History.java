package com.hfad.ezyfood.Item;

import com.hfad.ezyfood.Item.Item;

import java.util.ArrayList;

public class History {
    private int history;
    private String date;
    private String address;
    public ArrayList<Item> allItem;

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public History(int historyId, String date, String address, ArrayList<Item> allItem) {
        this.history = historyId;
        this.date = date;
        this.address = address;
        allItem = new ArrayList<>();
        this.allItem = allItem;
    }
}
