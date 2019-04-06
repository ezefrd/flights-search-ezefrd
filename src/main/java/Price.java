import java.util.Currency;

public class Price {
    private double basePrice;
    private Currency currency;
    public Price(double basePrice, Currency currency) {
        this.basePrice = basePrice;
        this.currency = currency;
    }
}
