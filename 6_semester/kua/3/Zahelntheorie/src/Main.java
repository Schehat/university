public class Main {
    public static void main(String[] args) {
        Zahlentheorie zahlentheorie = new Zahlentheorie();
        System.out.println(zahlentheorie.primZerlegung(97 ));
        System.out.println(zahlentheorie.siebErastosthenes(100 ));
        System.out.println(zahlentheorie.ggT(6930, 1098));
        System.out.println(zahlentheorie.diophant(-12, 8, 4));
    }
}
