package com.variables.oop_homework;

//Часть 1. Абстрактный класс MenuItem
public abstract class MenuItem {

    protected final String name;
    protected final int basePrice;

    MenuItem(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    void printReceipt() {
        System.out.println("[" + kind() + "] " + name + " — " + price() + " руб");
    }

    abstract int price();

    abstract String kind();
}
