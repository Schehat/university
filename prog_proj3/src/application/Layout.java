package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Layout {
    private static Image iBackground = new Image("background.gif");
    private static ImageView ivBackground = new ImageView(iBackground);   
    private static Image iPlayer = new Image("player_right.png");
    private static ImageView ivPlayer = new ImageView(iPlayer);
    
    public static ImageView getBackground() {
        return ivBackground;
    }
}
