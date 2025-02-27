import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;

public class KeyControls implements KeyListener {
    
    private final int SPACEBARKEYCODE = 32;
    private final int timerDelay = 200;
    private static int sceneCount = 1;
    private int frameDelay;
    private int stepSize;
    private SceneCanvas sceneCanvas;
    private Timer timer1;
    private Timer timer2;
    // private Timer timer1;
    // private Timer timer2;
    // private TimerTask timerTask1;
    // private TimerTask timerTask2;
    private Cat walkingCat;
    private WalkingCat walkingCat2;
    private boolean isCatWalking;
    private boolean isCatFighting;
    private boolean isDoneFighting;
    private boolean catsCreated;
    private SceneHandler sceneHandler;
    private ArrayList<DrawingObject> drawingObjects;
    private double xCatPos;
    private double yCatPos;
    private double catSize;

    public KeyControls(SceneCanvas sceneCanvas){
        this.sceneCanvas = sceneCanvas;
        isCatWalking = false;
        isCatFighting = false;
        isDoneFighting = false;
        sceneHandler = sceneCanvas.getSceneHandler();
        drawingObjects = sceneCanvas.getDrawingObjects();
        stepSize = 60;
        frameDelay = 200;
        xCatPos = 446.5;
        }

    @Override
    public void keyTyped(KeyEvent event){};

    @Override
    public void keyPressed(KeyEvent event){
        if ((event.getKeyCode() == SPACEBARKEYCODE) && (!isCatWalking) && (!isCatFighting)){
            isCatWalking = true;
            //Modify walking cat according to current scene
            changeWalk();
            timer1 = new Timer(timerDelay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae){
                    startAnimation();
                }
            });
            timer1.setInitialDelay(timerDelay);
            timer1.start();
        }
    };
 
    @Override
    public void keyReleased(KeyEvent event){
        if (event.getKeyCode() == SPACEBARKEYCODE && (!isCatFighting)){
            timer1.stop();
            isCatWalking = false;
            changeWalk();
            sceneCanvas.repaint();
        }
    };

    private void startAnimation(){
        walkingCat = (Cat) drawingObjects.get(1);
        xCatPos += stepSize;
        
        // Check if cat is out of frame and transition scenes
        if (walkingCat.getX() >= sceneCanvas.getWidth()){
            double excess = sceneCanvas.getWidth() + walkingCat.getCatLength();
            walkingCat.adjustX(-(excess));
            xCatPos -= excess;
            sceneCount++;
            changeWalk();

            // Loop scenes
            if (sceneCount > 9) sceneCount = 1;
            else sceneHandler.changeScene(sceneCount);
        }

        // Scene 4 cat fight animation
        else if ((sceneCount == 4) && (xCatPos >= 200) && (!isCatFighting) && (!isDoneFighting)){
            catFightScene();
        }

        // Scene 6 Cutscene Animation
        else if (xCatPos >= 330 && sceneCount == 6){
            // cutScene1();
        }
        else {
            walkingCat.adjustX(stepSize);
            walkingCat.changeFrame();
        }
        sceneCanvas.repaint();
    }

    private void catFightScene(){
        // Disable other key controls
        isCatFighting = true;
        timer1.stop();

        // Repaint canvas, now with an angry enemy cat
        drawingObjects.set(0, new Scene4(sceneCanvas, sceneCanvas.getWidth(), sceneCanvas.getHeight(), true, false));
        sceneCanvas.repaint();

        // Get the cat and instantiate a new fightcloud
        DrawingObject cat = drawingObjects.get(1);  
        FightCloud fightCloud = new FightCloud(400, 320.6, 1.5);

        // Task 2: Make cloud move
        final int cloudMovesAllowed = 50;        
        Timer cloudMovementTimer = new Timer(50, new ActionListener() {
            int moveCounter = 0;
            int direction = 1;
            
            @Override
            public void actionPerformed(ActionEvent ae){    
                if (moveCounter < cloudMovesAllowed){
                    fightCloud.adjustX(direction * (Math.random() * 10));
                    sceneCanvas.repaint();
                    direction *= -1;
                    moveCounter++;
                } else {
                    drawingObjects.remove(fightCloud);
                    drawingObjects.set(0, new Scene4(sceneCanvas, sceneCanvas.getWidth(), sceneCanvas.getHeight(), true, false));
                    cat.setColor(Color.decode("#242424"));
                    sceneCanvas.repaint();
                    isCatFighting = false;
                    isCatWalking = false;
                    isDoneFighting = true;
                    ((Timer) ae.getSource()).stop();
                }
            }
        });
        
        // Task 1: Make cat transparent and add cloud
        Timer catFightSceneTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                // Make the walkingCat transparent
                cat.setColor(new Color(0, 0, 0, 0));
                sceneCanvas.repaint();

                // Add a fightcloud and animate
                drawingObjects.add(fightCloud);
                cloudMovementTimer.start();
                ((Timer) ae.getSource()).stop();
            }
        });
        catFightSceneTimer.start();
    }
        
        
        
        
            
        

    // private void cutScene1(){
    //     //Make the black cat sit for 5 seconds and move with the white cat after
    //     xCatPos = 330.3;
    //     drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));

    //     catsCreated = false;
    //     timer2 = new Timer();
    //     timerTask2 = new TimerTask(){
    //         @Override
    //         public void run(){
    //             if (!catsCreated){
    //                 drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
    //                 drawingObjects.set(2, new WalkingCat(xCatPos+204.6, 444.8, 0.83, 0, Color.WHITE));
    //                 catsCreated = true;
    //             }
    //             walkingCat = (WalkingCat) drawingObjects.get(1);
    //             walkingCat2 = (WalkingCat) drawingObjects.get(2);
    //             walkingCat.adjustX(stepSize);
    //             walkingCat2.adjustX(stepSize);
    //             walkingCat.changeFrame();
    //             walkingCat2.changeFrame();
    //             sceneCanvas.repaint();
    //             if (walkingCat.getX() >= sceneCanvas.getWidth()){
    //                 timer2.cancel();
    //                 timer2.purge();
    //                 drawingObjects.remove(2);
    //             }
    //         }
    //     };
    //     timer2.scheduleAtFixedRate(timerTask2, 5000, frameDelay);
    // }

    private void changeWalk(){
        // Change y position of cat depending on scene. Change to sittingcat when not key pressed.
        switch (sceneCount){
            case 1:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 469.9, 0.59, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 434.1, 0.67, Color.decode("#242424")));
                break;
            case 2:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 452.5, 0.75, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 417.5, 0.78, Color.decode("#242424")));
                break;
            case 3:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 382.6, 1.02, Color.decode("#242424")));
                break;
            case 4:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 5:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 6:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 7:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 8:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            case 9:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
            }
        }

    public int getSceneCount(){
        return sceneCount;
    }
}
