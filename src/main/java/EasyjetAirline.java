import java.util.Currency;
import java.util.Locale;

public class EasyjetAirline extends Airline{

    public EasyjetAirline(AirlineCode airlineCode) {
        super(airlineCode, new Price(19.9, Currency
                .getInstance(new Locale("es", "ES"))));
    }
}