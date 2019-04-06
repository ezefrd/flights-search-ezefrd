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
}
