public class LesAuf_b {
    public static void main(String[] args) {
        print(3);
        print(2);
        print(1);
    }
    public static void p(int n) {
        for (int i = 0; i <= n; i++)    {
            System.out.print("+");
        }
        System.out.println();
    }
    
    public static void m(int n) {
        for (int i = 0; i <= n; i++)    {
            System.out.print("-");
        }
        System.out.println();
    }
    
    public static void print(int n) {
        p(n);
        m(n);
        p(n);
    }
}