//3. Конфиг CartConfig (внутри теста)
import org.aeonbits.owner.Config;

interface CartConfig extends Config {
    @Key("cart.default.size")
    @DefaultValue("3")
    int defaultSize();

    @Key("cart.max.size")
    @DefaultValue("20")
    int maxSize();
    // TODO: defaultSize() — ключ cart.default.size, дефолт 3
    // TODO: maxSize()     — ключ cart.max.size, дефолт 20
}