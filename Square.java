
/**
        The Square class creates a Square object and has methods
        for drawing it as it implements DrawingObject. This object
        uses Rectangle2D.Double to create a rectangle of the same
        height and width.
   
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

public class Square implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;

    /**
     * Initializes the object's field values to the arguments provided
     * @param xPosition the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 1px by 1px
     * @param color the object's color
     */
    public Square(double xPosition, double yPosition, double size, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double square = new Rectangle2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(square);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    };
}