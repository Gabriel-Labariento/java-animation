import java.awt.*;

public interface DrawingObject {
    void draw(Graphics2D g2d);
    void adjustX(double distance);
}