import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Flights {
    private ArrayList<Flight> flights;

    public Flights(){
        this.flights = new ArrayList<Flight>();
    }

    public Flights(ArrayList<Flight> flights){
        this.flights = flights;
    }


    public Flights add(Flight flight){
        this.flights = this.flights != null ? this.flights : new ArrayList<>();
        this.flights.add(flight);
        return this;
    }

    public Flights searchFlightsFromTo(Airport originAirport, Airport destinyAirport) {
        ArrayList<Flight> foundedFlights = this.flights.parallelStream()
                .filter(flight -> flight.matchOriginAndDestinyAirports(originAirport, destinyAirport))
                .collect(Collectors.toCollection(ArrayList::new));

        return foundedFlights.size() > 0 ? new Flights(foundedFlights) : new NoneFlights();
    }

    @Override public boolean equals(Object obj) {
        Flights otherFlights = (Flights) obj;
        return flights.containsAll(otherFlights.flights) &&
                flights.size() == otherFlights.flights.size();
    }

    public FlightsResult createFlightsResults(Passengers passengers,
            PriceRate departureDateRate) {
        ArrayList<FlightResult> flightResults = this.flights.stream()
                .map(flight -> flight.calculateFlightResult(passengers, departureDateRate))
                .collect(Collectors.toCollection(ArrayList::new));
        return flightResults.isEmpty() != true ?new FlightsResult(flightResults) : new NoneFlightsResults();
    }
}
