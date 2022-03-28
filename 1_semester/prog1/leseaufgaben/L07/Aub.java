public class Aub {
    public static void main(String[] args) {
        double x = log(2.71, 2.71);
        System.out.println(x); 
    }
    /** Vorbe.: arg u. base > 0 u. != 1
        Nachbe.: liefer ln(arg) den Exponeten heraus
    */
    public static double log(double arg, double base) {
        if (arg <= 0 || base <= 0) {
            throw new IllegalArgumentException("Werte > 0 angeben!");
        }
        if (arg == 1 || base == 1) { 
            throw new IllegalArgumentException("Werte != 1 angeben!");
        }
        return Math.log(arg) / Math.log(base);
    }
}