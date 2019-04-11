import java.time.LocalDate;

public class FlightSearch {
    private LocalDate today;
    private Flights flights;


    public FlightSearch(Flights flights, LocalDate today) {
        this.flights = flights;
        this.today = today;
    }

    public FlightsResult search(Passengers passengers, DepartureDate departureDate, Airport airportOrigin, Airport airportDestiny) {
        Flights potentialFlights = flights.searchFlightsFromTo(airportOrigin, airportDestiny);
        PriceRate departureDateRate = new DepartureDateRateFactory().createRate(today, departureDate);
        return potentialFlights.createFlightsResults(passengers, departureDateRate);
    }
}
