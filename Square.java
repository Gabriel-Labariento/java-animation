import java.awt.*;
import java.awt.geom.*;

public class Square implements DrawingObject {
    private int xPosition;
    private int yPosition;
    private int size;
    private Color color;

    public Square(int xPosition, int yPosition, int size, Color color){
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