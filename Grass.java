import java.awt.*;
import java.awt.geom.*;

public class Grass implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;

    public Grass(double xPosition, double yPosition, double size, Color c){
        x = xPosition;
        y = yPosition;
        this.size = size;
        color = c;
    }

    public double getX(){
        return x;
    }

    public void adjustX(double distance){
        x += distance;
    }

    public void draw(Graphics2D g2d){
        
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        // First blade from the left

        Ellipse2D.Double e = new Ellipse2D.Double(size*(x+12.5), size*(y+87.2), size*54.5, size*6.9);
        g2d.rotate(Math.toRadians(62.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double(size*(x+34.2), size*(y+135.7));
        triPoints[1] = new Point2D.Double(size*(x+8.9), size*(y+88.2));
        triPoints[2] = new Point2D.Double(size*(x+52.8), size*(y+117.9));
        Triangle t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Second blade from the left
        e = new Ellipse2D.Double(size*(x+26.5), size*(y+118.3), size*95.3, size*6.9);
        g2d.rotate(Math.toRadians(-81.9), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
        
        triPoints[0] = new Point2D.Double(size*(x+31.4), size*(y+124));
        triPoints[1] = new Point2D.Double(size*(x+42.9), size*(y+25.6));
        triPoints[2] = new Point2D.Double(size*(x+56.9), size*(y+123.6));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Third blade from the left
        triPoints[0] = new Point2D.Double(size*(x+47.8), size*(y+131.6));
        triPoints[1] = new Point2D.Double(size*(x+59.2), size*(y+45.5));
        triPoints[2] = new Point2D.Double(size*(x+72.8), size*(y+131.4));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        e = new Ellipse2D.Double(size*(x+66.7), size*(y+123.6), size*78.5, size*6.9);
        g2d.rotate(Math.toRadians(-97.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Fourth blade from the left
        triPoints[0] = new Point2D.Double(size*(x+81.5), size*(y+120.7));
        triPoints[1] = new Point2D.Double(size*(x+63.5), size*(y+4.9));
        triPoints[2] = new Point2D.Double(size*(x+103.5), size*(y+115.2));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Fifth blade from the left
        triPoints[0] = new Point2D.Double(size*(x+54.6), size*(y+123.6));
        triPoints[1] = new Point2D.Double(size*(x+97.3), size*(y+12.5));
        triPoints[2] = new Point2D.Double(size*(x+92.8), size*(y+131.6));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Sixth blade from the left
        triPoints[0] = new Point2D.Double(size*(x+65.1), size*(y+98.8));
        triPoints[1] = new Point2D.Double(size*(x+115.1), size*(y+44.7));
        triPoints[2] = new Point2D.Double(size*(x+91.2), size*(y+115.2));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Seventh blade from the left
        triPoints[0] = new Point2D.Double(size*(x+77.5), size*(y+105.4));
        triPoints[1] = new Point2D.Double(size*(x+128.8), size*(y+51.1));
        triPoints[2] = new Point2D.Double(size*(x+104.3), size*(y+120.7));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);
        
        e = new Ellipse2D.Double(size*(x+100.1), size*(y+124), size*78.5, size*6.9);
        g2d.rotate(Math.toRadians(-70.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Eigth blade from the left
        triPoints[0] = new Point2D.Double(size*(x+102.7), size*(y+115.2));
        triPoints[1] = new Point2D.Double(size*(x+155.8), size*(y+66.4));
        triPoints[2] = new Point2D.Double(size*(x+122.9), size*(y+132.3));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);
        
        e = new Ellipse2D.Double(size*(x+118.9), size*(y+135.6), size*78.5, size*6.9);
        g2d.rotate(Math.toRadians(-63.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Base rectangle
        g2d.fill(new Rectangle2D.Double(size*(x+34.2), size*(y+113), size*88.8, size*24.5));
    }
}
