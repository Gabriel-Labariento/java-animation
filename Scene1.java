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
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, 800, 600);
        g2d.setColor(Color.decode("#EB5A3C"));
        g2d.fill(background);

        Circle sun = new Circle(119.5, 322.8, 63.6, Color.decode("#EDF4C2"));
        sun.draw(g2d);

        Rectangle2D.Double horizon = new Rectangle2D.Double(0, 354.6, 800, 245.4);
        g2d.setColor(Color.decode("#ebda9b"));
        g2d.fill(horizon);

        Cloud c1 = new Cloud(667.8, 196.3, 1, Color.decode("#1f2020"));
        c1.draw(g2d);

        Ellipse2D.Double mountain1 = new Ellipse2D.Double(499.1, 280.6, 570.7, 211.7);
        g2d.setColor(Color.decode("#EDF4C2"));
        g2d.fill(mountain1);

        Buildings b1 = new Buildings(579.6, 288.1, 1, Color.decode("#242424"), Color.decode("#aca8a9"), Color.decode("#ebebeb"));       
        b1.draw(g2d);

        Ellipse2D.Double mountain2 = new Ellipse2D.Double(499.1, 280.6, 570.7, 211.7);
        g2d.setColor(Color.decode("#EDF4C2"));
        g2d.fill(mountain2);

        FeedingCats feedingCats = new FeedingCats(98.4, 375, 2, Color.decode("#242424"), Color.decode("#898989"), Color.decode("#ACA8A9"));
        feedingCats.draw(g2d);

    }


}