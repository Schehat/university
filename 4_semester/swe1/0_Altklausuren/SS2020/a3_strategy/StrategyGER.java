public class StrategyGER extends Strategy {
    @Override
    public int berechneMWST(int warenwert) {
        return (int) (warenwert * 0.07);
    }
}
