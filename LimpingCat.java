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
        
        Ellipse2D.Double head = new Ellipse2D.Double(size*(x+202.3),size*(y+13.9), size*31.8, size*31.1);
        g2d.fill(head);

        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(size*(x+212.1), size*(y+41.9));
        quadPoints[1] = new Point2D.Double(size*(x+228.1), size*(y+28));
        quadPoints[2] = new Point2D.Double(size*(x+233.2), size*(y+40.1));
        quadPoints[3] = new Point2D.Double(size*(x+222.5), size*(y+49.7));
        Quadrilateral snout = new Quadrilateral(quadPoints, color, true);
        snout.draw(g2d);

        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double(size*(x+199.1), size*(y+19.2));
        triPoints[1] = new Point2D.Double(size*(x+209.6), size*(y));
        triPoints[2] = new Point2D.Double(size*(x+220.1), size*(y+19.5));
        Triangle earOne = new Triangle(triPoints, color, true);
        earOne.draw(g2d);

        triPoints[0] = new Point2D.Double(size*(x+206.8), size*(y+16.4));
        triPoints[1] = new Point2D.Double(size*(x+226.5), size*(y+7.8));
        triPoints[2] = new Point2D.Double(size*(x+224.1), size*(y+28.8));
        Triangle earTwo = new Triangle(triPoints, color, true);
        earTwo.draw(g2d);
    }

    private void drawBody(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);
        
        Ellipse2D.Double e = new Ellipse2D.Double(size*(x+107), size*(y+6.6), size*113.1, size*39.1);
        g2d.fill(e);

        e = new Ellipse2D.Double(size*(x+43.7), size*(y+7.7), size*155.4, size*50.5);
        g2d.fill(e);

        e = new Ellipse2D.Double(size*(x+136.2), size*(y+22.2), size*55.2, size*39.1);
        g2d.fill(e);
    
        e = new Ellipse2D.Double(size*(x+80.6), size*(y+20.1), size*42.2, size*34.2);
        g2d.rotate(Math.toRadians(46.9), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+36.4), size*(y+65.9), size*45.8, size*25.6);
        g2d.rotate(Math.toRadians(-60.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
    }

    private void drawLegs(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        // First leg from the back
        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(size*(x+25.7), size*(y+73.5));
        quadPoints[1] = new Point2D.Double(size*(x+50.4), size*(y+56.9));
        quadPoints[2] = new Point2D.Double(size*(x+56.9), size*(y+70.8));
        quadPoints[3] = new Point2D.Double(size*(x+28.9), size*(y+81));
        Quadrilateral upperHindOne = new Quadrilateral(quadPoints, color, true);
        upperHindOne.draw(g2d);

        Rectangle2D.Double lowerHindOne = new Rectangle2D.Double(size*(x+35.5), size*(y+73.7), size*25.2, size*10.1);
        g2d.rotate(Math.toRadians(90), lowerHindOne.getX(), lowerHindOne.getY());
        g2d.fill(lowerHindOne);
        g2d.setTransform(reset);

        Ellipse2D.Double foot = new Ellipse2D.Double(size*(x+25.5), size*(y+95.3), size*17.7, size*9.3);
        g2d.rotate(Math.toRadians(-2), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);

        // Second leg from the back
        Rectangle2D.Double upperHindTwo = new Rectangle2D.Double(size*(x+72.7), size*(y+83), size*38.6, size*12);
        g2d.rotate(Math.toRadians(-100), upperHindTwo.getX(), upperHindTwo.getY());
        g2d.fill(upperHindTwo);
        g2d.setTransform(reset);

        Rectangle2D.Double lowerHindTwo = new Rectangle2D.Double(size*(x+89.9), size*(y+101.7), size*25.2, size*10.1);
        g2d.rotate(Math.toRadians(-135), lowerHindTwo.getX(), lowerHindTwo.getY());
        g2d.fill(lowerHindTwo);
        g2d.setTransform(reset);

        Rectangle2D.Double lowerHindThree = new Rectangle2D.Double(size*(x+72.2), size*(y+75.9), size*37, size*14.8);
        g2d.rotate(Math.toRadians(-56.7), lowerHindThree.getX(), lowerHindThree.getY());
        g2d.fill(lowerHindThree);
        g2d.setTransform(reset);

        foot = new Ellipse2D.Double(size*(x+88.2), size*(y+94.3), size*20.9, size*9.9);
        g2d.rotate(Math.toRadians(-2.2), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);

        // Third leg from the back
        quadPoints[0] = new Point2D.Double(size*(x+151.4), size*(y+42.3));
        quadPoints[1] = new Point2D.Double(size*(x+171.4), size*(y+42.3));
        quadPoints[2] = new Point2D.Double(size*(x+167.4), size*(y+87.6));
        quadPoints[3] = new Point2D.Double(size*(x+154.8), size*(y+87.6));
        Quadrilateral frontUpperOne = new Quadrilateral(quadPoints, color, true);
        frontUpperOne.draw(g2d);

        quadPoints[0] = new Point2D.Double(size*(x+154.8), size*(y+87.6));
        quadPoints[1] = new Point2D.Double(size*(x+167), size*(y+87));
        quadPoints[2] = new Point2D.Double(size*(x+166.6), size*(y+103.9));
        quadPoints[3] = new Point2D.Double(size*(x+160.8), size*(y+104.7));
        Quadrilateral frontLowerOne = new Quadrilateral(quadPoints, color, true);
        frontLowerOne.draw(g2d);

        foot = new Ellipse2D.Double(size*(x+160.4), size*(y+98.9), size*21, size*10);
        g2d.rotate(Math.toRadians(-2.2), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);

        // Fourth leg from the back, first from the front
        Rectangle2D.Double frontLeg = new Rectangle2D.Double(size*(x+142.8), size*(y+50.8), size*14.4, size*55.6);
        g2d.rotate(Math.toRadians(-47.9), frontLeg.getX(), frontLeg.getY());
        g2d.fill(frontLeg);
        g2d.setTransform(reset);
        
        foot = new Ellipse2D.Double(size*(x+171.1), size*(y+90.4), size*26.2, size*11.8);
        g2d.rotate(Math.toRadians(-40.7), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);
    }

    private void drawTail(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        Ellipse2D.Double e = new Ellipse2D.Double(size*(x+14.2), size*(y+62.9), size*56, size*10.9);
        g2d.rotate(Math.toRadians(-51.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+8.7), size*(y+65.7), size*27.1, size*8.9);
        g2d.rotate(Math.toRadians(-41.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x), size*(y+66.7), size*27.1, size*8.9);
        g2d.rotate(Math.toRadians(-22.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

    }
}
