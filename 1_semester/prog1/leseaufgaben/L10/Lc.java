public class Lc {
    public static void main(String[] args) {
        String[] w= new String[4];
        for (int i=1; i<4; i++) {
            w[i]= String.valueOf(w[i-1].length());
        }
    }
}