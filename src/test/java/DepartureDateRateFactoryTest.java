import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DepartureDateRateFactoryTest {

    @Test
    public void test_create_departure_date_rate_for_more_than_30_days(){
        //given:
        DepartureDateRateFactory departureDateRateFactory = new DepartureDateRateFactory();
        LocalDate today = LocalDate.of(2019,3,31);

        DepartureDate departureDate = new DepartureDate(today.plusDays(31));
        //when:
        PriceRate departureDateRate = departureDateRateFactory.createRate(today, departureDate);
        //then:
        Assert.assertEquals(new PriceRate(80), departureDateRate);
    }

    @Test
    public void test_create_departure_date_rate_for_16_days(){
        //given:
        DepartureDateRateFactory departureDateRateFactory = new DepartureDateRateFactory();
        LocalDate today = LocalDate.of(2019,3,31);

        DepartureDate departureDate = new DepartureDate(today.plusDays(16));
        //when:
        PriceRate departureDateRate = departureDateRateFactory.createRate(today, departureDate);
        //then:
        Assert.assertEquals(new PriceRate(100), departureDateRate);
    }

    @Test
    public void test_create_departure_date_rate_for_30_days(){
        //given:
        DepartureDateRateFactory departureDateRateFactory = new DepartureDateRateFactory();
        LocalDate today = LocalDate.of(2019,3,31);

        DepartureDate departureDate = new DepartureDate(today.plusDays(30));
        //when:
        PriceRate departureDateRate = departureDateRateFactory.createRate(today, departureDate);
        //then:
        Assert.assertEquals(new PriceRate(100), departureDateRate);
    }

    @Test
    public void test_create_departure_date_rate_for_15_days(){
        //given:
        DepartureDateRateFactory departureDateRateFactory = new DepartureDateRateFactory();
        LocalDate today = LocalDate.of(2019,3,31);

        DepartureDate departureDate = new DepartureDate(today.plusDays(15));
        //when:
        PriceRate departureDateRate = departureDateRateFactory.createRate(today, departureDate);
        //then:
        Assert.assertEquals(new PriceRate(120), departureDateRate);
    }

    @Test
    public void test_create_departure_date_rate_for_3_days(){
        //given:
        DepartureDateRateFactory departureDateRateFactory = new DepartureDateRateFactory();
        LocalDate today = LocalDate.of(2019,3,31);

        DepartureDate departureDate = new DepartureDate(today.plusDays(3));
        //when:
        PriceRate departureDateRate = departureDateRateFactory.createRate(today, departureDate);
        //then:
        Assert.assertEquals(new PriceRate(120), departureDateRate);
    }

    @Test
    public void test_create_departure_date_rate_for_less_than_3_days(){
        //given:
        DepartureDateRateFactory departureDateRateFactory = new DepartureDateRateFactory();
        LocalDate today = LocalDate.of(2019,3,31);

        DepartureDate departureDate = new DepartureDate(today.plusDays(2));
        //when:
        PriceRate departureDateRate = departureDateRateFactory.createRate(today, departureDate);
        //then:
        Assert.assertEquals(new PriceRate(150), departureDateRate);
    }
}
