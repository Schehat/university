import org.junit.Before;
import org.junit.Test;

class Linie {
    private double startX;
    private double startY;

    private double endX;
    private double endY;

    public Linie(double startX, double startY, double endX, double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public double distanz() {
        return Math.sqrt(Math.pow(endX - startX, 2.0)
                + Math.pow(endY - startY, 2.0));
    }

    public double flaeche() {
        return (Math.abs(endX - startX) * Math.abs(endY - startY)) / 2;
    }
}

class LinieTest {
    Linie linie;

    @Before
    protected void setUp() {
        linie = new Linie(1.0, 1.0, 2.0, 2.0);
    }

    @Test
    void distance() {
        double expected = Math.sqrt(2);
        // assertEquals(expected, linie.distanz());
    }
}
