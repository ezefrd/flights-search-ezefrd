import java.time.LocalDate;

public class DepartureDateRateFactory {
    public PriceRate createRate(LocalDate today, DepartureDate departureDate) {
        if(departureDate.differenceWithToday(today) > 30){
            return new PriceRate(80);
        }

        if(departureDate.differenceWithToday(today) >= 16 && departureDate.differenceWithToday(today) <= 30){
            return new PriceRate(100);
        }

        if(departureDate.differenceWithToday(today) >= 3 && departureDate.differenceWithToday(today) <= 15){
            return new PriceRate(120);
        }

        return new PriceRate(150);
    }
}
