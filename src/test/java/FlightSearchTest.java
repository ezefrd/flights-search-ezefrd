import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FlightSearchTest {

    Flights flights;
    Airports airports;

    @Before
    public void setup() {
        this.airports = new Airports();

        airports.add(new Airport("CPH", "Copenhagen"));
        airports.add(new Airport("MAD", "Madrid"));
        airports.add(new Airport("BCN", "Barcelona"));
        airports.add(new Airport("FRA", "Frankfurt"));
        airports.add(new Airport("LHR", "London"));
        airports.add(new Airport("CDG", "Paris"));
        airports.add(new Airport("IST", "Istanbul"));
        airports.add(new Airport("AMS", "Amsterdam"));
        airports.add(new Airport("FCO", "Roma"));

        this.flights = readFlightsFromCSV();
    }

    @Test
    public void test_an_adult_wants_to_fly_from_cph_to_fra_buying_ticket_more_than_30_days_prior_the_departure() {
        //given:
        FlightSearch flightSearch = new FlightSearch(new Date(2019,1,1));
        Passengers passengers = new Passengers();

        passengers.addPassanger(new AdultPassanger());


        DepartureDate departureDate = new DepartureDate(new Date(2019,3, 31));
        Airport airportOrigin = new Airport("CPF", "Copenhagen");
        Airport airportDestiny = new Airport("FRA", "Frankfurt");

        LinkedHashMap<String, String> expectedResult = new LinkedHashMap<>();

        //when:
        FlightsResult flightsResult = flightSearch.search(passengers, departureDate, airportOrigin, airportDestiny);
        //then:
        MapDifference<String, String> difference = Maps.difference(flightsResult.asMap(), expectedResult);
        System.out.print(difference.toString());
        Assert.assertTrue(difference.areEqual());

    }

    private Flights readFlightsFromCSV(){
        Flights flights = new Flights();
        AirlineFactory airlineFactory = new AirlineFactory();
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/flights.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                flights.add(
                        new Flight(
                                airports.findByIATA(values[0]),
                                airports.findByIATA(values[1]),
                                airlineFactory.createFromCode(new AirlineCode(values[2])),
                                new Price(new Integer(values[3]), Currency.getInstance(new Locale("es", "ES")))
                        )
                );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flights;
    }
}
