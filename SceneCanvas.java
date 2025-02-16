import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;
    private Triangle t;

    public SceneCanvas(int w, int h){
        width = w;
        height = h;
        
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints( rh);
        
        t.draw(g2d);
    }
}