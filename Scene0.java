/**
        The Scene0 class creates a Scene0 object and has methods
        for drawing it as it implements DrawingObject. This object
        serves as the animation's title page. After the viewer
        has exited this scene by pressing on the spacebar, the
        animation will not loop back to it.
   
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


public class Scene0 implements DrawingObject {
    private double width;
    private double height;

    /**
     * Initializes the object's field values to the provided arguments
     * @param w the scene's width
     * @param h the scene's height
     */
    public Scene0(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#1f2020"));
        g2d.fill(background);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Segoe Script", Font.PLAIN, 100)); 
        g2d.drawString("don't let go", 100, 325);
        g2d.setFont(new Font("Arial", Font.PLAIN, 15));
        g2d.drawString("HOLD THE SPACEBAR TO MOVE", 285, 550);

        Line lineUnderSubTitle = new Line(285, 557, 514.8, 557, 1, Color.WHITE);
        lineUnderSubTitle.draw(g2d);
    }

    @Override
    public void setColor(Color color) {}
}
