public abstract class Airline {
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

    @Override public boolean equals(Object obj) {
        Airline otherAirline = (Airline) obj;
        return otherAirline.airlineCode.equals(airlineCode) &&
                otherAirline.infantPrice.equals(infantPrice);
    }

    public Price calculatePriceForInfant(PriceRate passangerRate, PriceRate departureDateRate) {
        return infantPrice;
    }
}
