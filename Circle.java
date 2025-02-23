import java.awt.*;
import java.awt.geom.*;


public class Circle implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;

    public Circle(double xPosition, double yPosition, double size, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(circle);
    }

    public void adjustX(double distance){
        x += distance;
    }
}