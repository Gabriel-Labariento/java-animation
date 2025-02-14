import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;
    private Square s;

    public SceneCanvas(int w, int h){
        width = w;
        height = h;
        s = new Square(10, 10, 50, Color.black);
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints( rh);
        
        s.draw(g2d);
        


        // Rectangle2D.Double r = new Rectangle2D.Double(0,0,width,height);
        // g2d.setColor(new Color(100, 149, 237));
        // g2d.fill(r);

        // Ellipse2D.Double e = new Ellipse2D.Double(200,75,100,100);
        // g2d.setColor(Color.BLUE);
        // g2d.fill(e);

        // Line2D.Double l = new Line2D.Double(100,250,300,75);
        // g2d.setColor(Color.BLACK);
        // g2d.draw(l);

    }
}