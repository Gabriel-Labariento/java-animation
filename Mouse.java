import java.awt.*;
import java.awt.geom.*;

public class Mouse implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    public Mouse(double xPosition, double yPosition, double size, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        drawMouseNoScaling(g2d);

        g2d.setTransform(reset);
    };

    public void adjustX(double distance){
        x += distance;
    };

    private void drawMouseNoScaling(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(color);

        // Tail
        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double(size*(x), size*(y+3.3));
        triPoints[1] = new Point2D.Double(size*(x+23.5), size*(y+9.4));
        triPoints[2] = new Point2D.Double(size*(x+23.3), size*(y+7.52));
        Triangle t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        Ellipse2D.Double e = new Ellipse2D.Double(size*(x+19.1), size*(y+7), size*14.8, size*2.6);
        g2d.fill(e);

        e = new Ellipse2D.Double(size*(x+23.3), size*(y+7.9), size*37, size*3.2);
        g2d.rotate(Math.toRadians(-10.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+53.1), size*(y+1.4), size*17.6, size*3.2);
        g2d.rotate(Math.toRadians(6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+61.8), size*(y+0.7), size*48, size*4.7);
        g2d.rotate(Math.toRadians(19.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Body
        e = new Ellipse2D.Double(size*(x+84.4), size*(y+3.3), size*48, size*23.3);
        g2d.fill(e);
        
        e = new Ellipse2D.Double(size*(x+113.4), size*(y+15.7), size*29.5, size*12.9);
        g2d.rotate(Math.toRadians(-2.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Head
        e = new Ellipse2D.Double(size*(x+117.1), size*(y+11.6), size*45.3, size*12.9);
        g2d.rotate(Math.toRadians(-10.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Eyes
        e = new Ellipse2D.Double(size*(x+131.4), size*(y+3.7), size*7, size*12.9);
        g2d.rotate(Math.toRadians(-10.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+138.4), size*(y+1.1), size*6, size*12.9);
        g2d.rotate(Math.toRadians(-10.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
    }

}
