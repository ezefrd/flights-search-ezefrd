public class FlightResult {

    private AirlinePresenter airline;
    private PricePresenter totalCost;

    public FlightResult(AirlinePresenter airline, PricePresenter totalCost){
        this.airline = airline;
        this.totalCost = totalCost;
    }

    @Override public boolean equals(Object obj) {
        FlightResult otherFlightResult = (FlightResult) obj;
        return this.airline.equals(otherFlightResult.airline) && this.totalCost.equals(otherFlightResult.totalCost);
    }

    public String show(){
        StringBuilder flightResult = new StringBuilder();
        airline.appendCodeTo(flightResult);
        //flightResult.append(airline.showCode());
        flightResult.append(", ");
        totalCost.appendCostTo(flightResult);
        //flightResult.append(totalCost.showCost());
        flightResult.append("\n");
        return flightResult.toString();
    }
}
