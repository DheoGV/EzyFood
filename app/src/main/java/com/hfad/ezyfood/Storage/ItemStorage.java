package com.hfad.ezyfood.Storage;

import com.hfad.ezyfood.Item.Item;

import java.util.ArrayList;

public class ItemStorage {
    public ArrayList<Item> item;
    public static ItemStorage instance;
    public ItemStorage(){
        item = new ArrayList<>();
    }
    public static ItemStorage getInstance(){
        if(instance == null){
            instance = new ItemStorage();
        }
        return instance;
    }
}
