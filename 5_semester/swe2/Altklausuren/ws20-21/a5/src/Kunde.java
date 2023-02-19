import java.util.ArrayList;

public class Kunde {
    private ArrayList<Auto> auto = new ArrayList<Auto>();

    public ArrayList<Auto> getAuto() {
        return auto;
    }

    public void addAuto() {
        auto.add(new Auto());
    }
}
