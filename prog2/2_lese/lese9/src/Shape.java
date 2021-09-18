public abstract class Shape implements HasArea {
  public abstract double perimeter();
  public double compactness() {
    double peri= perimeter();
    return (4.0*Math.PI*area())/(peri*peri);
	}
}


