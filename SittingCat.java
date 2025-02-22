import java.awt.*;
import java.awt.geom.*;

public class SittingCat implements DrawingObject{
    private double x;
    private double y;
    private double size;
    private Color color;

    public SittingCat(double xPosition, double yPosition, double size, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    public void adjustX(double distance){
        x += distance;
    }

    @Override
    public void draw(Graphics2D g2d){
        drawHead(g2d);
        drawBody(g2d);
        drawTail(g2d);
    }

    private void drawHead(Graphics2D g2d){
        Point2D.Double[] earOnePoints = new Point2D.Double[3];
        earOnePoints[0] = new Point2D.Double(size*(x+6.4), size*(y+18));
        earOnePoints[1] = new Point2D.Double(size*(x+15.6), size*(y+40.7));
        earOnePoints[2] = new Point2D.Double(size*(x+29.5), size*(y+26.6));
        Triangle earOne = new Triangle(earOnePoints, color, true);

        Point2D.Double[] earTwoPoints = new Point2D.Double[3];
        earTwoPoints[0] = new Point2D.Double(size*(x+32.4), size*(y+25.2));
        earTwoPoints[1] = new Point2D.Double(size*(x+46.1), size*y);
        earTwoPoints[2] = new Point2D.Double(size*(x+53.4), size*(y+27.7));
        Triangle earTwo = new Triangle(earTwoPoints, color, true);

        Circle head = new Circle(size*(x+15.6), size*(y+19.4), size*45.4, color);

        earOne.draw(g2d);
        earTwo.draw(g2d);
        head.draw(g2d);
    };

    private void drawBody(Graphics2D g2d){
        Ellipse2D.Double e1 = new Ellipse2D.Double(size*(x+15.6), size*(y+51.7), size*46.5, size*79.6);
        Ellipse2D.Double e2 = new Ellipse2D.Double(size*(x+7.8), size*(y+64.9), size*62.8, size*77.3);

        g2d.fill(e1);
        g2d.fill(e2);
    };

    private void drawTail(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Ellipse2D.Double e1 = new Ellipse2D.Double(size*(x+39.7), size*(y+131.9), size*26.7, size*9.8);
        g2d.rotate(Math.toRadians(4.9), e1.getX(), e1.getY());
        g2d.fill(e1);

        g2d.setTransform(reset);

        Ellipse2D.Double e2 = new Ellipse2D.Double(size*(x+52.1), size*(y+136.2), size*(26.7), size*(9.8));
        g2d.rotate(Math.toRadians(-18.4), e2.getX(), e2.getY());
        g2d.fill(e2);

        g2d.setTransform(reset);

        Ellipse2D.Double e3 = new Ellipse2D.Double(size*(x+65.1), size*(y+136.9), size*18.1, size*8.8);
        g2d.rotate(Math.toRadians(-54), e3.getX(), e3.getY());
        g2d.fill(e3);

        g2d.setTransform(reset);

        Ellipse2D.Double e4 = new Ellipse2D.Double(size*(x+54.5), size*(y+119.4), size*26.7, size*8.8);
        g2d.rotate(Math.toRadians(6.8), e4.getX(), e4.getY());
        g2d.fill(e4);

        g2d.setTransform(reset);
    };
}
