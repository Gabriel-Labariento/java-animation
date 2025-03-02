/**
        The Line class creates a Line object and has methods
        for drawing it as it implements DrawingObject. This object
        uses Line2D.Double to create a line of the same x and y positions.
        Line color and thickness are also fields of the Line class.
   
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

public class Line implements DrawingObject {
    private double xStart;
    private double yStart;
    private double xEnd;
    private double yEnd;
    private double thickness;
    private Color color;

    /**
     * Initializes object's field values to the provided arguments
     * @param xStart the x-coordinate of the starting point
     * @param yStart the y-coordinate of the starting point
     * @param xEnd the x-coordinate of the end point
     * @param yEnd the y-coordinate of te end point
     * @param thickness the line thickness 
     * @param color the line color
     */
    public Line(double xStart, double yStart, double xEnd, double yEnd, double thickness, Color color){
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.thickness = thickness;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        Line2D.Double line = new Line2D.Double(xStart, yStart, xEnd, yEnd);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke((float)thickness));
        g2d.draw(line);
    }
    
    @Override
    public void setColor(Color color) {
        this.color = color;
    };

}