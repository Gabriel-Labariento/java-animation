import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

// import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;
    private Color backgroundColor;
    private WalkingCat walkingCat;
    private ArrayList<DrawingObject> drawingObjects;

    public SceneCanvas(int w, int h, Color c){
        width = w;
        height = h;
        backgroundColor = c;
        setPreferredSize(new Dimension(width, height));
        walkingCat = new WalkingCat(0, 410.5, 1, 2, Color.BLACK);
        // drawingObjects = new ArrayList<DrawingObject>();
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

        walkingCat.draw(g2d);
    }

    public WalkingCat getWalkingCat(){
        return walkingCat;
    }

    public int getWidth(){
        return width;
    }
    
}