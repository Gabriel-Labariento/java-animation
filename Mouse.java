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

    @Override
    public void setColor(Color color) {};
    
    public void adjustX(double distance){
        x += distance;
    };

    private void drawMouseNoScaling(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(color);

        // Tail
        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double((0), (3.3));
        triPoints[1] = new Point2D.Double((23.5), (9.4));
        triPoints[2] = new Point2D.Double((23.3), (7.52));
        Triangle t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        Ellipse2D.Double e = new Ellipse2D.Double((19.1), (7), 14.8, 2.6);
        g2d.fill(e);

        e = new Ellipse2D.Double((23.3), (7.9), 37, 3.2);
        g2d.rotate(Math.toRadians(-10.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((53.1), (1.4), 17.6, 3.2);
        g2d.rotate(Math.toRadians(6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((61.8), (0.7), 48, 4.7);
        g2d.rotate(Math.toRadians(19.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Body
        e = new Ellipse2D.Double((84.4), (3.3), 48, 23.3);
        g2d.fill(e);
        
        e = new Ellipse2D.Double((113.4), (15.7), 29.5, 12.9);
        g2d.rotate(Math.toRadians(-2.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Head
        e = new Ellipse2D.Double((117.1), (11.6), 45.3, 12.9);
        g2d.rotate(Math.toRadians(-10.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Eyes
        e = new Ellipse2D.Double((131.4), (3.7), 7, 12.9);
        g2d.rotate(Math.toRadians(-10.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((138.4), (1.1), 6, 12.9);
        g2d.rotate(Math.toRadians(-10.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
    }

}
