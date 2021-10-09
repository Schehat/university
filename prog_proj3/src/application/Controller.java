package application;

import javafx.scene.image.ImageView;

/**
 * 
 * @author Schehat
 * controls of the game the user can use
 */
public class Controller {
    public static void moveLeft(ImageView ivPlayer) {
        ivPlayer.setX(ivPlayer.getX() - 7);
    }
    
    public static void moveRight(ImageView ivPlayer) {
        ivPlayer.setX(ivPlayer.getX() + 7);
    }
    
    public static void moveUp(ImageView ivPlayer) {
        ivPlayer.setY(ivPlayer.getY() - 7);
    }
    
    public static void moveDown(ImageView ivPlayer) {
        ivPlayer.setY(ivPlayer.getY() + 7);
    }
}
