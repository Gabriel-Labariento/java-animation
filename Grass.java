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

        

    }
}
