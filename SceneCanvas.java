import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

// import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;
    private Color backgroundColor;
    // private SittingCat sittingCat1;
    // private SittingCat sittingCat2;
    private WalkingCat walkingCat;
    private ArrayList<DrawingObject> drawingObjects;

    public SceneCanvas(int w, int h, Color c){
        width = w;
        height = h;
        backgroundColor = c;
        setPreferredSize(new Dimension(width, height));
        // sittingCat1 = new SittingCat(300, 20, 2, Color.BLACK);
        // sittingCat2 = new SittingCat(50, 30, 1.5, Color.BLACK);
        // walkingCat = new WalkingCat(0, 0, 1, 2, Color.BLACK);
        drawingObjects = new ArrayList<DrawingObject>();
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
        // sittingCat1.draw(g2d);
        // sittingCat2.draw(g2d);
    }
}