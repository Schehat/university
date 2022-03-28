public class KochSnow implements HasArea {
  private double side;
  public KochSnow(double side) {
    this.side= side;
  }
  @Override public double area() {
    return 1.6 * (side*side*Math.sqrt(3)/4.0);
  }
}
