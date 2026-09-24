import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {
    //4. Тест 1 — конфиг отдаёт значения по умолчанию
    @Test
    void configReturnsDefaults() {
        CartConfig config = ConfigFactory.create(CartConfig.class);
        assertThat(config.defaultSize()).isEqualTo(3);
        assertThat(config.maxSize()).isEqualTo(20);
    }
    //5. Тест 2 — фабрика создаёт корзину размера из конфига
    @Test
    void factoryCreatesCartOfDefaultSize() {
        CartConfig config = ConfigFactory.create(CartConfig.class);
        Cart cart = CartFactory.newCart(config.defaultSize());
        assertThat(cart.getUserId()).isPositive();
        assertThat(cart.getItems().size()).isEqualTo(config.defaultSize());
        assertThat(cart.getItems()).
                allSatisfy(item -> {
                    assertThat(!item.getDish().isBlank());
                    assertThat(item.getQuantity()).isBetween(1, 4);
                    assertThat(item.getPrice()).isBetween(100.00, 1000.00);
        });
    }
    //6. Тест 3 — явный размер
    @Test
    void factoryRespectsExplicitSize() {
        Cart cart = CartFactory.newCart(7);
        assertThat(cart.getItems().size()).isEqualTo(7);
    }
}
