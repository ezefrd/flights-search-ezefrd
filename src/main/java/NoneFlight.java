public class NoneFlight extends Flight {
    public NoneFlight() {
        super(new NoneAirport(), new NoneAirport(), new NoneAirline(), new NonePrice());
    }
}
