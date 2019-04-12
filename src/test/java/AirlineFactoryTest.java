import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
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

    @Test
    public void test_create_from_code_iberia_airline_fails_no_such_method()
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //given:
        AirlineCode airlineCode = Mockito.mock(AirlineCode.class);

        Mockito.when(
                airlineCode.starsWithThenReturnInstanceOrDefault(
                        "IB",
                        IberiaAirline.class,
                        new DefaultAirline())
        ).thenThrow(NoSuchMethodException.class);
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertNull(airline);
    }


    //@Smell: following tests don't say too much.. should them?
    @Test
    public void test_create_from_code_iberia_airline_fails_illegal_accesse_exception()
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //given:
        AirlineCode airlineCode = Mockito.mock(AirlineCode.class);

        Mockito.when(
                airlineCode.starsWithThenReturnInstanceOrDefault(
                        "IB",
                        IberiaAirline.class,
                        new DefaultAirline())
        ).thenThrow(IllegalAccessException.class);
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertNull(airline);
    }

    @Test
    public void test_create_from_code_iberia_airline_fails_invocation_target_exception()
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //given:
        AirlineCode airlineCode = Mockito.mock(AirlineCode.class);

        Mockito.when(
                airlineCode.starsWithThenReturnInstanceOrDefault(
                        "IB",
                        IberiaAirline.class,
                        new DefaultAirline())
        ).thenThrow(InvocationTargetException.class);
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertNull(airline);
    }

    @Test
    public void test_create_from_code_iberia_airline_fails_instantiation_exception()
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //given:
        AirlineCode airlineCode = Mockito.mock(AirlineCode.class);

        Mockito.when(
                airlineCode.starsWithThenReturnInstanceOrDefault(
                        "IB",
                        IberiaAirline.class,
                        new DefaultAirline())
        ).thenThrow(InstantiationException.class);
        //when:
        Airline airline = airlineFactory.createFromCode(airlineCode);
        //then:
        Assert.assertNull(airline);
    }

}