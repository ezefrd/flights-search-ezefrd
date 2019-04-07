import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.*;

public class InfantPassangerTest {

    Airport barcelonaAirport;
    Airport madridAirport;
    Currency currency;

    @Before public void setup() {
        barcelonaAirport = new Airport("BCN", "Barcelona");
        madridAirport = new Airport("MAD", "Madrid");

        currency = Currency.getInstance(new Locale("es", "ES"));

    }

    @Test public void test_add_own_price_applying_self_rate_and_departure_day_rate() {
        //given:
        InfantPassanger infantPassanger = new InfantPassanger();
        Flight flight = new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(150.0, currency));
        PriceRate departureDateRate = new PriceRate(80);
        //when:
        Price infantPrice = infantPassanger
                .calculateFlightPrice(flight, departureDateRate);
        //then:
        Assert.assertEquals(
                new Price(10.0, Currency.getInstance(new Locale("es", "ES"))),
                infantPrice);
    }
}