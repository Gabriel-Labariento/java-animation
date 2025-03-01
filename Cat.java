import java.awt.Graphics2D;

public interface Cat {
    void adjustX(double distance);
    void changeFrame();
    double getX();
    double getCatLength();
    void draw(Graphics2D g2d);
    void setIsLimping(boolean isLimping);
}
