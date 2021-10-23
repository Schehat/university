package application;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * 
 * @author Schehat
 * handling multiple game loops
 */
public class GameLoopManager {
    private static Canvas canvas = new Canvas(Main.getSize()[0], Main.getSize()[1]);
    private static GraphicsContext gc = canvas.getGraphicsContext2D();
    
    //free form animation defined by KeyFrames and their duration 
    private static Timeline tl1 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl1(gc)));
    private static Timeline tl2 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl2(gc)));
    private static Timeline tl3 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl3(gc)));
    private static Timeline tl4 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl4(gc)));
    private static Timeline tl5 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl5(gc)));
    private static Timeline tl6 = new Timeline(new KeyFrame(Duration.millis(10), e -> runLvl6(gc)));
    
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
    
    public static String circleColor = "F3EF10"; // yellow
    public static int[] circleSize = {20, 20};  // width & height
    public static ArrayList<ImageView> arrIVCircle = new ArrayList<ImageView>();
    public static int[] enemySize = {30, 30};  // width & height
    public static ArrayList<ImageView> arrIVEnemy = new ArrayList<ImageView>();
    public static ArrayList<Integer> arrIVEnemyMove = new ArrayList<Integer>();
    public static boolean setup = false; // for if statements to run code only once  
    
    public static int maxNeededCircles;
    public static int circlesObtained = 0;
    public static int maxEnemies = 0;
    
    public static double enemyOffsetY;
    public static double enemyOffsetX;
    
    /**
     * handling multiple game loops
     */
    public static void gameLoopManager() {
        // at the start disable all buttons except button 1
        Level.getBtnLevel2().setDisable(true);
        Level.getBtnLevel3().setDisable(true);
        Level.getBtnLevel4().setDisable(true);
        Level.getBtnLevel5().setDisable(true);
        Level.getBtnLevel6().setDisable(true);

        // maxLevel == 1 not needed, should always be not disabled
        if (Level.getMaxLevel() >= 2)  Level.getBtnLevel2().setDisable(false);
        if (Level.getMaxLevel() >= 3)  Level.getBtnLevel3().setDisable(false);
        if (Level.getMaxLevel() >= 4)  Level.getBtnLevel4().setDisable(false);
        if (Level.getMaxLevel() >= 5)  Level.getBtnLevel5().setDisable(false);
        if (Level.getMaxLevel() >= 6)  Level.getBtnLevel6().setDisable(false);
        
        // reset state
        circlesObtained = 0;
        setup = false;
        
        // clear canvas when switching between levels
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // clear circles & enemies
        arrIVCircle.clear();
        arrIVEnemy.clear();
        arrIVEnemyMove.clear();
        
        if (Level.getCurrentLevel() == 1) {
            // do not want the game loop of the other level play at background
            tl2.stop();
            tl3.stop();
            tl4.stop();
            tl5.stop();
            tl6.stop();
            
            // load circles & enemies
            maxNeededCircles = 2;
            initilizeCircle();
            maxEnemies = 3;
            initilizeEnemy();
            
            //number of cycles in animation INDEFINITE = repeat indefinitely
            tl1.setCycleCount(Timeline.INDEFINITE);
            
            // level switches will not continue where they left, instead start at
            // the beginning again
            tl1.playFromStart();
        } else if (Level.getCurrentLevel() == 2) {         
            tl1.stop();
            tl3.stop();
            tl4.stop();
            tl5.stop();
            tl6.stop();
            
            maxNeededCircles = 4;
            initilizeCircle();
            maxEnemies = 10;
            initilizeEnemy();
            
            tl2.setCycleCount(Timeline.INDEFINITE);
            tl2.playFromStart();
        } else if (Level.getCurrentLevel() == 3) {     
            tl1.stop();
            tl2.stop();
            tl4.stop();
            tl5.stop();
            tl6.stop();
            
            maxNeededCircles = 3;
            initilizeCircle();
            maxEnemies = 3;
            initilizeEnemy();
            
            tl3.setCycleCount(Timeline.INDEFINITE);
            tl3.playFromStart();
        } else if (Level.getCurrentLevel() == 4) {           
            tl1.stop();
            tl2.stop();
            tl3.stop();
            tl5.stop();
            tl6.stop();
           
            maxNeededCircles = 4;
            initilizeCircle();
            maxEnemies = 8;
            initilizeEnemy();
            
            tl4.setCycleCount(Timeline.INDEFINITE);
            tl4.playFromStart();
        } else if (Level.getCurrentLevel() == 5) {   
            tl1.stop();
            tl2.stop();
            tl3.stop();
            tl4.stop();
            tl6.stop();
         
            maxNeededCircles = 3;
            initilizeCircle();
            maxEnemies = 6;
            initilizeEnemy();
            
            tl5.setCycleCount(Timeline.INDEFINITE);
            tl5.playFromStart();
        } else if (Level.getCurrentLevel() == 6) {      
            tl1.stop();
            tl2.stop();
            tl3.stop();
            tl4.stop();
            tl5.stop();
            
            maxNeededCircles = 4;
            initilizeCircle();
            maxEnemies = 12;
            initilizeEnemy();
            
            tl6.setCycleCount(Timeline.INDEFINITE);
            tl6.playFromStart();
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
        gc.setFill(Color.web("0x" + Level.getRectHexBlue(), 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        rectRedY = 300.0 - 50.0; // center from canvas 150 to 450 then +- 50 
        rectRedW = 100.0; 
        rectRedH = 100.0;
        gc.setFill(Color.web("0x" + Level.getRectHexRed(), 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        rectWhiteX = rectBlueX + rectBlueW;
        rectWhiteY = rectBlueY - 50;
        rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        rectWhiteH = rectBlueH + 2*50.0;
        gc.setFill(Color.web("0x" + Level.getRectHexWhite(), 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);

        int offsetX = 80;
        // left circle
        arrIVCircle.get(0).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 - offsetX);
        arrIVCircle.get(0).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2);
        
        // right circle
        arrIVCircle.get(1).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 + offsetX);
        arrIVCircle.get(1).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2);
        
        int xPadding = 75;
        if (setup == false) {
            setPlayerPosition((int) (rectBlueX + rectBlueW/2 - Level.getPlayer().getImage().getWidth()/2), 
                    (int) (rectBlueY + rectBlueH/2 - Level.getPlayer().getImage().getHeight()/2));
            
            enemyOffsetX = (rectWhiteW - enemySize[0]) / (maxEnemies-1) - xPadding;
            enemyOffsetY = (rectWhiteH - enemySize[0]) / (maxEnemies-1);
            for (int i = 0; i < maxEnemies; i++) {
                arrIVEnemy.get(i).setX(rectWhiteX + i*enemyOffsetX + xPadding);
                arrIVEnemy.get(i).setY(rectWhiteY + i*enemyOffsetY);
            }
        }
        
        moveEnemiesVertical(2);
        
        // for some reason not needed to clear before adding when switching between scenes
        addImagesToRoot();
        
        Level.checkKeysPressed();      
        checkMovementBorder();
        checkCollision();
        checkNextLevel(2);
    }
    
    /**
     * run game loop to animate level environment & enemies of 2nd level
     * @param gc
     */
    public static void runLvl2(GraphicsContext gc) {          
        rectBlueX = 50.0;
        rectBlueY = 300.0 - 50.0; // center from canvas 150 to 450 then +- 50 
        rectBlueW = 100.0; 
        rectBlueH = 100.0;
        gc.setFill(Color.web("0x" + Level.getRectHexBlue(), 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        rectRedY = 300.0 - 50.0; // center from canvas 150 to 450 then +- 50 
        rectRedW = 100.0; 
        rectRedH = 100.0;
        gc.setFill(Color.web("0x" + Level.getRectHexRed(), 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        rectWhiteX = rectBlueX + rectBlueW;
        rectWhiteY = rectBlueY - 100;
        rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        rectWhiteH = rectBlueH + 2*100.0;
        gc.setFill(Color.web("0x" + Level.getRectHexWhite(), 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        GameLoopManager.drawCirclesInCorners(10, 10);
        
        if (setup == false) {
            setPlayerPosition((int) (rectBlueX + rectBlueW/2 - Level.getPlayer().getImage().getWidth()/2), 
                    (int) (rectBlueY + rectBlueH/2 - Level.getPlayer().getImage().getHeight()/2));
            
            enemyOffsetX = (rectWhiteW - enemySize[0]) / (maxEnemies-1);
            for (int i = 0; i < maxEnemies; i++) {
                arrIVEnemy.get(i).setX(rectWhiteX + i*enemyOffsetX);
                if (i % 2 == 0) {
                    arrIVEnemy.get(i).setY(rectWhiteY + 0);
                } else {
                    arrIVEnemy.get(i).setY(rectWhiteY + rectWhiteH - enemySize[0]);
                }
            }
        }
        
        moveEnemiesVertical(2);
        
        addImagesToRoot();
        
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollision();
        checkNextLevel(3);
    }
    
    /**
     * run game loop to animate level environment & enemies of 3rd level
     * @param gc
     */
    public static void runLvl3(GraphicsContext gc) {
        rectBlueX = 50.0;
        rectBlueY = 325.0;
        rectBlueW = 100.0; 
        rectBlueH = 75.0;
        gc.setFill(Color.web("0x" + Level.getRectHexBlue(), 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        rectRedY = 200.0;
        rectRedW = 100.0; 
        rectRedH = 75.0;
        gc.setFill(Color.web("0x" + Level.getRectHexRed(), 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        rectWhiteX = rectBlueX + rectBlueW;
        rectWhiteY = rectRedY;
        rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        rectWhiteH = rectBlueY + rectBlueH - rectRedY;
        gc.setFill(Color.web("0x" + Level.getRectHexWhite(), 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        GameLoopManager.drawCirclesInDiagonal(0);
        
        int yPadding = 35;
        if (setup == false) {
            setPlayerPosition((int) (rectBlueX + rectBlueW/2 - Level.getPlayer().getImage().getWidth()/2), 
                    (int) (rectBlueY + rectBlueH/2 - Level.getPlayer().getImage().getHeight()/2));
            
            enemyOffsetX = (rectWhiteW - enemySize[0]) / (maxEnemies-1);
            enemyOffsetY = (rectWhiteH - enemySize[0]) / (maxEnemies-1) - yPadding;
            for (int i = 0; i < maxEnemies; i++) {
                arrIVEnemy.get(i).setX(rectWhiteX + i*enemyOffsetX);
                arrIVEnemy.get(i).setY(rectWhiteY + i*enemyOffsetY + yPadding);
            }
        }
        
        moveEnemiesHorizontal(3);
        
        addImagesToRoot();
        
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollision();
        checkNextLevel(4);
    }
    
    /**
     * run game loop to animate level environment & enemies of 4th level
     * @param gc
     */
    public static void runLvl4(GraphicsContext gc) {   
        rectBlueX = 50.0;
        rectBlueY = 375.0;
        rectBlueW = 100.0; 
        rectBlueH = 75.0;
        gc.setFill(Color.web("0x" + Level.getRectHexBlue(), 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        rectRedY = 150.0;
        rectRedW = 100.0; 
        rectRedH = 75.0;
        gc.setFill(Color.web("0x" + Level.getRectHexRed(), 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        rectWhiteX = rectBlueX + rectBlueW;
        rectWhiteY = rectRedY;
        rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        rectWhiteH = rectBlueY + rectBlueH - rectRedY;
        gc.setFill(Color.web("0x" + Level.getRectHexWhite(), 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        GameLoopManager.drawCirclesInCorners(50, 50);
        
        if (setup == false) {
            setPlayerPosition((int) (rectBlueX + rectBlueW/2 - Level.getPlayer().getImage().getWidth()/2), 
                    (int) (rectBlueY + rectBlueH/2 - Level.getPlayer().getImage().getHeight()/2));
            
            enemyOffsetY = (rectWhiteH - enemySize[0]) / (maxEnemies-1);
            for (int i = 0; i < maxEnemies; i++) {
                arrIVEnemy.get(i).setY(rectWhiteY + i*enemyOffsetY);
                if (i % 2 == 0) {
                    arrIVEnemy.get(i).setX(rectWhiteX);
                } else {
                    arrIVEnemy.get(i).setX(rectWhiteX + rectWhiteW - enemySize[0]);
                }
            }
        }
        
        moveEnemiesHorizontal(3);
        
        addImagesToRoot();
        
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollision();
        checkNextLevel(5);
    }
    
    /**
     * run game loop to animate level environment & enemies of 5th level
     * @param gc
     */
    public static void runLvl5(GraphicsContext gc) {        
        rectBlueX = 50.0;
        rectBlueY = 200.0;
        rectBlueW = 100.0; 
        rectBlueH = 75.0;
        gc.setFill(Color.web("0x" + Level.getRectHexBlue(), 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        rectRedY = 325.0;
        rectRedW = 100.0; 
        rectRedH = 75.0;
        gc.setFill(Color.web("0x" + Level.getRectHexRed(), 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        rectWhiteX = rectBlueX + rectBlueW;
        rectWhiteY = rectBlueY;
        rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        rectWhiteH = rectRedY + rectBlueH - rectBlueY;
        gc.setFill(Color.web("0x" + Level.getRectHexWhite(), 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        GameLoopManager.drawCirclesInDiagonal(1);
        
        int verticalEnemies = 3;
        if (setup == false) {
            setPlayerPosition((int) (rectBlueX + rectBlueW/2 - Level.getPlayer().getImage().getWidth()/2), 
                    (int) (rectBlueY + rectBlueH/2 - Level.getPlayer().getImage().getHeight()/2));
            for (int i = 0; i < verticalEnemies; i++) {
                arrIVEnemy.get(i).setX(arrIVCircle.get(i).getX() - circleSize[0]/4);
                /*
                 * should be i % 2 != 0 but first circle is in center thats why doing this
                   for proper position so left & right enemy starts at top and the center enemy at the bottom
                 */
                if (i > 0) {
                    arrIVEnemy.get(i).setY(rectWhiteY);
                } else {
                    arrIVEnemy.get(i).setY(rectWhiteY + rectWhiteH - enemySize[0]);
                }
            }
        }
        ;
        int horizontalEnemies = 3;
        if (setup == false) {
            setPlayerPosition((int) (rectBlueX + rectBlueW/2 - Level.getPlayer().getImage().getWidth()/2), 
                    (int) (rectBlueY + rectBlueH/2 - Level.getPlayer().getImage().getHeight()/2));
            for (int i = horizontalEnemies; i < maxEnemies; i++) {
                arrIVEnemy.get(i).setY(arrIVCircle.get(i - horizontalEnemies).getY() - circleSize[0]/4);
                if (i > horizontalEnemies) {
                    arrIVEnemy.get(i).setX(rectWhiteX);
                } else {
                    arrIVEnemy.get(i).setX(rectWhiteX + rectWhiteW - enemySize[0]);
                }
            }
        }
        
        int speed = 2;
        // movie enemies vertically
        for (int i = 0; i < verticalEnemies; i++) {
            if (arrIVEnemy.get(i).getY() < rectWhiteY || arrIVEnemy.get(i).getY() > rectWhiteY + rectWhiteH - enemySize[0]) {
                arrIVEnemyMove.set(i, -1*arrIVEnemyMove.get(i));
            }
            arrIVEnemy.get(i).setY(arrIVEnemy.get(i).getY() + speed*arrIVEnemyMove.get(i));
        }
        
        speed = 3;
        // movie enemies horizontally
        for (int i = horizontalEnemies; i < maxEnemies; i++) {
            if (arrIVEnemy.get(i).getX() < rectWhiteX || arrIVEnemy.get(i).getX() > rectWhiteX + rectWhiteW - enemySize[0]) {
                arrIVEnemyMove.set(i, -1*arrIVEnemyMove.get(i));
            }
            arrIVEnemy.get(i).setX(arrIVEnemy.get(i).getX() + speed*arrIVEnemyMove.get(i));
        }
        
        addImagesToRoot();
        
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollision();
        checkNextLevel(6);
    }
    
    /**
     * run game loop to animate level environment & enemies of 6th level
     * @param gc
     */
    public static void runLvl6(GraphicsContext gc) {
        rectBlueX = 50.0;
        rectBlueY = 150.0;
        rectBlueW = 100.0; 
        rectBlueH = 75.0;
        gc.setFill(Color.web("0x" + Level.getRectHexBlue(), 1.0));
        gc.fillRect(rectBlueX, rectBlueY, rectBlueW, rectBlueH);
        
        rectRedX = Main.getSize()[0] - 2*rectBlueX - rectBlueX;
        rectRedY = 375.0;
        rectRedW = 100.0; 
        rectRedH = 75.0;
        gc.setFill(Color.web("0x" + Level.getRectHexRed(), 1.0));
        gc.fillRect(rectRedX, rectRedY, rectRedW, rectRedH);
        
        rectWhiteX = rectBlueX + rectBlueW;
        rectWhiteY = rectBlueY;
        rectWhiteW = rectRedX - rectBlueX - rectBlueW; 
        rectWhiteH = rectRedY + rectBlueH - rectBlueY;
        gc.setFill(Color.web("0x" + Level.getRectHexWhite(), 1.0));
        gc.fillRect(rectWhiteX, rectWhiteY, rectWhiteW, rectWhiteH);
        
        GameLoopManager.drawCirclesInCorners(80, 80);
        
        int xPadding = 35;
        int verticalEnemies = 4;
        if (setup == false) {
            setPlayerPosition((int) (rectBlueX + rectBlueW/2 - Level.getPlayer().getImage().getWidth()/2), 
                    (int) (rectBlueY + rectBlueH/2 - Level.getPlayer().getImage().getHeight()/2));
            for (int i = 0; i < verticalEnemies; i++) {
                arrIVEnemy.get(i).setX(arrIVCircle.get(i).getX() - circleSize[0]/4 + xPadding);
                /*
                 * should be i % 2 != 0 but first circle is in center thats why doing this
                   for proper position so left & right enemy starts at top and the center enemy at the bottom
                 */
                if (i % 2 == 0) {
                    arrIVEnemy.get(i).setY(rectWhiteY);
                } else {
                    arrIVEnemy.get(i).setY(rectWhiteY + rectWhiteH - enemySize[0]);
                }
            }
        }
        ;
        int horizontalEnemies = 4;
        if (setup == false) {
            for (int i = horizontalEnemies; i < horizontalEnemies + verticalEnemies; i++) {
                arrIVEnemy.get(i).setY(arrIVCircle.get(i - horizontalEnemies).getY() - circleSize[0]/4);
                arrIVEnemy.get(i).setX(arrIVCircle.get(i - horizontalEnemies).getX() - circleSize[0]/4);
            }
        }
        
        // enemies in the center
        if (setup == false) {
                // center top
                arrIVEnemy.get(8).setX(rectWhiteX + rectWhiteW/2 - enemySize[0]/2);
                arrIVEnemy.get(8).setY(rectWhiteY);
                
                // center bottom
                arrIVEnemy.get(9).setX(rectWhiteX + rectWhiteW/2 - enemySize[0]/2);
                arrIVEnemy.get(9).setY(rectWhiteY + rectWhiteH - enemySize[0]);
                
                // center left
                arrIVEnemy.get(10).setX(rectWhiteX);
                arrIVEnemy.get(10).setY(rectWhiteY + rectWhiteH/2 - enemySize[0]/2);
                
                // center right
                arrIVEnemy.get(11).setX(rectWhiteX + rectWhiteW - enemySize[0]);
                arrIVEnemy.get(11).setY(rectWhiteY + rectWhiteH/2 - enemySize[0]/2);
        }
        
        int speed = 2;
        // movie enemies vertically
        for (int i = 0; i < verticalEnemies; i++) {
            if (arrIVEnemy.get(i).getY() < rectWhiteY || arrIVEnemy.get(i).getY() > rectWhiteY + rectWhiteH - enemySize[0]) {
                arrIVEnemyMove.set(i, -1*arrIVEnemyMove.get(i));
            }
            arrIVEnemy.get(i).setY(arrIVEnemy.get(i).getY() + speed*arrIVEnemyMove.get(i));
        }
        
        // special configuration of movement pattern
        if (setup == false ) {
            for (int i = horizontalEnemies; i < horizontalEnemies + verticalEnemies; i++) {
                if (i < horizontalEnemies + 2) {
                    arrIVEnemyMove.set(i, 1);
                } else {
                    arrIVEnemyMove.set(i, -1);
                }
            }   
        }
        
        // movie enemies horizontally
        for (int i = horizontalEnemies; i < horizontalEnemies + verticalEnemies; i++) {
            if (arrIVEnemy.get(i).getX() < rectWhiteX || arrIVEnemy.get(i).getX() > rectWhiteX + rectWhiteW - enemySize[0]) {
                arrIVEnemyMove.set(i, -1*arrIVEnemyMove.get(i));
            }
            arrIVEnemy.get(i).setX(arrIVEnemy.get(i).getX() + speed*arrIVEnemyMove.get(i));
        }
        
        // movie enemies which were place in the center
        // vertically
        for (int i = 8; i <= 9; i++) {
            if (arrIVEnemy.get(i).getY() < rectWhiteY || arrIVEnemy.get(i).getY() > rectWhiteY + rectWhiteH - enemySize[0]) {
                arrIVEnemyMove.set(i, -1*arrIVEnemyMove.get(i));
            } 
            arrIVEnemy.get(i).setY(arrIVEnemy.get(i).getY() + speed*arrIVEnemyMove.get(i));
        }
        // horizontally 
        for (int i = 10; i <= 11; i++) {
            if (arrIVEnemy.get(i).getX() < rectWhiteX || arrIVEnemy.get(i).getX() > rectWhiteX + rectWhiteW - enemySize[0]) {
                arrIVEnemyMove.set(i, -1*arrIVEnemyMove.get(i));
            }
            arrIVEnemy.get(i).setX(arrIVEnemy.get(i).getX() + speed*arrIVEnemyMove.get(i));
        }
        
        addImagesToRoot();
        
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollision();
    }
    
    /**
     * block players movement at level borders
     */
    public static void checkMovementBorder() {
        if (Level.getLeftKeyPressed()) {
            // rect blue left
            if (Level.getPlayer().getX() - Controller.getSpeed() < rectBlueX) {
                Controller.moveRight(Level.getPlayer());
            }
            // rect white bottom & top left
            if (
                    (Level.getPlayer().getY() + Level.getPlayer().getImage().getHeight() > rectBlueY + rectBlueH
                        || Level.getPlayer().getY() < rectBlueY
                    ) && Level.getPlayer().getX() - Controller.getSpeed() < rectWhiteX) {
                Controller.moveRight(Level.getPlayer());
            }
        }
        
        if (Level.getRightKeyPressed()) {
            // red rect right
            if (Level.getPlayer().getX() + Controller.getSpeed() + Level.getPlayer().getImage().getWidth() 
                    > rectRedX + rectRedW) {
                Controller.moveLeft(Level.getPlayer());
            }
            // rect white bottom & top right
            if (
                    (Level.getPlayer().getY() + Level.getPlayer().getImage().getHeight() > rectRedY + rectRedH
                        || Level.getPlayer().getY() < rectRedY)
                    && Level.getPlayer().getX() + Controller.getSpeed() + Level.getPlayer().getImage().getWidth() 
                    > rectWhiteX + rectWhiteW) {
                Controller.moveLeft(Level.getPlayer());
            }
        }
        
        if (Level.getUpKeyPressed()) {
            // blue rect top
            if (Level.getPlayer().getX() > rectBlueX && Level.getPlayer().getX() < rectBlueX + rectBlueW
                    && Level.getPlayer().getY() - Controller.getSpeed() < rectBlueY) {
                Controller.moveDown(Level.getPlayer());
            }
            // white rect top
            if (Level.getPlayer().getX() > rectWhiteX && Level.getPlayer().getX() < rectWhiteX + rectWhiteW
                    && Level.getPlayer().getY() - Controller.getSpeed() < rectWhiteY) {
                Controller.moveDown(Level.getPlayer());
            }
            // red rect top
            if (Level.getPlayer().getX() + Level.getPlayer().getImage().getWidth() > rectRedX 
                    && Level.getPlayer().getX() + Level.getPlayer().getImage().getWidth() < rectRedX + rectRedW
                    && Level.getPlayer().getY() - Controller.getSpeed() < rectRedY) {
                Controller.moveDown(Level.getPlayer());
            }
        }
        
        if (Level.getDownKeyPressed()) {
            // blue rect bottom
            if (Level.getPlayer().getX() > rectBlueX && Level.getPlayer().getX() < rectBlueX + rectBlueW
                    && Level.getPlayer().getY() + Controller.getSpeed() + 
                    Level.getPlayer().getImage().getHeight()> rectBlueY + rectBlueH) {
                Controller.moveUp(Level.getPlayer());
            }
            // white rect bottom
            if (Level.getPlayer().getX() > rectWhiteX && Level.getPlayer().getX() < rectWhiteX + rectWhiteW
                    && Level.getPlayer().getY() + Controller.getSpeed() 
                    + Level.getPlayer().getImage().getHeight() > rectWhiteY + rectWhiteH) {
                Controller.moveUp(Level.getPlayer());
            }
            // red rect bottom
            if (Level.getPlayer().getX() + Level.getPlayer().getImage().getWidth() > rectRedX  
                    && Level.getPlayer().getX() + Level.getPlayer().getImage().getWidth() < rectRedX + rectRedW
                    && Level.getPlayer().getY() + Controller.getSpeed() + 
                    Level.getPlayer().getImage().getHeight()> rectRedY + rectRedH) {
                Controller.moveUp(Level.getPlayer());
            }
        }
    }
    
    /**
     * 
     * @param offsetX of circle to static x location
     * @param offsetY of circle to static y location
     */
    public static void drawCirclesInCorners(int offsetX, int offsetY) {
        // top left
        arrIVCircle.get(0).setX(rectWhiteX + offsetX);
        arrIVCircle.get(0).setY(rectWhiteY + offsetY);
        
        // bottom left
        arrIVCircle.get(1).setX(rectWhiteX + offsetX);
        arrIVCircle.get(1).setY(rectWhiteY + rectWhiteH - offsetY - circleSize[1]);
        
        // top right
        arrIVCircle.get(2).setX(rectWhiteX + rectWhiteW - offsetX - circleSize[0]);
        arrIVCircle.get(2).setY(rectWhiteY + offsetY);
        
        // bottom right
        arrIVCircle.get(3).setX(rectWhiteX + rectWhiteW - offsetX - circleSize[0]);
        arrIVCircle.get(3).setY(rectWhiteY + rectWhiteH - offsetY - circleSize[1]);
    }
    
    /**
     * draws circles in correct position for the level
     * @param direction, 0: from bottom left to top right & 1: from top left to bottom right
     */
    public static void drawCirclesInDiagonal(int direction) {
        gc.setFill(Color.web("0x" + circleColor, 1.0));
        int offsetX = 125, offsetY = 75;
        
        // center
        arrIVCircle.get(0).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2);
        arrIVCircle.get(0).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2);
        
        if (direction == 0) {
            // left
            arrIVCircle.get(1).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 - offsetX);
            arrIVCircle.get(1).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2 + offsetY);
            
            // right
            arrIVCircle.get(2).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 + offsetX);
            arrIVCircle.get(2).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2 - offsetY);
        } else {
            // left
            arrIVCircle.get(1).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 - offsetX);
            arrIVCircle.get(1).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2 - offsetY);
            
            // right
            arrIVCircle.get(2).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 + offsetX);
            arrIVCircle.get(2).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2 + offsetY);
        }
    }
    
    /**
     * check collision between player & circles and player & enemies
     */
    public static void checkCollision() {
        for (int i = 0; i < maxNeededCircles; i++) {
            // when not checking weather circle in root then collision still works at the background
            if (Level.getRoot().getChildren().contains(arrIVCircle.get(i))) {
                if (Level.getPlayer().getImageView().getBoundsInParent().intersects(arrIVCircle.get(i).getBoundsInParent())) {
                    Level.getRoot().getChildren().remove(arrIVCircle.get(i));
                    circlesObtained++;
                }
            }
        }
        
        for (int i = 0; i < maxEnemies; i++) {
            if (Level.getRoot().getChildren().contains(arrIVEnemy.get(i))) {
                if (Level.getPlayer().getImageView().getBoundsInParent().intersects(arrIVEnemy.get(i).getBoundsInParent())) {
                    setPlayerPosition((int) (rectBlueX + rectBlueW/2 - Level.getPlayer().getImage().getWidth()/2), 
                            (int) (rectBlueY + rectBlueH/2 - Level.getPlayer().getImage().getHeight()/2));
                    Level.incrementDeathCounter();
                    circlesObtained = 0;
                    Level.clearRoot();
                    setup = false;  // so addImagesToRoot works
                    addImagesToRoot();
                }
            }
        }
    }
    
    /**
     * 
     * @return canvas
     */
    public static Canvas getCanvas() {
        return canvas;
    }
    
    /**
     * add circle images to array object to display them later
     */
    public static void initilizeCircle() {
        for (int i = 0; i < maxNeededCircles; i++ ) {
            arrIVCircle.add(new ImageView(new Image("circle.png")));
        }
    }
    
    /**
     * add enemy images to array object to display them later
     */
    public static void initilizeEnemy() {
        int sign = 1;
        for (int i = 0; i < maxEnemies; i++ ) {
            arrIVEnemy.add(new ImageView(new Image("smith.png")));
            arrIVEnemyMove.add(sign);
            sign*= -1;
        }
    }
    
    /**
     * checks weather next level should be unlocked, meaning the button is 
     */
    public static void checkNextLevel(int nextLevel) {
        if (Level.getPlayer().getX() > rectRedX && circlesObtained == maxNeededCircles) {
            Level.setMaxLevel(nextLevel);
            if (nextLevel == 2) {
                Level.setBtn(Level.getBtnLevel2(), Level.getBtnLevel2().getText(), Level.getBtnHexBlue());
                Level.getBtnLevel2().setDisable(false);
            } else if (nextLevel == 3) {
                Level.setBtn(Level.getBtnLevel3(), Level.getBtnLevel3().getText(), Level.getBtnHexBlue());
                Level.getBtnLevel3().setDisable(false);
            } else if (nextLevel == 4) {
                Level.setBtn(Level.getBtnLevel4(), Level.getBtnLevel4().getText(), Level.getBtnHexBlue());
                Level.getBtnLevel4().setDisable(false);
            }  else if (nextLevel == 5) {
                Level.setBtn(Level.getBtnLevel5(), Level.getBtnLevel5().getText(), Level.getBtnHexBlue());
                Level.getBtnLevel5().setDisable(false);
            }  else if (nextLevel == 6) {
                Level.setBtn(Level.getBtnLevel6(), Level.getBtnLevel6().getText(), Level.getBtnHexBlue());
                Level.getBtnLevel6().setDisable(false);
            }
        }
    }
    
    /**
     * add circles & enemies to root to be seen
     */
    public static void addImagesToRoot() {
        if (setup == false) {
            for (int i = 0; i < maxNeededCircles; i++) {
                    Level.getRoot().getChildren().add(arrIVCircle.get(i));
            }
            for (int i = 0; i < maxEnemies; i++) {
                Level.getRoot().getChildren().add(arrIVEnemy.get(i));
            }
            setup = true;
        }
    }
    
    /**
     * stops all timelines to allow smooth scene switches when clicking the back button
     */
    public static void stopAllTimelines() {
        tl1.stop();
        tl2.stop();
        tl3.stop();
        tl4.stop();
        tl5.stop();
        tl6.stop();
    }
    
    /**
     * moving enemies vertically in the level
     * @param speed
     */
    public static void moveEnemiesVertical(double speed) {
        for (int i = 0; i < maxEnemies; i++) {
            if (arrIVEnemy.get(i).getY() < rectWhiteY || arrIVEnemy.get(i).getY() > rectWhiteY + rectWhiteH - enemySize[0]) {
                arrIVEnemyMove.set(i, -1*arrIVEnemyMove.get(i));
            }
            arrIVEnemy.get(i).setY(arrIVEnemy.get(i).getY() + speed*arrIVEnemyMove.get(i));
        }
    }
    
    /**
     * moving enemies horizontally in the level
     * @param speed
     */
    public static void moveEnemiesHorizontal(double speed) {
        for (int i = 0; i < maxEnemies; i++) {
            if (arrIVEnemy.get(i).getX() < rectWhiteX || arrIVEnemy.get(i).getX() > rectWhiteX + rectWhiteW - enemySize[0]) {
                arrIVEnemyMove.set(i, -1*arrIVEnemyMove.get(i));
            }
            arrIVEnemy.get(i).setX(arrIVEnemy.get(i).getX() + speed*arrIVEnemyMove.get(i));
        }
    }
    
    /**
     * set player position
     * @param x
     * @param y
     */
    public static void setPlayerPosition(int x, int y) {
        Level.getPlayer().setX(x);
        Level.getPlayer().setY(y);
    }
}
