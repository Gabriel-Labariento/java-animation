import java.awt.*;
import java.awt.geom.*;

public class LimpingCat implements DrawingObject{
    private double x, y, size;
    private Color color;

    public LimpingCat(double xPositon, double yPosition, double size, Color color){
        x = xPositon;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    public void adjustX(double distance){
        x += distance;
    }

    @Override 
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        drawHead(g2d);
        drawBody(g2d);
        drawLegs(g2d);
        drawTail(g2d);

        g2d.setTransform(reset);
    };
    
    @Override
    public void setColor(Color color) {};

    private void drawHead(Graphics2D g2d){
        g2d.setColor(color);
        
        Ellipse2D.Double head = new Ellipse2D.Double((202.3),(13.9), 31.8, 31.1);
        g2d.fill(head);

        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double((212.1), (41.9));
        quadPoints[1] = new Point2D.Double((228.1), (28));
        quadPoints[2] = new Point2D.Double((233.2), (40.1));
        quadPoints[3] = new Point2D.Double((222.5), (49.7));
        Quadrilateral snout = new Quadrilateral(quadPoints, color, true);
        snout.draw(g2d);

        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double((199.1), (19.2));
        triPoints[1] = new Point2D.Double((209.6), 0);
        triPoints[2] = new Point2D.Double((220.1), (19.5));
        Triangle earOne = new Triangle(triPoints, color, true);
        earOne.draw(g2d);

        triPoints[0] = new Point2D.Double((206.8), (16.4));
        triPoints[1] = new Point2D.Double((226.5), (7.8));
        triPoints[2] = new Point2D.Double((224.1), (28.8));
        Triangle earTwo = new Triangle(triPoints, color, true);
        earTwo.draw(g2d);
    }

    private void drawBody(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);
        
        Ellipse2D.Double e = new Ellipse2D.Double((107), (6.6), 113.1, 39.1);
        g2d.fill(e);

        e = new Ellipse2D.Double((43.7), (7.7), 155.4, 50.5);
        g2d.fill(e);

        e = new Ellipse2D.Double((136.2), (22.2), 55.2, 39.1);
        g2d.fill(e);
    
        e = new Ellipse2D.Double((80.6), (20.1), 42.2, 34.2);
        g2d.rotate(Math.toRadians(46.9), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((36.4), (65.9), 45.8, 25.6);
        g2d.rotate(Math.toRadians(-60.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
    }

    private void drawLegs(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        // First leg from the back
        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double((25.7), (73.5));
        quadPoints[1] = new Point2D.Double((50.4), (56.9));
        quadPoints[2] = new Point2D.Double((56.9), (70.8));
        quadPoints[3] = new Point2D.Double((28.9), (81));
        Quadrilateral upperHindOne = new Quadrilateral(quadPoints, color, true);
        upperHindOne.draw(g2d);

        Rectangle2D.Double lowerHindOne = new Rectangle2D.Double((35.5), (73.7), 25.2, 10.1);
        g2d.rotate(Math.toRadians(90), lowerHindOne.getX(), lowerHindOne.getY());
        g2d.fill(lowerHindOne);
        g2d.setTransform(reset);

        Ellipse2D.Double foot = new Ellipse2D.Double((25.5), (95.3), 17.7, 9.3);
        g2d.rotate(Math.toRadians(-2), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);

        // Second leg from the back
        Rectangle2D.Double upperHindTwo = new Rectangle2D.Double((72.7), (83), 38.6, 12);
        g2d.rotate(Math.toRadians(-100), upperHindTwo.getX(), upperHindTwo.getY());
        g2d.fill(upperHindTwo);
        g2d.setTransform(reset);

        Rectangle2D.Double lowerHindTwo = new Rectangle2D.Double((89.9), (101.7), 25.2, 10.1);
        g2d.rotate(Math.toRadians(-135), lowerHindTwo.getX(), lowerHindTwo.getY());
        g2d.fill(lowerHindTwo);
        g2d.setTransform(reset);

        Rectangle2D.Double lowerHindThree = new Rectangle2D.Double((72.2), (75.9), 37, 14.8);
        g2d.rotate(Math.toRadians(-56.7), lowerHindThree.getX(), lowerHindThree.getY());
        g2d.fill(lowerHindThree);
        g2d.setTransform(reset);

        foot = new Ellipse2D.Double((88.2), (94.3), 20.9, 9.9);
        g2d.rotate(Math.toRadians(-2.2), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);

        // Third leg from the back
        quadPoints[0] = new Point2D.Double((151.4), (42.3));
        quadPoints[1] = new Point2D.Double((171.4), (42.3));
        quadPoints[2] = new Point2D.Double((167.4), (87.6));
        quadPoints[3] = new Point2D.Double((154.8), (87.6));
        Quadrilateral frontUpperOne = new Quadrilateral(quadPoints, color, true);
        frontUpperOne.draw(g2d);

        quadPoints[0] = new Point2D.Double((154.8), (87.6));
        quadPoints[1] = new Point2D.Double((167), (87));
        quadPoints[2] = new Point2D.Double((166.6), (103.9));
        quadPoints[3] = new Point2D.Double((160.8), (104.7));
        Quadrilateral frontLowerOne = new Quadrilateral(quadPoints, color, true);
        frontLowerOne.draw(g2d);

        foot = new Ellipse2D.Double((160.4), (98.9), 21, 10);
        g2d.rotate(Math.toRadians(-2.2), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);

        // Fourth leg from the back, first from the front
        Rectangle2D.Double frontLeg = new Rectangle2D.Double((142.8), (50.8), 14.4, 55.6);
        g2d.rotate(Math.toRadians(-47.9), frontLeg.getX(), frontLeg.getY());
        g2d.fill(frontLeg);
        g2d.setTransform(reset);
        
        foot = new Ellipse2D.Double((171.1), (90.4), 26.2, 11.8);
        g2d.rotate(Math.toRadians(-40.7), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);
    }

    private void drawTail(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        Ellipse2D.Double e = new Ellipse2D.Double((14.2), (62.9), 56, 10.9);
        g2d.rotate(Math.toRadians(-51.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((8.7), (65.7), 27.1, 8.9);
        g2d.rotate(Math.toRadians(-41.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(0, (66.7), 27.1, 8.9);
        g2d.rotate(Math.toRadians(-22.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

    }
}
