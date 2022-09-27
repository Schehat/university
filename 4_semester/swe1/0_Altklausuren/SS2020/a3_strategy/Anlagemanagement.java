public class Anlagemanagement {
    Strategy strategy;

    public Anlagemanagement() {

    }

    public void setStrategie(Strategy strategy) {
        this.strategy = strategy;
    }

    public int berechneMWST(int warenwert) {
        return strategy.berechneMWST(warenwert);
    }
}