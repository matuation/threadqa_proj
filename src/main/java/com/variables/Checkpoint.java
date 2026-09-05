package com.variables;

public class Checkpoint {
    public static void main(String[] args) {

        // Входные данные
        String dish = "SHAWARMA_XL";
        int qty = 2;
        int minutesToClose = 18;

        // 1. unitPrice
        int unitPrice = switch (dish) {
            case "SHAWARMA_CLASSIC" -> 220;
            case "SHAWARMA_XL" -> 320;
            case "FALAFEL" -> 180;
            case "DRINK" -> 90;
            default -> 0;
        };

        // 2. subtotal
        int subtotal = unitPrice * qty;

        // 3. discountPercent
        int discountPercent = 0;
        if (subtotal >= 2000) {
            discountPercent = 15;
        } else if (subtotal >= 1000) {
            discountPercent = 10;
        } else if (subtotal >= 500) {
            discountPercent = 5;
        } else {
            discountPercent = 0;
        }
        // 4. total
        int total = subtotal - subtotal * discountPercent / 100;

        //5. batch
        String batch = qty <= 1 ? "single" :
                qty <= 5 ? "small batch" : "big batch";

        //6. kitchenAction
        String kitchenAction = "";
        if (minutesToClose <= 0) {
            System.out.println(kitchenAction);
            kitchenAction = "kitchen closed - reject";
        } else {
            kitchenAction = switch (dish) {
                case "SHAWARMA_CLASSIC" -> "grill 4 min";
                case "SHAWARMA_XL" -> "grill 7 min";
                case "FALAFEL" -> "fry 5 min";
                case "DRINK" -> "pour & serve";
                default -> "manual check";
            };
        }

        //7. PaymentCheckPrint
        System.out.println("ORDER " + dish + " " + "x" + qty);
        System.out.println("PRICE " + subtotal + "->" + + total + "(" + "-" + discountPercent + "%"+")");
        System.out.println("BATCH " + batch);
        System.out.println("KITCHEN " + kitchenAction);
        System.out.println("CLOSE " + minutesToClose + " min left");
    }
}
