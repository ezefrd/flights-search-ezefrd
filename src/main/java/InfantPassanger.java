public class InfantPassanger extends Passanger{
    public InfantPassanger(){
        super(new PriceRate(0));
    }

    @Override
    public Price calculateFlightPrice(PriceableFlight flight,
            PriceRate departureDateRate) {
        return flight.calculatePriceForInfant();
    }
}
