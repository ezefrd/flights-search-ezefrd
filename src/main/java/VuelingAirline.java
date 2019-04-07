import java.util.Currency;
import java.util.Locale;

public class VuelingAirline  extends Airline{

    public VuelingAirline(AirlineCode airlineCode) {
        super(airlineCode, new Price(10.0, Currency
                .getInstance(new Locale("es", "ES"))));
    }
}
