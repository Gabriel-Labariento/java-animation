import java.awt.*;
import java.awt.geom.*;

public class Scene7 implements DrawingObject {
    private double width;
    private double height;

    public Scene7(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#fd9990"));
        g2d.fill(background);

        Rectangle2D.Double foreground = new Rectangle2D.Double(0, 415.4, 800, 184.6);
        g2d.setColor(Color.decode("#c08284"));
        g2d.fill(foreground);

        Ellipse2D.Double mat = new Ellipse2D.Double(88.2, 436.5, 311.8, 82.7);
        g2d.setColor(Color.decode("#046582"));
        g2d.fill(mat);

        FeedingCats feedingCats = new FeedingCats(169.5, 383.3, 1.13, Color.WHITE, Color.decode("#898989"), Color.decode("#ACA8A9"));
        feedingCats.draw(g2d);

        Rectangle2D.Double outerFrame = new Rectangle2D.Double(234, -85, 574.4, 171.9);
        g2d.setColor(Color.decode("#6e7582"));
        g2d.fill(outerFrame);

        Rectangle2D.Double sky = new Rectangle2D.Double(279.6, -100.5, 528.8, 171.9);
        g2d.setColor(Color.decode("#394252"));
        g2d.fill(sky);

        Rectangle2D.Double innerFrame = new Rectangle2D.Double(606.9, -89.5, 65.8, 171.9);
        g2d.setColor(Color.decode("#6e7582"));
        g2d.fill(innerFrame);

        Circle sun = new Circle(384.6, -35.3, 63.6, Color.WHITE);
        Circle star1 = new Circle(310.7, 4.4, 6.4, Color.WHITE);
        Circle star2 = new Circle(372.3, 49.2, 6.4, Color.WHITE);
        Circle star3 = new Circle(445, 54.2, 6.4, Color.WHITE);
        Circle star4 = new Circle(489.5, 15.5, 6.4, Color.WHITE);
        Circle star5 = new Circle(572.5, 30, 6.4, Color.WHITE);
        Circle star6 = new Circle(697.5, 42.8, 6.4, Color.WHITE);
        Circle star7 = new Circle(714.2, 5.9, 6.4, Color.WHITE);
        Circle star8 = new Circle(730.2, 21.9, 6.4, Color.WHITE);
        Circle star9 = new Circle(768, 57.4, 6.4, Color.WHITE);
        sun.draw(g2d);
        star1.draw(g2d);
        star2.draw(g2d);
        star3.draw(g2d);
        star4.draw(g2d);
        star5.draw(g2d);
        star6.draw(g2d);
        star7.draw(g2d);
        star8.draw(g2d);
        star9.draw(g2d);

        Color cloudColor = Color.decode("#1f2020");
        Cloud c1 = new Cloud(410.9, 4.4, 0.46, cloudColor);
        Cloud c2 = new Cloud(335.5, -33.2, 0.46, cloudColor);
        Cloud c3 = new Cloud(740, -37.8, 0.66, cloudColor);
        Cloud c4 = new Cloud(756, -21.8, 0.66, cloudColor);
        c1.draw(g2d);
        c2.draw(g2d);
        c3.draw(g2d);
        c4.draw(g2d);

        CatBowl catBowl1 = new CatBowl(624.8, 451.1, 0.72, Color.decode("#046582"), Color.decode("#242424"));
        CatBowl catBowl2 = new CatBowl(744.6, 478.8, 0.92, Color.decode("#046582"), Color.decode("#242424"));
        catBowl1.draw(g2d);
        catBowl2.draw(g2d);

    }
}