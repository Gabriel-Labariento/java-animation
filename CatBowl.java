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
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        g2d.setColor(colorOne);
        
        Ellipse2D.Double e = new Ellipse2D.Double((10.1), y, 113.1, 13.2);
        g2d.fill(e);

        g2d.setColor(colorTwo);
        e = new Ellipse2D.Double((18.1), (2.8), 97.1, 8.5);
        g2d.fill(e);

        g2d.setColor(colorOne);
        e = new Ellipse2D.Double((x), (31.7), 133.2, 13.2);
        g2d.fill(e);


        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(0, (37.2));
        quadPoints[1] = new Point2D.Double((9.3), (7.4));
        quadPoints[2] = new Point2D.Double((122.2), (7.4));
        quadPoints[3] = new Point2D.Double((131.6), (37.2));
        Quadrilateral bowl = new Quadrilateral(quadPoints, colorOne, true);
        bowl.draw(g2d);
        
        g2d.setTransform(reset);
    };

}
