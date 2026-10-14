package junit_extension;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class TestCart {
    private final long id;
    private final List<String> items = new ArrayList<>();

    void add(String dish) {
        items.add(dish);
    }

    void clear() {
        items.clear();
    }
}