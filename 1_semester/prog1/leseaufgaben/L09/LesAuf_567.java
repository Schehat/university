public class LesAuf_567 {
    public static void main(String[] args) {
        int zahl = 57;
        System.out.println(getBit(zahl, 3));
        
        for (int pos = 7; pos >= 0; pos--) {
            boolean bit = getBit(zahl, pos);
            if (bit) {
                System.out.print(1); 
            } else {
                System.out.print(0);
            }
        }
    }
    
    public static boolean getBit(int zahl, int pos) {
        int mask = 1 << pos;
        return (zahl & mask) != 0;
    }
}