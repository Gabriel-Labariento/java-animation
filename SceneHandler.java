/**
        The SceneHandler class handles scene transitions. It does so
        by creating new scene objects inside the drawingObjects ArrayList
        based on the passed value of sceneCount. It also handles the 
        audio of the scenes along with the transitions.
   
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
import javax.sound.sampled.*;
import javax.swing.Timer;

public class SceneHandler {
    
    private SceneCanvas sceneCanvas;
    private ArrayList<DrawingObject> drawingObjects;
    private int width;
    private int height;
    private ArrayList<File> bgFiles;
    private ArrayList<AudioInputStream> bgStreams;
    private ArrayList<Clip> bgClips;
    private File squeaksFile;
    private AudioInputStream squeaksStream;
    private Clip squeaksClip;
    private ArrayList<Butterfly> butterflies;
    private Clip clip;
    private Timer butterfliesTimer;
    private Timer mouseTimer;
    private Boolean hasPlayed;
    private Boolean isFirstLoop;
    private double butterflyXend;
    private double mouseXend;

    /**
     * Creates a sceneHandler that manages scenes for the provided sceneCanvas, initializes audio, and starts the animation with a Scene0 object. 
     * @param sceneCanvas the canvas where scenes are displayed
     * @param drawingObjects the ArrayList containing the objects to be drawn
     * @param w the width of the scenes
     * @param h the height of the scenes
     * @throws UnsupportedAudioFileException when the audio file used is not supported See: http://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/UnsupportedAudioFileException.html
     * @throws IOException when an Input-Output error has occured. See: https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html
     * @throws LineUnavailableException when a line cannot be opened. See: https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/LineUnavailableException.html
     */
    public SceneHandler(SceneCanvas sceneCanvas, ArrayList<DrawingObject> drawingObjects, int w, int h) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.sceneCanvas = sceneCanvas;
        this.drawingObjects = drawingObjects;
        width = w;
        height = h;
        hasPlayed = false;
        isFirstLoop = true;
        bgFiles = new ArrayList<>();
        bgStreams = new ArrayList<>();
        bgClips = new ArrayList<>();
        butterflies = new ArrayList<>();

        // Start with Scene0
        drawingObjects.add(new Scene0(width, height));
    }

    /**
     * Changes the scene displayed and audio played based on the value of sceneCount
     * Creates appropriate drawing objects and sets up animations in different scenes 
     * @param sceneCount
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public void changeScene(int sceneCount) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        if (isFirstLoop){
            // Populate the ArrayLists with appropriate files
            for (int i = 0; i < 9; i++){
                bgFiles.add(new File(String.format("%d.wav", i+1)));
                bgStreams.add(AudioSystem.getAudioInputStream(bgFiles.get(i)));
                bgClips.add(AudioSystem.getClip());
            }
            isFirstLoop = false;
        }
        else {
            for (int j = 0; j < 9; j++) {
                bgFiles.set(j, new File(String.format("%d.wav", j+1)));
                bgStreams.set(j, AudioSystem.getAudioInputStream(bgFiles.get(j)));
                bgClips.set(j, AudioSystem.getClip());
            }
        }

        if (!(sceneCount == 0)){
            //Check if music has been played before, if it has stop the currently playing music
            if (hasPlayed){
                clip.stop();
                clip.close();
            } 
            else hasPlayed = true;
            
            clip = bgClips.get(sceneCount-1);
            clip.open(bgStreams.get(sceneCount-1));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        
        switch (sceneCount){
            case 0:
                drawingObjects.set(0, new Scene0(width, height));
                drawingObjects.remove(1);
                isFirstLoop = false;
                break;
            case 1:
                drawingObjects.set(0, new Scene1(width, height));
                drawingObjects.add(new SleepingCat(400, 488.6, 0.66, Color.decode("#242424")));
                break;
            case 2:
                drawingObjects.set(0, new Scene2(width, height));
                drawingObjects.add(new Butterfly(-32.6, 398.2, 0.33, 0, Color.WHITE));
                drawingObjects.add(new Butterfly(20.9, 429.8, 0.23, 0, Color.WHITE));
                drawingObjects.add(new Butterfly(31.6, 362, 0.42, 0, Color.WHITE));
    
                for (int k = 2; k <= 4; k++){
                    butterflies.add((Butterfly) drawingObjects.get(k));
                }

                butterflyXend = -32.6;
                butterfliesTimer = new Timer(300, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae){
                        butterflyXend += 20;
                        for (Butterfly butterfly : butterflies){
                            butterfly.adjustX(20);
                            butterfly.adjustY(-4);
                            butterfly.changeFrame();

                        }
                        if (butterflyXend >= width){
                            //For tracking if the butterflies have gone off screen without relying on getx
                            butterfliesTimer.stop();
                        }
                        sceneCanvas.repaint();
                    }
                });
                butterfliesTimer.start();
                break;
            case 3:
                //Delete left-over effects from previous scene
                for (int l = 0; l < 3; l++){
                    drawingObjects.remove(2);
                    butterflies.remove(0);
                }

                drawingObjects.set(0, new Scene3(width, height));
                drawingObjects.add(new Mouse(-179.5, 496.2, 1.29, Color.decode("#242424")));
                Mouse mouse = (Mouse) drawingObjects.get(2);

                //Make variables for mouse squeaking sound effect
                squeaksFile = new File("squeaks.wav");
                squeaksStream = AudioSystem.getAudioInputStream(squeaksFile);
                squeaksClip = AudioSystem.getClip();
                squeaksClip.open(squeaksStream);
                squeaksClip.start();
                
                mouseXend = -179.5;
                mouseTimer = new Timer(15, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae){
                        mouseXend += 10;
                        mouse.adjustX(10);
                        if (mouseXend >= width){
                            squeaksClip.stop();
                            squeaksClip.close();
                            mouseTimer.stop();

                        }
                        sceneCanvas.repaint();
                    }
                });
                mouseTimer.start();
                break;
            case 4:
                //Delete left-over effects from previous scene
                drawingObjects.remove(2);
                drawingObjects.set(0, new Scene4(width, height));
                drawingObjects.add(new SittingCat(519.5, 377.6, 1.10, Color.decode("#242424")));
                break;
            case 5:
                drawingObjects.remove(2);
                drawingObjects.set(0, new Scene5(width, height));
                break;
            case 6:
                for (int m = 0; m < 5; m++){
                    drawingObjects.remove(2);
                }

                drawingObjects.set(0, new Scene6(width, height));
                drawingObjects.add(new SittingCat(414, 381.5, 1, Color.WHITE));
                break;
            case 7:
                drawingObjects.set(0, new Scene7(width, height));
                break;
            case 8:
                drawingObjects.set(0, new Scene8(width, height));
                break;
            case 9:
                drawingObjects.set(0, new Scene9(width, height));
                break;
        }
    }
}
