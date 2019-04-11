import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class TurkishAirline extends Airline{

    public TurkishAirline(AirlineCode airlineCode) {
        super(airlineCode, new Price(new BigDecimal(5), Currency
                .getInstance(new Locale("es", "ES"))));
    }
}