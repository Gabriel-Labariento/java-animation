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

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        drawGrassNoScaling(g2d);
        g2d.setTransform(reset);
    }

    @Override
    public void setColor(Color color) {};
    
    private void drawGrassNoScaling(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        // First blade from the left

        Ellipse2D.Double e = new Ellipse2D.Double((12.5), (87.2), 54.5, 6.9);
        g2d.rotate(Math.toRadians(62.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);



        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double((34.2), (135.7));
        triPoints[1] = new Point2D.Double((8.9), (88.2));
        triPoints[2] = new Point2D.Double((52.8), (117.9));
        Triangle t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Second blade from the left
        e = new Ellipse2D.Double((26.5), (118.3), 95.3, 6.9);
        g2d.rotate(Math.toRadians(-81.9), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
        
        triPoints[0] = new Point2D.Double((31.4), (124));
        triPoints[1] = new Point2D.Double((42.9), (25.6));
        triPoints[2] = new Point2D.Double((56.9), (123.6));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Third blade from the left
        triPoints[0] = new Point2D.Double((47.8), (131.6));
        triPoints[1] = new Point2D.Double((59.2), (45.5));
        triPoints[2] = new Point2D.Double((72.8), (131.4));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        e = new Ellipse2D.Double((66.7), (123.6), 78.5, 6.9);
        g2d.rotate(Math.toRadians(-97.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Fourth blade from the left
        triPoints[0] = new Point2D.Double((81.5), (120.7));
        triPoints[1] = new Point2D.Double((63.5), (4.9));
        triPoints[2] = new Point2D.Double((103.5), (115.2));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Fifth blade from the left
        triPoints[0] = new Point2D.Double((54.6), (123.6));
        triPoints[1] = new Point2D.Double((97.3), (12.5));
        triPoints[2] = new Point2D.Double((92.8), (131.6));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Sixth blade from the left
        triPoints[0] = new Point2D.Double((65.1), (98.8));
        triPoints[1] = new Point2D.Double((115.1), (44.7));
        triPoints[2] = new Point2D.Double((91.2), (115.2));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        // Seventh blade from the left
        triPoints[0] = new Point2D.Double((77.5), (105.4));
        triPoints[1] = new Point2D.Double((128.8), (51.1));
        triPoints[2] = new Point2D.Double((104.3), (120.7));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);
        
        e = new Ellipse2D.Double((100.1), (124), 78.5, 6.9);
        g2d.rotate(Math.toRadians(-70.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Eigth blade from the left
        triPoints[0] = new Point2D.Double((102.7), (115.2));
        triPoints[1] = new Point2D.Double((155.8), (66.4));
        triPoints[2] = new Point2D.Double((122.9), (132.3));
        t = new Triangle(triPoints, color, true);
        t.draw(g2d);
        
        e = new Ellipse2D.Double((118.9), (135.6), 78.5, 6.9);
        g2d.rotate(Math.toRadians(-63.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Base rectangle
        g2d.fill(new Rectangle2D.Double((34.2), (113), 88.8, 24.5));
    }
}
