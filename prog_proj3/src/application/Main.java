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
    private static int WIDTH = 800;
    private static int HEIGHT = 600;
	@Override
	public void start(Stage stage) {
		try {
		    stage = setStage(stage);
		    StartScene.setLayout(stage);
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
        stage.setTitle("Contruct"); 
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        return stage;
	}
	
	public static int[] getSize() {
	    return new int[] {WIDTH, HEIGHT};
	}
	
	/**
	 * runs in the background the start method  
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
