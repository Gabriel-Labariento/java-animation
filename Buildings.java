import java.awt.*;
import java.awt.geom.*;

public class Buildings implements DrawingObject {
    
    private double x;
    private double y;
    private double size;
    private Color c1;
    private Color c2;
    private Color c3;

    public Buildings(double xPosition, double yPosition, double size, Color colorOne, Color colorTwo, Color colorThree){
        x = xPosition;
        y = yPosition;
        this.size = size;
        c1 = colorOne;
        c2 = colorTwo;
        c3 = colorThree;
    }

    public void draw(Graphics2D g2d){

    };

    public void adjustX(double distance){};

    private void drawTertiaryBuildings(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        
        g2d.setColor(c3);
        
        Rectangle2D.Double r1 = new Rectangle2D.Double(size*(x+108.3), size*(y), size*140.7, size*31.3);
        g2d.rotate(Math.toRadians(90), r1.getX(), r1.getY());
        g2d.fill(r1);
        g2d.setTransform(reset);
        
        Rectangle2D.Double r2 = new Rectangle2D.Double(size*(x+143.4), size*(y+51.8), size*88.9, size*12.9);
        g2d.rotate(Math.toRadians(90), r2.getX(), r2.getY());
        g2d.fill(r2);
        g2d.setTransform(reset);
    };

    private void drawSecondaryBuildings(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(c2);

        Rectangle2D.Double r1 = new Rectangle2D.Double(size*(x+18.6), size*(y+39.5), size*101.2, size*12.4);
        g2d.rotate(Math.toRadians(90), r1.getX(), r1.getY());
        g2d.fill(r1);
        g2d.setTransform(reset);

        Rectangle2D.Double r2 = new Rectangle2D.Double(size*(x+65), size*(y+48.4), size*92.3, size*23.7);
        g2d.rotate(Math.toRadians(90), r2.getX(), r2.getY());
        g2d.fill(r2);
        g2d.setTransform(reset);

        Rectangle2D.Double r3 = new Rectangle2D.Double(size*(x+65), size*(y+48.4), size*92.3, size*23.7);
        g2d.rotate(Math.toRadians(90), r2.getX(), r2.getY());
        g2d.fill(r2);
        g2d.setTransform(reset);

    }

}
