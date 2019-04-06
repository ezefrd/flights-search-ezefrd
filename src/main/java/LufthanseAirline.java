import java.util.Currency;
import java.util.Locale;

public class LufthanseAirline extends Airline{

    public LufthanseAirline(AirlineCode airlineCode) {
        super(airlineCode, new Price(7, Currency
                .getInstance(new Locale("es", "ES"))));
    }
}
