import java.awt.*;
import java.awt.geom.*;

public class AngryCat implements DrawingObject {
    private double x, y, size;
    private Color color;

    public AngryCat(double xPositon, double yPosition, double size, Color color){
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
        g2d.translate(x, y);
        g2d.scale(size, size);
        drawHead(g2d);
        drawBody(g2d);
        drawLegs(g2d);
        drawTail(g2d);
        g2d.setTransform(reset);
    }

    private void drawHead(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        // Teeth 
        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double((3.7), (14));
        triPoints[1] = new Point2D.Double((9.3), (15));
        triPoints[2] = new Point2D.Double((4.5), (24.8));
        Triangle teeth = new Triangle(triPoints, color, true);
        teeth.draw(g2d);

        // Head
        Ellipse2D.Double e = new Ellipse2D.Double((4.1), (8), 33.4, 13.7);
        g2d.rotate(Math.toRadians(17.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((37.9), (30.5), 33.4, 15);
        g2d.rotate(Math.toRadians(-159.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((14.8), (39.6), 33.7, 9);
        g2d.rotate(Math.toRadians(-64.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((10.1), (39.4), 33.7, 10.8);
        g2d.rotate(Math.toRadians(-42.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Ear
        triPoints[0] = new Point2D.Double((45.8), (6.6));
        triPoints[1] = new Point2D.Double((43.2), (25.8));
        triPoints[2] = new Point2D.Double((27), (12.7));
        Triangle ear = new Triangle(triPoints, color, true);
        ear.draw(g2d);
    }

    private void drawBody(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        Ellipse2D.Double e = new Ellipse2D.Double((49.5), (13.5), 48, 30.5);
        g2d.rotate(Math.toRadians(72.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((53.1), (33.8), 48, 30.5);
        g2d.rotate(Math.toRadians(72.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
    
        e = new Ellipse2D.Double((30.3), (17.6), 41.9, 30.5);
        g2d.rotate(Math.toRadians(2.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((99.6), (40.7), 48, 30.5);
        g2d.rotate(Math.toRadians(128.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((49.5), (y), 62.3, 58.7);
        g2d.fill(e);
    
        e = new Ellipse2D.Double((101.1), (100.9), 66.7, 14);
        g2d.rotate(Math.toRadians(-107.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((130.6), (42.2), 48, 30.5);
        g2d.rotate(Math.toRadians(128.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        Rectangle2D.Double r = new Rectangle2D.Double((118.3), (47.5), 40.7, 17.8);
        g2d.rotate(Math.toRadians(-136.7), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);    
    }

    private void drawLegs(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        // First leg from the front

        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double((58.4), (119.5));
        quadPoints[1] = new Point2D.Double((36.5), (66.7));
        quadPoints[2] = new Point2D.Double((49.7), (62.8));
        quadPoints[3] = new Point2D.Double((66), (117));
        Quadrilateral frontLegOne = new Quadrilateral(quadPoints, color, true);
        frontLegOne.draw(g2d);

        // Second leg from the front

        quadPoints[0] = new Point2D.Double((63.4), (117));
        quadPoints[1] = new Point2D.Double((54), (63.6));
        quadPoints[2] = new Point2D.Double((72.7), (61.3));
        quadPoints[3] = new Point2D.Double((75.2), (117.8));
        Quadrilateral frontLegTwo = new Quadrilateral(quadPoints, color, true);
        frontLegTwo.draw(g2d);
        
        Ellipse2D.Double foot = new Ellipse2D.Double((77.4), (122.2), 24.8, 7.2);
        g2d.rotate(Math.toRadians(-180), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);

        // Third leg from the front
        quadPoints[0] = new Point2D.Double((102.4), (105.3));
        quadPoints[1] = new Point2D.Double((72.7), (57.9));
        quadPoints[2] = new Point2D.Double((86.4), (49.9));
        quadPoints[3] = new Point2D.Double((110.2), (100.9));
        Quadrilateral hindUpperOne = new Quadrilateral(quadPoints, color, true);
        hindUpperOne.draw(g2d);

        Rectangle2D.Double r = new Rectangle2D.Double((109.1), (99.1), 24.6, 10.3);
        g2d.rotate(Math.toRadians(113.7), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        foot = new Ellipse2D.Double((84.5), (116.7), 15.1, 7.2);
        g2d.fill(foot);

    }

    private void drawTail(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(color);

        Ellipse2D.Double e = new Ellipse2D.Double((124.4), (56.6), 29.1, 27.5);
        g2d.rotate(Math.toRadians(-130.7), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((102.2), (97.7), 72.6, 17.8);
        g2d.rotate(Math.toRadians(-67.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double((105.4), (97.3));
        triPoints[1] = new Point2D.Double((118.5), (95));
        triPoints[2] = new Point2D.Double((115.1), (111.5));

        Triangle tailEnd = new Triangle(triPoints, color, true);
        tailEnd.draw(g2d);
    }
    
}
