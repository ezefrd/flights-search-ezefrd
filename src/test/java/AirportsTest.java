import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirportsTest {

    @Test
    public void test_add_airport_to_list(){
        //given:
        Airports airports = new Airports();
        Airport romeAirport = new Airport("FCO", "Roma");
        //when:
        airports = airports.add(romeAirport);
        //then:
        Assert.assertTrue(airports.airports.size() == 1);
        Assert.assertTrue(airports.airports.get(0) == romeAirport);

    }

    @Test
    public void test_find_airport_by_IATA_and_find_one(){
        //given:
        Airports airports = new Airports();
        Airport romeAirport = new Airport("FCO", "Roma");
        Airport barcelonaAirport = new Airport("BCN", "Barcelona");
        Airport madridAirport = new Airport("MAD", "Madrid");
        airports.add(romeAirport);
        airports.add(barcelonaAirport);
        airports.add(madridAirport);
        //when:
        Airport airport = airports.findByIATA("BCN");

        //then:
        Assert.assertTrue(airport.equals(barcelonaAirport));
    }

    @Test
    public void test_find_airport_by_IATA_and_find_no_one(){
        //given:
        Airports airports = new Airports();
        Airport romeAirport = new Airport("FCO", "Roma");
        Airport barcelonaAirport = new Airport("BCN", "Barcelona");
        Airport madridAirport = new Airport("MAD", "Madrid");
        airports.add(romeAirport);
        airports.add(barcelonaAirport);
        airports.add(madridAirport);
        //when:
        Airport airport = airports.findByIATA("JPN");

        //then:
        Assert.assertTrue(airport.equals(new NoneAirport()));
    }

}