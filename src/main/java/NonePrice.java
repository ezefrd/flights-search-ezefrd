import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class NonePrice extends Price {
    public NonePrice() {
        super(new BigDecimal(0), Currency.getInstance(new Locale("es", "ES")));
    }
}
