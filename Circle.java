import java.awt.*;
import java.awt.geom.*;


public class Circle implements DrawingObject {
    private double xPosition;
    private double yPosition;
    private double size;
    private Color color;

    public Circle(double xPosition, double yPosition, double size, Color color){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.size = size;
        this.color = color;
    }


    @Override
    public void draw(Graphics2D g2d){
        Ellipse2D.Double circle = new Ellipse2D.Double(xPosition, yPosition, size, size);
        g2d.setColor(color);
        g2d.fill(circle);
    }
}