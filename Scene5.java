/**
        The Scene5 class creates a Scene5 object and has methods
        for drawing it as it implements DrawingObject. This object
        uses Buildings, Cloud, Grass, and Circle classes to compose
        the scene.
   
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

import java.awt.*;
import java.awt.geom.*;

public class Scene5 implements DrawingObject {
    private double width;
    private double height;

    /**
     * Initializes the object's field values to the provided arguments
     * @param w the scene's width
     * @param h the scene's height
     */
    public Scene5(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        Color cloudColor = Color.decode("#1f2020");
        Color grassColor = Color.decode("#82954b");

        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#ffef82"));
        g2d.fill(background);

        Rectangle2D.Double middleGround = new Rectangle2D.Double(0, 353.6, 800, 245.4);
        g2d.setColor(Color.decode("#efd345"));
        g2d.fill(middleGround);

        Rectangle2D.Double foreGround = new Rectangle2D.Double(0, 454.2, 800, 174.4);
        g2d.setColor(Color.decode("#babd42"));
        g2d.fill(foreGround);

        Rectangle2D.Double b1 = new Rectangle2D.Double(417, 285.4, 31.3, 78.3);
        g2d.setColor(Color.decode("#aca8a9"));
        g2d.fill(b1);

        Buildings buildings = new Buildings(-29.7, 91.1, 1.97, Color.decode("#242424"), Color.decode("#aca8a9"), Color.decode("#ebebeb"));       
        buildings.draw(g2d);

        Circle sun = new Circle(575, 134.3, 63.6, Color.decode("#fffdfd"));
        sun.draw(g2d);
        
        Cloud c1 = new Cloud(532.6, 166.1, 0.44, cloudColor);
        Cloud c2 = new Cloud(611.4, 91.1, 0.68, cloudColor);
        Cloud c3 = new Cloud(714.7, 227.5, 0.24, cloudColor);
        Cloud c4 = new Cloud(148.1, -71.8, 1.12, cloudColor);
        c1.draw(g2d);
        c2.draw(g2d);
        c3.draw(g2d);
        c4.draw(g2d);

        Rectangle2D.Double b2 = new Rectangle2D.Double(-121.9, -27.4, 328.6, 487.2);
        g2d.setColor(Color.decode("#5a5546"));
        g2d.fill(b2);

        Grass g1 = new Grass(-153.2, 232, 1.83, grassColor);
        Grass g2 = new Grass(217.8, 348.2, 0.91, grassColor);
        Grass g3 = new Grass(371.2, 435.9, 0.41, grassColor);
        Grass g4 = new Grass(33.9, 368.4, 0.81, grassColor);
        Grass g5 = new Grass(111.4, 413.6, 0.51, grassColor);
        Grass g6 = new Grass(154.4, 436.2, 0.51, grassColor);
        Grass g7 = new Grass(174.5, 381.9, 0.69, grassColor);
        g1.draw(g2d);
        g2.draw(g2d);
        g3.draw(g2d);
        g4.draw(g2d);
        g5.draw(g2d);
        g6.draw(g2d);
        g7.draw(g2d);

        Rectangle2D.Double shard1 = new Rectangle2D.Double(6.9, 555, 23.4, 11.7);
        Rectangle2D.Double shard2 = new Rectangle2D.Double(13, 509.2, 14.9, 7.4);
        Rectangle2D.Double shard3 = new Rectangle2D.Double(20.9, 509.2, 14.9, 7.4);
        Rectangle2D.Double shard4 = new Rectangle2D.Double(49.2, 530.4, 23.4, 7.2);
        Rectangle2D.Double shard5 = new Rectangle2D.Double(57.2, 528.7, 23.4, 11.7);
        Rectangle2D.Double shard6 = new Rectangle2D.Double(109.4, 527.1, 10.9, 5);
        Rectangle2D.Double shard7 = new Rectangle2D.Double(239.8, 538.5, 5.3, 5.1);
        
        g2d.setColor(Color.WHITE);
        g2d.rotate(Math.toRadians(-148.3), shard1.getX(), shard1.getY());
        g2d.fill(shard1);
        g2d.setTransform(reset);
        g2d.rotate(Math.toRadians(-15.2), shard2.getX(), shard2.getY());
        g2d.fill(shard2);
        g2d.setTransform(reset);
        g2d.rotate(Math.toRadians(-15.2), shard3.getX(), shard3.getY());
        g2d.fill(shard3);
        g2d.setTransform(reset);        
        g2d.rotate(Math.toRadians(21.4), shard4.getX(), shard4.getY());
        g2d.fill(shard4);
        g2d.setTransform(reset);
        g2d.rotate(Math.toRadians(21.4), shard5.getX(), shard5.getY());
        g2d.fill(shard5);
        g2d.setTransform(reset);
        g2d.rotate(Math.toRadians(-26), shard6.getX(), shard6.getY());
        g2d.fill(shard6);
        g2d.setTransform(reset);
        g2d.rotate(Math.toRadians(35.1), shard7.getX(), shard7.getY());
        g2d.fill(shard7);
        g2d.setTransform(reset);


        Grass g8 = new Grass(-23.4, 524, 0.68, grassColor);
        g8.draw(g2d);
    }

    @Override
    public void setColor(Color color) {};
}