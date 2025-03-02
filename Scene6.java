/**
        The Scene6 class creates a Scene6 object and has methods
        for drawing it as it implements DrawingObject. This object
        uses Buildings, Cloud, and Circle classes to compose the scene.
   
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

public class Scene6 implements DrawingObject {
    private double width;
    private double height;

    /**
     * Initializes the object's field values to the provided arguments
     * @param w the scene's width
     * @param h the scene's height
     */
    public Scene6(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#ffcdb2"));
        g2d.fill(background);

        Rectangle2D.Double middleGround = new Rectangle2D.Double(0, 355.6, 800, 244.4);
        g2d.setColor(Color.decode("#db9093"));
        g2d.fill(middleGround);

        Circle sun = new Circle(604.6, 292, 63.6, Color.decode("#fffdfd"));
        sun.draw(g2d);

        Color cloudColor = Color.decode("#1f2020");
        Cloud c1 = new Cloud(492.3, 273.6, 0.36, cloudColor);
        Cloud c2 = new Cloud(526.5, 291.3, 0.26, cloudColor);
        Cloud c3 = new Cloud(728.8, -61.7, 0.95, cloudColor);
        Cloud c4 = new Cloud(142.9, 136.9, 0.92, cloudColor);
        Cloud c5 = new Cloud(646.9, 281.7, 0.27, cloudColor);
        Cloud c6 = new Cloud(592.1, 327.6, 0.12, cloudColor);
        c1.draw(g2d);
        c2.draw(g2d);
        c3.draw(g2d);
        c4.draw(g2d);
        c5.draw(g2d);
        c6.draw(g2d);

        Buildings backBuildings1 = new Buildings(280, 273.6, 1.27, Color.decode("#242424"), Color.decode("#aca8a9"), Color.decode("#ebebeb"));       
        Buildings backBuildings2 = new Buildings(574.6, 273.6, 1.27, Color.decode("#242424"), Color.decode("#aca8a9"), Color.decode("#ebebeb"));       
        backBuildings1.draw(g2d);
        backBuildings2.draw(g2d);

        Color dark = Color.decode("#9d7079");
        Color neutral = Color.decode("#e1a6aa");
        Color light = Color.decode("#ffc3c7");
        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(337.8, 153.5);
        quadPoints[1] = new Point2D.Double(337.8, 458.8);
        quadPoints[2] = new Point2D.Double(132.4, 458.8);
        quadPoints[3] = new Point2D.Double(132.4, 203.8);
        Quadrilateral darkBuilding1 = new Quadrilateral(quadPoints, dark, true);
        darkBuilding1.draw(g2d);

        quadPoints[2] = new Point2D.Double(401.1, 458.8);
        quadPoints[3] = new Point2D.Double(401.1, 194.7);
        Quadrilateral neutralBuilding1 = new Quadrilateral(quadPoints, neutral, true);
        neutralBuilding1.draw(g2d);

        quadPoints[0] = new Point2D.Double(71.1, 270.7);
        quadPoints[1] = new Point2D.Double(71.1, 458.8);
        quadPoints[2] = new Point2D.Double(0, 458.8);
        quadPoints[3] = new Point2D.Double(0, 286.4);
        Quadrilateral darkBuilding2 = new Quadrilateral(quadPoints, dark, true);
        darkBuilding2.draw(g2d);

        quadPoints[2] = new Point2D.Double(249.9, 458.8);
        quadPoints[3] = new Point2D.Double(249.9, 298.9);
        Quadrilateral neutralBuilding2 = new Quadrilateral(quadPoints, neutral, true);
        neutralBuilding2.draw(g2d);

        quadPoints[0] = new Point2D.Double(506.5, 419);
        quadPoints[1] = new Point2D.Double(519.4, 411.7);
        quadPoints[2] = new Point2D.Double(393, 409.6);
        quadPoints[3] = new Point2D.Double(367.5, 416.3);
        Quadrilateral lightBuilding3 = new Quadrilateral(quadPoints, light, true);
        lightBuilding3.draw(g2d);

        quadPoints[2] = new Point2D.Double(519.4, 458.8);
        quadPoints[3] = new Point2D.Double(506.5, 458.8);
        Quadrilateral neutralBuilding3 = new Quadrilateral(quadPoints, neutral, true);
        neutralBuilding3.draw(g2d);

        quadPoints[1] = new Point2D.Double(506.5, 458.8);
        quadPoints[2] = new Point2D.Double(367.5, 458.8);
        quadPoints[3] = new Point2D.Double(367.5, 416.3);
        Quadrilateral darkBuilding3 = new Quadrilateral(quadPoints, dark, true);
        darkBuilding3.draw(g2d);

        quadPoints[0] = new Point2D.Double(769.2, 207.6);
        quadPoints[1] = new Point2D.Double(769.2, 458.8);
        quadPoints[2] = new Point2D.Double(800, 458.8);
        quadPoints[3] = new Point2D.Double(800, 215.1);
        Quadrilateral darkBuilding4 = new Quadrilateral(quadPoints, dark, true);
        darkBuilding4.draw(g2d);

        quadPoints[2] = new Point2D.Double(751.8, 458.8);
        quadPoints[3] = new Point2D.Double(751.8, 227.9);
        Quadrilateral neutralBuilding4 = new Quadrilateral(quadPoints, neutral, true);
        neutralBuilding4.draw(g2d);

        quadPoints[0] = new Point2D.Double(556.2, 383.8);
        quadPoints[1] = new Point2D.Double(800, 383.8);
        quadPoints[2] = new Point2D.Double(800, 458.8);
        quadPoints[3] = new Point2D.Double(556.2, 458.8);
        Quadrilateral darkBuilding5 = new Quadrilateral(quadPoints, dark, true);
        darkBuilding5.draw(g2d);

        quadPoints[2] = new Point2D.Double(800, 371.5);
        quadPoints[3] = new Point2D.Double(587, 371.5);
        Quadrilateral lightBuilding5 = new Quadrilateral(quadPoints, light, true);
        lightBuilding5.draw(g2d);
                
        Rectangle2D.Double foreGround = new Rectangle2D.Double(0, 453.3, 800, 191.1);
        g2d.setColor(Color.decode("#f8bdc1"));
        g2d.fill(foreGround);

    }

    @Override
    public void setColor(Color color) {};

}