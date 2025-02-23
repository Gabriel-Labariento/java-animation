import java.awt.*;
import java.awt.geom.*;

public class Scene1 implements DrawingObject {
    private double width;
    private double height;

    public Scene1(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#EB5A3C"));
        g2d.fill(background);

        Circle sun = new Circle(119.5, 322.8, 63.6, Color.decode("#EDF4C2"));
        sun.draw(g2d);

        Rectangle2D.Double horizon = new Rectangle2D.Double(0, 354.6, 800, 245.4);
        g2d.setColor(Color.decode("#ebda9b"));
        g2d.fill(horizon);

        Cloud c1 = new Cloud(667.8, 196.3, 1.56, Color.decode("#1f2020"));
        c1.draw(g2d);

        Ellipse2D.Double mountain = new Ellipse2D.Double(499.1, 280.6, 570.7, 211.7);
        g2d.setColor(Color.decode("#EDF4C2"));
        g2d.fill(mountain);

        Buildings b1 = new Buildings(579.6, 288.1, 0.38, Color.decode("#242424"), Color.decode("#aca8a9"), Color.decode("#ebebeb"));       
        Buildings b2 = new Buildings(647.9, 275, 0.51, Color.decode("#242424"), Color.decode("#aca8a9"), Color.decode("#ebebeb"));       
        b1.draw(g2d);
        b2.draw(g2d);

        mountain = new Ellipse2D.Double(153.5, 331.1, 813.1, 224.4);
        g2d.setColor(Color.decode("#fae9a6"));
        g2d.fill(mountain);

        mountain = new Ellipse2D.Double(475, 288.1, 1021.8, 344.3);
        g2d.setColor(Color.decode("#ebda9b"));
        g2d.fill(mountain);

        Cloud c2 = new Cloud(360.3, 56.1, 1.04, Color.decode("#1f2020"));
        c2.draw(g2d);

        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(372.9, 60);
        quadPoints[1] = new Point2D.Double(475, 175.6);
        quadPoints[2] = new Point2D.Double(0, 290.4);
        quadPoints[3] = new Point2D.Double(0, 149.9);
        Quadrilateral coverBelow = new Quadrilateral(quadPoints, Color.decode("#e7d283"), true);
        coverBelow.draw(g2d);

        Cloud c3 = new Cloud(64, 291.7, 0.6, Color.decode("#1f2020"));
        c3.draw(g2d);

        Color dark = Color.decode("#df9755");
        Color light = Color.decode("#d4be6c");

        quadPoints[0] = new Point2D.Double(111.6, 600);
        quadPoints[1] = new Point2D.Double(111.6, 246.5);
        quadPoints[2] = new Point2D.Double(73.2, 255.9);
        quadPoints[3] = new Point2D.Double(73.7, 600);
        Quadrilateral darkLeg1 = new Quadrilateral(quadPoints, dark, true);
        darkLeg1.draw(g2d);

        quadPoints[2] = new Point2D.Double(123.5, 260.4);
        quadPoints[3] = new Point2D.Double(123.5, 600);
        Quadrilateral lightLeg1 = new Quadrilateral(quadPoints, light, true);
        lightLeg1.draw(g2d);

        quadPoints[0] = new Point2D.Double(0, 134.4);
        quadPoints[1] = new Point2D.Double(0, 157.5);
        quadPoints[2] = new Point2D.Double(380.1, 66.2);
        quadPoints[3] = new Point2D.Double(380.1, 42.6);
        Quadrilateral coverSide1 = new Quadrilateral(quadPoints, dark, true);
        coverSide1.draw(g2d);

        quadPoints[0] = new Point2D.Double(379.3, 42.6);
        quadPoints[1] = new Point2D.Double(379.3, 68);
        quadPoints[2] = new Point2D.Double(475, 175.6);
        quadPoints[3] = new Point2D.Double(475, 151.4);
        Quadrilateral coverSide2 = new Quadrilateral(quadPoints, light, true);
        coverSide2.draw(g2d);

        quadPoints[0] = new Point2D.Double(31.6, 408.5);
        quadPoints[1] = new Point2D.Double(31.6, 146.9);
        quadPoints[2] = new Point2D.Double(0, 154.5);
        quadPoints[3] = new Point2D.Double(0, 408.5);
        Quadrilateral darkLeg2 = new Quadrilateral(quadPoints, dark, true);
        darkLeg2.draw(g2d);

        quadPoints[2] = new Point2D.Double(43.5, 162.1);
        quadPoints[3] = new Point2D.Double(43.5, 408.5);
        Quadrilateral lightLeg2 = new Quadrilateral(quadPoints, light, true);
        lightLeg2.draw(g2d);

        Ellipse2D.Double foreground1 = new Ellipse2D.Double(-26.3, 351.9, 323.1, 153.1);
        g2d.setColor(Color.decode("#e9d27e"));
        g2d.rotate(Math.toRadians(29.3), foreground1.getX(), foreground1.getY());
        g2d.fill(foreground1);
        g2d.setTransform(reset);

        quadPoints[0] = new Point2D.Double(463.1, 163.3);
        quadPoints[1] = new Point2D.Double(463.1, 473.1);
        quadPoints[2] = new Point2D.Double(426.9, 473.1);
        quadPoints[3] = new Point2D.Double(426.9, 171.8);
        Quadrilateral darkLeg3 = new Quadrilateral(quadPoints, dark, true);
        darkLeg3.draw(g2d);

        quadPoints[2] = new Point2D.Double(475, 473.1);
        quadPoints[3] = new Point2D.Double(475, 174);
        Quadrilateral lightLeg3 = new Quadrilateral(quadPoints, light, true);
        lightLeg3.draw(g2d);

        Rectangle2D.Double foreground2 = new Rectangle2D.Double(0, 467.1, 800, 132.9);
        g2d.setColor(Color.decode("#e9d27e"));
        g2d.fill(foreground2);

        FeedingCats feedingCats = new FeedingCats(98.4, 375, 1.46, Color.decode("#242424"), Color.decode("#898989"), Color.decode("#ACA8A9"));
        feedingCats.draw(g2d);

        quadPoints[0] = new Point2D.Double(380.1, 65.3);
        quadPoints[1] = new Point2D.Double(380.1, 600);
        quadPoints[2] = new Point2D.Double(341.6, 600);
        quadPoints[3] = new Point2D.Double(341.6, 75.2);
        Quadrilateral darkLeg4 = new Quadrilateral(quadPoints, dark, true);
        darkLeg4.draw(g2d);

        quadPoints[2] = new Point2D.Double(392, 580.1);
        quadPoints[3] = new Point2D.Double(392, 80.2);
        Quadrilateral lightLeg4 = new Quadrilateral(quadPoints, light, true);
        lightLeg4.draw(g2d);
    }
}