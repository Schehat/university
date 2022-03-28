public class L331   {
    public static void main(String[] args)  {
        String buch = "Programmieren in Java";
        
        System.out.print("a) " + buch.substring(14, 16));
        System.out.println();
        
        buch = buch.toUpperCase();
        System.out.print("b) " + buch);
    }
}