import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class KeyControls implements KeyListener {
    
    private final int SPACEBARKEYCODE = 32;
    private final int timerDelay = 200;
    private static int sceneCount = 1;
    private int frameDelay;
    private int stepSize;
    private SceneCanvas sceneCanvas;
    private Timer timer1;
    private Timer timer2;
    private TimerTask timerTask1;
    private TimerTask timerTask2;
    private WalkingCat walkingCat;
    private WalkingCat walkingCat2;
    private boolean isAnimating;
    private boolean catsCreated;
    private SceneHandler sceneHandler;
    private ArrayList<DrawingObject> drawingObjects;
    private double xCatPos;
    private double yCatPos;
    private double catSize;

    public KeyControls(SceneCanvas sceneCanvas){
        this.sceneCanvas = sceneCanvas;
        isAnimating = false;
        sceneHandler = sceneCanvas.getSceneHandler();
        drawingObjects = sceneCanvas.getDrawingObjects();
        stepSize = 20;
        frameDelay = 200;
        xCatPos = 446.5;
        }

    @Override
    public void keyTyped(KeyEvent event){};

    @Override
    public void keyPressed(KeyEvent event){
        if ((event.getKeyCode() == SPACEBARKEYCODE) && !isAnimating){
            isAnimating = true;
            //Modify walking cat according to current scene
            changeWalk();
            timer1 = new Timer();
            timerTask1 = new TimerTask(){
                @Override
                public void run(){
                    startAnimation();
                }
            };
            timer1.scheduleAtFixedRate(timerTask1, timerDelay, frameDelay);
        }
    };
 
    @Override
    public void keyReleased(KeyEvent event){
        if (event.getKeyCode() == SPACEBARKEYCODE){
            timer1.cancel();
            timer1.purge();
            isAnimating = false;
            changeWalk();
            sceneCanvas.repaint();
        }
    };

    private void startAnimation(){
        walkingCat = (WalkingCat) drawingObjects.get(1);
        xCatPos += stepSize;

        //Scene 6 Cutscene Animation
        if (xCatPos >= 330 && sceneCount == 6){
            cutScene1();
        }
        else {
            walkingCat.adjustX(stepSize);
            walkingCat.changeFrame();
        }
        
        //Check if cat is out of frame and transition scenes
        if (walkingCat.getX() >= sceneCanvas.getWidth()){
            double excess = sceneCanvas.getWidth() + walkingCat.getCatLength();
            walkingCat.adjustX(-(excess));
            xCatPos -= excess;
            sceneCount++;
            changeWalk();

            if (sceneCount > 9) sceneCount = 1;
            sceneHandler.changeScene(sceneCount);
        }
        sceneCanvas.repaint();
    }

    private void cutScene1(){
        //Make the black cat sit for 5 seconds and move with the white cat after
        xCatPos = 330.3;
        drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));

        catsCreated = false;
        timer2 = new Timer();
        timerTask2 = new TimerTask(){
            @Override
            public void run(){
                if (!catsCreated){
                    drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                    drawingObjects.set(2, new WalkingCat(xCatPos+204.6, 444.8, 0.83, 0, Color.WHITE));
                    catsCreated = true;
                }
                walkingCat = (WalkingCat) drawingObjects.get(1);
                walkingCat2 = (WalkingCat) drawingObjects.get(2);
                walkingCat.adjustX(stepSize);
                walkingCat2.adjustX(stepSize);
                walkingCat.changeFrame();
                walkingCat2.changeFrame();
                sceneCanvas.repaint();
                if (walkingCat.getX() >= sceneCanvas.getWidth()){
                    timer2.cancel();
                    timer2.purge();
                    drawingObjects.remove(2);
                }
            }
        };
        timer2.scheduleAtFixedRate(timerTask2, 5000, frameDelay);
    }



    private void changeWalk(){
        switch (sceneCount){
            case 1:
                if (isAnimating) drawingObjects.set(1, new WalkingCat(xCatPos, 469.9, 0.59, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 434.1, 0.67, Color.decode("#242424")));
                break;
            case 2:
                if (isAnimating) drawingObjects.set(1, new WalkingCat(xCatPos, 452.5, 0.75, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 417.5, 0.78, Color.decode("#242424")));
                break;
            case 3:
                if (isAnimating) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 382.6, 1.02, Color.decode("#242424")));
                break;
            case 4:
                if (isAnimating) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 5:
                if (isAnimating) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 6:
                if (isAnimating) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 7:
                if (isAnimating) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 8:
                if (isAnimating) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 9:
                if (isAnimating) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            }
        }

    public int getSceneCount(){
        return sceneCount;
    }
}
