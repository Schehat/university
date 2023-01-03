public class Manager implements PersonalType {
    @Override
    public double getGehaltszahlung(Personal personal) {
        return personal.getGrundgehalt() + personal.getVariablenAnteil();
    }
}
