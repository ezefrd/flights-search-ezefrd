import java.util.Currency;
import java.util.Locale;

public class Flight implements PotentialFlight{
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

    /**
     * Esto se puede hacer diferente.. si en vez de pasar el string del codigo IATA,
     * le paso los airports.
     * @param originIATA
     * @param destinyIATA
     * @return
     */
    public boolean matchOriginAndDestinyIATA(String originIATA, String destinyIATA) {
        return airportOrigin.matchIata(originIATA) && airportDestiny.matchIata(destinyIATA);
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
            PriceRate departureDayRate) {

        Price accumulatedPrice = new Price(0.0, Currency.getInstance(new Locale("es", "ES")));



        /*for (Passanger passanger : passengers){
            Price passangerRate = passanger.calculateFlightPrice(this, departureDayRate)
        }*/

        return null;
    }

    public Price calculatePriceWithRates(PriceRate passangerRate, PriceRate departureDateRate) {
        Price price = departureDateRate.calculatePrice(this.basePrice);
        price = passangerRate.calculatePrice(price);

        return price;
    }

    public Price calculatePriceForInfant(PriceRate passangerRate, PriceRate departureDateRate) {
        return this.airline.calculatePriceForInfant(passangerRate, departureDateRate);
    }
}
