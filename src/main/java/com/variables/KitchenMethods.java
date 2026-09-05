package com.variables;

import java.util.*;

public class KitchenMethods {

    // 1. menuLine

    static String menuLine(String dish, int price) {

        String dishFormattedString = new StringBuilder().append(dish).append(" — ").append(price).append(" руб").toString();
        return dishFormattedString;
        // menuLine("Шаурма классическая", 250) → "Шаурма классическая — 250 руб"
    }

    // 2. orderTotal
    static int orderTotal(List<Integer> prices) {
        int totalOrderPrice = 0;
        for (int price : prices)
            totalOrderPrice += price;
        return totalOrderPrice;
    }
    // orderTotal(List.of(250, 90, 250)) → 590
    // orderTotal(List.of()) → 0

    // 3. availableDishes
    static List<String> availableDishes(List<String> menu, Set<String> soldOut) {
        List<String> inStock = new ArrayList<>();
        for (String menuItem : menu) {
            for (String soldOutMenuItem : soldOut) {
                if (!soldOutMenuItem.equals(menuItem)) {
                    inStock.add(menuItem);
                }
            }
        }
        return inStock;
    }
    // menu    = ["Шаурма", "Фалафель", "Кола"]
    // soldOut = {"Фалафель"}
    // availableDishes(menu, soldOut) → ["Шаурма", "Кола"]

    // 4. countOrders
    static Map<String, Integer> countOrders(List<String> orders) {
        Map<String, Integer> countedOrders = new HashMap<>();
        for (String orderItem : orders) {
            int dishFound = 0;
            for (String dish : orders) {
                if (orderItem.equals(dish)) {
                    dishFound++;
                }
            }
            countedOrders.put(orderItem, dishFound);
        }
        return countedOrders;
    }
    // countOrders(["Шаурма", "Кола", "Шаурма"]) → {Шаурма=2, Кола=1}

    // 5. joinDishes
    static String joinDishes(List<String> dishes) {
        StringBuilder builtDishString = new StringBuilder();
        String finalString;
        if (dishes.size() != 0) {
            for (String dish : dishes) {
                builtDishString.append(dish).append(", ");
            }
            finalString = builtDishString.toString();
            finalString = finalString.substring(0, finalString.length() - 2);
        } else {
            finalString = "";
        }
        return finalString;
    }
    // joinDishes(["Шаурма", "Фалафель", "Кола"]) → "Шаурма, Фалафель, Кола"
    // joinDishes([]) → "пусто"

    // 6. isOnMenu
    static boolean isOnMenu(List<String> menu, String dish) {
        boolean isPresent = false;
        for (String menuItem : menu) {
            if (menuItem.toLowerCase().equals(dish.toLowerCase())) {
                isPresent = true;
            }
        }
        return isPresent;
    }
// menu = ["Шаурма", "Кола"]
// isOnMenu(menu, "кола") → true
// isOnMenu(menu, "Фалафель") → false

    public static void main(String[] args) {
        System.out.println(menuLine("Шаурма классическая", 250)); // Шаурма классическая — 250 руб
        System.out.println(orderTotal(List.of(250, 90, 250)));    // 590
        System.out.println(availableDishes(List.of("Шаурма", "Фалафель", "Кола"),
                Set.of("Фалафель")));   // [Шаурма, Кола]
        System.out.println(countOrders(List.of("Шаурма", "Кола", "Шаурма"))); // {Шаурма=2, Кола=1}
        System.out.println(joinDishes(List.of("Шаурма", "Фалафель", "Кола")));// Шаурма, Фалафель, Кола
        System.out.println(isOnMenu(List.of("Шаурма", "Кола"), "кола"));      // true
    }
}
