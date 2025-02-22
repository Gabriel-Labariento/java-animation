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
        drawHead(g2d);
        drawBody(g2d);
        drawLegs(g2d);
        drawTail(g2d);
    }

    private void drawHead(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        // Teeth 
        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double(size*(x+3.7), size*(y+14));
        triPoints[1] = new Point2D.Double(size*(x+9.3), size*(y+15));
        triPoints[2] = new Point2D.Double(size*(x+4.5), size*(y+24.8));
        Triangle teeth = new Triangle(triPoints, color, true);
        teeth.draw(g2d);

        // Head
        Ellipse2D.Double e = new Ellipse2D.Double(size*(x+4.1), size*(y+8), size*33.4, size*13.7);
        g2d.rotate(Math.toRadians(17.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+37.9), size*(y+30.5), size*33.4, size*15);
        g2d.rotate(Math.toRadians(-159.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+14.8), size*(y+39.6), size*33.7, size*9);
        g2d.rotate(Math.toRadians(-64.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+10.1), size*(y+39.4), size*33.7, size*10.8);
        g2d.rotate(Math.toRadians(-42.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Ear
        triPoints[0] = new Point2D.Double(size*(x+45.8), size*(y+6.6));
        triPoints[1] = new Point2D.Double(size*(x+43.2), size*(y+25.8));
        triPoints[2] = new Point2D.Double(size*(x+27), size*(y+12.7));
        Triangle ear = new Triangle(triPoints, color, true);
        ear.draw(g2d);
    }

    private void drawBody(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        Ellipse2D.Double e = new Ellipse2D.Double(size*(x+49.5), size*(y+13.5), size*48, size*30.5);
        g2d.rotate(Math.toRadians(72.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+53.1), size*(y+33.8), size*48, size*30.5);
        g2d.rotate(Math.toRadians(72.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
    
        e = new Ellipse2D.Double(size*(x+30.3), size*(y+17.6), size*41.9, size*30.5);
        g2d.rotate(Math.toRadians(2.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+99.6), size*(y+40.7), size*48, size*30.5);
        g2d.rotate(Math.toRadians(128.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+49.5), size*(y), size*62.3, size*58.7);
        g2d.fill(e);
    
        e = new Ellipse2D.Double(size*(x+101.1), size*(y+100.9), size*66.7, size*14);
        g2d.rotate(Math.toRadians(-107.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+130.6), size*(y+42.2), size*48, size*30.5);
        g2d.rotate(Math.toRadians(128.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        Rectangle2D.Double r = new Rectangle2D.Double(size*(x+118.3), size*(y+47.5), size*40.7, size*17.8);
        g2d.rotate(Math.toRadians(-136.7), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);    
    }

    private void drawLegs(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(color);

        // First leg from the front

        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(size*(x+58.4), size*(y+119.5));
        quadPoints[1] = new Point2D.Double(size*(x+36.5), size*(y+66.7));
        quadPoints[2] = new Point2D.Double(size*(x+49.7), size*(y+62.8));
        quadPoints[3] = new Point2D.Double(size*(x+66), size*(y+117));
        Quadrilateral frontLegOne = new Quadrilateral(quadPoints, color, true);
        frontLegOne.draw(g2d);

        // Second leg from the front

        quadPoints[0] = new Point2D.Double(size*(x+63.4), size*(y+117));
        quadPoints[1] = new Point2D.Double(size*(x+54), size*(y+63.6));
        quadPoints[2] = new Point2D.Double(size*(x+72.7), size*(y+61.3));
        quadPoints[3] = new Point2D.Double(size*(x+75.2), size*(y+117.8));
        Quadrilateral frontLegTwo = new Quadrilateral(quadPoints, color, true);
        frontLegTwo.draw(g2d);
        
        Ellipse2D.Double foot = new Ellipse2D.Double(size*(x+77.4), size*(y+122.2), size*24.8, size*7.2);
        g2d.rotate(Math.toRadians(-180), foot.getX(), foot.getY());
        g2d.fill(foot);
        g2d.setTransform(reset);

        // Third leg from the front
        quadPoints[0] = new Point2D.Double(size*(x+102.4), size*(y+105.3));
        quadPoints[1] = new Point2D.Double(size*(x+72.7), size*(y+57.9));
        quadPoints[2] = new Point2D.Double(size*(x+86.4), size*(y+49.9));
        quadPoints[3] = new Point2D.Double(size*(x+110.2), size*(y+100.9));
        Quadrilateral hindUpperOne = new Quadrilateral(quadPoints, color, true);
        hindUpperOne.draw(g2d);

        Rectangle2D.Double r = new Rectangle2D.Double(size*(x+109.1), size*(y+99.1), size*24.6, size*10.3);
        g2d.rotate(Math.toRadians(113.7), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        foot = new Ellipse2D.Double(size*(x+84.5), size*(y+116.7), size*15.1, size*7.2);
        g2d.fill(foot);

    }

    private void drawTail(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(color);

        Ellipse2D.Double e = new Ellipse2D.Double(size*(x+124.4), size*(y+56.6), size*29.1, size*27.5);
        g2d.rotate(Math.toRadians(-130.7), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(size*(x+102.2), size*(y+97.7), size*72.6, size*17.8);
        g2d.rotate(Math.toRadians(-67.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double(size*(x+105.4), size*(y+97.3));
        triPoints[1] = new Point2D.Double(size*(x+118.5), size*(y+95));
        triPoints[2] = new Point2D.Double(size*(x+115.1), size*(y+111.5));

        Triangle tailEnd = new Triangle(triPoints, color, true);
        tailEnd.draw(g2d);
    }
    
}
