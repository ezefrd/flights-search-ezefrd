import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Flights foundedFlights = flights.searchFlightsFromTo("BCN","MAD");
        //then:
        Assert.assertEquals(foundedFlights, new Flights().add(getBarcelonaMadridIBFlight()).add(getBarcelonaMadridBAFlight()));
    }

    @Test
    public void test_find_flights_matching_origin_and_destination_with_one_flight(){
                //when:
        Flights foundedFlights = flights.searchFlightsFromTo("BCN","FCO");
        //then:
        Assert.assertEquals(foundedFlights, new Flights().add(getBarcelonaRomeIBFlight()));
    }

    @Test
    public void test_find_flights_matching_origin_and_destination_with_none_flightst(){

        //when:
        Flights foundedFlights = flights.searchFlightsFromTo("BCN","AMS");
        //then:
        Assert.assertEquals(foundedFlights, new NoneFlights());
    }

    private Flight getBarcelonaMadridIBFlight() {
        return new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(150.0, currency));
    }

    private Flight getBarcelonaMadridBAFlight() {
        return new Flight(barcelonaAirport, madridAirport,
                new IberiaAirline(new AirlineCode("BA1234")),
                new Price(180.0, currency));
    }

    private Flight getBarcelonaRomeIBFlight() {
        return new Flight(barcelonaAirport, romeAirport,
                new IberiaAirline(new AirlineCode("IB1234")),
                new Price(100.5, currency));
    }

}