//1. Класс Cart
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class Cart {
    private final long userId;
    private final List<Item> items = new ArrayList<>();

    void addItem(Item item) {
        items.add(item);
    }

    @Data
    static class Item {
        private final String dish;
        private final int quantity;
        private final double price;
    }
}