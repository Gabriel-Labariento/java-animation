/**
        The SceneCanvas class extends the JComponent object from java Swing.
        Its main purpose it to serve as the object where DrawingObjects can
        be drawn. It works with a sceneHandler object to transition the
        scenes appropriately.
   
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
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;


public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;
    private ArrayList<DrawingObject> drawingObjects;
    private SceneHandler sceneHandler;

    /**
     * Initializes the width and height of the sceneCanvas, creates an ArrayList of DrawingObjects, and creates a new SceneHandler.
     * @param w width of the sceneCanvas
     * @param h height of the sceneCanvas
     * @throws UnsupportedAudioFileException when the audio file used is not supported See: http://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/UnsupportedAudioFileException.html
     * @throws IOException when an Input-Output error has occured. See: https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html
     * @throws LineUnavailableException when a line cannot be opened. See: https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/LineUnavailableException.html
     */
    public SceneCanvas(int w, int h) throws UnsupportedAudioFileException,IOException, LineUnavailableException{
        width = w;
        height = h;
        setPreferredSize(new Dimension(width, height));
        drawingObjects = new ArrayList<DrawingObject>();
        sceneHandler = new SceneHandler(this, drawingObjects, width, height);
    }

    /**
     * Draws all the objects in the drawingObjects ArrayList and sets RenderingHints
     * to have ANTIALISING on for smoother graphics. 
     */
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(rh);

        for (DrawingObject drawingObject : drawingObjects) {
            drawingObject.draw(g2d);
        }
    }
    
    /**
     * Gets the drawingObjects ArrayList
     * @return the drawingObjects ArrayList containing the objects to be drawn on the sceneCanvas
     */
    public ArrayList<DrawingObject> getDrawingObjects(){
        return drawingObjects;
    }

    /**
     * Gets the sceneHandler instance of the sceneCanvas
     * @return the sceneHandler in sceneCanvas
     */
    public SceneHandler getSceneHandler(){
        return sceneHandler;
    }
    
    /**
     * Returns the width of the sceneCanvas
     * @return the width of sceneCanvas
     */
    public int getWidth(){
        return width;
    };

}