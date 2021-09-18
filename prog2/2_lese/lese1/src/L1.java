import com.bjp.DrawingPanel;
import java.awt.*;
public class L1 {

    public static void main(String[] args) {
        DrawingPanel panel= new DrawingPanel(200, 100);
        Graphics g= panel.getGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(10, 30, 60, 35);
        g.setColor(Color.RED);
        g.fillOval(80, 40, 50, 70);
        g.setColor(Color.BLUE);
        g.drawLine(0, 0, 199, 99);
    }

}
