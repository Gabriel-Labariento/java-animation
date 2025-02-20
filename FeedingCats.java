import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class FeedingCats implements DrawingObject{
   
    private double x;
    private double y;
    private double size;
    private Color c1;
    private Color c2;
    private Color c3;

    public FeedingCats(double xPosition, double yPosition, double size, Color colorONe, Color colorTwo, Color colorThree){
        x = xPosition;
        y = yPosition;
        this.size = size;
        c1 = colorONe;
        c2 = colorTwo;
        c3 = colorThree;
    }

    public void draw(Graphics2D g2d){
        drawCatOne(g2d);
        drawCatTwo(g2d);
        drawCatThree(g2d);
    };
    
    public void adjustX(double distance){
        x += distance;
    };

    private void drawCatOne(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Point2D.Double[] earPoints = new Point2D.Double[3];
        earPoints[0] = new Point2D.Double(size*(x+24.4), size*(y+28));
        earPoints[1] = new Point2D.Double(size*(x+16.4), size*(y+13.6));
        earPoints[2] = new Point2D.Double(size*(x+32.7), size*(y+14.5));
        Triangle earOne = new Triangle(earPoints, c1, true);
        earOne.draw(g2d);

        earPoints[0] = new Point2D.Double(size*(x+38.1), size*(y+10.9));
        earPoints[1] = new Point2D.Double(size*(x+55.2), size*(y+5.6));
        earPoints[2] = new Point2D.Double(size*(x+49.9), size*(y+21.7));
        Triangle earTwo = new Triangle(earPoints, c1, true);
        earTwo.draw(g2d);

        g2d.setColor(c1);

        Circle cirlceOne = new Circle(size*(x+23.2), size*(y+10.6), size*28.5, c1);
        cirlceOne.draw(g2d);

        Circle cirlceTwo = new Circle(size*(x+45.8), size*(y+18.2), size*28.5, c1);
        cirlceTwo.draw(g2d);

        Ellipse2D.Double e1 = new Ellipse2D.Double(size*(x+30.4), size*(y+18.2), size*55.6, size*36.5);
        g2d.rotate(Math.toRadians(27.4), e1.getX(), e1.getY());
        g2d.fill(e1);
        g2d.setTransform(reset);

        Ellipse2D.Double e2 = new Ellipse2D.Double(size*(x+19.5), size*(y+54.6), size*33.6, size*16.4);
        g2d.rotate(Math.toRadians(-9.5), e2.getX(), e2.getY());
        g2d.fill(e2);
        g2d.setTransform(reset);

        Ellipse2D.Double e3 = new Ellipse2D.Double(size*(x+68.3), size*(y+9.4), size*73.8, size*28.5);
        g2d.rotate(Math.toRadians(27.4), e3.getX(), e3.getY());
        g2d.fill(e3);
        g2d.setTransform(reset);

        Ellipse2D.Double e4 = new Ellipse2D.Double(size*(x+74.6), size*(y+29.9), size*72.2, size*37.4);
        g2d.rotate(Math.toRadians(33.3), e4.getX(), e4.getY());
        g2d.fill(e4);
        g2d.setTransform(reset);

        Ellipse2D.Double e5 = new Ellipse2D.Double(size*(x+138.6), size*(y+60.2), size*39.9, size*28.5);
        g2d.rotate(Math.toRadians(123.9), e5.getX(), e5.getY());
        g2d.fill(e5);
        g2d.setTransform(reset);

        Ellipse2D.Double e6 = new Ellipse2D.Double(size*(x+97.4), size*(y+100.8), size*27, size*14);
        g2d.rotate(Math.toRadians(-57.2), e6.getX(), e6.getY());
        g2d.fill(e6);
        g2d.setTransform(reset);

        Ellipse2D.Double e7 = new Ellipse2D.Double(size*(x+86.9), size*(y+105.2), size*28.9, size*8.5);
        g2d.rotate(Math.toRadians(-24.4), e7.getX(), e7.getY());
        g2d.fill(e7);
        g2d.setTransform(reset);
    }

    private void drawCatTwo(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Point2D.Double[] earPoints = new Point2D.Double[3];
        earPoints[0] = new Point2D.Double(size*(x+61.6), size*(y+57.4));
        earPoints[1] = new Point2D.Double(size*(x+62.8), size*(y+40.5));
        earPoints[2] = new Point2D.Double(size*(x+76.2), size*(y+50.3));
        Triangle earOne = new Triangle(earPoints, c2, true);
        earOne.draw(g2d);

        earPoints[0] = new Point2D.Double(size*(x+74.2), size*(y+51.3));
        earPoints[1] = new Point2D.Double(size*(x+90.6), size*(y+47.1));
        earPoints[2] = new Point2D.Double(size*(x+86.5), size*(y+64));
        Triangle earTwo = new Triangle(earPoints, c2, true);
        earTwo.draw(g2d);

        g2d.setColor(c2);

        Ellipse2D.Double e1 = new Ellipse2D.Double(size*(x+64.5), size*(y+47.1), size*25.8, size*22.3);
        g2d.rotate(Math.toRadians(12.2), e1.getX(), e1.getY());
        g2d.fill(e1);
        g2d.setTransform(reset);

        Ellipse2D.Double e2 = new Ellipse2D.Double(size*(x+77.6), size*(y+53.2), size*44.9, size*22.3);
        g2d.rotate(Math.toRadians(32.2), e2.getX(), e2.getY());
        g2d.fill(e2);
        g2d.setTransform(reset);

        Ellipse2D.Double e3 = new Ellipse2D.Double(size*(x+81.3), size*(y+54.5), size*44.9, size*46.7);
        g2d.rotate(Math.toRadians(32.2), e3.getX(), e3.getY());
        g2d.fill(e3);
        g2d.setTransform(reset);
    }

    private void drawCatThree(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Point2D.Double[] earPoints = new Point2D.Double[3];
        earPoints[0] = new Point2D.Double(size*(x+66.1), size*(y+73.5));
        earPoints[1] = new Point2D.Double(size*(x+78.8), size*(y+71.7));
        earPoints[2] = new Point2D.Double(size*(x+71), size*(y+81.6));
        Triangle earOne = new Triangle(earPoints, c3, true);
        earOne.draw(g2d);

        g2d.setColor(c3);

        Ellipse2D.Double e1 = new Ellipse2D.Double(size*(x+47.9), size*(y+74.1), size*22.2, size*21.9);
        g2d.rotate(Math.toRadians(-29.5), e1.getX(), e1.getY());
        g2d.fill(e1);
        g2d.setTransform(reset);

        Ellipse2D.Double e2 = new Ellipse2D.Double(size*(x+68.7), size*(y+74.3), size*13.9, size*17);
        g2d.rotate(Math.toRadians(66.5), e2.getX(), e2.getY());
        g2d.fill(e2);
        g2d.setTransform(reset);

        Ellipse2D.Double e3 = new Ellipse2D.Double(size*(x+59.1), size*(y+57.3), size*22.2, size*28.3);
        g2d.rotate(Math.toRadians(57.5), e3.getX(), e3.getY());
        g2d.fill(e3);
        g2d.setTransform(reset);

        Ellipse2D.Double e4 = new Ellipse2D.Double(size*(x+54.5), size*(y+56.1), size*22.2, size*43.7);
        g2d.rotate(Math.toRadians(64), e4.getX(), e4.getY());
        g2d.fill(e4);
        g2d.setTransform(reset);

        Ellipse2D.Double e5 = new Ellipse2D.Double(size*(x+29.1), size*(y+56.8), size*43.3, size*54.6);
        g2d.rotate(Math.toRadians(32.2), e5.getX(), e5.getY());
        g2d.fill(e5);
        g2d.setTransform(reset);

        Ellipse2D.Double e6 = new Ellipse2D.Double(size*(x+63.5), size*(y+91.9), size*11.6, size*46.7);
        g2d.rotate(Math.toRadians(67.5), e6.getX(), e6.getY());
        g2d.fill(e6);
        g2d.setTransform(reset);

        Ellipse2D.Double e7 = new Ellipse2D.Double(size*(x+69.2), size*(y+87.2), size*9.3, size*28.3);
        g2d.rotate(Math.toRadians(57.5), e7.getX(), e7.getY());
        g2d.fill(e7);
        g2d.setTransform(reset);
    }

}
