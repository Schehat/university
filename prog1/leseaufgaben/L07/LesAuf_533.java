public class LesAuf_533{
    public static void main(String[] args) {
        int x = 42;
        int y = 17;
        int z = 25;
        
        boolean a = y < x && y <= z;
        boolean b = x % 2 == y % 2 || x % 2 == z % 2;
        boolean c = x <= y + z && x >= y + z;
        boolean d = !(x < y && x < z);
        
        System.out.println(a + " " + b + " " + c + " " + d);
    }
}