public class ChildPassanger extends Passanger{
    public ChildPassanger(){
        super(new PriceRate(77));
    }

    @Override
    public Price calculateFlightPrice(Flight flight,
            PriceRate departureDateRate) {
        return flight.calculatePriceWithRates(this.passangerRate, departureDateRate);
    }
}