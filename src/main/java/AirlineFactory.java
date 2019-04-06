import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

public class AirlineFactory {

    LinkedHashMap<String, Class> airlines;

    public AirlineFactory(){
        airlines = new LinkedHashMap<>();
        airlines.put("IB", IberiaAirline.class);
        airlines.put("BA", BritishAirwaysAirline.class);
        airlines.put("FR", LufthanseAirline.class);
        airlines.put("LH", RyanairAirline.class);
        airlines.put("VY", VuelingAirline.class);
        airlines.put("TK", TurkishAirline.class);
        airlines.put("U2", EasyjetAirline.class);
    }

    public AirlineFactory(LinkedHashMap<String, Class> airlines){
        this.airlines = airlines;
    }


    public Airline createFromCode(AirlineCode airlineCode) {
        //Airline airline = airlineCode.checkCodeAndReturnAirlineOrDefault("IB", new IberiaAirline(airlineCode), new DefaultAirline());
        //return airline;
        Airline airline = new DefaultAirline();
        for(String key : airlines.keySet()){
            try {
                airline = airlineCode.starsWithThenReturnInstanceOrDefault(key, airlines.get(key), airline);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        return airline;
    }
}
