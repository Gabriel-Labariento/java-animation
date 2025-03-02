/**
        The Quadrilateral class creates a Quadrilateral object and
        has methods for drawing it as it implements DrawingObject. 
        This object is created using four Point2D.Double objects that
        serve as the shape's vertices. The Quadrilateral class is a
        fundamental shape in composing more complicated objects such 
        as WalkingCat.
   
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

public class Quadrilateral implements DrawingObject {
    private Point2D.Double[] points;
    private Color color;
    private boolean fill;

    /**
     * Initializes the object's field values to the arguments provided
     * @param points an array of four Point2D.Double objects that will serve as the vertices, must be ordered in clockwise or counterclockwise format
     * @param color the color of the quadrilateral
     * @param fill a boolean indicating whether the shape is filled with the color or drawn only with an outline
     */
    public Quadrilateral(Point2D.Double[] points, Color color, boolean fill){
        this.points = points;
        this.color = color;
        this.fill = fill;
    }


    @Override
    public void draw(Graphics2D g2d){        
        if (points.length != 4) return;

        Path2D.Double p = new Path2D.Double();

        p.moveTo(points[0].getX(), points[0].getY());
        for (int i = 1; i < 4; i++){
            p.lineTo(points[i].getX(), points[i].getY());
        }
        p.closePath();

        g2d.setColor(color);

        if (fill) g2d.fill(p);
        else g2d.draw(p);     
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    };
    
}