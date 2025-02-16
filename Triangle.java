import java.awt.*;
import java.awt.geom.*;

public class Triangle implements DrawingObject {
    private double xOne;
    private double yOne;
    private double xTwo;
    private double yTwo;
    private double xThree;
    private double yThree;
    private Color color;
    private boolean fill;

    public Triangle(double xOne, double yOne, double xTwo, double yTwo, double xThree, double yThree, Color color, boolean fill){
        this.xOne = xOne;     
        this.yOne = yOne;
        this.xTwo = xTwo;
        this.xTwo = xTwo;
        this.yTwo = yTwo;
        this.xThree = xThree;
        this.yThree = yThree;
        this.color = color;
        this.fill = fill;
    }

    @Override
    public void draw(Graphics2D g2d){
        Path2D.Double p = new Path2D.Double();
        p.moveTo(xOne, yOne);
        p.lineTo(xTwo, yTwo);
        p.lineTo(xThree, yThree);
        p.closePath();
        
        g2d.setColor(color);

        if (fill) g2d.fill(p);
        else g2d.draw(p);
        
    }
}