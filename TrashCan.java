import java.awt.*;
import java.awt.geom.*;

public class TrashCan implements DrawingObject {
    private double x, y, size;
    private Color color;

    public TrashCan(double xPositon, double yPosition, double size, Color color){
        x = xPositon;
        y = yPosition;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.setColor(color);

        // Lid
        Rectangle2D.Double r = new Rectangle2D.Double(size*(x+17.5), size*y, size*55.9, size*12.3);
        g2d.fill(r);
        r = new Rectangle2D.Double(size*(x+0.5), size*(y+11.8), size*90.3, size*12.3);
        g2d.fill(r);

        // Body
        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(size*(x+22.5), size*(y+114.7));
        quadPoints[1] = new Point2D.Double(size*(x+0.5), size*(y+12.7));
        quadPoints[2] = new Point2D.Double(size*(x+89.9), size*(y+12.3));
        quadPoints[3] = new Point2D.Double(size*(x+66.7), size*(y+114.7));
        Quadrilateral body = new Quadrilateral(quadPoints, color, true);
        body.draw(g2d);
    };

    @Override
    public void adjustX(double distance){
        x += distance;
    };

}
