import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.Timer;
import java.io.IOException;
import javax.sound.sampled.*;

public class KeyControls implements KeyListener {
    
    private final int SPACEBARKEYCODE = 32;
    private int timerDelay;
    private static int sceneCount = 0;
    private int frameDelay;
    private int stepSize;
    private int pastDigit;
    private SceneCanvas sceneCanvas;
    private Timer timer1;
    private Cat walkingCat;
    private boolean isCatWalking;
    private boolean isCatFighting;
    private boolean isDoneFighting;
    private boolean isCatMingling;
    private boolean isCatSleeping;
    private boolean catsCreated;
    private boolean dropShiftedUp;
    private Timer sittingCatToSleepingCatTimer;
    private SceneHandler sceneHandler;
    private ArrayList<DrawingObject> drawingObjects;
    private double xCatPos;

    public KeyControls(SceneCanvas sceneCanvas){
        this.sceneCanvas = sceneCanvas;
        isCatWalking = false;
        isCatFighting = false;
        isDoneFighting = false;
        isCatMingling = false;
        isCatSleeping = true;
        dropShiftedUp = false;
        sceneHandler = sceneCanvas.getSceneHandler();
        drawingObjects = sceneCanvas.getDrawingObjects();
        stepSize = 20;
        frameDelay = 200;
        timerDelay = 2000;
        xCatPos = 446.5;
        timer1 = null;
        }

    @Override
    public void keyTyped(KeyEvent event){};

