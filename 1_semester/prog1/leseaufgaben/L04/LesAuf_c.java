public class LesAuf_c   {
    public static void main(String[] args)  {
        double b= 4;
        double c= 3.6;
        double alpha= 65; // in Grad
        
        double a = Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2) - 2*b*c*Math.cos(Math.toRadians(65)));
        System.out.println(a);
    }
}   