import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Заказы")
@Feature("Оформление заказа")
class CheckoutAllureTest {

    @Test
    @Story("Успешный заказ")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тестирование успешного заказа")
    @Description("Флоу успешного заказа")
    void successfulCheckoutFlow() {
        // TODO: вызвать пять шагов по очереди
    }

    @Step("Логинимся как {0} с паролем {1}")
    void loginAs(String email, String password) {
        // TODO (заглушка)
    }

    // TODO: createOrder(recipeId, qty) -> orderId
    @Step("Создаем заказ по рецепту {0} в количестве {1}")
    int createOrder(int recipeId, int qty){
        int orderId = 0;
        return orderId;
    }

    // TODO: payByCard(orderId, cardNumber)
    @Step("Оплачиваем заказ {0} картой {1}")
    void loginAs(int orderId, long cardNumber) {
        // TODO (заглушка)
    }

    // TODO: fetchStatus(orderId) -> status
    @Step("Оплачиваем заказ {0} картой {1}")
    String fetchStatus(int orderId) {
        String status = "";
        return status;
    }
    // TODO: assertStatus(actual, expected) — внутри AssertJ
    @Step("Проверяем что статус {0} соответствует ожидаемому {1}")
    void assertStatus(String actual, String expected) {
        assertThat(actual).isEqualTo(expected);
    }
}