/**
        The KeyControls class implements KeyListener and it's three abstract
        methods KeyTyped, KeyPressed, and KeyReleased. KeyControls is the 
        program's main event listener class. It listens for spacebar presses 
        and releases to activate the walking cat animation. It also handles
        triggering scene-specific animations in scene 4, 6, and 9.
   
        @author Niles Tristan V. Cabrera (240828)
        @author Gabriel Matthew P. Labariento (242425)
        @version 03 March 2025

        We have not discussed the Java language code in my program
        with anyone other than my instructor or the teaching assistants
        assigned to this course.
        We have not used Java language code obtained from another student,
        or any other unauthorized source, either modified or unmodified.
        If any Java language code or documentation used in our program
        was obtained from another source, such as a textbook or website,
        that has been clearly noted with a proper citation in the comments
        of our program.
**/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
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
    private Timer timer;
    private Cat walkingCat;
    private boolean isCatWalking;
    private boolean isCatFighting;
    private boolean isDoneFighting;
    private boolean isCatMingling;
    private boolean isCatSleeping;
    private boolean catsCreated;
    private boolean dropShiftedUp;
    private File angryFile;
    private File fightFile;
    private AudioInputStream angryStream;
    private AudioInputStream fightStream;
    private Clip angryClip;
    private Clip fightClip;
    private Timer sittingCatToSleepingCatTimer;
    private SceneHandler sceneHandler;
    private ArrayList<DrawingObject> drawingObjects;
    private double xCatPos;

    /**
     * Initializes the boolean variables needed to describe the initial state of the main cat
     * Initializes the sceneHandler and drawingObjects fields by their respective get methods from sceneCanvas
     * @param sceneCanvas the animation's canvas where objects are drawn. Source of sceneHandler and drawingObjects
     */
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
        timer = null;
        }

    // Prefer to use keyPressed over keyTyped
    @Override
    public void keyTyped(KeyEvent event){};

    /**
     * Listens for a spacebar press and calls different event animations based on the sceneCount and 
     * the cat's current state.
     */
    @Override
    public void keyPressed(KeyEvent event){
        if ((event.getKeyCode() == SPACEBARKEYCODE) && (!isCatWalking) && (!isCatFighting) && (!isCatMingling)){
            isCatWalking = true;

            // After the first click, switch from scene 0 to scene 1
            if (sceneCount == 0){
                sceneCount++;
                try {
                    sceneHandler.changeScene(sceneCount);
                } catch (IOException ex) {
                } catch (LineUnavailableException ex) {
                } catch (UnsupportedAudioFileException ex) {
                }
                sceneCanvas.repaint();

                timer = new Timer(frameDelay, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae){
                        try {
                            if(isCatSleeping){
                                changeStance();
                                isCatSleeping = false;
                            }
                            
                            startAnimation();
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        }
                    }
                });
                timer.setInitialDelay(timerDelay);
                timer.start();
            } else {
                changeStance();
                timer.setInitialDelay(frameDelay);
                if (!timer.isRunning()) timer.start();
            }   
        }
    };
 
    /**
     * Listens for when the spacebar is released. Triggers stopping the cat
     * from walking and looping the scenes after scene nine. 
     */
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
                } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
                }
                sceneCanvas.repaint();
            } 
            
            if (timer != null) {
                if (timer.isRunning()) timer.stop();
                isCatWalking = false;
                changeStance();
                sceneCanvas.repaint();
            }
        }
    }

    /**
     * Handles the animations. It handles checking when the cat is out of frame and
     * transitions the scenes appropriately. It supports looping the scenes. Scene five's
     * walking cat to limping cat transition and scene-specific animations in scenes 
     * 4, 6, and 9 are also handled by this method.
     */
    private void startAnimation() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        if (drawingObjects.size() > 1) walkingCat = (Cat) drawingObjects.get(1);
        stepSize = getStepsize();
        xCatPos += stepSize;

        // Change the scenes whenever the cat get out of frame
        if (walkingCat.getX() >= sceneCanvas.getWidth()){
            double positionOfCatSnout = sceneCanvas.getWidth() + walkingCat.getCatLength();
            walkingCat.adjustX(-(positionOfCatSnout));
            xCatPos -= positionOfCatSnout;
            sceneCount++;
            changeStance();

            // Loop scenes
            if (sceneCount > 9) sceneCount = 1;
			else
				try {
					sceneHandler.changeScene(sceneCount);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				}
        }

        // LOCAL SCENE HANDLING (SCENE SPECIFIC ANIMATIONS)

        // Scene 4 cat fight animation
        else if ((sceneCount == 4) && (xCatPos >= 200) && (!isCatFighting) && (!isDoneFighting)){
            sceneFourAnimation();
        }
        // Scene 5 make cat limp
        else if (sceneCount == 5){
            walkingCat.setIsLimping(true);
            walkingCat.adjustX(stepSize);
            walkingCat.changeFrame();

            //Handles blood drops
            int thirdDigit = ( (int) Math.round(xCatPos) / 100) % 10;

            //Checks for any change in the third digit of xCatPos and if the new third digit is an odd number
            if (pastDigit != thirdDigit && thirdDigit % 2 != 0) {
                pastDigit = thirdDigit;
                if (dropShiftedUp){
                    drawingObjects.add(new Blood(xCatPos-40, 535.3));      
                    dropShiftedUp = false;
                }
                else {
                    drawingObjects.add(new Blood(xCatPos-40, 502.2));
                    dropShiftedUp = true;    
                }
            }
        }
        // Scene 6 lovercats animation
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

    /**
     * A private method called by startAnimation when the main cat in scene four 
     * and is sufficiently close enough to the enemy cat. It simulates a fight 
     * scene between the two cats by using the FightCloud object.
     */
    private void sceneFourAnimation() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        // Disable other key controls
        isCatFighting = true;
        timer.stop();

        // Repaint canvas, now with an angry enemy cat, and add sound effects also
        angryFile = new File("angry.wav");
        angryStream = AudioSystem.getAudioInputStream(angryFile);
        angryClip = AudioSystem.getClip();
        angryClip.open(angryStream);
        angryClip.start();
        drawingObjects.set(2, new AngryCat(519.5, 377.6, 1.10, Color.decode("#242424")));
        sceneCanvas.repaint();

        // Get the cat and instantiate a new fightcloud
        DrawingObject cat = drawingObjects.get(1);  
        FightCloud fightCloud = new FightCloud(400, 320.6, 1.5);

        // Task 2: Make cloud move
        final int cloudMovesAllowed = 50;
        final int delayBetweenCloudMoves = 50;        

        Timer cloudMovementTimer = new Timer(delayBetweenCloudMoves, new ActionListener() {
            int moveCounter = 0;
            int direction = 1; // Determines whether the cloud moves left or right
            
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

                    //End the fight's sound effect
                    fightClip.stop();
                    fightClip.close();

                    sceneCanvas.repaint();
                    isCatFighting = false;
                    isCatWalking = false;
                    isDoneFighting = true;
                    ((Timer) ae.getSource()).stop();
                }
            }
        });
        
        // Task 1: Make cat transparent and add cloud
        Timer sceneFourTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    // Make the walkingCat transparent
                    cat.setColor(new Color(0, 0, 0, 0));
                    sceneCanvas.repaint();
                    
                    //End the angry cat's sound effect
                    angryClip.stop();
                    angryClip.close();
                    
                    // Add a fightcloud, animate, and add sound effects
                    fightFile = new File("fight.wav");
                    fightStream = AudioSystem.getAudioInputStream(fightFile);
                    fightClip = AudioSystem.getClip();
                    fightClip.open(fightStream);
                    fightClip.start();
                    
                    drawingObjects.set(2, fightCloud);
                    cloudMovementTimer.start();
                    ((Timer) ae.getSource()).stop();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                }
            }
        });
        sceneFourTimer.start();
    }
    

    /**
     * A private method called by startAnimation when the main cat is in scene six
     * and is sufficiently close enough to the lover cat. The user then loses control
     * of the cats as they walk off frame.  
     */
    private void sceneSixAnimation(){
        // Disable other key controls
        timer.stop();
        isCatMingling = true;

        // Set the position of the main cat and convert from WalkingCat to SittingCat
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
                    ((Timer) ae.getSource()).stop();
                    sceneCount++;
                    try {
						sceneHandler.changeScene(sceneCount);
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					}
                    xCatPos = -200;
                    isCatWalking = false;
                    isCatMingling = false;
                }
                else {
                    final int loverCatStepSize = 20;
                    loverCatBlack.adjustX(loverCatStepSize);
                    loverCatWhite.adjustX(loverCatStepSize);
                    loverCatBlack.changeFrame();
                    loverCatWhite.changeFrame();
                }
                sceneCanvas.repaint();
            }
        });

        // After 5 seconds of sitting down together, have the cats walk out of frame
        final int loverCatsSittingTime = 8000;
        Timer loverCatsSittingTimer = new Timer(loverCatsSittingTime, new ActionListener() {
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
        loverCatsSittingTimer.start();
    }

    /**
     * A private method called by startAnimation when the main cat is in scene nine
     * and is sufficiently close enough to the right edge of the frame. The sitting cat
     * is converted to a sleeping cat after five seconds.
     */
    private void sceneNineAnimation(){
        timer.stop();
        isCatSleeping = true;

        xCatPos = 495;
        drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
        sceneCanvas.repaint();
        
        final int sittingCatToSleepingCatTime = 5000;
        sittingCatToSleepingCatTimer = new Timer(sittingCatToSleepingCatTime, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                drawingObjects.set(1, new SleepingCat(xCatPos, 473.1, 1, Color.decode("#242424")));
                sceneCanvas.repaint();
            }
        });
        sittingCatToSleepingCatTimer.start();
    }

    /**
     * Changes the x and y position of the cat along with the size depending on the scene count.
     * Also converts the WalkingCat to SittingCat when the spacebar is released and isCatWalking is false.
     * Conversely, converts the SittingCat to WalkingCat when the spacebar is pressed and isCatWalking is true.
     */
    private void changeStance(){
        // Change y position of cat depending on scene. Change to sittingcat when not key pressed.
        switch (sceneCount){
            case 0:
                break;
            case 1:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 469.9, 0.59, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 434.1, 0.67, Color.decode("#242424")));
                break;
            case 2:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 452.5, 0.75, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 417.5, 0.78, Color.decode("#242424")));
                break;
            case 3:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 439.3, 0.88, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 382.6, 1.02, Color.decode("#242424")));
                break;
            case 9:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#1f2020")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#1f2020")));    
            default:
                if (isCatWalking) drawingObjects.set(1, new WalkingCat(xCatPos, 430.7, 0.96, 0, Color.decode("#242424")));
                else drawingObjects.set(1, new SittingCat(xCatPos, 365.1, 1.14, Color.decode("#242424")));
                break;
        }     
    }
    /**
     * Determines far along the x-axis the cat moves depending on the scene
     * @return an integer representing the distance along the x-axis the cat moves for each step
     */
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
