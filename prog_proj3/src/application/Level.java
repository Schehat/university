package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author Schehat
 * configuration of the first level in the game
 */
public class Level {
    private static Stage stage;
    private static BorderPane root = new BorderPane();
    private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);
    private static Player player;
    
    private static Button btnRedPill = new Button();
    private static Button btnBluePill = new Button();     
    /**
     * create level layout
     */
    public static void setLayout() {
        player = new Player("neo");
        player.getImageView().setX(200);
        player.setX(200);
        player.setY(300);
                
        btnRedPill.setText("Level 1");
        btnRedPill.setPrefWidth(100);
        btnRedPill.setMaxHeight(35);
      
        btnRedPill.setStyle("-fx-border-width: 2px; "
                  + "-fx-border-color: #000000; "
                  + "-fx-font-size: 20px; "
                  + "-fx-background-color: #C75A41; "
                  + "-fx-border-radius: 6px;");
          
        btnBluePill.setText("Level 2");
        btnBluePill.setPrefWidth(100);
        btnBluePill.setMaxHeight(35);
      
        btnBluePill.setStyle("-fx-border-width: 2px; "
              + "-fx-border-color: #000000; "
              + "-fx-font-size: 20px; "
              + "-fx-background-color: #415FC7; "
              + "-fx-border-radius: 6px;");     
        
        HBox hboxBottom = new HBox();
        hboxBottom.getChildren().addAll(btnRedPill, btnBluePill);
        hboxBottom.setSpacing(10.0);
        hboxBottom.setPadding(new Insets(30));
        hboxBottom.setAlignment(Pos.CENTER);
        
        Canvas canvas = new Canvas(Main.getSize()[0], Main.getSize()[1]);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        //free form animation defined by KeyFrames and their duration 
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl1(gc)));
        //number of cycles in animation INDEFINITE = repeat indefinitely
        tl.setCycleCount(Timeline.INDEFINITE);
        
        root.getChildren().addAll(StartScene.getBackground(), canvas, player.getImageView());
        root.setBottom(hboxBottom);
        
        tl.play();
    }
    
    /**
     * set up all events in the first level
     */
    public static void setEvents() {
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
            case LEFT: 
                Controller.moveLeft(player);
                break;
            case RIGHT: 
                Controller.moveRight(player);
                break;
            case UP: 
                Controller.moveUp(player);
                break;
            case DOWN: 
                Controller.moveDown(player);
                break;
            default:
                break;
            }
        });
    }
    
    /**
     * 
     * @return scene of Level
     */
    public static Scene getScene() {
        return Level.scene;
    }
    
    /**
     * to customize scene need current stage
     * @param stage
     */
    public static void setStage(Stage stage) {
        Level.stage = stage;
    }
    
    
    /**
     * run game loop to animate level environment & enemies of first level
     * @param gc
     */
    public static void runLvl1(GraphicsContext gc) {
        double rectX = 75.0, rectY = 150.0;
        
        gc.setFill(Color.web("0xF3F5F6", 1.0));;
        gc.fillRect(rectX, rectY, Main.getSize()[0] - 2*rectX, Main.getSize()[1] - 2*rectY);       
    }
}
