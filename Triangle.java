import java.awt.*;
import java.awt.geom.*;

public class Triangle implements DrawingObject {
    private Point2D.Double[] points;
    private Color color;
    private boolean fill;

    public Triangle(Point2D.Double[] points, Color color, boolean fill){
        this.points = points;
        this.color = color;
        this.fill = fill;
    }

    @Override
    public void draw(Graphics2D g2d){        
        if (points.length != 3) return;

        Path2D.Double p = new Path2D.Double();
        
        p.moveTo(points[0].getX(), points[0].getY());
        for (int i = 1; i < 3; i++){
            p.lineTo(points[i].getX(), points[i].getY());
        }
        p.closePath();
        
        g2d.setColor(color);

        if (fill) g2d.fill(p);
        else g2d.draw(p);

    }
}