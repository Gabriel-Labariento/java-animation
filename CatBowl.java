import java.awt.*;
import java.awt.geom.*;

public class CatBowl implements DrawingObject{
    private double x, y, size;
    private Color colorOne, colorTwo;

    public CatBowl(double xPositon, double yPosition, double size, Color colorOne, Color colorTwo){
        x = xPositon;
        y = yPosition;
        this.size = size;
        this.colorOne = colorOne;
        this.colorTwo = colorTwo;
    }

    @Override
    public void adjustX(double distance){
        x += distance;
    }

    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(colorOne);
        
        Ellipse2D.Double e = new Ellipse2D.Double(size*(x+10.1), size*y, size*113.1, size*13.2);
        g2d.fill(e);

        g2d.setColor(colorTwo);
        e = new Ellipse2D.Double(size*(x+18.1), size*(y+2.8), size*97.1, size*8.5);
        g2d.fill(e);

        g2d.setColor(colorOne);
        e = new Ellipse2D.Double(size*(x), size*(y+31.7), size*133.2, size*13.2);
        g2d.fill(e);


        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(size*x, size*(y+37.2));
        quadPoints[1] = new Point2D.Double(size*(x+9.3), size*(y+7.4));
        quadPoints[2] = new Point2D.Double(size*(x+122.2), size*(y+7.4));
        quadPoints[3] = new Point2D.Double(size*(x+131.6), size*(y+37.2));
        Quadrilateral bowl = new Quadrilateral(quadPoints, colorOne, true);
        bowl.draw(g2d);
        
    };

}
