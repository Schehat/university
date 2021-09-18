public class LesAufb {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            if (i*i < 6000 || i*i > 8000) {
                System.out.println(i + " * " + i + " = " + i*i);
            }
        }
    }
}