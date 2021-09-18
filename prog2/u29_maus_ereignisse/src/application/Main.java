package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;


import java.util.Locale;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javafx.scene.Cursor;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class Main extends Application {
    private double  deltaX, deltaY;
    private DraggableCircle dc;
    private Text text;
    private void updateText() {
        text.setText(String.format(Locale.US, "(%.1f, %.1f)", 
                dc.getCenterX(), dc.getCenterY()));
    
    }
    @Override
    public void start(final Stage stage) throws Exception {
        dc= new DraggableCircle(100d, 100d);
        text= new Text(10, 10, "");
        updateText(); // initialize once
        
        dc.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deltaX = event.getSceneX();
                deltaY = event.getSceneY();
            }
            
        });
        
        dc.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dc.setCenterX(dc.getCenterX() + event.getSceneX() - deltaX);
                dc.setCenterY(dc.getCenterY() + event.getSceneY() - deltaY);
                deltaX = event.getSceneX();
                deltaY = event.getSceneY();
                updateText();
                stage.show();
            }
            
        });
        
        Group root = new Group(dc, text);
        stage.setScene(new Scene(root, 400, 400, Color.ALICEBLUE));
        stage.setTitle("Drag Sample");
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}

class DraggableCircle extends Circle {
    DraggableCircle(double x, double y) {
        super(x, y, 10);
        setFill(Color.YELLOW);
        setStroke(Color.GOLD);
        setStrokeWidth(2);
        setStrokeType(StrokeType.OUTSIDE);

        setOnMousePressed( ev -> {
            getScene().setCursor(Cursor.MOVE);
        });
        setOnMouseReleased( ev -> {
            getScene().setCursor(Cursor.DEFAULT);
        });
    }
}