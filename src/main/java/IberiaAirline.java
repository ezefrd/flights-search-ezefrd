import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class IberiaAirline extends Airline{

    public IberiaAirline(AirlineCode airlineCode){
        super(airlineCode, new Price(new BigDecimal(10), Currency.getInstance(new Locale("es", "ES"))));
    }
}
