public class Flight implements PotentialFlight, PriceableFlight{
    private Airport airportOrigin;
    private Airport airportDestiny;
    private Airline airline;
    private Price basePrice;

    public Flight(Airport airportOrigin, Airport airportDestiny, Airline airline, Price basePrice){
        this.airportOrigin = airportOrigin;
        this.airportDestiny = airportDestiny;
        this.airline = airline;
        this.basePrice = basePrice;
    }

    public boolean matchOriginAndDestinyAirports(Airport originAirport, Airport destinyAirport) {
        return airportOrigin.equals(originAirport) && airportDestiny.equals(destinyAirport);
    }

    @Override
    public boolean equals(Object obj) {
        Flight otherFlight = (Flight) obj;
        return otherFlight.airportOrigin.equals(airportOrigin) &&
                otherFlight.airportDestiny.equals(airportDestiny) &&
                otherFlight.airline.equals(airline) &&
                otherFlight.basePrice.equals(basePrice);
    }

    @Override
    public FlightResult calculateFlightResult(Passengers passengers,
            PriceRate departureDateRate) {

        Price totalAmount = passengers.calculateFlightAmount(this, departureDateRate);

        return new FlightResult(this.airline, totalAmount);
    }

    @Override
    public Price calculatePriceWithRates(PriceRate passangerRate, PriceRate departureDateRate) {
        Price price = departureDateRate.calculatePrice(this.basePrice);
        price = passangerRate.calculatePrice(price);

        return price;
    }

    @Override
    public Price calculatePriceForInfant() {
        return this.airline.calculatePriceForInfant();
    }
}
