import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.*;

public class PassengersTest {

    @Test
    public void test_calculate_flight_price_for_passanger_when_only_one_adult(){
        //give:
        Passengers passengers = new Passengers();
        passengers.addPassanger(new AdultPassanger());
        Flight flight = new Flight(
                    new Airport("MAD", "Madrid"),
                    new Airport("BCN", "Barcelona"),
                    new IberiaAirline(new AirlineCode("IB1234")),
                    new Price(new BigDecimal(150), Currency.getInstance(new Locale("es", "ES")))
                );
        PriceRate departureDateRate = new PriceRate(80);
        //when:
        Price totalAmount = passengers.calculateFlightAmount(flight, departureDateRate);
        //then:
        Assert.assertEquals(new Price(new BigDecimal(120), Currency.getInstance(new Locale("es", "ES"))), totalAmount);
    }

    @Test
    public void test_calculate_flight_price_for_passanger_when_2_adults_1_child_1_infant(){
        //give:
        Passengers passengers = new Passengers();
        passengers.addPassanger(new AdultPassanger());
        passengers.addPassanger(new AdultPassanger());
        passengers.addPassanger(new ChildPassanger());
        passengers.addPassanger(new InfantPassanger());

        Flight flight = new Flight(
                new Airport("MAD", "Madrid"),
                new Airport("BCN", "Barcelona"),
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(new BigDecimal(150), Currency.getInstance(new Locale("es", "ES")))
        );
        PriceRate departureDateRate = new PriceRate(120);
        //when:
        Price totalAmount = passengers.calculateFlightAmount(flight, departureDateRate);
        //then:
        Assert.assertEquals(new Price(new BigDecimal(490.6), Currency.getInstance(new Locale("es", "ES"))), totalAmount);
    }

}