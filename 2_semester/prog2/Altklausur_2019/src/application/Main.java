package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //launch(args);
//                String a = "0123456789";
//                System.out.println(a.substring(a.length()-5,a.length()));
//        
                X a = new X();
                X b = new X();
                X c = new X();
                a.v = c;
                FileOutputStream fos = new FileOutputStream(new File("datei.dat"));
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(a);
                
                FileInputStream fis = new FileInputStream(new File("datei.dat"));
                ObjectInputStream ois = new ObjectInputStream(fis);
                X a2 = (X)ois.readObject();
                
                System.out.println(a2 == c);
        //        
        //        Factory.setY(5);
        //        System.out.println(Factory.create(3)); // Points x=3, y=5
        //        System.out.println(Factory.create(4)); // Point x=4, y=5
        //        Factory.setY(1);
        //        System.out.println(Factory.create(2)); // Point x=2, y=1

//        Ressource r = new Ressource();
//        Thread t1 = new Thread() {
//            @Override public void run() {
//                for (int i = 0; i < 100; i++) {
//                    r.incr();
//                    System.out.println(r.getVal());
//                }
//            }};
//            Thread t2 = new Thread(() -> {
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//                for (int i = 0; i < 100; i++) {
//                    r.decr();
//                    System.out.println(r.getVal());
//                }
//            });
//            t2.start();
//            t1.start();
//            t1.join();
//            t2.join();

    }
}
