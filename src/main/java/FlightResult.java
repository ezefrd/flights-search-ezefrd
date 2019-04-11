public class FlightResult {

    private Airline airline;
    private Price totalCost;

    public FlightResult(Airline airline, Price totalCost){
        this.airline = airline;
        this.totalCost = totalCost;
    }

    @Override public boolean equals(Object obj) {
        FlightResult otherFlightResult = (FlightResult) obj;
        return this.airline.equals(otherFlightResult.airline) && this.totalCost.equals(otherFlightResult.totalCost);
    }

    public String show(){
        StringBuilder flightResult = new StringBuilder();
        flightResult.append(airline.showCode());
        flightResult.append(", ");
        flightResult.append(totalCost.showCost());
        flightResult.append("\n");
        return flightResult.toString();
    }
}
