import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class Price {
    private Double basePrice;
    private Currency currency;

    public Price(Double basePrice, Currency currency) {
        this.basePrice = basePrice;
        this.currency = currency;
    }

    @Override public boolean equals(Object obj) {
        Price otherPrice = (Price) obj;
        return otherPrice.basePrice.equals(basePrice)&& otherPrice.currency.equals(currency);
    }

    public Price applyRate(int rate) {
        Double priceWithRate = ((rate * this.basePrice ) / 100.0);
        BigDecimal bdPriceWithRate = new BigDecimal(priceWithRate);
        bdPriceWithRate = bdPriceWithRate.setScale(this.currency.getDefaultFractionDigits(), BigDecimal.ROUND_HALF_UP);
        return new Price(bdPriceWithRate.doubleValue(), this.currency);
    }

    public void addPrice(Price otherAmount) {
        this.basePrice += otherAmount.basePrice;
    }
}
