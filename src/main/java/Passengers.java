import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class Passengers {
    private ArrayList<Passanger> passangers;

    public Passengers(){
        passangers = new ArrayList<>();
    }

    public Passengers addPassanger(Passanger passanger) {
        this.passangers = this.passangers != null ? this.passangers : new ArrayList<>();
        this.passangers.add(passanger);
        return this;
    }

    public Price calculateFlightAmount(Flight flight,
            PriceRate departureDateRate) {
        Price totalAmount = new Price(new BigDecimal(0), Currency.getInstance(new Locale("es", "ES")));

        for (Passanger passanger : this.passangers){
            Price passangerAmount = passanger.calculateFlightPrice(flight,departureDateRate);
            totalAmount.addPrice(passangerAmount);
        }

        return totalAmount;
    }
}
