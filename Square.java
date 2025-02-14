import java.awt.*;
import java.awt.geom.*;

public class Square implements DrawingObject {
    private double xPosition;
    private double yPosition;
    private double size;
    private Color color;

    public Square(double xPosition, double yPosition, double size, Color color){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double square = new Rectangle2D.Double(xPosition, yPosition, size, size);
        g2d.setColor(color);
        g2d.fill(square);
    }
}