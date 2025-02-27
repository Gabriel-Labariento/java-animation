import java.awt.*;
import java.awt.geom.*;


public class Scene0 implements DrawingObject {
    private double width;
    private double height;

    public Scene0(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#1f2020"));
        g2d.fill(background);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Segoe Script", Font.PLAIN, 100)); 
        g2d.drawString("don't let go", 100, 325);
        g2d.setFont(new Font("Arial", Font.PLAIN, 15));
        g2d.drawString("HOLD THE SPACEBAR TO MOVE", 280, 550);
    }
}