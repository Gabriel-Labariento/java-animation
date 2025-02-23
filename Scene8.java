import java.awt.*;
import java.awt.geom.*;

public class Scene8 implements DrawingObject {
    private double width;
    private double height;

    public Scene8(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#394252"));
        g2d.fill(background);

        Rectangle2D.Double foreground = new Rectangle2D.Double(0, 482, 800, 118.1);
        g2d.setColor(Color.decode("#2c3442"));
        g2d.fill(foreground);

        Door door = new Door(0, 0, 1);
        door.draw(g2d);
    }
}