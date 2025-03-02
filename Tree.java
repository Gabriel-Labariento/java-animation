/**
        The Tree class creates a Tree object and has methods
        for drawing it as it implements DrawingObject. This object
        uses multiple Ellipse2D.Double for composition.  
   
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


public class Tree implements DrawingObject{
    private double x, y, size;
    private Color color;

    /**
     * Initializes the object's field values to the arguments provided
     * @param xPositon the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 255.2px by 277.5px
     * @param color the object's color
     */
    public Tree(double xPositon, double yPosition, double size, Color color){
        x = xPositon;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        drawTreeNoScaling(g2d);
        g2d.setTransform(reset);
    }

    /**
     * Draws the Tree object without the translations and scaling provided to the constructor
     * @param g2d
     */
    private void drawTreeNoScaling(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(color);

        // Tree base
        Ellipse2D.Double e = new Ellipse2D.Double((52.6), (233.2), 97.8, 44.3);
        g2d.fill(e);

        // Stem from left to right
        e = new Ellipse2D.Double((60.6), (140.8), 8, 25.6);
        g2d.rotate(Math.toRadians(38.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((49.9), (153.4), 8, 25.6);
        g2d.rotate(Math.toRadians(32.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((39.4), (167), 8, 25.6);
        g2d.rotate(Math.toRadians(10.7), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((36), (180.7), 8, 19.5);
        g2d.rotate(Math.toRadians(-2.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((35.3), (195.8), 8, 19.5);
        g2d.rotate(Math.toRadians(-39.2), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((44.6), (209.8), 8, 27.2);
        g2d.rotate(Math.toRadians(-80.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((57.1), (214.3), 8, 27.2);
        g2d.rotate(Math.toRadians(-99.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((112.9), (240.1), 21.1, 47.9);
        g2d.rotate(Math.toRadians(156.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Middle stem
        e = new Ellipse2D.Double((101.5), (221.4), 21.1, 35.1);
        g2d.rotate(Math.toRadians(164.6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((80.5), (204.8), 14.6, 35.1);
        g2d.rotate(Math.toRadians(-118.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((112.1), (193.8), 18.7, 30.2);
        g2d.rotate(Math.toRadians(-136.1), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((97.9), (161.1), 18.7, 30.2);
        g2d.rotate(Math.toRadians(-50.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
  
        e = new Ellipse2D.Double((96.4), (137.2), 16.1, 30.2);
        g2d.rotate(Math.toRadians(-10.2), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((122.1), (106.3), 9.6, 38);
        g2d.rotate(Math.toRadians(42.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((106), (118.4), 13.1, 30.2);
        g2d.rotate(Math.toRadians(20.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((139), (98.5), 6.1, 40.1);
        g2d.rotate(Math.toRadians(56.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Right stem
        e = new Ellipse2D.Double((103.5), (189.4), 8.1, 33.3);
        g2d.rotate(Math.toRadians(-49.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((116.9), (203.9), 8.1, 27.1);
        g2d.rotate(Math.toRadians(-72.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((127.2), (209.9), 8.1, 27.1);
        g2d.rotate(Math.toRadians(-83.9), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((146.4), (214.1), 8.1, 27.1);
        g2d.rotate(Math.toRadians(-114.4), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((165.5), (207.3), 8.1, 27.1);
        g2d.rotate(Math.toRadians(-146), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Tree fluff left
        e = new Ellipse2D.Double((0), (126.9), 55.8, 15);
        g2d.fill(e);

        e = new Ellipse2D.Double((40.4), (115), 45.7, 33.2);
        g2d.fill(e);

        e = new Ellipse2D.Double((3.6), (95.6), 73.5, 33.2);
        g2d.fill(e);

        // Tree fluff center
        e = new Ellipse2D.Double((83.9), (43.8), 145, 65.6);
        g2d.fill(e);

        e = new Ellipse2D.Double((145.1), (28.1), 110.1, 53.5);
        g2d.fill(e);

        e = new Ellipse2D.Double((100), (0), 110.1, 47.4);
        g2d.fill(e);

        // Tree fluff right
        e = new Ellipse2D.Double((167.1), (137), 73.5, 39.5);
        g2d.fill(e);

        e = new Ellipse2D.Double((149), (151.2), 30.7, 15.3);
        g2d.fill(e);

        e = new Ellipse2D.Double((153.5), (155.8), 52.7, 32.9);
        g2d.fill(e);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    };
}
