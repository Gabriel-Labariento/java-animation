/**
        The FeedingCats class creates a FeedingCats object and has methods
        for drawing it as it implements DrawingObject. This object
        appears in scene one and seven.
   
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

    /**
     * Initializes the FeedingCat object's field values to the provided arguments
     * @param xPosition the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 138.6px by 126px
     * @param colorOne the color of the biggest cat
     * @param colorTwo the color of the cat in the middle
     * @param colorThree the color of the leftmost cat
     */
    public FeedingCats(double xPosition, double yPosition, double size, Color colorOne, Color colorTwo, Color colorThree){
        x = xPosition;
        y = yPosition;
        this.size = size;
        c1 = colorOne;
        c2 = colorTwo;
        c3 = colorThree;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        drawCatOne(g2d);
        drawCatTwo(g2d);
        drawCatThree(g2d);

        g2d.setTransform(reset);
    };
    
    @Override
    public void setColor(Color color) {};
    
    /**
     * Factors out drawing the largest cat
     * @param g2d object to manipulate geometric shapes
     */
    private void drawCatOne(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Point2D.Double[] earPoints = new Point2D.Double[3];
        earPoints[0] = new Point2D.Double((24.4), (28));
        earPoints[1] = new Point2D.Double((16.4), (13.6));
        earPoints[2] = new Point2D.Double((32.7), (14.5));
        Triangle earOne = new Triangle(earPoints, c1, true);
        earOne.draw(g2d);

        earPoints[0] = new Point2D.Double((38.1), (10.9));
        earPoints[1] = new Point2D.Double((55.2), (5.6));
        earPoints[2] = new Point2D.Double((49.9), (21.7));
        Triangle earTwo = new Triangle(earPoints, c1, true);
        earTwo.draw(g2d);

        g2d.setColor(c1);

        Circle cirlceOne = new Circle((23.2), (10.6), 28.5, c1);
        cirlceOne.draw(g2d);

        Circle cirlceTwo = new Circle((45.8), (18.2), 28.5, c1);
        cirlceTwo.draw(g2d);

        Ellipse2D.Double e1 = new Ellipse2D.Double((30.4), (18.2), 55.6, 36.5);
        g2d.rotate(Math.toRadians(27.4), e1.getX(), e1.getY());
        g2d.fill(e1);
        g2d.setTransform(reset);

        Ellipse2D.Double e2 = new Ellipse2D.Double((19.5), (54.6), 33.6, 16.4);
        g2d.rotate(Math.toRadians(-9.5), e2.getX(), e2.getY());
        g2d.fill(e2);
        g2d.setTransform(reset);

        Ellipse2D.Double e3 = new Ellipse2D.Double((68.3), (9.4), 73.8, 28.5);
        g2d.rotate(Math.toRadians(27.4), e3.getX(), e3.getY());
        g2d.fill(e3);
        g2d.setTransform(reset);

        Ellipse2D.Double e4 = new Ellipse2D.Double((74.6), (29.9), 72.2, 37.4);
        g2d.rotate(Math.toRadians(33.3), e4.getX(), e4.getY());
        g2d.fill(e4);
        g2d.setTransform(reset);

        Ellipse2D.Double e5 = new Ellipse2D.Double((138.6), (60.2), 39.9, 28.5);
        g2d.rotate(Math.toRadians(123.9), e5.getX(), e5.getY());
        g2d.fill(e5);
        g2d.setTransform(reset);

        Ellipse2D.Double e6 = new Ellipse2D.Double((97.4), (100.8), 27, 14);
        g2d.rotate(Math.toRadians(-57.2), e6.getX(), e6.getY());
        g2d.fill(e6);
        g2d.setTransform(reset);

        Ellipse2D.Double e7 = new Ellipse2D.Double((86.9), (105.2), 28.9, 8.5);
        g2d.rotate(Math.toRadians(-24.4), e7.getX(), e7.getY());
        g2d.fill(e7);
        g2d.setTransform(reset);
    }

    /**
     * Factors out drawing the middle cat
     * @param g2d object to manipulate geometric shapes
     */
    private void drawCatTwo(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Point2D.Double[] earPoints = new Point2D.Double[3];
        earPoints[0] = new Point2D.Double((61.6), (57.4));
        earPoints[1] = new Point2D.Double((62.8), (40.5));
        earPoints[2] = new Point2D.Double((76.2), (50.3));
        Triangle earOne = new Triangle(earPoints, c2, true);
        earOne.draw(g2d);

        earPoints[0] = new Point2D.Double((74.2), (51.3));
        earPoints[1] = new Point2D.Double((90.6), (47.1));
        earPoints[2] = new Point2D.Double((86.5), (64));
        Triangle earTwo = new Triangle(earPoints, c2, true);
        earTwo.draw(g2d);

        g2d.setColor(c2);

        Ellipse2D.Double e1 = new Ellipse2D.Double((64.5), (47.1), 25.8, 22.3);
        g2d.rotate(Math.toRadians(12.2), e1.getX(), e1.getY());
        g2d.fill(e1);
        g2d.setTransform(reset);

        Ellipse2D.Double e2 = new Ellipse2D.Double((77.6), (53.2), 44.9, 22.3);
        g2d.rotate(Math.toRadians(32.2), e2.getX(), e2.getY());
        g2d.fill(e2);
        g2d.setTransform(reset);

        Ellipse2D.Double e3 = new Ellipse2D.Double((81.3), (54.5), 44.9, 46.7);
        g2d.rotate(Math.toRadians(32.2), e3.getX(), e3.getY());
        g2d.fill(e3);
        g2d.setTransform(reset);
    }

    /**
     * Factors out draing the leftmost cat
     * @param g2d object to manipulate geometric shapes
     */
    private void drawCatThree(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Point2D.Double[] earPoints = new Point2D.Double[3];
        earPoints[0] = new Point2D.Double((66.1), (73.5));
        earPoints[1] = new Point2D.Double((78.8), (71.7));
        earPoints[2] = new Point2D.Double((71), (81.6));
        Triangle earOne = new Triangle(earPoints, c3, true);
        earOne.draw(g2d);

        g2d.setColor(c3);

        Ellipse2D.Double e1 = new Ellipse2D.Double((47.9), (74.1), 22.2, 21.9);
        g2d.rotate(Math.toRadians(-29.5), e1.getX(), e1.getY());
        g2d.fill(e1);
        g2d.setTransform(reset);

        Ellipse2D.Double e2 = new Ellipse2D.Double((68.7), (74.3), 13.9, 17);
        g2d.rotate(Math.toRadians(66.5), e2.getX(), e2.getY());
        g2d.fill(e2);
        g2d.setTransform(reset);

        Ellipse2D.Double e3 = new Ellipse2D.Double((59.1), (57.3), 22.2, 28.3);
        g2d.rotate(Math.toRadians(57.5), e3.getX(), e3.getY());
        g2d.fill(e3);
        g2d.setTransform(reset);

        Ellipse2D.Double e4 = new Ellipse2D.Double((54.5), (56.1), 22.2, 43.7);
        g2d.rotate(Math.toRadians(64), e4.getX(), e4.getY());
        g2d.fill(e4);
        g2d.setTransform(reset);

        Ellipse2D.Double e5 = new Ellipse2D.Double((29.1), (56.8), 43.3, 54.6);
        g2d.rotate(Math.toRadians(32.2), e5.getX(), e5.getY());
        g2d.fill(e5);
        g2d.setTransform(reset);

        Ellipse2D.Double e6 = new Ellipse2D.Double((63.5), (91.9), 11.6, 46.7);
        g2d.rotate(Math.toRadians(67.5), e6.getX(), e6.getY());
        g2d.fill(e6);
        g2d.setTransform(reset);

        Ellipse2D.Double e7 = new Ellipse2D.Double((69.2), (87.2), 9.3, 28.3);
        g2d.rotate(Math.toRadians(57.5), e7.getX(), e7.getY());
        g2d.fill(e7);
        g2d.setTransform(reset);
    }

}
