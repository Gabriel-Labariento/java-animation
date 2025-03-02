/**
        The TrashCan class creates a TrashCan object and has methods
        for drawing it as it implements DrawingObject. This object
        uses the Quadrilateral class for composition. 
   
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

public class TrashCan implements DrawingObject {
    private double x, y, size;
    private Color color;

    /**
     * Initializes this object's field values to the arguments provided
     * @param xPositon the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 90.8px by 116.5px
     * @param color the object's color
     */
    public TrashCan(double xPositon, double yPosition, double size, Color color){
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
        g2d.setColor(color);

        // Lid
        Rectangle2D.Double r = new Rectangle2D.Double((17.5), 0, 55.9, 12.3);
        g2d.fill(r);
        r = new Rectangle2D.Double((0.5), (11.8), 90.3, 12.3);
        g2d.fill(r);

        // Body
        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double((22.5), (114.7));
        quadPoints[1] = new Point2D.Double((0.5), (12.7));
        quadPoints[2] = new Point2D.Double((89.9), (12.3));
        quadPoints[3] = new Point2D.Double((66.7), (114.7));
        Quadrilateral body = new Quadrilateral(quadPoints, color, true);
        body.draw(g2d);

        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {
        this.color = color;
    };

}
