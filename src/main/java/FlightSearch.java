import java.util.Date;

public class FlightSearch {
    private Date today;

    public FlightSearch(Date today) {
        this.today = today;
    }

    public FlightsResult search(Passengers passengers, DepartureDate departureDate, Airport airportOrigin, Airport airportDestiny) {
        return new FlightsResult();
    }
}
