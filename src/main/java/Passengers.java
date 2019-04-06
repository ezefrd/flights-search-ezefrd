import java.util.ArrayList;

public class Passengers {
    private ArrayList<Passanger> passangers;

    public Passengers(){
        passangers = new ArrayList<>();
    }

    public Passengers addPassanger(Passanger passanger) {
        this.passangers = this.passangers != null ? this.passangers : new ArrayList<>();
        this.passangers.add(passanger);
        return this;
    }
}
