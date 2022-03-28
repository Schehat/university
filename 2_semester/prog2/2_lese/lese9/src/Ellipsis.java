public class Ellipsis extends Shape implements ConicSection {
    private double a, b;
    /** Constructs a new ellipsis with the given semi axes. */
    public Ellipsis(double a, double b) {
        this.a= a;
        this.b= b;
    }
    /** Returns the area of this ellipsis. */
    @Override public double area() {
        return Math.PI * a * b;
    }
    /* Returns the perimeter of this ellipsis. */
    @Override public double perimeter() {
        return Math.PI * (a+b);
    }
    /** Returns "ellipse" as conic section type */
    @Override public String getConicType() {
        return "ellipse";
    }
}