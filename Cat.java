/**
        The Cat interface allows the main cat to switch between
        sitting, walking, and sleeping without errors. Through
        its methods, it allows the Cat to be drawin, change x-position,
        change frame, activate limping animation, return its x-position,
        and return its length.
   
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

import java.awt.Graphics2D;

public interface Cat {
    /**
     * Changes the x-coordinate of the Cat by a certain amount
     * @param distance the amount to change the x-coordinate of the Cat by
     */
    void adjustX(double distance);

    /**
     * Calls the changeFrame method of the Cat, essential for its animation
     */
    void changeFrame();

    /**
     * Gets the x-coordinate of the Cat
     * @return the x-coordinate of the Cat's framing rectangle
     */
    double getX();

    /**
     * Gets the length of the cat. Needed for collisions
     * @return the width of the Cat's framing rectangle
     */
    double getCatLength();

    /**
     * Allows the Cat to be drawn on the canvas
     * @param g2d the object to manipulate geometric shapes
     */
    void draw(Graphics2D g2d);

    /**
     * Sets the isLimping field of the Cat to the provided argument
     * @param isLimping true or false, the values to set the isLimping field to
     */
    void setIsLimping(boolean isLimping);
}
