/**
        The Buttefly class creates a Buttefly object and has methods
        for drawing it as it implements DrawingObject. This object
        has three instances in scene two.
        
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

public class Butterfly implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private int flyFrame;
    private Color color;

    /**
     * Initializes the Butterfly with the arguments as field values
     * @param xPosition the x-coordinate of the butterfly
     * @param yPosition the y-coordinate of the butterfly
     * @param size the scaling applies to the butterfly. If size = 1, framing rectangle is 71.7px by 61.8px
     * @param flyFrame
     * @param color
     */
    public Butterfly(double xPosition, double yPosition, double size, int flyFrame, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;

        // Handles passing a flyFrame that does not exist
        if ((flyFrame > 1) || (flyFrame < 0)) this.flyFrame = 1;
        else this.flyFrame = flyFrame;
        
        this.color = color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        g2d.setColor(color);

        drawFrames(g2d);
        g2d.setTransform(reset);
    }

    /**
     * Draws the frame of the cat based on the current value of flyFrame
     * @param g2d object to manipulate geometric shapes
     */
    private void drawFrames(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        
        if (flyFrame == 0){
            Ellipse2D.Double b1 = new Ellipse2D.Double((163.3), (60.5), 58.6, 152.4);
            g2d.rotate(Math.toRadians(109.7), b1.getX(), b1.getY());
            g2d.fill(b1);
            g2d.setTransform(reset);

            Ellipse2D.Double b2 = new Ellipse2D.Double((98.6), (0), 58.6, 115.7);
            g2d.fill(b2);

            Ellipse2D.Double b3 = new Ellipse2D.Double((12), (91.2), 58.6, 115.7);
            g2d.rotate(Math.toRadians(-74.6), b3.getX(), b3.getY());
            g2d.fill(b3);
            g2d.setTransform(reset);

            Ellipse2D.Double b4 = new Ellipse2D.Double((28.6), (132.8), 58.6, 101.1);
            g2d.rotate(Math.toRadians(-84.7), b4.getX(), b4.getY());
            g2d.fill(b4);
            g2d.setTransform(reset);

            Ellipse2D.Double b5 = new Ellipse2D.Double((168.7), (96.9), 83.6, 23.1);
            g2d.rotate(Math.toRadians(144.7), b5.getX(), b5.getY());
            g2d.fill(b5);   
            g2d.setTransform(reset);
        }
        else if (flyFrame == 1){
            Ellipse2D.Double f1 = new Ellipse2D.Double((116.9), (18.9), 96.9, 23.1);
            g2d.rotate(Math.toRadians(144.7), f1.getX(), f1.getY());
            g2d.fill(f1);
            g2d.setTransform(reset);

            Ellipse2D.Double f2 = new Ellipse2D.Double((106.4), (115.5), 43, 97.7);
            g2d.rotate(Math.toRadians(178.4), f2.getX(), f2.getY());
            g2d.fill(f2);
            g2d.setTransform(reset);

            Ellipse2D.Double f3 = new Ellipse2D.Double((46.1), (153.9), 27.1, 97.7);
            g2d.rotate(Math.toRadians(-157.5), f3.getX(), f3.getY());
            g2d.fill(f3);
            g2d.setTransform(reset);

            Ellipse2D.Double f4 = new Ellipse2D.Double((80.1), (48.7), 37, 97.7);
            g2d.rotate(Math.toRadians(46.6), f4.getX(), f4.getY());
            g2d.fill(f4);
            g2d.setTransform(reset);

            Ellipse2D.Double f5 = new Ellipse2D.Double((63.9), (23.8), 43, 97.7);
            g2d.rotate(Math.toRadians(40.8), f5.getX(), f5.getY());
            g2d.fill(f5);
            g2d.setTransform(reset);
        }

        g2d.setTransform(reset);
    }

    /**
     * Switches the flyFrame of the Butterfly instance
     */
    public void changeFrame(){
        if (this.flyFrame == 1) this.flyFrame = 0;
        else flyFrame = 1;
    }

    /**
     * Gets the current x-position
     * @return the x-coordinate of the framing rectangle
     */
    public double getX(){
        return x;
    }

    /**
     * Gets the current y-position
     * @return the y-coordinate of the framing rectangle
     */
    public double getY(){
        return y;
    }

    /**
     * Changes the object's x-position by a certain amount
     * @param distance the amount to change the object's x-position by
     */
    public void adjustX(double distance){
        x += distance;
    }

    /**
     * Changes the object's y-position by a cerain amount
     * @param distance the amount to change the object's y-position by
     */
    public void adjustY(double distance){
        y += distance;
    }
}


