public class NoneAirport extends Airport {
    public NoneAirport() {
        super("", "");
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof NoneAirport;
    }
}
