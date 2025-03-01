import java.awt.*;
import java.awt.geom.*;

public class Butterfly implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private int flyFrame;
    private Color color;

    public Butterfly(double xPosition, double yPosition, double size, int flyFrame, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        if (flyFrame > 1) this.flyFrame = 1;
        else this.flyFrame = flyFrame;
        this.color = color;
    }

    public void adjustX(double distance){
        x += distance;
    }

    public void adjustY(double distance){
        y += distance;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        g2d.setColor(color);

        drawFrames(g2d);
        g2d.setTransform(reset);
    }

    private void drawFrames(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        if (flyFrame == 0){
            Ellipse2D.Double b1 = new Ellipse2D.Double((163.3), (60.5), 58.6, 152.4);
            g2d.rotate(Math.toRadians(109.7), b1.getX(), b1.getY());
            g2d.fill(b1);
            g2d.setTransform(reset);

            Ellipse2D.Double b2 = new Ellipse2D.Double((98.6), (0), 58.6, 115.7);
            g2d.fill(b2);

            Ellipse2D.Double b3 = new Ellipse2D.Double((12), (91.2), 58.6, 115.7);
            g2d.rotate(Math.toRadians(-74.6), b3.getX(), b3.getY());
            g2d.fill(b3);
            g2d.setTransform(reset);

            Ellipse2D.Double b4 = new Ellipse2D.Double((28.6), (132.8), 58.6, 101.1);
            g2d.rotate(Math.toRadians(-84.7), b4.getX(), b4.getY());
            g2d.fill(b4);
            g2d.setTransform(reset);

            Ellipse2D.Double b5 = new Ellipse2D.Double((168.7), (96.9), 83.6, 23.1);
            g2d.rotate(Math.toRadians(144.7), b5.getX(), b5.getY());
            g2d.fill(b5);   
            g2d.setTransform(reset);
        }
        else if (flyFrame == 1){
            Ellipse2D.Double f1 = new Ellipse2D.Double((116.9), (18.9), 96.9, 23.1);
            g2d.rotate(Math.toRadians(144.7), f1.getX(), f1.getY());
            g2d.fill(f1);
            g2d.setTransform(reset);

            Ellipse2D.Double f2 = new Ellipse2D.Double((106.4), (115.5), 43, 97.7);
            g2d.rotate(Math.toRadians(178.4), f2.getX(), f2.getY());
            g2d.fill(f2);
            g2d.setTransform(reset);

            Ellipse2D.Double f3 = new Ellipse2D.Double((46.1), (153.9), 27.1, 97.7);
            g2d.rotate(Math.toRadians(-157.5), f3.getX(), f3.getY());
            g2d.fill(f3);
            g2d.setTransform(reset);

            Ellipse2D.Double f4 = new Ellipse2D.Double((80.1), (48.7), 37, 97.7);
            g2d.rotate(Math.toRadians(46.6), f4.getX(), f4.getY());
            g2d.fill(f4);
            g2d.setTransform(reset);

            Ellipse2D.Double f5 = new Ellipse2D.Double((63.9), (23.8), 43, 97.7);
            g2d.rotate(Math.toRadians(40.8), f5.getX(), f5.getY());
            g2d.fill(f5);
            g2d.setTransform(reset);
        }

        g2d.setTransform(reset);
    }

    public void changeFrame(){
        if (this.flyFrame == 1) this.flyFrame = 0;
        else flyFrame += 1;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public void setColor(Color color) {
    }
}


