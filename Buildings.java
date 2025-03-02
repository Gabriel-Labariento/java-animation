/**
        The Buildings class creates a Building object and has methods
        for drawing it as it implements DrawingObject. This object
        is mainly used as a background element in the scenes. It appears
        in all the scenes except scenes seven, eight, and nine.

        @author Niles Tristan V. Cabrera ()
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

public class Buildings implements DrawingObject {
    
    private double x;
    private double y;
    private double size;
    private Color c1;
    private Color c2;
    private Color c3;

    /**
     * Constructor creates a Buldings object, setting the arguments as field values
     * @param xPosition the x-coordinate of the object
     * @param yPosition the y-coordinate of the object
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 231px by 140.7px
     * @param colorOne color of the buildings at the first layer
     * @param colorTwo color of the buildings at the second layer
     * @param colorThree color of the buildings at the third layer
     */
    public Buildings(double xPosition, double yPosition, double size, Color colorOne, Color colorTwo, Color colorThree){
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

        drawTertiaryBuildings(g2d);
        drawSecondaryBuildings(g2d);
        drawPrimaryBuildings(g2d);

        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {
        c1 = color;
    };

    /**
     * Factors out drawing the buildings nearest to the front
     * @param g2d object to manipulate geometric shapes
     */
    private void drawPrimaryBuildings(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        g2d.setColor(c1);

        Rectangle2D.Double r = new Rectangle2D.Double(15.8, 70.8, 69.5, 15.8);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(37.6, 63.6, 76.7, 23.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(47.7, 102, 38.4, 13);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(77.9, 67.2, 73.1, 25.8);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(88.5, 78, 62.3, 13.2);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(97.2, 93.4, 47, 13.2);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(123.9, 47.1, 93.2, 28.6);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(141.2, 102, 38.4, 19.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(155.7, 63.6, 76.7, 23.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(173.2, 82.1, 58.2, 23.3);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(186.2, 32.8, 107.4, 17.3);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(204.5, 97.6, 42.6, 19.1);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        r = new Rectangle2D.Double(231, 58, 82.3, 31.3);
        g2d.rotate(Math.toRadians(90), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

    }

    /**
     * Factors out drawing the buildings in the middle layer
     * @param g2d object to manipulate geometric shapes
     */
    private void drawSecondaryBuildings(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(c2);

        Rectangle2D.Double r1 = new Rectangle2D.Double(18.6, 39.5, 101.2, 12.4);
        g2d.rotate(Math.toRadians(90), r1.getX(), r1.getY());
        g2d.fill(r1);
        g2d.setTransform(reset);

        Rectangle2D.Double r2 = new Rectangle2D.Double(65, 48.4, 92.3, 23.7);
        g2d.rotate(Math.toRadians(90), r2.getX(), r2.getY());
        g2d.fill(r2);
        g2d.setTransform(reset);

        Rectangle2D.Double r3 = new Rectangle2D.Double(95.3, 70.8, 69.5, 13.9);
        g2d.rotate(Math.toRadians(90), r3.getX(), r3.getY());
        g2d.fill(r3);
        g2d.setTransform(reset);

        Rectangle2D.Double r4 = new Rectangle2D.Double(192.7, 44.5, 95.9, 31.3);
        g2d.rotate(Math.toRadians(90), r4.getX(), r4.getY());
        g2d.fill(r4);
        g2d.setTransform(reset);

        Rectangle2D.Double r5 = new Rectangle2D.Double(204.5, 17.7, 122.7, 31.3);
        g2d.rotate(Math.toRadians(90), r5.getX(), r5.getY());
        g2d.fill(r5);
        g2d.setTransform(reset);

    }

    /**
     * Factors out drawing the buildings in the farthest layer
     * @param g2d object to manipulate geometric shapes
     */
    private void drawTertiaryBuildings(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        
        g2d.setColor(c3);
        
        Rectangle2D.Double r1 = new Rectangle2D.Double(108.3, 0, 140.7, 31.3);
        g2d.rotate(Math.toRadians(90), r1.getX(), r1.getY());
        g2d.fill(r1);
        g2d.setTransform(reset);
        
        Rectangle2D.Double r2 = new Rectangle2D.Double(143.4, 51.8, 88.9, 12.9);
        g2d.rotate(Math.toRadians(90), r2.getX(), r2.getY());
        g2d.fill(r2);
        g2d.setTransform(reset);
    };
}
