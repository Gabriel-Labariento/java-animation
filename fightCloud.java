import java.awt.*;
import java.awt.geom.AffineTransform;

public class fightCloud implements DrawingObject{
    private double x, y, size;

    public fightCloud(double xPositon, double yPosition, double size){
        x = xPositon;
        y = yPosition;
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        drawFightCloudNoScaling(g2d);
        g2d.setTransform(reset);
    }

    private void drawFightCloudNoScaling(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Color colorOne = Color.decode("#b6b6b6");
        Color colorTwo = Color.decode("#eeeeee");
        Color colorThree = Color.decode("#898989");

        g2d.setColor(colorOne);
        Cloud c = new Cloud(0, 132.2, 1, colorOne);
        g2d.rotate(Math.toRadians(-61.8), c.getX(), c.getY());
        c.draw(g2d);
        g2d.setTransform(reset);

        c = new Cloud(52.9, 13.9, 1, colorThree);
        c.draw(g2d);

        c = new Cloud(49.5, 158.7, 1, colorTwo);
        g2d.rotate(Math.toRadians(-61.8), c.getX(), c.getY());
        c.draw(g2d);
        g2d.setTransform(reset);

        c = new Cloud(216.7, 139, 1, colorThree);
        g2d.rotate(Math.toRadians(140.3), c.getX(), c.getY());
        c.draw(g2d);
        g2d.setTransform(reset);

        c = new Cloud(227.1, 38.2, 1, colorOne);
        g2d.rotate(Math.toRadians(95.1), c.getX(), c.getY());
        c.draw(g2d);
        g2d.setTransform(reset);
        
    }
}
