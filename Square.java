import java.awt.*;
import java.awt.geom.*;

public class Square implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;

    public Square(double xPosition, double yPosition, double size, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void adjustX(double distance){
        x += distance;
    }

    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double square = new Rectangle2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(square);
    }
}