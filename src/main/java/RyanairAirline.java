import java.util.Currency;
import java.util.Locale;

public class RyanairAirline extends Airline{

    public RyanairAirline(AirlineCode airlineCode) {
        super(airlineCode, new Price(20.0, Currency.getInstance(new Locale("es", "ES"))));
    }
}
