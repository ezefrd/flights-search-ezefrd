public class Flight {
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
}
