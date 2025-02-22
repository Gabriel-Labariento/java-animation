import java.awt.*;
import java.awt.geom.*;

public class Scene6 implements DrawingObject {
    private double width;
    private double height;

    public Scene6(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, 800, 600);
        g2d.setColor(Color.decode("#ffcdb2"));
        g2d.fill(background);

        FeedingCats feedingCats = new FeedingCats(98.4, 375, 1, Color.decode("#242424"), Color.decode("#898989"), Color.decode("#ACA8A9"));
    }
}