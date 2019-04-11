import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class EasyjetAirline extends Airline{

    public EasyjetAirline(AirlineCode airlineCode) {
        super(airlineCode, new Price(new BigDecimal(19.9), Currency
                .getInstance(new Locale("es", "ES"))));
    }
}