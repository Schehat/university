public class L323   {
    public static void main(String[] args)  {
        double x;
        x = Math.abs(-1.23);
        System.out.println("a. Math.abs(-1.23) = " + x);
        
        x = Math.pow(3, 2);
        System.out.println("b. Math.pow(3, 2) = " + x);
        
        x = Math.pow(10, -2);
        System.out.println("c. Math.pow(10, -2) = " + x);
        
        x = Math.sqrt(121.0) - Math.sqrt(256.0);
        System.out.println("d. Math.sqrt(121.0) - Math.sqrt(256.0) = " + x);
        
        x = Math.round(Math.PI) + Math.round(Math.E);
        System.out.println("e. Math.round(Math.PI) + Math.round(Math.E) = " + x);
        
        x = Math.ceil(6.022) + Math.floor(15.9994);
        System.out.println("f. Math.ceil(6.022) + Math.floor(15.9994) = " + x);
        
        x = Math.abs(Math.min(-3, -5));
        System.out.println("g. Math.abs(Math.min(-3, -5)) = " + x);
    }
}