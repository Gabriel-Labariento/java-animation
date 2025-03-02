/**
        The Cloud class creates a Cloud object and has methods
        for drawing it as it implements DrawingObject. This object
        uses multiple instances of the Circle class to create a
        cloud shape. It is also used to compose the FightCloud
        object.
   
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

public class Cloud implements DrawingObject{
    private double x;
    private double y;
    private double size;
    private Color color;

    /**
     * Initializes the Cloud object's field values to the arguments provided.
     * @param xPosition the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 149.6px by 98.5px
     * @param color the object's color
     */
    public Cloud(double xPosition, double yPosition, double size, Color color){
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

        Circle c = new Circle((5.7), (32), 64, color);
        c.draw(g2d);

        c = new Circle((32.7), (3.2), 64, color);
        c.draw(g2d);

        c = new Circle((48.5), (37.7), 64, color);
        c.draw(g2d);

        c = new Circle((61), (3.2), 64, color);
        c.draw(g2d);

        c = new Circle((91.3), (32), 64, color);
        c.draw(g2d);

        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {};
    
    /**
     * Gets the x-coordinate of the Cloud object
     * @return the x-coordinate of the object's framing rectangle
     */
    public double getX(){
        return x;
    }

    /**
     * Gets the y-coordinate of the Cloud object
     * @return the y-coordinate of the object's framing rectangle
     */
    public double getY(){
        return y;
    }

    
    
}
