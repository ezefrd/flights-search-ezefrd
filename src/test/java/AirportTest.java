import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirportTest {

    @Test
    public void test_match_iata_and_match_true(){
        //given:
        Airport airport = new Airport("MAD", "Madrid");
        //when:
        boolean match = airport.matchIata("MAD");
        //then:
        Assert.assertTrue(match);
    }

    @Test
    public void test_match_iata_and_match_false(){
        //given:
        Airport airport = new Airport("MAD", "Madrid");
        //when:
        boolean match = airport.matchIata("BCN");
        //then:
        Assert.assertFalse(match);
    }

}