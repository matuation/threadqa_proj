package com.variables.lambda_steam_homework;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Часть 5. Аналитика заказов
public class OrderAnalytics {
//5.1. Оплаченные заказы клиента
    static List<OrderRow> paidByCustomer(
            List<OrderRow> orders,
            String customer) {
        List<OrderRow> ordersPaidByCustomer = orders.stream()
                .filter(o-> o.getStatus().equals(OrderStatus.PAID))
                .filter(o->o.getCustomer().equals(customer))
                .toList();
        return ordersPaidByCustomer;
    }
//5.2. Общая выручка
    static double revenue(List<OrderRow> orders){
        double totalRevenue = orders.stream()
                .filter(o->!o.getStatus().equals(OrderStatus.CANCELLED))
                .mapToDouble(o->o.getTotal())
                .sum();
        return totalRevenue;
    }
//5.3. Количество заказов по статусам
static Map<OrderStatus, Long> countByStatus(List<OrderRow> orders){
    Map<OrderStatus, Long> totalCountByStatus = orders.stream()
            .collect(Collectors.groupingBy(OrderRow::getStatus, Collectors.counting()));
    return totalCountByStatus;
}
//5.4. Выручка по способам оплаты
static Map<PaymentChoice, Double> revenueByPayment(List<OrderRow> orders){
    Map<PaymentChoice, Double> totalRevenueByPayment = orders.stream()
            .filter(o->!o.getStatus().equals(OrderStatus.CANCELLED))
            .collect(Collectors.groupingBy(OrderRow::getPayment, Collectors.summingDouble(OrderRow::getTotal)));
    return totalRevenueByPayment;
}
//5.5. Пагинация
static Page<OrderRow> page(List<OrderRow> orders, int pageNum, int pageSize) {
    List<OrderRow> items = orders.stream()
            .skip(pageSize)
            .limit(pageSize)
            .toList();
    Page<OrderRow> thisPage = new Page<>(items, pageNum, pageSize, orders.size());
    return thisPage;
}
}
