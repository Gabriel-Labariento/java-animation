/**
        The FightCloud class creates a FightCloud object and has methods
        for drawing it as it implements DrawingObject. This object
        appears in scene four to illustrate the cat fight scene.
   
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

public class FightCloud implements DrawingObject{
    private double x, y, size;

    /**
     * Initializes the object's field values to the arguments provided.
     * @param xPositon the object's x-coordinate
     * @param yPosition the object's y-coordinte
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 204.8px by 203.4px
     */
    public FightCloud(double xPositon, double yPosition, double size){
        x = xPositon;
        y = yPosition;
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        drawFightCloudNoScaling(g2d);
        g2d.setTransform(reset);
    }

    @Override
    public void setColor(Color color) {}

    /**
     * Adjusts the object's position along the x-axis
     * @param distance the distance to adjust the object's position by
     */
    public void adjustX(double distance) {
        x += distance;
    }

    /**
     * Draws a cloud object without the translation and scaling given to the constructor. Called inside draw method.
     * @param g2d object to manipulate geometric shapes
     */
    private void drawFightCloudNoScaling(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Color colorOne = Color.decode("#b6b6b6");
        Color colorTwo = Color.decode("#eeeeee");
        Color colorThree = Color.decode("#898989");

        g2d.setColor(colorOne);
        Cloud c = new Cloud(0, 132.2, 1, colorOne);
        g2d.rotate(Math.toRadians(-61.8), c.getX(), c.getY());
        c.draw(g2d);
        g2d.setTransform(reset);

        c = new Cloud(52.9, 13.9, 1, colorThree);
        c.draw(g2d);

        c = new Cloud(49.5, 158.7, 1, colorTwo);
        g2d.rotate(Math.toRadians(-61.8), c.getX(), c.getY());
        c.draw(g2d);
        g2d.setTransform(reset);

        c = new Cloud(216.7, 139, 1, colorThree);
        g2d.rotate(Math.toRadians(140.3), c.getX(), c.getY());
        c.draw(g2d);
        g2d.setTransform(reset);

        c = new Cloud(227.1, 38.2, 1, colorOne);
        g2d.rotate(Math.toRadians(95.1), c.getX(), c.getY());
        c.draw(g2d);
        g2d.setTransform(reset);
        
    }
}