    @Override
    public void keyPressed(KeyEvent event){
        if ((event.getKeyCode() == SPACEBARKEYCODE) && (!isCatWalking) && (!isCatFighting) && (!isCatMingling)){
            isCatWalking = true;

            if (sceneCount == 0){
                sceneCount++;
                try {
                    sceneHandler.changeScene(sceneCount);
                } catch (IOException ex) {
                } catch (LineUnavailableException ex) {
                } catch (UnsupportedAudioFileException ex) {
                }
                sceneCanvas.repaint();

                //Modify walking cat according to current scene

                timer1 = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae){
                        if(isCatSleeping){
                            changeStance();
                            isCatSleeping = false;
                        }
                        startAnimation();
                    }
                });
                timer1.setInitialDelay(timerDelay);
                timer1.start();
            } else {
                changeStance();
                timer1.setInitialDelay(200);
                if (!timer1.isRunning()) timer1.start();
            }   
        }
    };
 
    @Override
    public void keyReleased(KeyEvent event){
        if (event.getKeyCode() == SPACEBARKEYCODE && (!isCatFighting) && (!isCatMingling)){
            if (sceneCount == 9 && isCatSleeping){
                //Reset the boolean to make cat fight scene loopable
                isDoneFighting = false;

                sittingCatToSleepingCatTimer.stop();
                sceneCount = 0;
                try {
                    sceneHandler.changeScene(sceneCount);
                } catch (IOException ex) {
                } catch (LineUnavailableException ex) {
                } catch (UnsupportedAudioFileException ex) {
                }
                sceneCanvas.repaint();
            } 
            
            if (timer1 != null) {
                if (timer1.isRunning()) timer1.stop();
                isCatWalking = false;
                changeStance();
                sceneCanvas.repaint();
            }
        }
    }

    private void startAnimation(){
        if (drawingObjects.size() > 1) walkingCat = (Cat) drawingObjects.get(1);
        stepSize = getStepsize();
        xCatPos += stepSize;

        // Check if cat is out of frame and transition scenes
        if (walkingCat.getX() >= sceneCanvas.getWidth()){
            double excess = sceneCanvas.getWidth() + walkingCat.getCatLength();
            walkingCat.adjustX(-(excess));
            xCatPos -= excess;
            sceneCount++;
            changeStance();

            // Loop scenes
            if (sceneCount > 9) sceneCount = 1;
			else
				try {
					sceneHandler.changeScene(sceneCount);
				} catch (UnsupportedAudioFileException e) {
				} catch (IOException e) {
				} catch (LineUnavailableException e) {
				}
        }
        //LOCAL SCENE HANDLING (ANIMATION)
        // Scene 4 cat fight animation
        else if ((sceneCount == 4) && (xCatPos >= 200) && (!isCatFighting) && (!isDoneFighting)){
            scene4Animation();
        }
        // Scene 5  make cat limp
        else if (sceneCount == 5){
            walkingCat.setIsLimping(true);
            walkingCat.adjustX(stepSize);
            walkingCat.changeFrame();

            //Handles blood drops
            int thirdDigit = ((int)Math.round(xCatPos)/100)%10;
            //Checks for any change in the third digit of xCatPos and if the new third digit is an odd number
            if(pastDigit != thirdDigit && thirdDigit % 2 != 0) {
                pastDigit = thirdDigit;
                if(dropShiftedUp){
                    drawingObjects.add(new Blood(xCatPos-30, 535.3));      
                    dropShiftedUp = false;
                }
                else{
                    drawingObjects.add(new Blood(xCatPos-30, 502.2));
                    dropShiftedUp = true;    
                }
            }
        }
        // Scene 6 Cutscene Animation
        else if ((sceneCount == 6) && (xCatPos >= 182.1) && (!isCatMingling)){
            sceneSixAnimation();
        }
        // Scene 9 Cat to sleep animation
        else if ((sceneCount == 9) && (xCatPos >= 495) && (!isCatSleeping)){
            sceneNineAnimation();
        } 
        else {
            walkingCat.adjustX(stepSize);
            walkingCat.changeFrame();
        }
        sceneCanvas.repaint();
    }

    private void scene4Animation(){
        // Disable other key controls
        isCatFighting = true;
        timer1.stop();

        // Repaint canvas, now with an angry enemy cat
        drawingObjects.set(2, new AngryCat(519.5, 377.6, 1.10, Color.decode("#242424")));
        sceneCanvas.repaint();

        // Get the cat and instantiate a new fightcloud
        DrawingObject cat = drawingObjects.get(1);  
        FightCloud fightCloud = new FightCloud(400, 320.6, 1.5);

        // Task 2: Make cloud move
        final int cloudMovesAllowed = 50;        
        //CHANGE AS INTENDED
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
                    xCatPos = 500;
                    drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                    drawingObjects.set(2, new SleepingCat(562.9, 420, 1, Color.decode("#242424")));

                    sceneCanvas.repaint();
                    isCatFighting = false;
                    isCatWalking = false;
                    isDoneFighting = true;
                    ((Timer) ae.getSource()).stop();
                }
            }
        });
        
        // Task 1: Make cat transparent and add cloud
        Timer scene4Timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                // Make the walkingCat transparent
                cat.setColor(new Color(0, 0, 0, 0));
                sceneCanvas.repaint();

                // Add a fightcloud and animate
                drawingObjects.set(2, fightCloud);
                cloudMovementTimer.start();
                ((Timer) ae.getSource()).stop();
            }
        });
        scene4Timer.start();
    }
        
    private void sceneSixAnimation(){
        timer1.stop();
        isCatMingling = true;

        //Make the black cat sit for 5 seconds and move with the white cat after
        xCatPos = 330.3;
        drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
        
        catsCreated = false;
        
        // Stop when the cats are out of frame, otherwise keep moving
        Timer loverCatsMovementTimer = new Timer(frameDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                Cat loverCatBlack = null;
                Cat loverCatWhite = null;

                if (drawingObjects.size() > 2){
                    loverCatBlack = (Cat) drawingObjects.get(1);
                    loverCatWhite = (Cat) drawingObjects.get(2);
                }

                if ((loverCatBlack != null) && (loverCatBlack.getX() >= sceneCanvas.getWidth())){
                    drawingObjects.remove(2);
                    isCatMingling = false;
                    ((Timer) ae.getSource()).stop();
                    sceneCount++;
                    try {
						sceneHandler.changeScene(sceneCount);
					} catch (UnsupportedAudioFileException e) {
					} catch (IOException e) {
					} catch (LineUnavailableException e) {
					}
                    xCatPos = 0;
                }
                else {
                    loverCatBlack.adjustX(20);
                    loverCatWhite.adjustX(20);
                    loverCatBlack.changeFrame();
                    loverCatWhite.changeFrame();
                }
                sceneCanvas.repaint();
            }
        });

        Timer timer2 = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if (!catsCreated){
                    walkingCat = new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424"));
                    drawingObjects.set(1, (DrawingObject) walkingCat);
                    drawingObjects.set(2, new WalkingCat(xCatPos+204.6, 444.8, 0.83, 0, Color.WHITE));
                    catsCreated = true;
                    sceneCanvas.repaint();
                    ((Timer) ae.getSource()).stop();
                    loverCatsMovementTimer.start();
                }
            }
        });
        timer2.start();
    }

    private void sceneNineAnimation(){
        timer1.stop();
        isCatSleeping = true;

        xCatPos = 495;
        drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
        sceneCanvas.repaint();
        
        sittingCatToSleepingCatTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                drawingObjects.set(1, new SleepingCat(xCatPos, 473.1, 1, Color.decode("#242424")));
                sceneCanvas.repaint();
            }
        });
        sittingCatToSleepingCatTimer.start();
    }

    private void changeStance(){
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
                if (isCatWalking && (!isCatMingling)) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
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

    private int getStepsize(){
        //STEPSIZE HANDLING
        switch (sceneCount){
            case 1, 5:
                return 10;
            case 2, 9:
                return 15;
            case 3:
                return 40;
            default:
                return 20;
        }
    }
}
