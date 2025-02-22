import java.awt.*;
import java.awt.geom.*;


public class Tree implements DrawingObject{
    private double x, y, size;
    private Color color;

    public Tree(double xPositon, double yPosition, double size, Color color){
        x = xPositon;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    public void adjustX(double distance){
        x += distance;
    }

    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(color);

        // Tree base
        Ellipse2D.Double e = new Ellipse2D.Double(size*(x+52.6), size*(y+233.2), size*97.8, size*44.3);
        g2d.fill(e);

        // Stem from left to right
        e = new Ellipse2D.Double(size*(x+60.6), size*(y+140.8), size*8, size*25.6);
        g2d.rotate(Math.toRadians(38.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+49.9), size*(y+153.4), size*8, size*25.6);
        g2d.rotate(Math.toRadians(32.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+39.4), size*(y+167), size*8, size*25.6);
        g2d.rotate(Math.toRadians(10.7), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+36), size*(y+180.7), size*8, size*19.5);
        g2d.rotate(Math.toRadians(-2.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+35.3), size*(y+195.8), size*8, size*19.5);
        g2d.rotate(Math.toRadians(-39.2), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+44.6), size*(y+209.8), size*8, size*27.2);
        g2d.rotate(Math.toRadians(-80.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+57.1), size*(y+214.3), size*8, size*27.2);
        g2d.rotate(Math.toRadians(-99.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+112.9), size*(y+240.1), size*21.1, size*47.9);
        g2d.rotate(Math.toRadians(156.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Middle stem
        e = new Ellipse2D.Double(size*(x+101.5), size*(y+221.4), size*21.1, size*35.1);
        g2d.rotate(Math.toRadians(164.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+80.5), size*(y+204.8), size*14.6, size*35.1);
        g2d.rotate(Math.toRadians(-118.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+112.1), size*(y+193.8), size*18.7, size*30.2);
        g2d.rotate(Math.toRadians(-136.1), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+97.9), size*(y+161.1), size*18.7, size*30.2);
        g2d.rotate(Math.toRadians(-50.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+96.4), size*(y+137.2), size*16.1, size*30.2);
        g2d.rotate(Math.toRadians(-10.2), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+122.1), size*(y+106.3), size*9.6, size*38);
        g2d.rotate(Math.toRadians(42.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+139), size*(y+98.5), size*6.1, size*40.1);
        g2d.rotate(Math.toRadians(56.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Right stem
        e = new Ellipse2D.Double(size*(x+103.5), size*(y+189.4), size*8.1, size*33.3);
        g2d.rotate(Math.toRadians(-49.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+116.9), size*(y+203.9), size*8.1, size*27.1);
        g2d.rotate(Math.toRadians(-72.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+127.2), size*(y+209.9), size*8.1, size*27.1);
        g2d.rotate(Math.toRadians(-83.9), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+146.4), size*(y+214.1), size*8.1, size*27.1);
        g2d.rotate(Math.toRadians(-114.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+165.5), size*(y+207.3), size*8.1, size*27.1);
        g2d.rotate(Math.toRadians(-146), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Tree fluff left
        e = new Ellipse2D.Double(size*(x), size*(y+126.9), size*55.8, size*15);
        g2d.fill(e);

        e = new Ellipse2D.Double(size*(x+40.4), size*(y+115), size*45.7, size*33.2);
        g2d.fill(e);

        e = new Ellipse2D.Double(size*(x+3.6), size*(y+95.6), size*73.5, size*33.2);
        g2d.fill(e);

        // Tree fluff center
        e = new Ellipse2D.Double(size*(x+83.9), size*(y+43.8), size*145, size*65.6);
        g2d.fill(e);

        e = new Ellipse2D.Double(size*(x+145.1), size*(y+28.1), size*110.1, size*53.5);
        g2d.fill(e);

        e = new Ellipse2D.Double(size*(x+100), size*(y), size*110.1, size*47.4);
        g2d.fill(e);

        // Tree fluff right
        e = new Ellipse2D.Double(size*(x+167.1), size*(y+137), size*73.5, size*39.5);
        g2d.fill(e);

        e = new Ellipse2D.Double(size*(x+149), size*(y+151.2), size*30.7, size*15.3);
        g2d.fill(e);

        e = new Ellipse2D.Double(size*(x+153.5), size*(y+155.8), size*52.7, size*32.9);
        g2d.fill(e);
    }

}
