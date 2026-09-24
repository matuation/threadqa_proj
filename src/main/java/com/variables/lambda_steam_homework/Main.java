package com.variables.lambda_steam_homework;

import java.util.List;

//Часть 6. Проверка
public class Main {
    public static void main(String[] args) {
        List<OrderRow> orders = List.of(
                new OrderRow(
                        1,
                        "Alice",
                        OrderStatus.CREATED,
                        PaymentChoice.CARD,
                        321
                ),
                new OrderRow(
                        2,
                        "Alice",
                        OrderStatus.CANCELLED,
                        PaymentChoice.CRYPTO,
                        321
                ),
                new OrderRow(
                        3,
                        "Alice",
                        OrderStatus.PAID,
                        PaymentChoice.CASH,
                        321
                ),
                new OrderRow(
                        4,
                        "Boris",
                        OrderStatus.PREPARING,
                        PaymentChoice.CARD,
                        321
                ),
                new OrderRow(
                        5,
                        "Boris",
                        OrderStatus.PAID,
                        PaymentChoice.CASH,
                        321
                ),
                new OrderRow(
                        6,
                        "Boris",
                        OrderStatus.CANCELLED,
                        PaymentChoice.CARD,
                        321
                ),
                new OrderRow(
                        7,
                        "Jinx",
                        OrderStatus.COMPLETED,
                        PaymentChoice.CRYPTO,
                        321
                )
                ,
                new OrderRow(
                        8,
                        "Jinx",
                        OrderStatus.PAID,
                        PaymentChoice.CASH,
                        321
                ),
                new OrderRow(
                        9,
                        "Jinx",
                        OrderStatus.CANCELLED,
                        PaymentChoice.CARD,
                        321
                ),
                new OrderRow(
                        10,
                        "Alice",
                        OrderStatus.PAID,
                        PaymentChoice.CASH,
                        121
                )
        );
        OrderAnalytics
                .paidByCustomer(orders, "Alice")
                .forEach(System.out::println);
        System.out.println("==========================");
        System.out.println(
                OrderAnalytics.revenue(orders)
        );
        System.out.println("==========================");
        System.out.println(
                OrderAnalytics.countByStatus(orders)
        );
        System.out.println("==========================");
        System.out.println(
                OrderAnalytics.revenueByPayment(orders)
        );
        System.out.println("==========================");
        System.out.println(
                OrderAnalytics.page(orders, 2, 4)
        );
        System.out.println("==========================");
    }
}
