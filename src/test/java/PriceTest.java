import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class PriceTest {

    @Test
    public void test_two_prices_are_the_same(){
        //given:
        Price price1 = new Price(
                new BigDecimal(10),
                Currency.getInstance(new Locale("es", "ES"))
        );

        Price price2 = new Price(
                new BigDecimal(10),
                Currency.getInstance(new Locale("es", "ES"))
        );

        //expect:
        Assert.assertEquals(price1, price2);
    }

    @Test
    public void test_two_different_prices_by_base_price(){
        //given:
        Price price1 = new Price(
                new BigDecimal(10),
                Currency.getInstance(new Locale("es", "ES"))
        );

        Price price2 = new Price(
                new BigDecimal(12),
                Currency.getInstance(new Locale("es", "ES"))
        );

        //expect:
        Assert.assertNotEquals(price1, price2);
    }

    @Test
    public void test_two_different_prices_by_currency(){
        //given:
        Price price1 = new Price(
                new BigDecimal(10),
                Currency.getInstance(new Locale("es", "ES"))
        );

        Price price2 = new Price(
                new BigDecimal(10),
                Currency.getInstance(new Locale("es", "AR"))
        );

        //expect:
        Assert.assertNotEquals(price1, price2);
    }

    @Test
    public void test_two_different_prices(){
        //given:
        Price price1 = new Price(
                new BigDecimal(10),
                Currency.getInstance(new Locale("es", "ES"))
        );

        Price price2 = new Price(
                new BigDecimal(12),
                Currency.getInstance(new Locale("es", "AR"))
        );

        //expect:
        Assert.assertNotEquals(price1, price2);
    }

}