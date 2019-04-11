import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;

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
        FlightSearch flightSearch = new FlightSearch(flights, LocalDate.of(2019,1,1));
        Passengers passengers = new Passengers();

        passengers.addPassanger(new AdultPassanger());


        DepartureDate departureDate = new DepartureDate(LocalDate.of(2019, 3, 31));
        Airport airportOrigin = new Airport("CPH", "Copenhagen");
        Airport airportDestiny = new Airport("FRA", "Frankfurt");

        //when:
        FlightsResult flightsResult = flightSearch.search(passengers, departureDate, airportOrigin, airportDestiny);
        //then:
        Assert.assertEquals("flights:\nIB2818, 148.8 EUR\nLH1678, 238.4 EUR\n", flightsResult.show());

    }

    @Test
    public void test_1_adult_31_days_to_the_departure_date_flying_AMS_to_FRA(){
        FlightSearch flightSearch = new FlightSearch(flights, LocalDate.of(2019,1,1));
        Passengers passengers = new Passengers();

        passengers.addPassanger(new AdultPassanger());

        DepartureDate departureDate = new DepartureDate(LocalDate.of(2019, 2, 2));
        Airport airportOrigin = new Airport("AMS", "Amsterdam");
        Airport airportDestiny = new Airport("FRA", "Frankfurt");

        //when:
        FlightsResult flightsResult = flightSearch.search(passengers, departureDate, airportOrigin, airportDestiny);
        //then:
        Assert.assertEquals("flights:\nTK2372, 157.6 EUR\nTK2659, 198.4 EUR\nLH5909, 90.4 EUR\n", flightsResult.show());
    }
    
    @Test
    public void test_2_adults__1_child__1_infant__15_days_to_the_departure_date__flying_LHR_to_IST(){
        FlightSearch flightSearch = new FlightSearch(flights, LocalDate.of(2019,1,1));
        Passengers passengers = new Passengers();

        passengers.addPassanger(new AdultPassanger());
        passengers.addPassanger(new AdultPassanger());

        passengers.addPassanger(new ChildPassanger());
        passengers.addPassanger(new InfantPassanger());



        DepartureDate departureDate = new DepartureDate(LocalDate.of(2019, 1, 16));
        Airport airportOrigin = new Airport("LHR", "London");
        Airport airportDestiny = new Airport("IST", "Istanbul");

        //when:
        FlightsResult flightsResult = flightSearch.search(passengers, departureDate, airportOrigin, airportDestiny);
        //then:
        Assert.assertEquals("flights:\nTK8891, 806 EUR\nLH1085, 481.19 EUR\n", flightsResult.show());
    }


    @Test
    public void test_1_adult_2_children_wants_to_fly_from_bcn_to_mad_buying_ticket_2_days_prior_the_departure() {
        //given:
        FlightSearch flightSearch = new FlightSearch(flights, LocalDate.of(2019,1,1));
        Passengers passengers = new Passengers();

        passengers.addPassanger(new AdultPassanger());
        passengers.addPassanger(new ChildPassanger());
        passengers.addPassanger(new ChildPassanger());



        DepartureDate departureDate = new DepartureDate(LocalDate.of(2019, 1, 2));
        Airport airportOrigin = new Airport("BCN", "Barcelona");
        Airport airportDestiny = new Airport("MAD", "Madrid");

        //when:
        FlightsResult flightsResult = flightSearch.search(passengers, departureDate, airportOrigin, airportDestiny);
        //then:
        Assert.assertEquals("flights:\nIB2171, 909.08 EUR\nLH5496, 1,028.42 EUR\n", flightsResult.show());

    }

    @Test
    public void test_1_adult_2_children_wants_to_fly_from_cdg_to_fra_no_flights_available() {
        //given:
        FlightSearch flightSearch = new FlightSearch(flights, LocalDate.of(2019,1,1));
        Passengers passengers = new Passengers();

        passengers.addPassanger(new AdultPassanger());
        passengers.addPassanger(new ChildPassanger());
        passengers.addPassanger(new ChildPassanger());



        DepartureDate departureDate = new DepartureDate(LocalDate.of(2019, 1, 2));
        Airport airportOrigin = new Airport("CDG", "Paris");
        Airport airportDestiny = new Airport("FRA", "Frankfurt");

        //when:
        FlightsResult flightsResult = flightSearch.search(passengers, departureDate, airportOrigin, airportDestiny);
        //then:
        Assert.assertEquals("no flights available", flightsResult.show());

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
                                new Price(new BigDecimal(values[3]), Currency.getInstance(Locale.FRANCE))
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
