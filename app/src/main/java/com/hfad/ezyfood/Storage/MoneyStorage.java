package com.hfad.ezyfood.Storage;

public class MoneyStorage {
    private double money;
    private static MoneyStorage instance;

    private MoneyStorage() {
        this.money = 250000;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static MoneyStorage getInstance(){
        if(instance == null){
            instance = new MoneyStorage();
        }
        return instance;
    }
}
