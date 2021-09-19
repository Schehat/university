package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();

        Button btn1= new Button("Hü");
        Button btn2= new Button("Hott");
        
        root.getChildren().addAll(btn1, btn2);
        
        btn2.setDisable(true);

        btn1.setOnAction((event) -> {
            btn2.setDisable(false);
            btn1.setDisable(true);
            return;
        });
        
        btn2.setOnAction((event) -> {
            btn1.setDisable(false);
            btn2.setDisable(true);
            return;
        });
        
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
