import java.awt.*;
// import java.awt.geom.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    
    private int width;
    private int height;
    // private SittingCat sittingCat1;
    // private SittingCat sittingCat2;
    private WalkingCat walkingCat;

    public SceneCanvas(int w, int h){
        width = w;
        height = h;
        // sittingCat1 = new SittingCat(300, 20, 2, Color.BLACK);
        // sittingCat2 = new SittingCat(50, 30, 1.5, Color.BLACK);
        walkingCat = new WalkingCat(0, 0, 1, 0, Color.BLACK);
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints( rh);

        walkingCat.draw(g2d);
        // sittingCat1.draw(g2d);
        // sittingCat2.draw(g2d);
    }
}