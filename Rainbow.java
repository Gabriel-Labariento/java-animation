import java.awt.*;

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

        Circle redCircle = new Circle(size*x, size*y, size*242, RED);
        Circle orangeCircle = new Circle(size*(x+6.4), size*(y+6.4), size*229.2, ORANGE);
        Circle yellowCircle = new Circle(size*(x+12.7), size*(y+12.7), size*216.5, YELLOW);
        Circle greenCircle = new Circle(size*(x+19.1), size*(y+19.1), size*203.8, GREEN);
        Circle blueCircle = new Circle(size*(x+25.5), size*(y+25.5), size*191, BLUE);
        Circle centerCircle = new Circle(size*(x+31.8), size*(y+31.8), size*178.3, centerColor); 


        redCircle.draw(g2d);
        orangeCircle.draw(g2d);
        yellowCircle.draw(g2d);
        greenCircle.draw(g2d);
        blueCircle.draw(g2d);
        centerCircle.draw(g2d);
    };

    public double getX(){
        return x;
    }

    public void adjustX(double distance){
        x += distance;
    };
}
