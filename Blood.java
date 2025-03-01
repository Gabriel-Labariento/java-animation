import java.awt.*;
import java.awt.geom.*;

public class Blood implements DrawingObject{
    private double x;
    private double y;

    public Blood(double xPosition, double yPosition){
        x = xPosition;
        y = yPosition;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);

        Ellipse2D.Double drop1 = new Ellipse2D.Double(0, 0, 10.5, 5.7);
        Ellipse2D.Double drop2= new Ellipse2D.Double(16.4, 2.9, 26.5, 14.4);
        Ellipse2D.Double drop3= new Ellipse2D.Double(29.6, 2.9, 29.6, 10.7);
        g2d.setColor(Color.decode("#370000"));
        g2d.fill(drop1);
        g2d.fill(drop2);
        g2d.fill(drop3);

        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {};
    
    private void drawDrops(Graphics2D g2d){
        
    }
    
    
}
