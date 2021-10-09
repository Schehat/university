package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author Schehat
 * configuration of the first level in the game
 */
public class Level1 {
    private static Stage stage;
    private static BorderPane root = new BorderPane();
    private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);
    private static ImageView ivPlayer;
    
    public static void setLayout() {
        Image iBackground = new Image("background.jpg");
        ImageView ivBackground = new ImageView(iBackground);
        ivBackground.setX(0.0);
        ivBackground.setY(0.0);
        
        Image iPlayer = new Image("player_right.png");
        ivPlayer = new ImageView(iPlayer);
        System.out.println(iPlayer.impl_getUrl());
        ivPlayer.setX(200);
        ivPlayer.setY(300);
        
        Canvas canvas = new Canvas(Main.getSize()[0] - 100, Main.getSize()[1] - 100);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        //free form animation defined by KeyFrames and their duration 
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
        //number of cycles in animation INDEFINITE = repeat indefinitely
        tl.setCycleCount(Timeline.INDEFINITE);
        
        root.getChildren().addAll(ivBackground, canvas, ivPlayer);
        
        tl.play();
    }
    
    /**
     * set up all events in the first level
     */
    public static void setEvents() {
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
            case LEFT: 
                Controller.moveLeft(ivPlayer);
                break;
            case RIGHT: 
                Controller.moveRight(ivPlayer);
                break;
            case UP: 
                Controller.moveUp(ivPlayer);
                break;
            case DOWN: 
                Controller.moveDown(ivPlayer);
                break;
            default:
                break;
            }
        });
    }
    
    /**
     * 
     * @return scene of Level1
     */
    public static Scene getScene() {
        return Level1.scene;
    }
    
    /**
     * to access access in this class
     * @param stage
     */
    public static void setStage(Stage stage) {
        Level1.stage = stage;
    }
    
    
    /**
     * run game loop to animate enemies
     * @param gc
     */
    public static void run(GraphicsContext gc) {
        gc.setFill(Color.web("0xF3F5F6", 1.0));;
        gc.fillRect(100, 100, Main.getSize()[0] - 100, Main.getSize()[0] - 100);
    }
}
