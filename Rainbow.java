import java.awt.*;
import java.awt.geom.AffineTransform;

public class Rainbow implements DrawingObject{
    private double x;
    private double y;
    private double size;
    private Color centerColor;

    public Rainbow(double xPosition, double yPosition, double size, Color centerColor){
        x = xPosition;
        y = yPosition;
        this.size = size;
        this.centerColor = centerColor;
    }

    public void draw(Graphics2D g2d){
        final Color RED = new Color(195, 45, 47);
        final Color ORANGE = new Color(236, 83, 34);
        final Color YELLOW = new Color(228, 182, 10);
        final Color GREEN = new Color(1, 143, 77);
        final Color BLUE = new Color(74, 165, 249);

        Circle redCircle = new Circle(0, 0, 242, RED);
        Circle orangeCircle = new Circle((6.4), (6.4), 229.2, ORANGE);
        Circle yellowCircle = new Circle((12.7), (12.7), 216.5, YELLOW);
        Circle greenCircle = new Circle((19.1), (19.1), 203.8, GREEN);
        Circle blueCircle = new Circle((25.5), (25.5), 191, BLUE);
        Circle centerCircle = new Circle((31.8), (31.8), 178.3, centerColor); 

        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);
        redCircle.draw(g2d);
        orangeCircle.draw(g2d);
        yellowCircle.draw(g2d);
        greenCircle.draw(g2d);
        blueCircle.draw(g2d);
        centerCircle.draw(g2d);
        g2d.setTransform(reset);
    };

    public double getX(){
        return x;
    }

    public void adjustX(double distance){
        x += distance;
    };
}
