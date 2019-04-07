import java.util.Currency;
import java.util.Locale;

public class IberiaAirline extends Airline{

    public IberiaAirline(AirlineCode airlineCode){
        super(airlineCode, new Price(10.0, Currency.getInstance(new Locale("es", "ES"))));
    }
}
