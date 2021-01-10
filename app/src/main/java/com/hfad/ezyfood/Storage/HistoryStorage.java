package com.hfad.ezyfood.Storage;

import com.hfad.ezyfood.Item.History;
import com.hfad.ezyfood.Item.Item;

import java.util.ArrayList;
public class HistoryStorage {

    public ArrayList<Item> item;
    public ArrayList<History> history;
    private static HistoryStorage instance;

    private HistoryStorage(){
        history = new ArrayList<History>();
        item = new ArrayList<>();
    }

    public static HistoryStorage getInstance(){
        if(instance == null){
            instance = new HistoryStorage();
        }
        return instance;
    }



}
