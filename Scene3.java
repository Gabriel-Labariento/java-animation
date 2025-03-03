/**
        The Scene3 class creates a Scene3 object and has methods
        for drawing it as it implements DrawingObject. This object
        uses Mouse, Cloud, Buildings, Circle, and Grass classes
        to compose the scene.
   
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

public class Scene3 implements DrawingObject {
    private double width;
    private double height;

    /**
     * Initializes the object's field values to the provided arguments
     * @param w the scene's width
     * @param h the scene's height
     */
    public Scene3(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Color cloudColor = Color.decode("#1f2020");
        Color lightGrass = Color.decode("#3ac4a7");
        Color darkGrass = Color.decode("#0d9276");

        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#89f1ee"));
        g2d.fill(background);

        Rectangle2D.Double horizon = new Rectangle2D.Double(0, 354.6, 800, 245.4);
        g2d.setColor(Color.decode("#b2ffcc"));
        g2d.fill(horizon);

        Rectangle2D.Double foreground = new Rectangle2D.Double(0, 449.2, 800, 153.3);
        g2d.setColor(Color.decode("#93edb1"));
        g2d.fill(foreground);

        Buildings b1 = new Buildings(547.2, -211, 4.2, Color.decode("#242424"), Color.decode("#aca8a9"), Color.decode("#ebebeb"));       
        b1.draw(g2d);
        
        Grass g1 = new Grass(-216.5, 60, 2.82, darkGrass);
        Grass g2 = new Grass(232.3, 297.8, 1.13, lightGrass);
        Grass g3 = new Grass(299.2, 297.8, 1.46, darkGrass);
        Grass g4 = new Grass(416.1, 266.7, 1.35, darkGrass);
        Grass g5 = new Grass(523.4, 279.9, 1.38, lightGrass);
        Grass g6 = new Grass(547.2, 112.3, 2.63, darkGrass);
        Grass g7 = new Grass(-146.1, 511.1, 2.51, darkGrass);
        Grass g8 = new Grass(65.5, 540, 2.52, darkGrass);
        Grass g9 = new Grass(362.4, 540, 2.52, darkGrass);
        Grass g10 = new Grass(523.4, 525.9, 2.52, darkGrass);
        Grass g11 = new Grass(656.7, 525.9, 1.25, darkGrass);
        Grass g12 = new Grass(8, 525.9, 1.25, darkGrass);
        g1.draw(g2d);
        g2.draw(g2d);
        g3.draw(g2d);
        g4.draw(g2d);
        g5.draw(g2d);
        g6.draw(g2d);
        g7.draw(g2d);
        g8.draw(g2d);
        g9.draw(g2d);
        g10.draw(g2d);
        g11.draw(g2d);
        g12.draw(g2d);

        Cloud c1 = new Cloud(465.5, 134, 0.48, cloudColor);
        Cloud c2 = new Cloud(-44.8, -31.5, 1.03, cloudColor);
        Cloud c3 = new Cloud(47.9, -70.7, 1.03, cloudColor);
        c1.draw(g2d);
        c2.draw(g2d);
        c3.draw(g2d);

        Circle sun = new Circle(335.9, 45.8, 63.6, Color.decode("#fffdfd"));
        sun.draw(g2d);
    }

    @Override
    public void setColor(Color color) {};
}