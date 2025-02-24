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
        g2d.translate(x, y);
        g2d.scale(size, size);
        g2d.setColor(color);

        // Lid
        Rectangle2D.Double r = new Rectangle2D.Double((17.5), 0, 55.9, 12.3);
        g2d.fill(r);
        r = new Rectangle2D.Double((0.5), (11.8), 90.3, 12.3);
        g2d.fill(r);

        // Body
        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double((22.5), (114.7));
        quadPoints[1] = new Point2D.Double((0.5), (12.7));
        quadPoints[2] = new Point2D.Double((89.9), (12.3));
        quadPoints[3] = new Point2D.Double((66.7), (114.7));
        Quadrilateral body = new Quadrilateral(quadPoints, color, true);
        body.draw(g2d);

        g2d.setTransform(reset);
    };

    // @Override
    // public void adjustX(double distance){
    //     x += distance;
    // };

}
