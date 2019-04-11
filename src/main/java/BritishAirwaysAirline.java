import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class BritishAirwaysAirline extends Airline{
    public BritishAirwaysAirline(AirlineCode airlineCode) {
        super(airlineCode, new Price(new BigDecimal(15), Currency.getInstance(new Locale("es", "ES"))));
    }
}
