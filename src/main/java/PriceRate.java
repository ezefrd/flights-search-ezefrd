public class PriceRate {
    private int rate;

    public PriceRate(int rate){
        this.rate = rate;
    }

    public Price calculatePrice(Price originalPrice) {
        return originalPrice.applyRate(this.rate);
    }
}
