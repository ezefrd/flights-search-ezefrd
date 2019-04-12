public abstract class Airline implements AirlinePresenter{
    protected AirlineCode airlineCode;
    protected Price infantPrice;

    public Airline(AirlineCode airlineCode){
        this.airlineCode = airlineCode;
        this.infantPrice = new NonePrice();
    }

    public Airline(AirlineCode airlineCode, Price infantPrice){
        this.airlineCode = airlineCode;
        this.infantPrice = infantPrice;
    }

    @Override
    public void appendCodeTo(StringBuilder flightResult) {
        flightResult.append(this.airlineCode.show());
    }

    public Price calculatePriceForInfant() {
        return infantPrice;
    }

    @Override public boolean equals(Object obj) {
        Airline otherAirline = (Airline) obj;
        return otherAirline.airlineCode.equals(airlineCode) &&
                otherAirline.infantPrice.equals(infantPrice);
    }
}
