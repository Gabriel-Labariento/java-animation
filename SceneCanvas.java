import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;
    private Color backgroundColor;
    private ArrayList<DrawingObject> drawingObjects;
    private SceneHandler sceneHandler;

    public SceneCanvas(int w, int h, Color c) throws UnsupportedAudioFileException,IOException, LineUnavailableException{
        width = w;
        height = h;
        backgroundColor = c;
        setPreferredSize(new Dimension(width, height));
        drawingObjects = new ArrayList<DrawingObject>();
        sceneHandler = new SceneHandler(this, drawingObjects, width, height);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints( rh);

        for (DrawingObject drawingObject : drawingObjects) {
            drawingObject.draw(g2d);
        }
    }
    
    public ArrayList<DrawingObject> getDrawingObjects(){
        return drawingObjects;
    }

    public SceneHandler getSceneHandler(){
        return sceneHandler;
    }

    public int getWidth(){
        return width;
    };

    public int getHeight(){
        return height;
    }
    
}