import java.awt.*;
import java.awt.geom.*;

public class Triangle implements DrawingObject {
    private double[] xPoints;
    private double[] yPoints;
    private Color color;
    private boolean fill;

    public Triangle(double[] xPoints, double[] yPoints, Color color, boolean fill){
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.color = color;
        this.fill = fill;
    }

    @Override
    public void draw(Graphics2D g2d){
        Path2D.Double p = new Path2D.Double();
        
        if (xPoints.length != 3 || yPoints.length != 3) return;

        p.moveTo(xPoints[0], yPoints[0]);
        for (int i = 1; i < 3; i++){
            p.moveTo(xPoints[i], yPoints[i]);
        }
        p.closePath();
        
        g2d.setColor(color);

        if (fill) g2d.fill(p);
        else g2d.draw(p);
        
    }
}