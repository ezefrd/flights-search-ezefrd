import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class VuelingAirline  extends Airline{

    public VuelingAirline(AirlineCode airlineCode) {
        super(airlineCode, new Price(new BigDecimal(10), Currency
                .getInstance(new Locale("es", "ES"))));
    }
}
