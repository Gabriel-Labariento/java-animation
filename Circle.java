/**
        The Circle class creates a Circle object and has methods
        for drawing it as it implements DrawingObject. This object
        uses Ellipse2D.Double to create an ellipse of the same
        height and width. This class is a fundamental part of other
        objects in the animation. 
   
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


public class Circle implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;

    /**
     * Initializes the circle's field to the provided arguments.
     * @param xPosition the x-coordinate of the framing rectangle's top-left corner
     * @param yPosition the y-coordinate of the framing rectangle's top-left corner
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 1px by 1px
     * @param color the object's fill and outline color
     */
    public Circle(double xPosition, double yPosition, double size, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(circle);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    };
    
}