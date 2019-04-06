import java.util.ArrayList;

public class Airports {
    protected ArrayList<Airport> airports;

    public Airports() {
        this.airports = new ArrayList<>();
    }

    public Airports add(Airport airport){
        this.airports = this.airports != null ? this.airports : new ArrayList<>();
        this.airports.add(airport);
        return this;
    }

    public Airport findByIATA(String iata) {
        return this.airports.parallelStream()
                .filter(airport -> airport.matchIata(iata))
                .findAny()
                .orElse(new NoneAirport());
    }
}
