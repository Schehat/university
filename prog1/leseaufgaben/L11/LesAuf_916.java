public class LesAuf_916 {
    public static void main(String[] args) {
        System.out.println(ggT(5, 21));
    }
    
    public static int ggT(int a, int b) {
        if (b==0) {
            return a;
        }
        return ggT(b, a%b);
    }
}
