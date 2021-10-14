package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 * 
 * @author Schehat
 * client program to execute the game
 */
public class Main extends Application {
    private static double WIDTH = 800.0;
    private static double HEIGHT = 600.0;
    private static String gameTitle = "Construct";
    private static String iconName = "neo.png";
    
    /**
     *  stage control & setup of StartScene
     */
	@Override
	public void start(Stage stage) {
		try {
		    stage = setStage(stage);
		    stage.setResizable(false);
		    
		    StartScene.setStage(stage);
		    StartScene.setLayout();
		    StartScene.setEvents();
					    
            stage.setScene(StartScene.getScene());
            stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * customizing the stage
	 * @param stage
	 * @return stage
	 */
	public static Stage setStage(Stage stage) {
        stage.setTitle(gameTitle); 
        Image icon = new Image(iconName);
        stage.getIcons().add(icon);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        return stage;
	}
	
	/**
	 * 
	 * @return height & width of stage
	 */
	public static double[] getSize() {
	    return new double[] {WIDTH, HEIGHT};
	}
	
	/**
	 * runs in the background the start method  
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
