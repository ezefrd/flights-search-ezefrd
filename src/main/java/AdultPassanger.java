public class AdultPassanger extends Passanger{
    public AdultPassanger(){
        super(new PriceRate(100));
    }

    @Override
    public Price calculateFlightPrice(Flight flight,
            PriceRate departureDateRate) {
        return flight.calculatePriceWithRates(this.passangerRate, departureDateRate);
    }
}