import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.*;

public class PriceRateTest {

    @Test
    public void test_apply_rate_to_a_price(){
        //given:
        Price originalPrice = new Price(new BigDecimal(100), Currency.getInstance(new Locale("es", "ES")));
        PriceRate priceRate = new PriceRate(80);
        //when:
        Price modifiedPrice = priceRate.calculatePrice(originalPrice);
        //then:
        Assert.assertEquals(
                new Price(new BigDecimal(80), Currency.getInstance(new Locale("es", "ES"))),
                modifiedPrice
        );
    }

}