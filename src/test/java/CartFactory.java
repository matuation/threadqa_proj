//2. Класс CartFactory
import net.datafaker.Faker;

class CartFactory {
    private static final Faker FAKER = new Faker();

    static Cart newCart(int size) {
        Cart cart = new Cart(FAKER.number().randomNumber(10));
        for (int i = 0; i < size; i++) {
            Cart.Item item = new Cart.Item(FAKER.food().dish(),
                    FAKER.number().numberBetween(1, 5),
                    FAKER.number().randomDouble(2, 100, 1000));
            cart.addItem(item);
        }
        return cart;
    }
}