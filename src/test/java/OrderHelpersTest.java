import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderHelpersTest {
    @Test
    void formatBuildsHumanString() {
        assertThat(OrderHelpers.format(42, "PAID", 199.0))
                .isEqualTo("Order #42 | PAID | 199.0");
    }

    @Test
    void finalForPaidNotForCreated() {
        assertThat(OrderHelpers.isFinal("PAID")).isTrue();
        assertThat(OrderHelpers.isFinal("CREATED")).isFalse();
    }

    @ParameterizedTest(name = "{0} → {1}")
    @CsvSource({"CREATED, false",
            "PAID, true",
            "READY, true",
            "COMPLETED, true",
            "UNKNOWN, false"})
    void finalStatusTable(String status, boolean expected) {
        assertThat(OrderHelpers.isFinal(status)).isEqualTo(expected);
    }

    @Test
    void keepFinalFiltersOnlyFinalStatuses() {
        List<String> list = List.of("CREATED", "PAID", "READY", "CANCELLED");
        assertThat(OrderHelpers.keepFinal(list)).hasSize(3);
        assertThat(OrderHelpers.keepFinal(list)).contains("PAID", "READY");
        assertThat(OrderHelpers.keepFinal(list)).doesNotContain("CREATED");
    }
}