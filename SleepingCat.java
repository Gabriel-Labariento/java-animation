/**
        The SleepingCat class creates a SleepingCat object and has methods
        for drawing it as it implements DrawingObject. This object is appears
        at the beginning and end of the animation and also in scene four when
        the enemy cat is put to sleep.
   
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

public class SleepingCat implements DrawingObject{
    private double x, y, size;
    private Color color;

    /**
     * Initializes the object's field values to the arguments provided
     * @param xPosition the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 191.7px by 77.4px
     * @param color the object's color
     */
    public SleepingCat(double xPosition, double yPosition, double size, Color color){
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
        drawSleepingCatNoScaling(g2d);
        g2d.setTransform(reset);

    }

    /**
     * Draws the object without the translation and scaling passed to the constructor
     * @param g2d
     */
    private void drawSleepingCatNoScaling(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(color);

        // Ears
        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double(0,37.9);
        triPoints[1] = new Point2D.Double(16, 29.2);
        triPoints[2] = new Point2D.Double(16, 47.4);
        Triangle ear = new Triangle(triPoints, color, true);
        ear.draw(g2d);

        triPoints[0] = new Point2D.Double(32.2, 18.6);
        triPoints[1] = new Point2D.Double(48.2, 9.4);
        triPoints[2] = new Point2D.Double(47.4, 27.6);
        ear = new Triangle(triPoints, color, true);
        ear.draw(g2d);

        // Head
        Ellipse2D.Double e = new Ellipse2D.Double(40.1, 7.2, 45.3, 50.3);
        g2d.rotate(Math.toRadians(47.7), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        // Body
        e = new Ellipse2D.Double(22.2, 20.2, 114.7, 54.4);
        g2d.fill(e);

        e = new Ellipse2D.Double(70.5, 0, 79.7, 77.4);
        g2d.fill(e);

        //Tail
        Rectangle2D.Double r = new Rectangle2D.Double(138, 53.7, 37.6, 8.4);
        g2d.rotate(Math.toRadians(6.6), r.getX(), r.getY());
        g2d.fill(r);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(156.9, 55.6, 33.8, 9.4);
        g2d.rotate(Math.toRadians(4.8), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);

        e = new Ellipse2D.Double(153.2, 46, 40.5, 9.7);
        g2d.rotate(Math.toRadians(18), e.getX(), e.getY());
        g2d.fill(e);
        g2d.setTransform(reset);
    }
    
    @Override
    public void setColor(Color color) {
        this.color = color;
    };
    
}
