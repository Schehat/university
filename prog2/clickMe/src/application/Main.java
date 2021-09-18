package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class Main extends Application {
    private int cnt;
	@Override
	public void start(Stage primaryStage) {
	    
	    Label lbl = new Label(cnt + " Clicks");
	    Button btn = new Button("Click");
	    HBox root = new HBox(); // oder new HBox(lbl, btn)
	    root.getChildren().addAll(lbl, btn);
	    
	    btn.setOnAction((event) -> {
	        cnt++;
	        lbl.setText(cnt + " Clicks");
	    });
	    
		Scene scene = new Scene(root, 300, -1);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
