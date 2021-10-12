package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * 
 * @author Schehat
 * configuration of the start screen in the game
 */
public class StartScene {
    private static Stage stage;
    private static BorderPane root = new BorderPane();
    private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);
    private static Button btnRedPill = new Button();
    private static Button btnBluePill = new Button();  
    
    /**
     * customize scene layout
     * @param stage
     */
    public static void setLayout() {      
        Image iBg = new Image("background.gif");
        ImageView iVBg = new ImageView(iBg);
        iVBg.setX(0.0);
        iVBg.setY(0.0);
        root.getChildren().addAll(iVBg);
        
        btnRedPill.setText("TAKE RED PILL");
        btnRedPill.setPrefWidth(300);
        btnRedPill.setMaxHeight(35);
        
        btnRedPill.setStyle("-fx-border-width: 2px; "
                + "-fx-border-color: #000000; "
                + "-fx-font-size: 32px; "
                + "-fx-background-color: #C75A41; "
                + "-fx-border-radius: 6px;");
        
        btnBluePill.setText("TAKE BLUE PILL");
        btnBluePill.setPrefWidth(300);
        btnBluePill.setMaxHeight(35);
        
        btnBluePill.setStyle("-fx-border-width: 2px; "
                + "-fx-border-color: #000000; "
                + "-fx-font-size: 32px; "
                + "-fx-background-color: #415FC7; "
                + "-fx-border-radius: 6px;");

        HBox hboxBtns = new HBox(); 
        hboxBtns.getChildren().addAll(btnRedPill, btnBluePill);
        root.setCenter(hboxBtns);
        hboxBtns.setSpacing(20);
        hboxBtns.setAlignment(Pos.CENTER);
    }
    
    /**
     * set up all events in the start scene
     */
    public static void setEvents() {
        btnRedPill.setOnMouseEntered(e -> btnRedPill.setText("-TAKE RED PILL-"));
        btnRedPill.setOnMouseExited(e -> btnRedPill.setText("TAKE RED PILL"));
        btnRedPill.setOnAction(e -> {
            Level1.setStage(stage);
            Level1.setLayout();
            Level1.setEvents();
            stage.setScene(Level1.getScene());
        });
        
        btnBluePill.setOnMouseEntered(e -> btnBluePill.setText("-TAKE BLUE PILL-"));
        btnBluePill.setOnMouseExited(e -> btnBluePill.setText("TAKE BLUE PILL"));
        btnBluePill.setOnAction(e -> stage.close());
    }
    
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
    
}
