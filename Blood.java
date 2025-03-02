/**
        The Blood class creates a Blood object and has methods
        for drawing it as it implements DrawingObject. It paints
        on the canvas three drops of blood at three different
        x-coordinates. The Blood object appears in scene five.

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

public class Blood implements DrawingObject{
    private double x;
    private double y;
    private Color color;

    /**
     * Constructor creates the Blood instance with the arguments as g2D translations
     * @param xPosition the x-position of the first drop of blood
     * @param yPosition the y-position of the first drop of blood
     */
    public Blood(double xPosition, double yPosition){
        x = xPosition;
        y = yPosition;
        color = Color.decode("370000");
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);

        Ellipse2D.Double drop1 = new Ellipse2D.Double(0, 0, 10.5, 5.7);
        Ellipse2D.Double drop2= new Ellipse2D.Double(16.4, 2.9, 26.5, 14.4);
        Ellipse2D.Double drop3= new Ellipse2D.Double(29.6, 2.9, 29.6, 10.7);
        g2d.setColor(color);
        g2d.fill(drop1);
        g2d.fill(drop2);
        g2d.fill(drop3);

        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {
        this.color = color;
    };
    
}
