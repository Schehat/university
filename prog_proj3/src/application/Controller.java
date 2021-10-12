package application;

import javafx.scene.image.ImageView;

/**
 * 
 * @author Schehat
 * controls of the game the user can use
 */
public class Controller {
    private static int speed = 6;
    public static void moveLeft(ImageView ivPlayer) {
        ivPlayer.setX(ivPlayer.getX() - speed);
    }
    
    public static void moveRight(ImageView ivPlayer) {
        ivPlayer.setX(ivPlayer.getX() + speed);
    }
    
    public static void moveUp(ImageView ivPlayer) {
        ivPlayer.setY(ivPlayer.getY() - speed);
    }
    
    public static void moveDown(ImageView ivPlayer) {
        ivPlayer.setY(ivPlayer.getY() + speed);
    }
}
