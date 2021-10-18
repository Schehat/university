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
    private static Image iCircle = new Image("circle.png");
    public static ImageView iVCircle = new ImageView(iCircle);
    public static ArrayList<Image> arrICircle = new ArrayList<Image>();
    public static ArrayList<ImageView> arrIVCircle = new ArrayList<ImageView>();
    
    public static int maxNeededCircles;
    public static int circlesObtained;
    
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
        
        // clear canvas when switching between levels
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // clear circles
        arrICircle.clear();
        arrIVCircle.clear();
        
        if (Level.getCurrentLevel() == 1) {
            // do not want the game loop of the other level play at background
            tl2.stop();
            tl3.stop();
            tl4.stop();
            tl5.stop();
            tl6.stop();
            
            Level.getPlayer().setX(200);
            Level.getPlayer().setY(300);
            
            // load circles
            maxNeededCircles = 2;
            initilizeCircle();
            
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
            gc.drawImage(arrICircle.get(0), rectWhiteX + rectWhiteW/2 - circleSize[0]/2 - offsetX, 
                    rectWhiteY + rectWhiteH/2 - circleSize[0]/2);
            // need to set correct positions for the imageView to set collision detection
            arrIVCircle.get(0).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 - offsetX);
            arrIVCircle.get(0).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2);
            
            // right circle
            gc.drawImage(arrICircle.get(1), rectWhiteX + rectWhiteW/2 - circleSize[0]/2 + offsetX, 
                    rectWhiteY + rectWhiteH/2 - circleSize[0]/2);
            arrIVCircle.get(1).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 + offsetX);
            arrIVCircle.get(1).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2);

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
            
            Level.getPlayer().setX(200);
            Level.getPlayer().setY(300);
            
            maxNeededCircles = 4;
            initilizeCircle();
            
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
            
            tl2.setCycleCount(Timeline.INDEFINITE);
            tl2.playFromStart();
        } else if (Level.getCurrentLevel() == 3) {     
            tl1.stop();
            tl2.stop();
            tl4.stop();
            tl5.stop();
            tl6.stop();
            
            Level.getPlayer().setX(200);
            Level.getPlayer().setY(300);
            
            maxNeededCircles = 3;
            initilizeCircle();
            
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
            
            tl3.setCycleCount(Timeline.INDEFINITE);
            tl3.playFromStart();
        } else if (Level.getCurrentLevel() == 4) {           
            tl1.stop();
            tl2.stop();
            tl3.stop();
            tl5.stop();
            tl6.stop();
            
            Level.getPlayer().setX(200);
            Level.getPlayer().setY(300);
            
            maxNeededCircles = 4;
            initilizeCircle();
            
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
            
            tl4.setCycleCount(Timeline.INDEFINITE);
            tl4.playFromStart();
        } else if (Level.getCurrentLevel() == 5) {   
            tl1.stop();
            tl2.stop();
            tl3.stop();
            tl4.stop();
            tl6.stop();
            
            Level.getPlayer().setX(200);
            Level.getPlayer().setY(300);
         
            maxNeededCircles = 3;
            initilizeCircle();
            
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
            
            tl5.setCycleCount(Timeline.INDEFINITE);
            tl5.playFromStart();
        } else if (Level.getCurrentLevel() == 6) {      
            tl1.stop();
            tl2.stop();
            tl3.stop();
            tl4.stop();
            tl5.stop();
            
            Level.getPlayer().setX(200);
            Level.getPlayer().setY(300);
            
            maxNeededCircles = 4;
            initilizeCircle();
            
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
            
            tl6.setCycleCount(Timeline.INDEFINITE);
            tl6.playFromStart();
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 1st level
     * @param gc
     */
    public static void runLvl1(GraphicsContext gc) {          
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollisionCircle();
        
        if (Level.getPlayer().getX() > rectRedX) {
            Level.setMaxLevel(2);
            Level.setBtn(Level.getBtnLevel2(), Level.getBtnLevel2().getText(), Level.getBtnHexBlue());   
            Level.getBtnLevel2().setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 2nd level
     * @param gc
     */
    public static void runLvl2(GraphicsContext gc) {          
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollisionCircle();
        
        if (Level.getPlayer().getX() > rectRedX) {
            Level.setMaxLevel(3);
            Level.setBtn(Level.getBtnLevel3(), Level.getBtnLevel3().getText(), Level.getBtnHexBlue());   
            Level.getBtnLevel3().setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 3rd level
     * @param gc
     */
    public static void runLvl3(GraphicsContext gc) {
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollisionCircle();
        
        if (Level.getPlayer().getX() > rectRedX) {
            Level.setMaxLevel(4);
            Level.setBtn(Level.getBtnLevel4(), Level.getBtnLevel4().getText(), Level.getBtnHexBlue());
            Level.getBtnLevel4().setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 4th level
     * @param gc
     */
    public static void runLvl4(GraphicsContext gc) {       
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollisionCircle();
        
        if (Level.getPlayer().getX() > rectRedX) {
            Level.setMaxLevel(5);
            Level.setBtn(Level.getBtnLevel5(), Level.getBtnLevel5().getText(), Level.getBtnHexBlue());
            Level.getBtnLevel5().setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 5th level
     * @param gc
     */
    public static void runLvl5(GraphicsContext gc) {              
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollisionCircle();
        
        if (Level.getPlayer().getX() > rectRedX) {
            Level.setMaxLevel(6);
            Level.setBtn(Level.getBtnLevel6(), Level.getBtnLevel6().getText(), Level.getBtnHexBlue());
            Level.getBtnLevel6().setDisable(false);
        }
    }
    
    /**
     * run game loop to animate level environment & enemies of 6th level
     * @param gc
     */
    public static void runLvl6(GraphicsContext gc) {
        Level.checkKeysPressed();
        checkMovementBorder();
        checkCollisionCircle();
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
        gc.drawImage(arrICircle.get(0), rectWhiteX + offsetX, rectWhiteY + offsetY);
        arrIVCircle.get(0).setX(rectWhiteX + offsetX);
        arrIVCircle.get(0).setY(rectWhiteY + offsetY);
        
        // bottom left
        gc.drawImage(arrICircle.get(1), rectWhiteX + offsetX, rectWhiteY + rectWhiteH - offsetY - circleSize[1]);
        arrIVCircle.get(1).setX(rectWhiteX + offsetX);
        arrIVCircle.get(1).setY(rectWhiteY + rectWhiteH - offsetY - circleSize[1]);
        
        // top right
        gc.drawImage(arrICircle.get(1), rectWhiteX + rectWhiteW - offsetX - circleSize[0], 
                rectWhiteY + offsetY);
        arrIVCircle.get(2).setX(rectWhiteX + rectWhiteW - offsetX - circleSize[0]);
        arrIVCircle.get(2).setY(rectWhiteY + offsetY);
        
        // bottom right
        gc.drawImage(arrICircle.get(1), rectWhiteX + rectWhiteW - offsetX - circleSize[0], 
                rectWhiteY + rectWhiteH - offsetY - circleSize[1]);
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
        gc.drawImage(arrICircle.get(0), rectWhiteX + rectWhiteW/2 - circleSize[0]/2, 
                rectWhiteY + rectWhiteH/2 - circleSize[0]/2);
        arrIVCircle.get(0).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2);
        arrIVCircle.get(0).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2);
        
        if (direction == 0) {
            // left
            gc.drawImage(arrICircle.get(1), rectWhiteX + rectWhiteW/2 - circleSize[0]/2 - offsetX, 
                    rectWhiteY + rectWhiteH/2 - circleSize[0]/2 + offsetY);
            arrIVCircle.get(1).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 - offsetX);
            arrIVCircle.get(1).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2 + offsetY);
            
            // right
            gc.drawImage(arrICircle.get(2), rectWhiteX + rectWhiteW/2 - circleSize[0]/2 + offsetX, 
                    rectWhiteY + rectWhiteH/2 - circleSize[0]/2 - offsetY);
            arrIVCircle.get(2).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 + offsetX);
            arrIVCircle.get(2).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2 - offsetY);
        } else {
            // left
            gc.drawImage(arrICircle.get(1), rectWhiteX + rectWhiteW/2 - circleSize[0]/2 - offsetX, 
                    rectWhiteY + rectWhiteH/2 - circleSize[0]/2 - offsetY);
            arrIVCircle.get(1).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 - offsetX);
            arrIVCircle.get(1).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2 - offsetY);
            
            // right
            gc.drawImage(arrICircle.get(2), rectWhiteX + rectWhiteW/2 - circleSize[0]/2 + offsetX, 
                    rectWhiteY + rectWhiteH/2 - circleSize[0]/2 + offsetY);
            arrIVCircle.get(2).setX(rectWhiteX + rectWhiteW/2 - circleSize[0]/2 + offsetX);
            arrIVCircle.get(2).setY(rectWhiteY + rectWhiteH/2 - circleSize[0]/2 + offsetY);
        }
    }
    
    /**
     * check collision between player & circles
     */
    public static void checkCollisionCircle() {
        for (int i = 0; i < maxNeededCircles; i++) {
            if (Level.getPlayer().getImageView().getBoundsInParent().intersects(arrIVCircle.get(i).getBoundsInParent())) {
                System.out.println(i);
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
     * add images to array object to draw them next
     */
    public static void initilizeCircle() {
        for (int i = 0; i < maxNeededCircles; i++ ) {
            arrICircle.add(new Image("circle.png"));
            arrIVCircle.add(new ImageView(arrICircle.get(i)));
        }
    }
}
