public class Personal {
    private PersonalType personalType;

    public void setAngesteller(PersonalType personalType) {
        this.personalType = personalType;
    }

    public double getGehaltszahlung() {
        return personalType.getGehaltszahlung(this);
    }

    public double getGrundgehalt() {
        return 100;
    }

    public double getVariablenAnteil() {
        return 20;
    }

    public double getBonus(){
        return 50;
    }
}
