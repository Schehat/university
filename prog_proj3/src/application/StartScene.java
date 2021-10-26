package application;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * 
 * @author Schehat
 * configuration of the start screen in the game
 */
public class StartScene {
    private static Stage stage;
    private static BorderPane root = new BorderPane();
    private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);
    
    private static Image iBg = new Image("background.gif");
    private static ImageView iVBg = new ImageView(iBg);
    private static Image iRedPill = new Image("red_pill.png");
    private static ImageView iVRedPill = new ImageView(iRedPill);
    private static Image iBluePill = new Image("blue_pill.png");
    private static ImageView iVBluePill = new ImageView(iBluePill);
    private static Image iMorpheus = new Image("morpheus.png");
    private static ImageView iVMorpheus = new ImageView(iMorpheus);
    
    private static Media mButtonClicked = new Media(new File("C:\\Users\\Schehat\\university\\prog_proj3\\src\\buttonClicked.mp3").toURI().toString());
    private static MediaPlayer mPButtonClicked = new MediaPlayer(mButtonClicked);
    
    private static boolean levelLoaded = false;
    
    // after mouse hovered over pills 
    private static double pillGrowth = 20;
    
    /**
     * create start scene layout
     * @param stage
     */
    public static void setLayout() {      
        // needed when switching between scenes & calling the setLayout method
        root.getChildren().clear();
        
        iVBg.setX(0.0);
        iVBg.setY(0.0);
        root.getChildren().addAll(iVBg);

        // when changing sizes after events ratio of width & height will be the same
        iVRedPill.setPreserveRatio(true);
        iVBluePill.setPreserveRatio(true);
        
        HBox hboxCenter = new HBox();
        Label lblStart = new Label("CHOOSE WISELY");
        lblStart.setFont(new Font("Arial", 32));
        lblStart.setTextFill(Color.WHITE);
        hboxCenter.getChildren().addAll(iVRedPill, lblStart, iVBluePill);
        hboxCenter.setSpacing(10);
        hboxCenter.setAlignment(Pos.CENTER);
        
        HBox hboxTop = new HBox(); 
        hboxTop.getChildren().addAll(iVMorpheus);
        hboxTop.setPadding(new Insets(20));
        hboxTop.setAlignment(Pos.CENTER);
        
        VBox vboxCenter = new VBox();
        hboxTop.setPadding(new Insets(20));
        vboxCenter.getChildren().addAll(hboxTop, hboxCenter);
        root.setCenter(vboxCenter);
    }
    
    /**
     * set up all events in the start scene
     */
    public static void setEvents() {
        StartScene.setPillsEvents(iVRedPill, iRedPill);
        StartScene.setPillsEvents(iVBluePill, iBluePill);
        
        iVRedPill.setOnMouseClicked(e -> {
            mPButtonClicked.play();
            mPButtonClicked.seek(Duration.seconds(0.0));
            
            // this step only one time necessary
            if (!levelLoaded) {
                Level.setStage(stage);
                Level.setLayout();
                Level.setEvents();
                levelLoaded = true;
            }
            
            // this step will reset the current game loop
            if (levelLoaded) {                
                Level.clearRoot();
                GameLoopManager.gameLoopManager();
            }
            stage.setScene(Level.getScene());
        });
        
        iVBluePill.setOnMouseClicked(e -> stage.close());
    }
    
    /**
     * set events for pill images
     * @param iV
     * @param i
     */
    public static void setPillsEvents(ImageView iV, Image i) {
        iV.setOnMouseEntered(e -> {
            scene.setCursor(Cursor.HAND);
            iV.setFitHeight( i.getHeight() + pillGrowth);
        });
        
        iV.setOnMouseExited(e -> {
            scene.setCursor(Cursor.DEFAULT);
            iV.setFitHeight(i.getHeight() - pillGrowth);
        });
    }
    
    /**
     * to customize scene need current stage
     * @param stage
     */
    public static void setStage(Stage stage) {
        StartScene.stage = stage; 
    }
    
    /**
     * 
     * @return scene of StartScene
     */
    public static Scene getScene() {
        return StartScene.scene;
    }
    
    /**
     * 
     * @return background image iVBg
     */
    public static ImageView getBackground() {
        return iVBg;
    }
}
