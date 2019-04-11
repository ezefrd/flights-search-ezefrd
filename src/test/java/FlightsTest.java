import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.*;

public class FlightsTest {

    Airport barcelonaAirport;
    Airport madridAirport;
    Airport romeAirport;
    Currency currency;
    Flights flights;

    @Before
    public void setup(){
        barcelonaAirport = new Airport("BCN", "Barcelona");
        madridAirport = new Airport("MAD", "Madrid");
        romeAirport = new Airport("FCO", "Rome");

        currency = Currency.getInstance(new Locale("es", "ES"));

        flights = new Flights();

        flights.add(getBarcelonaMadridIBFlight());
        flights.add(getBarcelonaMadridBAFlight());
        flights.add(getBarcelonaRomeIBFlight());

    }

    @Test
    public void test_find_flights_matching_origin_and_destination_with_two_flights(){
        //when:
        Flights foundedFlights = flights.searchFlightsFromTo(barcelonaAirport,madridAirport);
        //then:
        Assert.assertEquals(foundedFlights, new Flights().add(getBarcelonaMadridIBFlight()).add(getBarcelonaMadridBAFlight()));
    }

    @Test
    public void test_find_flights_matching_origin_and_destination_with_one_flight(){
                //when:
        Flights foundedFlights = flights.searchFlightsFromTo(barcelonaAirport,romeAirport);
        //then:
        Assert.assertEquals(foundedFlights, new Flights().add(getBarcelonaRomeIBFlight()));
    }

    @Test
    public void test_find_flights_matching_origin_and_destination_with_none_flightst(){

        //when:
        Flights foundedFlights = flights.searchFlightsFromTo(barcelonaAirport,new Airport("AMS", "Amsterdam"));
        //then:
        Assert.assertEquals(foundedFlights, new NoneFlights());
    }

    private Flight getBarcelonaMadridIBFlight() {
        return new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(new BigDecimal(150), currency));
    }

    private Flight getBarcelonaMadridBAFlight() {
        return new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("BA1234")),
                new Price(new BigDecimal(180), currency));
    }

    private Flight getBarcelonaRomeIBFlight() {
        return new Flight(barcelonaAirport, romeAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(new BigDecimal(100.5), currency));
    }

}