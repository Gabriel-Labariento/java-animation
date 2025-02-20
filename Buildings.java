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
        drawTertiaryBuildings(g2d);
        drawSecondaryBuildings(g2d);
        drawPrimaryBuildings(g2d);
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

        Rectangle2D.Double r3 = new Rectangle2D.Double(size*(x+95.3), size*(y+70.8), size*69.5, size*13.9);
        g2d.rotate(Math.toRadians(90), r3.getX(), r3.getY());
        g2d.fill(r3);
        g2d.setTransform(reset);

        Rectangle2D.Double r4 = new Rectangle2D.Double(size*(x+192.7), size*(y+44.5), size*95.9, size*31.3);
        g2d.rotate(Math.toRadians(90), r4.getX(), r4.getY());
        g2d.fill(r4);
        g2d.setTransform(reset);

        Rectangle2D.Double r5 = new Rectangle2D.Double(size*(x+204.5), size*(y+17.7), size*122.7, size*31.3);
        g2d.rotate(Math.toRadians(90), r5.getX(), r5.getY());
        g2d.fill(r5);
        g2d.setTransform(reset);

    }

    private void drawPrimaryBuildings(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(c1);

        Rectangle2D.Double r = new Rectangle2D.Double(size*(x+15.8), size*(y+70.8), size*69.5, size*15.8);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+37.6), size*(y+63.6), size*76.7, size*23.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+47.7), size*(y+102), size*38.4, size*13);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+77.9), size*(y+67.2), size*73.1, size*25.8);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+88.5), size*(y+78), size*62.3, size*13.2);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+97.2), size*(y+93.4), size*47, size*13.2);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+123.9), size*(y+47.1), size*93.2, size*28.6);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+141.2), size*(y+102), size*38.4, size*19.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+155.7), size*(y+63.6), size*76.7, size*23.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+173.2), size*(y+82.1), size*58.2, size*23.3);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+186.2), size*(y+32.8), size*107.4, size*17.3);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+204.5), size*(y+97.6), size*42.6, size*19.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(size*(x+231), size*(y+58), size*82.3, size*31.3);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

    }
}
