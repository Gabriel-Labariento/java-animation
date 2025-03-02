/**
        The Rainbow class creates a Rainbow object and has methods
        for drawing it as it implements DrawingObject. This object
        uses multiple instances of the Circle class to create 
        concentric circles progressively getting bigger.
   
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

public class Rainbow implements DrawingObject{
    private double x;
    private double y;
    private double size;
    private Color centerColor;

    /**
     * Initializes the object's field values to the arguments provided
     * @param xPosition the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 242px by 242px
     * @param centerColor the color of the rainbow's center
     */
    public Rainbow(double xPosition, double yPosition, double size, Color centerColor){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.centerColor = centerColor;
    }

    @Override
    public void draw(Graphics2D g2d){
        final Color RED = new Color(195, 45, 47);
        final Color ORANGE = new Color(236, 83, 34);
        final Color YELLOW = new Color(228, 182, 10);
        final Color GREEN = new Color(1, 143, 77);
        final Color BLUE = new Color(74, 165, 249);

        Circle redCircle = new Circle(0, 0, 242, RED);
        Circle orangeCircle = new Circle((6.4), (6.4), 229.2, ORANGE);
        Circle yellowCircle = new Circle((12.7), (12.7), 216.5, YELLOW);
        Circle greenCircle = new Circle((19.1), (19.1), 203.8, GREEN);
        Circle blueCircle = new Circle((25.5), (25.5), 191, BLUE);
        Circle centerCircle = new Circle((31.8), (31.8), 178.3, centerColor); 

        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        redCircle.draw(g2d);
        orangeCircle.draw(g2d);
        yellowCircle.draw(g2d);
        greenCircle.draw(g2d);
        blueCircle.draw(g2d);
        centerCircle.draw(g2d);
        g2d.setTransform(reset);
    };

    @Override
    public void setColor(Color color) {
        centerColor = color;
    };
    
}
