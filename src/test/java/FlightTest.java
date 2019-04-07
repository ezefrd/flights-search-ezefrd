import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlightTest {

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
    public void test_flight_match_origin_and_destiny_iata(){
        //given:
        Flight barcelonaMadridIBFlight = new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(150.0, currency));
        //when:
        boolean matchIata = barcelonaMadridIBFlight.matchOriginAndDestinyIATA("BCN", "MAD");
        //then:
        assertTrue(matchIata);
    }

    @Test
    public void test_flight_dont_match_origin_and_destiny_iata(){
        //given:
        Flight barcelonaMadridIBFlight = new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(150.0, currency));
        //when:
        boolean matchIata = barcelonaMadridIBFlight.matchOriginAndDestinyIATA("BCN", "FCO");
        //then:
        assertFalse(matchIata);
    }

    @Test
    public void test_calculate_flight_result_for_one_adult(){
        //given:
        PotentialFlight barcelonaMadridIBFlight = new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(100.0, currency));

        Passengers passengers = new Passengers();
        passengers.addPassanger(new AdultPassanger());
        //when:
        FlightResult flightResult = barcelonaMadridIBFlight.calculateFlightResult(
                passengers,
                new PriceRate(80)
        );
        //then:
/*        Assert.assertEquals(
                new FlightResult(
                        new IberiaAirline(new AirlineCode("IB1234")),
                        new Price(
                                80.0,
                                Currency.getInstance(new Locale("es", "ES"))
                        )
                ), flightResult);*/
        Assert.assertNull(flightResult);
    }

    @Test
    public void test_calculate_price_with_rates(){
        //given:
        PriceRate passangerRate = new PriceRate(100);
        PriceRate departureDateRate = new PriceRate(80);
        Flight flight = new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(100.0, currency));
        //when:
        Price calculatedPrice = flight.calculatePriceWithRates(passangerRate, departureDateRate);
        //then:
        Assert.assertEquals(new Price(80.0, currency), calculatedPrice);

    }

}