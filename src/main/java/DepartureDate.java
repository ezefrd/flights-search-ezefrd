import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepartureDate {
    private LocalDate departureDate;

    public DepartureDate(LocalDate departureDate){
        this.departureDate = departureDate;
    }

    public long differenceWithToday(LocalDate today) {
        return ChronoUnit.DAYS.between(today, departureDate);
    }
}
