/**
        The CatBowl class creates a CatBowl object and has methods
        for drawing it as it implements DrawingObject. This object
        has two instances in scene seven.
   
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

public class CatBowl implements DrawingObject{
    private double x, y, size;
    private Color colorOne, colorTwo;

    /**
     * Initializes the CatBowl object's field to the provided arguments
     * @param xPositon the x-coordinate of the object
     * @param yPosition the y-coordinate of the object
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 133.2px by 44.9px
     * @param colorOne the outside color of the CatBowl
     * @param colorTwo the inside color of the CatBowl
     */
    public CatBowl(double xPositon, double yPosition, double size, Color colorOne, Color colorTwo){
        x = xPositon;
        y = yPosition;
        this.size = size;
        this.colorOne = colorOne;
        this.colorTwo = colorTwo;
    }

    @Override
    public void setColor(Color color) {};

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        
        g2d.setColor(colorOne);
        
        Ellipse2D.Double e = new Ellipse2D.Double((10.1), 0, 113.1, 13.2);
        g2d.fill(e);

        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(0, (37.2));
        quadPoints[1] = new Point2D.Double((9.3), (7.4));
        quadPoints[2] = new Point2D.Double((122.2), (7.4));
        quadPoints[3] = new Point2D.Double((131.6), (37.2));
        Quadrilateral bowl = new Quadrilateral(quadPoints, colorOne, true);
        bowl.draw(g2d);
        
        g2d.setColor(colorTwo);
        e = new Ellipse2D.Double((18.1), (2.8), 97.1, 8.5);
        g2d.fill(e);

        g2d.setColor(colorOne);
        e = new Ellipse2D.Double((0), (31.7), 133.2, 13.2);
        g2d.fill(e);

        g2d.setTransform(reset);
    };

}
