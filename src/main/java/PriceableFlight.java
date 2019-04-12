public interface PriceableFlight {
    public Price calculatePriceWithRates(PriceRate passangerRate, PriceRate departureDateRate);

    public Price calculatePriceForInfant();
}
