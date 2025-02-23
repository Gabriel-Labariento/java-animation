import java.awt.*;
import java.awt.geom.*;

public class Scene2 implements DrawingObject {
    private double width;
    private double height;

    public Scene2(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Color cloudColor = Color.decode("#1f2020");
        Color hillColor = Color.decode("#64d189");
        Color grassColor = Color.decode("#00a262");
        Color puddleColor = Color.decode("#c0e1ff");

        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#ffdb6f"));
        g2d.fill(background);

        Rainbow rainbow = new Rainbow(-119.2, 60, 2.59, Color.decode("#ffdb6f"));
        rainbow.draw(g2d);

        Circle sun = new Circle(151, 167.7, 63.6, Color.decode("#fffdfd"));
        sun.draw(g2d);

        Cloud c1 = new Cloud(-3.7, 276.6, 0.84, cloudColor);
        c1.draw(g2d);

        Rectangle2D.Double horizon = new Rectangle2D.Double(0, 354.6, 800, 245.4);
        g2d.setColor(Color.decode("#8fedaf"));
        g2d.fill(horizon);

        Ellipse2D.Double hill = new Ellipse2D.Double(-939.1, 217.1, 1102.3, 344.3);
        g2d.setColor(hillColor);
        g2d.fill(hill);

        Cloud c2 = new Cloud(196.6, 200.3, 0.42, cloudColor);
        Cloud c3 = new Cloud(520.7, 259.8, 0.64, cloudColor);
        Cloud c4 = new Cloud(466.6, 296, 0.85, cloudColor);
        Cloud c5 = new Cloud(179.8, 217.1, 0.26, cloudColor);
        c2.draw(g2d);
        c3.draw(g2d);
        c4.draw(g2d);
        c5.draw(g2d);

        hill = new Ellipse2D.Double(317.2, 272, 1021.8, 344.3);
        g2d.setColor(hillColor);
        g2d.fill(hill);

        Buildings b1 = new Buildings(625.2, 142.7, 1.28, Color.decode("#242424"), Color.decode("#aca8a9"), Color.decode("#ebebeb"));       
        b1.draw(g2d);

        hill = new Ellipse2D.Double(466.6, 263.6, 1021.8, 344.3);
        g2d.setColor(hillColor);
        g2d.fill(hill);

        Rectangle2D.Double foreground = new Rectangle2D.Double(0, 380.2, 800, 219.8);
        g2d.setColor(Color.decode("#16c47f"));
        g2d.fill(foreground);

        Ellipse2D.Double p1 = new Ellipse2D.Double(218.8, 490.1, 738.2, 303.2);
        Ellipse2D.Double p2 = new Ellipse2D.Double(479.6, 444.1, 738.2, 303.2);
        g2d.setColor(puddleColor);
        g2d.fill(p1);
        g2d.fill(p2);

        Grass g1 = new Grass(-18.7, 338.7, 0.79, grassColor);
        Grass g2 = new Grass(202.3, 300, 0.89, grassColor);
        Grass g3 = new Grass(47.4, 319.3, 0.79, grassColor);
        Grass g4 = new Grass(-102.8, 260.7, 1.18, grassColor);
        Grass g5 = new Grass(628.1, 516.9, 1.33, grassColor);
        Grass g6 = new Grass(530.8, 550.7, 1.33, grassColor);
        g1.draw(g2d);
        g2.draw(g2d);
        g3.draw(g2d);
        g4.draw(g2d);
        g5.draw(g2d);
        g6.draw(g2d);

    }
}