package com.variables.enum_exception_homework;

import static com.variables.enum_exception_homework.PaymentChoice.CARD;
import static com.variables.enum_exception_homework.PaymentChoice.CASH;
import static com.variables.enum_exception_homework.RecipeSize.L;
import static com.variables.enum_exception_homework.RecipeSize.M;


public class Main {
    //Часть 5. Проверка через runCase(...)
    private static void runCase(
            long recipeId,
            RecipeSize size,
            int qty,
            PaymentChoice payment
    ) {
        try {
            System.out.println("[OK] price= " + OrderValidator.validateAndPrice(recipeId, size, qty, payment));
        }
        catch (OrderValidationException e) {
            System.out.println("[REJECT]" + e.getMessage());
        }
    }
//Часть 6. Прогон тестов
    public static void main(String[] args) {
        runCase(0, M, 2, CARD);
        runCase(42, null, 2, CARD);
        runCase(42, L, 15, CARD);
        runCase(42, L, 2, null);
        runCase(42, L, 5, CASH);
        runCase(42, L, 2, CARD);
    }
}
