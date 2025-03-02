/**
        The Door class creates a Door object and has methods
        for drawing it as it implements DrawingObject. This object
        is seen in scene eight. It has fields for positioning and
        scaling, but transparency is unmodifiable.
   
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

public class Door implements DrawingObject{
    private double x;
    private double y;
    private double size;
    private AlphaComposite ac; // https://docs.oracle.com/javase/8/docs/api/java/awt/AlphaComposite.html

    /**
     * Initializes the Door object's field values to the provided arguments. AlphaComposite value is initialized to 0.3
     * @param xPosition the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object.
     */
    public Door(double xPosition, double yPosition, double size){
        x = xPosition;
        y = yPosition;
        this.size = size;
        ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f); 
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        
        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(735.4, 38.7);
        quadPoints[1] = new Point2D.Double(735.4, 500.3);
        quadPoints[2] = new Point2D.Double(800, 515.4);
        quadPoints[3] = new Point2D.Double(800, 23.9);
        Quadrilateral doorFrame = new Quadrilateral(quadPoints, Color.decode("#556265"), true);
        doorFrame.draw(g2d);

        quadPoints[2] = new Point2D.Double(557.4, 539.7);
        quadPoints[3] = new Point2D.Double(557.4, 0);
        Quadrilateral doorFront = new Quadrilateral(quadPoints, Color.decode("#354649"), true);
        doorFront.draw(g2d);

        quadPoints[0] = new Point2D.Double(552.4, 38.7);
        quadPoints[1] = new Point2D.Double(552.4, 503.2);
        Quadrilateral doorSide = new Quadrilateral(quadPoints, Color.decode("#081a2c"), true);
        doorSide.draw(g2d);

        quadPoints[0] = new Point2D.Double(745.4, 49.6);
        quadPoints[1] = new Point2D.Double(800, 38.7);
        quadPoints[2] = new Point2D.Double(800, 513.9);
        quadPoints[3] = new Point2D.Double(742.8, 500.3);
        Quadrilateral outside = new Quadrilateral(quadPoints, Color.WHITE, true);
        outside.draw(g2d);

        quadPoints[2] = new Point2D.Double(800, 600);
        quadPoints[3] = new Point2D.Double(248, 600);
        Quadrilateral light = new Quadrilateral(quadPoints, Color.WHITE, true);
        g2d.setComposite(ac);
        light.draw(g2d);

        ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f); 
        g2d.setComposite(ac);
        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {};

}
