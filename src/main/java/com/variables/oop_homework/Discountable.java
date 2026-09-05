package com.variables.oop_homework;

//Часть 2. Интерфейс Discountable
public interface Discountable {
    int discountPercent();

    default int applyDiscount(int amount) {
        return amount - amount * discountPercent() / 100;
    }
}
