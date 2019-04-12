import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AirlineCode implements AirlineCreator {
    private String airlineCode;
    public AirlineCode(String airlineCode){
        this.airlineCode = airlineCode;
    }

    @Override
    public Airline starsWithThenReturnInstanceOrDefault(String code, Class<Airline> validAirline, Airline defaultAirline)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        if(this.airlineCode.startsWith(code)){
            Constructor constructor = validAirline.getDeclaredConstructor(AirlineCode.class);
            return (Airline) constructor.newInstance(this);
        }

        return defaultAirline;
    }

    @Override public boolean equals(Object obj) {
        AirlineCode otherAirlineCode = (AirlineCode) obj;
        return otherAirlineCode.airlineCode.equals(airlineCode);
    }

    public String show() {
        return this.airlineCode;
    }
}
