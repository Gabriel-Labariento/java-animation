import java.awt.*;

public class Cloud implements DrawingObject{
    private double x;
    private double y;
    private double size;
    private Color color;

    public Cloud(double xPosition, double yPosition, double size, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics2D g2d){
        Circle c = new Circle(size*(x+5.7), size*(y+32), size*64, color);
        c.draw(g2d);
        c = new Circle(size*(x+32.7), size*(y+3.2), size*64, color);
        c.draw(g2d);
        c = new Circle(size*(x+48.5), size*(y+37.7), size*64, color);
        c.draw(g2d);
        c = new Circle(size*(x+61), size*(y+3.2), size*64, color);
        c.draw(g2d);
        c = new Circle(size*(x+91.3), size*(y+32), size*64, color);
        c.draw(g2d);
    };

    public void adjustX(double distance){
        x += distance;
    };

    
    
}
