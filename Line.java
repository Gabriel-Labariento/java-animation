import java.awt.*;
import java.awt.geom.*;

public class Line implements DrawingObject {
    private double xStart;
    private double yStart;
    private double xEnd;
    private double yEnd;
    private double thickness;
    private Color color;

    public Line(double xStart, double yStart, double xEnd, double yEnd, double thickness, Color color){
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.thickness = thickness;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        Line2D.Double line = new Line2D.Double(xStart, yStart, xEnd, yEnd);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke((float)thickness));
        g2d.draw(line);
    }
}