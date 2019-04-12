public class ChildPassanger extends Passanger{
    public ChildPassanger(){
        super(new PriceRate(67));
    }

    @Override
    public Price calculateFlightPrice(PriceableFlight flight,
            PriceRate departureDateRate) {
        return flight.calculatePriceWithRates(this.passangerRate, departureDateRate);
    }
}
