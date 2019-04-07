import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.*;

public class PriceRateTest {

    @Test
    public void test_apply_rate_to_a_price(){
        //given:
        Price originalPrice = new Price(100.0, Currency.getInstance(new Locale("es", "ES")));
        PriceRate priceRate = new PriceRate(80);
        //when:
        Price modifiedPrice = priceRate.calculatePrice(originalPrice);
        //then:
        Assert.assertEquals(
                new Price(80.0, Currency.getInstance(new Locale("es", "ES"))),
                modifiedPrice
        );
    }

}