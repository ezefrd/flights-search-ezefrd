import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FlightsResult {
    private ArrayList<FlightResult> flightResults;

    public FlightsResult(){
        this.flightResults = new ArrayList<FlightResult>();
    }

    public FlightsResult(ArrayList<FlightResult> flightResults){
        this.flightResults = flightResults;
    }

    public String show() {
        StringBuilder flights = new StringBuilder();
        flights.append("flights:").append("\n");

        for(FlightResult flightResult : flightResults){
            flights.append(flightResult.show());
        }

        return flights.toString();
    }
}
