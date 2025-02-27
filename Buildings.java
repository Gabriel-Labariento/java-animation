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

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        drawTertiaryBuildings(g2d);
        drawSecondaryBuildings(g2d);
        drawPrimaryBuildings(g2d);

        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {};

    private void drawTertiaryBuildings(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        
        g2d.setColor(c3);
        
        Rectangle2D.Double r1 = new Rectangle2D.Double(108.3, 0, 140.7, 31.3);
        g2d.rotate(Math.toRadians(90), r1.getX(), r1.getY());
        g2d.fill(r1);
        g2d.setTransform(reset);
        
        Rectangle2D.Double r2 = new Rectangle2D.Double(143.4, 51.8, 88.9, 12.9);
        g2d.rotate(Math.toRadians(90), r2.getX(), r2.getY());
        g2d.fill(r2);
        g2d.setTransform(reset);
    };

    private void drawSecondaryBuildings(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(c2);

        Rectangle2D.Double r1 = new Rectangle2D.Double(18.6, 39.5, 101.2, 12.4);
        g2d.rotate(Math.toRadians(90), r1.getX(), r1.getY());
        g2d.fill(r1);
        g2d.setTransform(reset);

        Rectangle2D.Double r2 = new Rectangle2D.Double(65, 48.4, 92.3, 23.7);
        g2d.rotate(Math.toRadians(90), r2.getX(), r2.getY());
        g2d.fill(r2);
        g2d.setTransform(reset);

        Rectangle2D.Double r3 = new Rectangle2D.Double(95.3, 70.8, 69.5, 13.9);
        g2d.rotate(Math.toRadians(90), r3.getX(), r3.getY());
        g2d.fill(r3);
        g2d.setTransform(reset);

        Rectangle2D.Double r4 = new Rectangle2D.Double(192.7, 44.5, 95.9, 31.3);
        g2d.rotate(Math.toRadians(90), r4.getX(), r4.getY());
        g2d.fill(r4);
        g2d.setTransform(reset);

        Rectangle2D.Double r5 = new Rectangle2D.Double(204.5, 17.7, 122.7, 31.3);
        g2d.rotate(Math.toRadians(90), r5.getX(), r5.getY());
        g2d.fill(r5);
        g2d.setTransform(reset);

    }

    private void drawPrimaryBuildings(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(c1);

        Rectangle2D.Double r = new Rectangle2D.Double(15.8, 70.8, 69.5, 15.8);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(37.6, 63.6, 76.7, 23.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(47.7, 102, 38.4, 13);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(77.9, 67.2, 73.1, 25.8);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(88.5, 78, 62.3, 13.2);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(97.2, 93.4, 47, 13.2);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(123.9, 47.1, 93.2, 28.6);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(141.2, 102, 38.4, 19.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(155.7, 63.6, 76.7, 23.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(173.2, 82.1, 58.2, 23.3);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(186.2, 32.8, 107.4, 17.3);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(204.5, 97.6, 42.6, 19.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(231, 58, 82.3, 31.3);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

    }
}
