import java.awt.*;
import java.awt.geom.*;

public class Scene5 implements DrawingObject {
    private double width;
    private double height;

    public Scene5(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
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
        Grass g8 = new Grass(-23.4, 524, 0.68, grassColor);
        g1.draw(g2d);
        g2.draw(g2d);
        g3.draw(g2d);
        g4.draw(g2d);
        g5.draw(g2d);
        g6.draw(g2d);
        g7.draw(g2d);
        g8.draw(g2d);
    }

    @Override
    public void setColor(Color color) {};
}