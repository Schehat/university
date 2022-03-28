package application;

import java.awt.Point;

public class Factory {
    private static int y;

    public static void setY(int ys) {
        y = ys;
    }
    
    public static Point create(int x) {
        return new Point(x, y);
    }
}
