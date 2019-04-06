import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AirlineCode {
    private String airlineCode;
    public AirlineCode(String airlineCode){
        this.airlineCode = airlineCode;
    }

    public Airline checkCodeAndReturnAirlineOrDefault(String code, Airline validAirline, Airline defaultAirline) {
        if(this.airlineCode.startsWith(code)){
            return validAirline;
        }

        return defaultAirline;
    }

    public Airline starsWithThenReturnInstanceOrDefault(String code, Class<Airline> validAirline, Airline defaultAirline)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        if(this.airlineCode.startsWith(code)){
            Constructor constructor = validAirline.getDeclaredConstructor(AirlineCode.class);
            return (Airline) constructor.newInstance(this);
        }

        return defaultAirline;
    }
}
