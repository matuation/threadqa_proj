package com.variables.oop_homework;
//Часть 4. Класс Drink
public class Drink extends MenuItem{
    Drink(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    int price() {
        return basePrice;
    }

    @Override
    String kind() {
        return "Напиток";
    }
}
