import java.awt.*;
import java.awt.geom.AffineTransform;

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

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        Circle c = new Circle((5.7), (32), 64, color);
        c.draw(g2d);
        c = new Circle((32.7), (3.2), 64, color);
        c.draw(g2d);
        c = new Circle((48.5), (37.7), 64, color);
        c.draw(g2d);
        c = new Circle((61), (3.2), 64, color);
        c.draw(g2d);
        c = new Circle((91.3), (32), 64, color);
        c.draw(g2d);

        g2d.setTransform(reset);
    };

    public void adjustX(double distance){
        x += distance;
    };

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    
    
}
