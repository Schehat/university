package application;
	
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class Main extends Application {
    private  TextField tfNumber;    
    private Button btnCalc;
    private EventHandler<ActionEvent> handler;
    private Label lblStatus;
    
	@Override
	public void start(Stage primaryStage) {
	    
	    Label lblNumber = new Label("Number");
	    tfNumber = new TextField();
	    btnCalc = new Button("Cal_culate");
	    btnCalc.setMnemonicParsing(true);

	    HBox inp = new HBox();
	    inp.getChildren().addAll(lblNumber, tfNumber, btnCalc);
	    inp.setSpacing(5);
	    inp.setAlignment(Pos.BASELINE_LEFT);
	    inp.setPadding(new Insets(5, 10, 5, 10));
	    HBox.setHgrow(lblNumber, Priority.NEVER);
	    HBox.setHgrow(btnCalc, Priority.NEVER);
	    HBox.setHgrow(tfNumber, Priority.ALWAYS);
	    
	    Label lblResult = new Label("Result:");
	    
	    
	    ScrollPane spResult = new ScrollPane(lblResult);
	    spResult.setPrefSize(230, 130);
	    spResult.setStyle("-fx-border-color: blue");
	    
//	    handler = new EventHandler<ActionEvent> () {
//	        @Override
//	        public void handle(ActionEvent event) {
//	            StringBuilder sb = new StringBuilder("Result:");
//	            long n = Long.parseLong(tfNumber.getText());
//	            for (long i = 2; i <= n/2; i++) {
//	                if (n % i == 0) {
//	                    sb.append("\n" + i);
//	                }
//	            }
//	            lblResult.setText(sb.toString());
//	        }
//	    };
	    
	    btnCalc.setOnAction((event) -> {
	        StringBuilder sb = new StringBuilder("Result:");
	        long n = Long.parseLong(tfNumber.getText());
            for (long i = 2; i <= n/2; i++) {
                if (n % i == 0) {
                    sb.append("\n" + i);
                }
            }
            lblResult.setText(sb.toString());
	    });
        tfNumber.setOnAction(handler);
        
        //tfNumber.setOnKeyReleased(event -> checkInput());
        //tfNumber.textProperty().addListener((obs,ov,nv) -> checkInput());
        
        BooleanBinding inputOk= Bindings.createBooleanBinding(
                () -> tfNumber.getText().matches("[0-9]+"),
                tfNumber.textProperty());
        btnCalc.disableProperty().bind(inputOk.not());
        tfNumber.styleProperty().bind(
                Bindings.when(inputOk)
                .then("")
                .otherwise("-fx-focus-color: red;"));
        
        lblStatus = new Label();
        
        lblStatus.textProperty().bind(
                Bindings.when(inputOk)
                .then("")
                .otherwise("Integer number expected"));
        
//      VBox.setVgrow(spResult, Priority.ALWAYS);
//	    VBox root = new VBox();
//	    root.getChildren().addAll(inp, spResult);
                
        //checkInput();
        
        BorderPane root = new BorderPane();
        root.setTop(inp);
        root.setCenter(spResult);
        root.setBottom(lblStatus);
        
        tfNumber.setTooltip(new Tooltip("Enter an integer number, please"));
        btnCalc.setTooltip(new Tooltip("Start calculation of factors"));
        
	    Scene scene = new Scene(root, 400, 300);
	    
	    primaryStage.setTitle("Factors");
	    primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	private void checkInput() {
	    String input = tfNumber.getText();
	    if (input.matches("[1-9]+")) {
	        tfNumber.setStyle("");
	        btnCalc.setDisable(false);
	        tfNumber.setOnAction(handler);
            lblStatus.setText("");

	    } else {
	        tfNumber.setStyle("-fx-focus-color: red");
	        btnCalc.setDisable(true);
	        tfNumber.setOnAction(null);
	        lblStatus.setText("Integer number expected");
	    }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
