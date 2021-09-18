import com.bjp.DrawingPanel;
import java.awt.*;
public class L221 {

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(200, 100);
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.BLACK);
        g.drawRect(5, 5, 30, 90);
        g.setColor(Color.RED);
        g.fillOval(10, 10, 20, 20);
        g.setColor(Color.YELLOW);
        g.fillOval(10, 40, 20, 20);
        g.setColor(Color.GREEN);
        g.fillOval(10, 70, 20, 20);
        
        g.setColor(Color.BLACK);
        g.drawPolygon(new int[] {60,80,60,40}, new int[]{20,40,60,40}, 4);
        g.setColor(Color.YELLOW);
        g.fillPolygon(new int[] {60,70,60,50}, new int[]{30,40,50,40}, 4);
        g.setColor(Color.BLACK);
        g.drawLine(60, 60, 60, 95);
    }

}
