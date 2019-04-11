import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

public class AirlineFactoryTest {

    LinkedHashMap<String, Class> airlines;
    AirlineFactory airlineFactory;


    @Before
    public void setup(){
        airlines = new LinkedHashMap<>();
        airlines.put("IB", IberiaAirline.class);
        airlines.put("BA", BritishAirwaysAirline.class);
        airlines.put("FR", LufthanseAirline.class);
        airlines.put("LH", RyanairAirline.class);
        airlines.put("VY", VuelingAirline.class);
        airlines.put("TK", TurkishAirline.class);
        airlines.put("U2", EasyjetAirline.class);


        airlineFactory = new AirlineFactory(airlines);
    }

    @Test
    public void test_create_from_code_iberia_airline(){
        //given:
        AirlineCode airlineCode = new AirlineCode("IB2345");
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertTrue(airline instanceof IberiaAirline);
    }

    @Test
    public void test_create_from_code_british_airline(){
        //given:
        AirlineCode airlineCode = new AirlineCode("BA2345");
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertTrue(airline instanceof BritishAirwaysAirline);
    }

    @Test
    public void test_create_from_code_lufthanse_airline(){
        //given:
        AirlineCode airlineCode = new AirlineCode("FR2345");
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertTrue(airline instanceof LufthanseAirline);
    }

    @Test
    public void test_create_from_code_ryanair_airline(){
        //given:
        AirlineCode airlineCode = new AirlineCode("LH2345");
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertTrue(airline instanceof RyanairAirline);
    }

    @Test
    public void test_create_from_code_vueling_airline(){
        //given:
        AirlineCode airlineCode = new AirlineCode("VY2345");
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertTrue(airline instanceof VuelingAirline);
    }

    @Test
    public void test_create_from_code_turkish_airline(){
        //given:
        AirlineCode airlineCode = new AirlineCode("TK2345");
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertTrue(airline instanceof TurkishAirline);
    }

    @Test
    public void test_create_from_code_easyjey_airline(){
        //given:
        AirlineCode airlineCode = new AirlineCode("U22345");
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertTrue(airline instanceof EasyjetAirline);
    }

    @Test
    public void test_create_from_code_invalid_airline(){
        //given:
        AirlineFactory airlineFactory = new AirlineFactory();
        AirlineCode airlineCode = new AirlineCode("INVALID");
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertTrue(airline instanceof DefaultAirline);
    }

}