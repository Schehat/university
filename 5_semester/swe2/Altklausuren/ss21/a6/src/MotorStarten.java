public class MotorStarten implements Zustand {
    @Override
    public Zustand motorStarten() {
        System.out.println("Motor wurde schon gestartet");
        return this;
    }

    @Override
    public Zustand ausschalten() {
        System.out.println("Motor wird ausgeschaltet");
        return new Ausschalten();
    }
}
