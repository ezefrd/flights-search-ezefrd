import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.*;

public class ChildPassangerTest {

    Airport barcelonaAirport;
    Airport madridAirport;
    Currency currency;

    @Before
    public void setup(){
        barcelonaAirport = new Airport("BCN", "Barcelona");
        madridAirport = new Airport("MAD", "Madrid");

        currency = Currency.getInstance(new Locale("es", "ES"));

    }

    @Test
    public void test_add_own_price_applying_self_rate_and_departure_day_rate(){
        //given:
        ChildPassanger childPassanger = new ChildPassanger();
        Flight flight = new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(new BigDecimal(150), currency));
        PriceRate departureDateRate = new PriceRate(80);
        //when:
        Price childPrice = childPassanger.calculateFlightPrice(flight, departureDateRate);
        //then:
        Assert.assertEquals(
                new Price(new BigDecimal(80.4), Currency.getInstance(new Locale("es", "ES"))),
                childPrice
        );
    }

}