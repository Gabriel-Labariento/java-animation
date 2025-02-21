import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
// import java.awt.geom.*;
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
        drawingObjects.add(new WalkingCat(0, 0, 1, 0, Color.BLACK));
        drawingObjects.add(new Rainbow(200, 200, 1, Color.WHITE));
        sceneHandler = new SceneHandler(drawingObjects);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints( rh);

        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(backgroundColor);
        g2d.fill(background);

        for (DrawingObject drawingObject : drawingObjects) {
            drawingObject.draw(g2d);
        }
    }

    public WalkingCat getWalkingCat(){
        return (WalkingCat) drawingObjects.get(0);
    }

    public int getWidth(){
        return width;
    }

    public SceneHandler getSceneHandler(){
        return sceneHandler;
    }
    
}