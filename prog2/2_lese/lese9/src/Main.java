import java.util.*;

public class Main {
	public static void main(String[] args) {
	    int a = 5;
	    int b = 5;
	    System.out.println(Integer.valueOf(a).compareTo(b));
	    
		ArrayList<HasArea> items= new ArrayList <HasArea>();
		items.add(new Rectangle(1.7, 0.8));
		items.add(new Circle(2.2));
		items.add(new Ellipsis(3.0, 4.0));
		items.add(new Triangle(1.9, 2.3, 2.4));
		items.add(new KochSnow(5));
		double totalArea= 0.0;
		for (HasArea item : items) {
		    totalArea += item.area();
		}
		System.out.println("Total area: " + totalArea);


		Circle circ = new Circle(12.0);
		Rectangle rect = new Rectangle(4, 7);
		Triangle tri = new Triangle(5, 12, 13);
		Ellipsis ell = new Ellipsis(12.0, 12.0);
		printInfo(circ);
		printInfo(tri);
		printInfo(rect);
		printInfo(ell);
	}
	
	public static void printInfo(Shape s) {
    System.out.println("The shape: " + s);
    System.out.println("area : " + s.area());
    System.out.println("perim: " + s.perimeter());
	}

}
