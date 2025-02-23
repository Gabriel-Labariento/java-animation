import java.awt.*;
import java.awt.geom.*;

public class Door implements DrawingObject{
    private double x;
    private double y;
    private double size;
    private AlphaComposite ac;

    public Door(double xPosition, double yPosition, double size){
        x = xPosition;
        y = yPosition;
        this.size = size;
        ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f); 
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        
        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(735.4, 38.7);
        quadPoints[1] = new Point2D.Double(735.4, 500.3);
        quadPoints[2] = new Point2D.Double(800, 515.4);
        quadPoints[3] = new Point2D.Double(800, 23.9);
        Quadrilateral doorFrame = new Quadrilateral(quadPoints, Color.decode("#556265"), true);
        doorFrame.draw(g2d);

        quadPoints[2] = new Point2D.Double(557.4, 539.7);
        quadPoints[3] = new Point2D.Double(557.4, 0);
        Quadrilateral doorFront = new Quadrilateral(quadPoints, Color.decode("#354649"), true);
        doorFront.draw(g2d);

        quadPoints[0] = new Point2D.Double(552.4, 38.7);
        quadPoints[1] = new Point2D.Double(552.4, 503.2);
        Quadrilateral doorSide = new Quadrilateral(quadPoints, Color.decode("#081a2c"), true);
        doorSide.draw(g2d);

        quadPoints[0] = new Point2D.Double(745.4, 49.6);
        quadPoints[1] = new Point2D.Double(800, 38.7);
        quadPoints[2] = new Point2D.Double(800, 513.9);
        quadPoints[3] = new Point2D.Double(742.8, 500.3);
        Quadrilateral outside = new Quadrilateral(quadPoints, Color.WHITE, true);
        outside.draw(g2d);

        quadPoints[2] = new Point2D.Double(800, 600);
        quadPoints[3] = new Point2D.Double(248, 600);
        Quadrilateral light = new Quadrilateral(quadPoints, Color.WHITE, true);
        g2d.setComposite(ac);
        light.draw(g2d);

        ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f); 
        g2d.setComposite(ac);
        g2d.setTransform(reset);
    };

    public void adjustX(double distance){
        x += distance;
    };

    
    
}
