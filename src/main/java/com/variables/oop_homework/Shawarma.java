package com.variables.oop_homework;

//Часть 3. Класс Shawarma
public class Shawarma extends MenuItem {

    private final boolean xl;

    Shawarma(String name, int basePrice, boolean xl) {
        super(name, basePrice);
        this.xl = xl;
    }

    @Override
    int price() {
        if (xl == false) {
            return basePrice;
        } else {
            return basePrice + 100;
        }
    }

    @Override
    String kind() {
        return "Шаурма";
    }
}
