/**
        The SittingCat class creates a SittingCat object and has methods
        for drawing it as it implements DrawingObject. This object also
        implements the Cat interface since the main cat will turn into
        a SittingCat when the spacebar is released.
   
        @author Niles Tristan V. Cabrera (240828)
        @author Gabriel Matthew P. Labariento (242425)
        @version 03 March 2025

        We have not discussed the Java language code in my program
        with anyone other than my instructor or the teaching assistants
        assigned to this course.
        We have not used Java language code obtained from another student,
        or any other unauthorized source, either modified or unmodified.
        If any Java language code or documentation used in our program
        was obtained from another source, such as a textbook or website,
        that has been clearly noted with a proper citation in the comments
        of our program.
**/

import java.awt.*;
import java.awt.geom.*;

public class SittingCat implements DrawingObject, Cat{
    private double x;
    private double y;
    private double size;
    private Color color;
    private final int CATLENGTH = 81;

    /**
     * Initializes the object's field values to the arguments provided.
     * @param xPosition the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 81px by 145.4px
     * @param color the cat's color
     */
    public SittingCat(double xPosition, double yPosition, double size, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void adjustX(double distance){
        x += distance;
    }

    @Override
    public double getX(){
        return x;
    }

    @Override
    public void changeFrame() {}

    @Override
    public double getCatLength(){
        return size * CATLENGTH;
    }

    @Override
    public void setIsLimping(boolean isLimping){}

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        drawHead(g2d);
        drawBody(g2d);
        drawTail(g2d);
        g2d.setTransform(reset);
    }

    /**
     * Factors out draing the cat's head
     * @param g2d object to manipulate geometric shapes
     */
    private void drawHead(Graphics2D g2d){
        Point2D.Double[] earOnePoints = new Point2D.Double[3];
        earOnePoints[0] = new Point2D.Double((6.4), (18));
        earOnePoints[1] = new Point2D.Double((15.6), (40.7));
        earOnePoints[2] = new Point2D.Double((29.5), (26.6));
        Triangle earOne = new Triangle(earOnePoints, color, true);

        Point2D.Double[] earTwoPoints = new Point2D.Double[3];
        earTwoPoints[0] = new Point2D.Double((32.4), (25.2));
        earTwoPoints[1] = new Point2D.Double((46.1), 0);
        earTwoPoints[2] = new Point2D.Double((53.4), (27.7));
        Triangle earTwo = new Triangle(earTwoPoints, color, true);

        Circle head = new Circle((15.6), (19.4), 45.4, color);

        earOne.draw(g2d);
        earTwo.draw(g2d);
        head.draw(g2d);
    };

    /**
     * Factors out draing the cat's body
     * @param g2d object to manipulate geometric shapes
     */
    private void drawBody(Graphics2D g2d){
        Ellipse2D.Double e1 = new Ellipse2D.Double((15.6), (51.7), 46.5, 79.6);
        Ellipse2D.Double e2 = new Ellipse2D.Double((7.8), (64.9), 62.8, 77.3);

        g2d.fill(e1);
        g2d.fill(e2);
    };

    /**
     * Factors out draing the cat's tail
     * @param g2d object to manipulate geometric shapes
     */
    private void drawTail(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Ellipse2D.Double e1 = new Ellipse2D.Double((39.7), (131.9), 26.7, 9.8);
        g2d.rotate(Math.toRadians(4.9), e1.getX(), e1.getY());
        g2d.fill(e1);

        g2d.setTransform(reset);

        Ellipse2D.Double e2 = new Ellipse2D.Double((52.1), (136.2), (26.7), (9.8));
        g2d.rotate(Math.toRadians(-18.4), e2.getX(), e2.getY());
        g2d.fill(e2);

        g2d.setTransform(reset);

        Ellipse2D.Double e3 = new Ellipse2D.Double((65.1), (136.9), 18.1, 8.8);
        g2d.rotate(Math.toRadians(-54), e3.getX(), e3.getY());
        g2d.fill(e3);

        g2d.setTransform(reset);

        Ellipse2D.Double e4 = new Ellipse2D.Double((54.5), (119.4), 26.7, 8.8);
        g2d.rotate(Math.toRadians(6.8), e4.getX(), e4.getY());
        g2d.fill(e4);

        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {
        this.color = color;
    };
}
