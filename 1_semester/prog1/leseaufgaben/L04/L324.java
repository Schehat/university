public class L324   {
    public static void main(String[] args)  {
        int alter = -40;
        int a = Math.max(0, alter);
        System.out.println("a: " + a);
        
        alter = 80;
        int b = Math.min(alter, 40);
        System.out.println("b: " + b);
    }
}