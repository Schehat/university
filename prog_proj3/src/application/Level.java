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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
    private static Player player = new Player("neo");
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
    private static String btnTextLevel = "LEVEL";
    private static String btnBackYellow = "#E9DD25";
    private static String btnHexRed = "#C75A41";
    private static String btnHexBlue = "#415FC7";
    private static String btnHexGreen = "#47D92B";
    private static String btnBorderWidth = "2px";
    private static String btnBorderColor = "#000000"; 
    private static String btnFontSize = "20px";
    private static String btnBorderRadius = "6px";
    
    private static int currentLevel = 1;
    private static int maxLevel = 1;  // to track the highest level the player can play
    private static Canvas canvas = new Canvas(Main.getSize()[0], Main.getSize()[1]);
    private static GraphicsContext gc = canvas.getGraphicsContext2D();
    private static String rectHexWhite = "F3F5F6";
    private static String rectHexRed = "C75A41";
    private static String rectHexBlue = "415FC7";
    
    //free form animation defined by KeyFrames and their duration 
    private static Timeline tl1 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl1(gc)));
    private static Timeline tl2 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl2(gc)));
    private static Timeline tl3 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl3(gc)));
    private static Timeline tl4 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl4(gc)));
    private static Timeline tl5 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl5(gc)));
    private static Timeline tl6 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl6(gc)));
    
    private static boolean leftKeyPressed = false;
    private static boolean rightKeyPressed = false;
    private static boolean upKeyPressed = false;
    private static boolean downKeyPressed = false;
    
    private static double rectBlueX;
    private static double rectBlueY;
    private static double rectBlueW; 
    private static double rectBlueH;
    private static double rectRedX;
    private static double rectRedY;
    private static double rectRedW; 
    private static double rectRedH;
    private static double rectWhiteX;
    private static double rectWhiteY;
    private static double rectWhiteW; 
    private static double rectWhiteH;
    
    /**
     * create level layout
     */
    public static void setLayout() {        
        root.getChildren().clear();
        
        iVBg.setX(0.0);
        iVBg.setY(0.0);
        
        Level.setBtn(btnBack, "BACK", btnBackYellow);
        Level.setBtn(btnLevel1, btnTextLevel + " 1", btnHexGreen);
        Level.setBtn(btnLevel2, btnTextLevel + " 2", btnHexRed);
        Level.setBtn(btnLevel3, btnTextLevel + " 3", btnHexRed);
        Level.setBtn(btnLevel4, btnTextLevel + " 4", btnHexRed);
        Level.setBtn(btnLevel5, btnTextLevel + " 5", btnHexRed);
        Level.setBtn(btnLevel6, btnTextLevel + " 6", btnHexRed);
        
        HBox hboxTop = new HBox();
        Label lblDeathCounter = new Label("DEATH COUNTER:\n0");
        lblDeathCounter.setFont(new Font("Arial", 18));
        // to not wrap text with ... sign
        lblDeathCounter.setMinWidth(170);
        lblDeathCounter.setTextFill(Color.WHITE);
        hboxTop.getChildren().addAll(iVMorpheus, iVInstructions, lblDeathCounter);
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
        btn.setMaxWidth(btnPrefWidth);
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
            if (e.getCode().equals(KeyCode.LEFT))   leftKeyPressed = true; 
            if (e.getCode().equals(KeyCode.RIGHT))  rightKeyPressed = true;
            if(e.getCode().equals(KeyCode.UP))      upKeyPressed = true;
            if (e.getCode().equals(KeyCode.DOWN))   downKeyPressed = true;
            
            // surprise! Mainly for debugging purposes skip level
            if (e.getCode().equals(KeyCode.N)) {
                maxLevel = 6;
                Level.gameLoopManager();
            }
        });
        
        scene.setOnKeyReleased(e -> {
            if (e.getCode().equals(KeyCode.LEFT))   leftKeyPressed = false; 
            if (e.getCode().equals(KeyCode.RIGHT))  rightKeyPressed = false;
            if(e.getCode().equals(KeyCode.UP))      upKeyPressed = false;
            if (e.getCode().equals(KeyCode.DOWN))   downKeyPressed = false;
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
            Level.setBtn(btn, btn.getText(), btnHexGreen);
            
            // change green colored button to blue
            if (currentLevel == 1) {
                Level.setBtn(btnLevel1, btnLevel1.getText(), btnHexBlue);
            } else if (currentLevel == 2) {
                Level.setBtn(btnLevel2, btnLevel2.getText(), btnHexBlue);
            } else if (currentLevel == 3) {
                Level.setBtn(btnLevel3, btnLevel3.getText(), btnHexBlue);
            } else if (currentLevel == 4) {
                Level.setBtn(btnLevel4, btnLevel4.getText(), btnHexBlue);
            } else if (currentLevel == 5) {
                Level.setBtn(btnLevel5, btnLevel5.getText(), btnHexBlue);
            } else if (currentLevel == 6) {
                Level.setBtn(btnLevel6, btnLevel6.getText(), btnHexBlue);
            }
            
            currentLevel = level;
            
            // if green button clicked again then it will turn blue
            // thats why after setting new level state need to 
            // turn the button to green color again
            if (currentLevel == 1) {
                Level.setBtn(btnLevel1, btnLevel1.getText(), btnHexGreen);
            } else if (currentLevel == 2) {
                Level.setBtn(btnLevel2, btnLevel2.getText(), btnHexGreen);
            } else if (currentLevel == 3) {
                Level.setBtn(btnLevel3, btnLevel3.getText(), btnHexGreen);
            } else if (currentLevel == 4) {
                Level.setBtn(btnLevel4, btnLevel4.getText(), btnHexGreen);
            } else if (currentLevel == 5) {
                Level.setBtn(btnLevel5, btnLevel5.getText(), btnHexGreen);
            } else if (currentLevel == 6) {
                Level.setBtn(btnLevel6, btnLevel6.getText(), btnHexGreen);
            }
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
     * handles selection of game loop per level & necessary editing before running the level
     */
    public static void gameLoopManager() {
        // at the start disable all buttons except button 1
        btnLevel2.setDisable(true);
        btnLevel3.setDisable(true);
        btnLevel4.setDisable(true);
        btnLevel5.setDisable(true);
        btnLevel6.setDisable(true);

        // maxLevel == 1 not needed, should always be not disabled
        if (maxLevel >= 2)  btnLevel2.setDisable(false);
        if (maxLevel >= 3)  btnLevel3.setDisable(false);
        if (maxLevel >= 4)  btnLevel4.setDisable(false);
        if (maxLevel >= 5)  btnLevel5.setDisable(false);
        if (maxLevel >= 6)  btnLevel6.setDisable(false);
                
        if (currentLevel == 1) {
            // do not want the game loop of the other level play at background
            tl2.stop();
            tl3.stop();
            tl4.stop();
            tl5.stop();
            tl6.stop();
            
            player.setX(200);
            player.setY(300);
            
            //number of cycles in animation INDEFINITE = repeat indefinitely
            tl1.setCycleCount(Timeline.INDEFINITE);
            
            // level switches will not continue where they left, instead start at
            // the beginning again
            tl1.playFromStart();
            
            // clear canvas when switching between levels
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        } else if (currentLevel == 2) {         
            tl1.stop();
            tl3.stop();
            tl4.stop();
            tl5.stop();
            tl6.stop();
            
            player.setX(200);
            player.setY(300);
            
            tl2.setCycleCount(Timeline.INDEFINITE);
            tl2.playFromStart();
            
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        } else if (currentLevel == 3) {     
            tl1.stop();
            tl2.stop();
            tl4.stop();
            tl5.stop();
            tl6.stop();
            
            player.setX(200);
            player.setY(300);
            
            tl3.setCycleCount(Timeline.INDEFINITE);
            tl3.playFromStart();
            
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        } else if (currentLevel == 4) {           
            tl1.stop();
            tl2.stop();
            tl3.stop();
            tl5.stop();
            tl6.stop();
            
            player.setX(200);
            player.setY(300);
            
            tl4.setCycleCount(Timeline.INDEFINITE);
            tl4.playFromStart();
            
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        } else if (currentLevel == 5) {   
            tl1.stop();
            tl2.stop();
            tl3.stop();
            tl4.stop();
            tl6.stop();
            
            player.setX(200);
            player.setY(300);
            
            tl5.setCycleCount(Timeline.INDEFINITE);
            tl5.playFromStart();
            
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        } else if (currentLevel == 6) {      
            tl1.stop();
            tl2.stop();
            tl3.stop();
            tl4.stop();
            tl5.stop();
            
            player.setX(200);
            player.setY(300);
            
            tl6.setCycleCount(Timeline.INDEFINITE);
            tl6.playFromStart();
            
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }
    
    /**
     * if keys pressed move player according to the pressed key
     */
    public static void checkKeysPressed() {
        if (leftKeyPressed) Controller.moveLeft(player);
        if (rightKeyPressed) Controller.moveRight(player);
        if (upKeyPressed) Controller.moveUp(player);
        if (downKeyPressed) Controller.moveDown(player);
    }
    
    /**
     * block players movement at level borders
     */
    public static void checkMovementBorder() {
        if (leftKeyPressed) {
            // rect blue left
            if (player.getX() - Controller.getSpeed() < rectBlueX) {
                Controller.moveRight(player);
            }
            // rect white bottom & top left
            if (
                    (
                        (player.getY() + player.getImage().getHeight() < rectWhiteY + rectWhiteH
                        && player.getY() + player.getImage().getHeight() > rectBlueY + rectBlueH)
                        || 
                        (player.getY() > rectWhiteY 
                        && player.getY() < rectBlueY)
                    )
                    &&
                    player.getX() - Controller.getSpeed() < rectWhiteX) {
                Controller.moveRight(player);
            }
        }
        
        if (rightKeyPressed) {
            // red rect right
            if (player.getX() + Controller.getSpeed() + player.getImage().getWidth() 
                    > rectRedX + rectRedW) {
                Controller.moveLeft(player);
            }
            // rect white bottom & top right
            if (
                    (
                        (player.getY() + player.getImage().getHeight() < rectWhiteY + rectWhiteH
                        && player.getY() + player.getImage().getHeight() > rectBlueY + rectBlueH)
                        || 
                        (player.getY() > rectWhiteY 
                        && player.getY() < rectBlueY)
                    )
                    &&
                    player.getX() + Controller.getSpeed() + player.getImage().getWidth() 
                    > rectWhiteX + rectWhiteW) {
                Controller.moveLeft(player);
            }
        }
        
        if (upKeyPressed) {
            // blue rect top
            if (player.getX() > rectBlueX && player.getX() < rectBlueX + rectBlueW
                    && player.getY() - Controller.getSpeed() < rectBlueY) {
                Controller.moveDown(player);
            }
            // white rect top
            if (player.getX() > rectWhiteX && player.getX() < rectWhiteX + rectWhiteW
                    && player.getY() - Controller.getSpeed() < rectWhiteY) {
                Controller.moveDown(player);
            }
            // red rect top
            if (player.getX() + player.getImage().getWidth() > rectRedX 
                    && player.getX() + player.getImage().getWidth() < rectRedX + rectRedW
                    && player.getY() - Controller.getSpeed() < rectRedY) {
                Controller.moveDown(player);
            }
        }
        
        if (downKeyPressed) {
            // blue rect bottom
            if (player.getX() > rectBlueX && player.getX() < rectBlueX + rectBlueW
                    && player.getY() + Controller.getSpeed() + 
                    player.getImage().getHeight()> rectBlueY + rectBlueH) {
                Controller.moveUp(player);
            }
            // white rect bottom
            if (player.getX() > rectWhiteX && player.getX() < rectWhiteX + rectWhiteW
                    && player.getY() + Controller.getSpeed() 
                    + player.getImage().getHeight() > rectWhiteY + rectWhiteH) {
                Controller.moveUp(player);
            }
            // red rect bottom
            if (player.getX() + player.getImage().getWidth() > rectRedX  
                    && player.getX() + player.getImage().getWidth() < rectRedX + rectRedW
                    && player.getY() + Controller.getSpeed() + 
                    player.getImage().getHeight()> rectRedY + rectRedH) {
                Controller.moveUp(player);
            }
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 1st level
     * @param gc
     */
    public static void runLvl1(GraphicsContext gc) {          
        rectBlueX = 50.0;
        rectBlueY = 300.0 - 50.0; // center from canvas 150 to 450 then +- 50 
        rectBlueW = 100.0; 
        rectBlueH = 100.0;
        gc.setFill(Color.web("0x" + rectHexBlue, 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        rectRedY = 300.0 - 50.0; // center from canvas 150 to 450 then +- 50 
        rectRedW = 100.0; 
        rectRedH = 100.0;
        gc.setFill(Color.web("0x" + rectHexRed, 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        rectWhiteX = rectBlueX + rectBlueW;
        rectWhiteY = rectBlueY - 50;
        rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        rectWhiteH = rectBlueH + 2*50.0;
        gc.setFill(Color.web("0x" + rectHexWhite, 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        Level.checkKeysPressed();
        
        Level.checkMovementBorder();
        
        if (player.getX() > 400) {
            maxLevel = 2;
            Level.setBtn(btnLevel2, btnLevel2.getText(), btnHexBlue);   
            btnLevel2.setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 2nd level
     * @param gc
     */
    public static void runLvl2(GraphicsContext gc) {
        Level.checkKeysPressed();
        
        double rectBlueX = 50.0;
        double rectBlueY = 300.0 - 50.0; // center from canvas 150 to 450 then +- 50 
        double rectBlueW = 100.0; 
        double rectBlueH = 100.0;
        gc.setFill(Color.web("0x" + rectHexBlue, 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        double rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        double rectRedY = 300.0 - 50.0; // center from canvas 150 to 450 then +- 50 
        double rectRedW = 100.0; 
        double rectRedH = 100.0;
        gc.setFill(Color.web("0x" + rectHexRed, 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        double rectWhiteX = rectBlueX + rectBlueW;
        double rectWhiteY = rectBlueY - 100;
        double rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        double rectWhiteH = rectBlueH + 2*100.0;
        gc.setFill(Color.web("0x" + rectHexWhite, 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        if (player.getX() > 400) {
            maxLevel = 3;
            Level.setBtn(btnLevel3, btnLevel3.getText(), btnHexBlue);   
            btnLevel3.setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 3rd level
     * @param gc
     */
    public static void runLvl3(GraphicsContext gc) {
        Level.checkKeysPressed();
        
        double rectBlueX = 50.0;
        double rectBlueY = 325.0;
        double rectBlueW = 100.0; 
        double rectBlueH = 75.0;
        gc.setFill(Color.web("0x" + rectHexBlue, 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        double rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        double rectRedY = 200.0;
        double rectRedW = 100.0; 
        double rectRedH = 75.0;
        gc.setFill(Color.web("0x" + rectHexRed, 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        double rectWhiteX = rectBlueX + rectBlueW;
        double rectWhiteY = rectRedY;
        double rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        double rectWhiteH = rectBlueY + rectBlueH - rectRedY;
        gc.setFill(Color.web("0x" + rectHexWhite, 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        if (player.getX() > 400) {
            maxLevel = 4;
            Level.setBtn(btnLevel4, btnLevel4.getText(), btnHexBlue);
            btnLevel4.setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 4th level
     * @param gc
     */
    public static void runLvl4(GraphicsContext gc) {
        Level.checkKeysPressed();
        
        double rectBlueX = 50.0;
        double rectBlueY = 375.0;
        double rectBlueW = 100.0; 
        double rectBlueH = 75.0;
        gc.setFill(Color.web("0x" + rectHexBlue, 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        double rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        double rectRedY = 150.0;
        double rectRedW = 100.0; 
        double rectRedH = 75.0;
        gc.setFill(Color.web("0x" + rectHexRed, 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        double rectWhiteX = rectBlueX + rectBlueW;
        double rectWhiteY = rectRedY;
        double rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        double rectWhiteH = rectBlueY + rectBlueH - rectRedY;
        gc.setFill(Color.web("0x" + rectHexWhite, 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        if (player.getX() > 400) {
            maxLevel = 5;
            Level.setBtn(btnLevel5, btnLevel5.getText(), btnHexBlue);
            btnLevel5.setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 5th level
     * @param gc
     */
    public static void runLvl5(GraphicsContext gc) {
        Level.checkKeysPressed();
        
        double rectBlueX = 50.0;
        double rectBlueY = 200.0;
        double rectBlueW = 100.0; 
        double rectBlueH = 75.0;
        gc.setFill(Color.web("0x" + rectHexBlue, 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        double rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        double rectRedY = 325.0;
        double rectRedW = 100.0; 
        double rectRedH = 75.0;
        gc.setFill(Color.web("0x" + rectHexRed, 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        double rectWhiteX = rectBlueX + rectBlueW;
        double rectWhiteY = rectBlueY;
        double rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        double rectWhiteH = rectRedY + rectBlueH - rectBlueY;
        gc.setFill(Color.web("0x" + rectHexWhite, 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        if (player.getX() > 400) {
            maxLevel = 6;
            Level.setBtn(btnLevel6, btnLevel6.getText(), btnHexBlue);
            btnLevel6.setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 6th level
     * @param gc
     */
    public static void runLvl6(GraphicsContext gc) {
        Level.checkKeysPressed();
        
        double rectBlueX = 50.0;
        double rectBlueY = 150.0;
        double rectBlueW = 100.0; 
        double rectBlueH = 75.0;
        gc.setFill(Color.web("0x" + rectHexBlue, 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        double rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        double rectRedY = 375.0;
        double rectRedW = 100.0; 
        double rectRedH = 75.0;
        gc.setFill(Color.web("0x" + rectHexRed, 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        double rectWhiteX = rectBlueX + rectBlueW;
        double rectWhiteY = rectBlueY;
        double rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        double rectWhiteH = rectRedY + rectBlueH - rectBlueY;
        gc.setFill(Color.web("0x" + rectHexWhite, 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
    }
}
