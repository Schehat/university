public class Main {
    public static void main(String[] args) {
        Auto a = new Auto();
        a.motorStarten();
        a.ausschalten();

        System.out.println("Fehlerzustände");
        a.ausschalten();
        a.motorStarten();
        a.motorStarten();
    }
}