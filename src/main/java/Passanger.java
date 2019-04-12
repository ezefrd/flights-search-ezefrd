public abstract class Passanger {
    protected PriceRate passangerRate;

    public Passanger(PriceRate rate){
        this.passangerRate = rate;
    }

    public abstract Price calculateFlightPrice(PriceableFlight flight, PriceRate departureDateRate);
}
