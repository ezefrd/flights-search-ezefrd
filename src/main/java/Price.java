import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;

public class Price {
    private BigDecimal basePrice;
    private Currency currency;

    public Price(BigDecimal basePrice, Currency currency) {
        this.basePrice = basePrice;
        this.currency = currency;
    }

    @Override public boolean equals(Object obj) {
        Price otherPrice = (Price) obj;
        return otherPrice.getBasePrice().equals(this.getBasePrice())&& otherPrice.currency.equals(currency);
    }

    private BigDecimal getBasePrice() {
        return this.basePrice.setScale(currency.getDefaultFractionDigits(), RoundingMode.DOWN);
    }

    public Price applyRate(int rate) {
        BigDecimal priceWithRate = this.basePrice.multiply(new BigDecimal(rate)).divide(new BigDecimal(100));
        return new Price(priceWithRate, this.currency);
    }

    public void addPrice(Price otherAmount) {
        this.basePrice = this.basePrice.add(otherAmount.basePrice);
        this.basePrice = this.basePrice.setScale(currency.getDefaultFractionDigits(), RoundingMode.DOWN);
    }

    public String showCost() {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setCurrency(currency);

        return formatter.format(this.basePrice) + " " + currency.getSymbol();
    }
}
