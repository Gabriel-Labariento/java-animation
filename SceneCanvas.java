import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;
    

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
        

        Rectangle2D.Double r = new Rectangle2D.Double(-100,-200,100,200);
        g2d.setColor(Color.BLACK);
        g2d.translate(100, 200);
        g2d.translate(175, 275);
        g2d.translate(-175,-275);
        g2d.fill(r);

    }
}