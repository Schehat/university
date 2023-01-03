public class Ausschalten implements Zustand {
    @Override
    public Zustand motorStarten() {
        System.out.println("Motor wird gestartet");
        return new MotorStarten();
    }

    @Override
    public Zustand ausschalten() {
        System.out.println("Motor ist schon ausgeschaltet");
        return this;
    }
}
