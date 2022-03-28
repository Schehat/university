public class Circle extends Shape implements ConicSection {
    private double radius;
    /** Constructs a new circle with the given radius. */
    public Circle(double radius) {
        this.radius = radius;
    }
    /** Returns the area of this circle. */
    @Override public double area() {
        return Math.PI * radius * radius;
    }
    /** Returns the perimeter of this circle. */
    @Override public double perimeter() {
        return 2.0 * Math.PI * radius;
    }
    /** Returns "ellipse" as conic section type */
    @Override public String getConicType() {
        return "ellipse";
    }
}
