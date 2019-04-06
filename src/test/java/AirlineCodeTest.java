import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirlineCodeTest {
    @Test
    public void test_if_airline_code_match_then_return_valid_airline(){
        //given:
        AirlineCode airlineCode = new AirlineCode("IB1234");
        //when:
        Airline airline = airlineCode.checkCodeAndReturnAirlineOrDefault("IB",new IberiaAirline(new AirlineCode("IB1234")), new DefaultAirline());
        //then:
        Assert.assertTrue(airline instanceof IberiaAirline);
    }

    @Test
    public void test_if_airline_code_match_then_return_default_airline(){
        //given:
        AirlineCode airlineCode = new AirlineCode("NN1234");
        //when:
        Airline airline = airlineCode.checkCodeAndReturnAirlineOrDefault("IB", new IberiaAirline(new AirlineCode("IB1234")), new DefaultAirline());
        //then:
        Assert.assertTrue(airline instanceof DefaultAirline);
    }

}