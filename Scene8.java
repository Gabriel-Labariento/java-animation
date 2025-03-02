/**
        The Scene8 class creates a Scene8 object and has methods
        for drawing it as it implements DrawingObject. This object
        uses the Door class to compose the scene.
   
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

public class Scene8 implements DrawingObject {
    private double width;
    private double height;

    /**
     * Initializes the object's field values to the provided arguments
     * @param w the scene's width
     * @param h the scene's height
     */
    public Scene8(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#394252"));
        g2d.fill(background);

        Rectangle2D.Double foreground = new Rectangle2D.Double(0, 482, 800, 118.1);
        g2d.setColor(Color.decode("#2c3442"));
        g2d.fill(foreground);

        Door door = new Door(0, 0, 1);
        door.draw(g2d);
    }

    @Override
    public void setColor(Color color) {};
}