public class Airport {
    private String IATA;
    private String city;

    public Airport(String IATA, String city){
        this.IATA = IATA;
        this.city = city;
    }

    /**
     * You should only use this method from Airports. Otherwise you'll be violating
     * Tell don't ask principle.
     */
    public boolean matchIata(String iata) {
        return this.IATA.equals(iata);
    }

    @Override public boolean equals(Object obj) {
        Airport otherAirport = (Airport) obj;
        return otherAirport.IATA.equals(IATA) &&
                otherAirport.city.equals(city);
    }
}
