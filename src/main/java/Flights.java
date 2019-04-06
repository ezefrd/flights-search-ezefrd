import java.util.ArrayList;

public class Flights {
    private ArrayList<Flight> flights;

    public Flights(){
        this.flights = new ArrayList<Flight>();
    }

    public Flights add(Flight flight){
        this.flights = this.flights != null ? this.flights : new ArrayList<>();
        this.flights.add(flight);
        return this;
    }
}
