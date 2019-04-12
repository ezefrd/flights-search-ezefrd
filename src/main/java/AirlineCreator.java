import java.lang.reflect.InvocationTargetException;

public interface AirlineCreator {
    public Airline starsWithThenReturnInstanceOrDefault(String code, Class validAirline, Airline defaultAirline) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException;
}
