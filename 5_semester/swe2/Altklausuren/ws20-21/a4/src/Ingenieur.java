public class Ingenieur implements PersonalType {
    @Override
    public double getGehaltszahlung(Personal personal) {
        return personal.getGrundgehalt() + personal.getBonus();
    }
}
