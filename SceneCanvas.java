import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;
    private Color backgroundColor;
    private ArrayList<DrawingObject> drawingObjects;
    private SceneHandler sceneHandler;

    public SceneCanvas(int w, int h, Color c){
        width = w;
        height = h;
        backgroundColor = c;
        setPreferredSize(new Dimension(width, height));
        drawingObjects = new ArrayList<DrawingObject>();
        sceneHandler = new SceneHandler(drawingObjects, width, height);
        drawingObjects.add(new WalkingCat(0, 0, 1, 0, Color.BLACK));
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

    public WalkingCat getWalkingCat(){
        return (WalkingCat) drawingObjects.get(1);
    }
    
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public SceneHandler getSceneHandler(){
        return sceneHandler;
    }
    
}