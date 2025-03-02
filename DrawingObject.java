/**
        The DrawingObject interface allows implementing objects to be drawn.
        It has two methods: draw and setColor. In the program, all scene 
        objects implement DrawingObject. Its main use is through the 
        drawingObjects ArrayList field of SceneCanvas.

        @author Niles Tristan V. Cabrera ()
        @author Gabriel Matthew P. Labariento (242425)
        @version 02 September 2023

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

public interface DrawingObject {

    /**
     * Allows the implementing object to be drawn on the SceneCanvas 
     * @param g2d the casted Graphics2D object that contains methods for shape manipulations 
     */
    void draw(Graphics2D g2d);

    /**
     * Sets the color field of the object to the passed argument
     * In the program, used to make the main character cat transparent
     * @param color the color to change the object to
     */
    void setColor(Color color);
}