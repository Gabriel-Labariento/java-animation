import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;

    private WalkingCat walkingCat;

    public SceneCanvas(int w, int h){
        width = w;
        height = h;
        walkingCat = new WalkingCat(Color.BLACK);
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints( rh);

        walkingCat.draw(g2d);
    }
}