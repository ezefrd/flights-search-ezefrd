import java.util.Currency;
import java.util.Locale;

public class BritishAirwaysAirline extends Airline{
    public BritishAirwaysAirline(AirlineCode airlineCode) {
        super(airlineCode, new Price(15.0, Currency.getInstance(new Locale("es", "ES"))));
    }
}
