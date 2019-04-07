public class InfantPassanger extends Passanger{
    public InfantPassanger(){
        super(new PriceRate(0));
    }

    @Override
    public Price calculateFlightPrice(Flight flight,
            PriceRate departureDateRate) {
        return flight.calculatePriceForInfant(this.passangerRate, departureDateRate);
    }
}
