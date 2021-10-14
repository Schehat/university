package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
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
    private static Player player = new Player("neo");;
    private static Image iBg = new Image("background.gif");
    private static ImageView iVBg = new ImageView(iBg);
    private static Image iMorpheus = new Image("morpheus_small.png");
    private static ImageView iVMorpheus = new ImageView(iMorpheus);
    private static Image iInstructions = new Image("instructions.png");
    private static ImageView iVInstructions = new ImageView(iInstructions);
    
    private static Button btnBack= new Button(); 
    private static Button btnLevel1 = new Button();
    private static Button btnLevel2 = new Button();     
    private static Button btnLevel3 = new Button();  
    private static Button btnLevel4 = new Button();  
    private static Button btnLevel5 = new Button();  
    private static Button btnLevel6 = new Button();  
    
    private static int btnPrefWidth = 100;
    private static int btnPrefHeight = 35;
    private static String btnBackYellow = "#E9DD25";
    private static String btnHexRed = "#C75A41";
    private static String btnHexBlue = "#415FC7";
    private static String btnBorderWidth = "2px";
    private static String btnBorderColor = "#000000"; 
    private static String btnFontSize = "20px";
    private static String btnBorderRadius = "6px";
    
    private static int currentLevel = 1;
    private static Canvas canvas = new Canvas(Main.getSize()[0], Main.getSize()[1]);
    private static GraphicsContext gc = canvas.getGraphicsContext2D();
    
    /**
     * create level layout
     */
    public static void setLayout() {        
        iVBg.setX(0.0);
        iVBg.setY(0.0);
        
        Level.setBtn(btnBack, "Zurück", btnBackYellow);
        Level.setBtn(btnLevel1, "Level 1", btnHexRed);
        Level.setBtn(btnLevel2, "Level 2", btnHexBlue);
        Level.setBtn(btnLevel3, "Level 3", btnHexBlue);
        Level.setBtn(btnLevel4, "Level 4", btnHexBlue);
        Level.setBtn(btnLevel5, "Level 5", btnHexBlue);
        Level.setBtn(btnLevel6, "Level 6", btnHexBlue);
        
        HBox hboxTop = new HBox();
        hboxTop.getChildren().addAll(iVMorpheus, iVInstructions);
        hboxTop.setSpacing(10.0);
        hboxTop.setPadding(new Insets(30));
        hboxTop.setAlignment(Pos.CENTER);
        
        
        HBox hboxBottom = new HBox();
        hboxBottom.getChildren().addAll(btnBack, btnLevel1, btnLevel2, btnLevel3, 
                                            btnLevel4, btnLevel5, btnLevel6);
        hboxBottom.setSpacing(10.0);
        hboxBottom.setPadding(new Insets(30));
        hboxBottom.setAlignment(Pos.CENTER);
              
        root.getChildren().addAll(iVBg, canvas, player.getImageView());
        root.setTop(hboxTop);
        root.setBottom(hboxBottom);
        
        Level.gameLoopManager();
    }
    
    /**
     * set properties of buttons & css styling
     * @param btn
     * @param text
     * @param bgColor
     */
    public static void setBtn(Button btn, String text, String bgColor) {
        btn.setText(text);
        btn.setPrefWidth(btnPrefWidth);
        btn.setMaxHeight(btnPrefHeight);
      
        btn.setStyle("-fx-border-width: " + btnBorderWidth + "; "
                  + "-fx-border-color: " + btnBorderColor + "; "
                  + "-fx-font-size: " + btnFontSize + "; "
                  + "-fx-background-color: " + bgColor + "; "
                  + "-fx-border-radius: " + btnBorderRadius + ";");
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
        
        btnBack.setOnMouseEntered(e -> scene.setCursor(Cursor.HAND));
        btnBack.setOnMouseExited(e -> scene.setCursor(Cursor.DEFAULT));
        btnBack.setOnAction(e -> {
            StartScene.setLayout();
            stage.setScene(StartScene.getScene());
        });
        
        Level.setButtonEvents(btnLevel1, 1);
        Level.setButtonEvents(btnLevel2, 2);
        Level.setButtonEvents(btnLevel3, 3);
        Level.setButtonEvents(btnLevel4, 4);
        Level.setButtonEvents(btnLevel5, 5);
        Level.setButtonEvents(btnLevel6, 6);
    }
    
    /**
     * set events for buttons
     * @param btn
     * @param level
     */
    public static void setButtonEvents(Button btn, int level) {
        btn.setOnAction(e -> {
            currentLevel = level;
            Level.gameLoopManager();
        });
        
        btn.setOnMouseEntered(e -> {
            // this if statement at the end not necessary due to 
            // only buttons which are not disabled allow events 
            if (!btn.isDisabled()) {
                scene.setCursor(Cursor.HAND);
            }
        });
        
        btn.setOnMouseExited(e -> {
            if (!btn.isDisabled()) {
                scene.setCursor(Cursor.DEFAULT);
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
        
        gc.setFill(Color.web("0xF3F5F6", 1.0));
        gc.fillRect(rectX, rectY, Main.getSize()[0] - 2*rectX, Main.getSize()[1] - 2*rectY);       
    }
    
    /**
     * handles selection of game loop per level & necessary editing before running the level
     */
    public static void gameLoopManager() {
        if (currentLevel == 1) {
            btnLevel1.setDisable(false);
            btnLevel2.setDisable(true);
            btnLevel3.setDisable(true);
            btnLevel4.setDisable(true);
            btnLevel5.setDisable(true);
            btnLevel6.setDisable(true);
            
            player.getImageView().setX(200);
            player.setX(200);
            player.setY(300);
            
            //free form animation defined by KeyFrames and their duration 
            Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl1(gc)));
            //number of cycles in animation INDEFINITE = repeat indefinitely
            tl.setCycleCount(Timeline.INDEFINITE);
            tl.play();
        }
    }
}
