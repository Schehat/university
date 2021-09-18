public class L315   {
    public static void main(String[] args)  {
        drawLine(12);
        drawLine(6);
        drawLine(34);
    }
    
    public static void drawLine(int count)   {
        for (int i = 0; i <= count; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}