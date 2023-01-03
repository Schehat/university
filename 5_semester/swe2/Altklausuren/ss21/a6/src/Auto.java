public class Auto {
    Zustand zustand = new Ausschalten();
    public void motorStarten() {
        setZustand(zustand.motorStarten());
    }
    public void ausschalten() {
        setZustand(zustand.ausschalten());
    }
    public void setZustand(Zustand zustand) {
        this.zustand = zustand;
    }
}
