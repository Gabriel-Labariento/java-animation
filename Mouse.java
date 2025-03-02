/**
        The Mouse class creates a Mouse object and has methods
        for drawing it as it implements DrawingObject. This object
        appears in scene three as prey to the cat.
   
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

public class Mouse implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    /**
     * Initializes the object's field values to the arguments provided
     * @param xPosition the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 164.4px by 28.6px
     * @param color
     */
    public Mouse(double xPosition, double yPosition, double size, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        drawMouseNoScaling(g2d);

        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {
        this.color = color;
    };
    
    /**
     * Changes the object's position by some given distance along the x-axis
     * @param distance the distance by which the object's position is changed
     */
    public void adjustX(double distance){
        x += distance;
    };

    /**
     * Draws a mouse without the translation and scaling given to the constructor.
     * Called inside the draw method
     * @param g2d the object to manipulate geometric shapes
     */
    private void drawMouseNoScaling(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(color);

        // Tail
        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double((0), (3.3));
        triPoints[1] = new Point2D.Double((23.5), (9.4));
        triPoints[2] = new Point2D.Double((23.3), (7.52));
        Triangle t = new Triangle(triPoints, color, true);
        t.draw(g2d);

        Ellipse2D.Double e = new Ellipse2D.Double((19.1), (7), 14.8, 2.6);
        g2d.fill(e);

        e = new Ellipse2D.Double((23.3), (7.9), 37, 3.2);
        g2d.rotate(Math.toRadians(-10.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((53.1), (1.4), 17.6, 3.2);
        g2d.rotate(Math.toRadians(6), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((61.8), (0.7), 48, 4.7);
        g2d.rotate(Math.toRadians(19.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Body
        e = new Ellipse2D.Double((84.4), (3.3), 48, 23.3);
        g2d.fill(e);
        
        e = new Ellipse2D.Double((113.4), (15.7), 29.5, 12.9);
        g2d.rotate(Math.toRadians(-2.3), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Head
        e = new Ellipse2D.Double((117.1), (11.6), 45.3, 12.9);
        g2d.rotate(Math.toRadians(-10.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Eyes
        e = new Ellipse2D.Double((131.4), (3.7), 7, 12.9);
        g2d.rotate(Math.toRadians(-10.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double((138.4), (1.1), 6, 12.9);
        g2d.rotate(Math.toRadians(-10.5), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
    }

}
