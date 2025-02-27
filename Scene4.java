import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;


public class Scene4 implements DrawingObject {
    private SceneCanvas sceneCanvas;
    private double width;
    private double height;
    private boolean areCatsFighting;
    private boolean isDoneFighting;

    public Scene4(SceneCanvas sc,int w, int h, boolean areCatsFighting, boolean isDoneFighting){
        sceneCanvas = sc;
        width = w;
        height = h;
        this.areCatsFighting = areCatsFighting;
        this.isDoneFighting = isDoneFighting;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#c6e1e8"));
        g2d.fill(background);

        Cloud cloud = new Cloud(519.5, 4.2, 0.36, Color.decode("#1f2020"));
        cloud.draw(g2d);
        
        Circle sun = new Circle(446.2, 44, 63.6, Color.decode("#fffdfd"));
        sun.draw(g2d);

        Rectangle2D.Double backBuilding1 = new Rectangle2D.Double(372.7, 72.2, 99.4, 296.2);
        Rectangle2D.Double backBuilding2 = new Rectangle2D.Double(493, 151.9, 99.4, 216.8);
        Rectangle2D.Double backBuilding3 = new Rectangle2D.Double(249.9, 244.4, 255.8, 124.2);
        Rectangle2D.Double backBuilding4 = new Rectangle2D.Double(519.5, 187.9, 349.4, 181.5);
        Rectangle2D.Double backBuilding5 = new Rectangle2D.Double(542.7, 9.4, 302.9, 359.2);
        Rectangle2D.Double backBuilding6 = new Rectangle2D.Double(-25.6, -67.2, 481.8, 435.8);
        Rectangle2D.Double backBuilding7 = new Rectangle2D.Double(589.4, -67.2, 328.6, 435.8);
        Rectangle2D.Double middleGround = new Rectangle2D.Double(0, 354.6, 800, 245.4);
        Rectangle2D.Double foreGround = new Rectangle2D.Double(0, 454.2, 800, 145.8);
        g2d.setColor(Color.decode("#f1f1f1"));
        g2d.fill(backBuilding1);
        g2d.fill(backBuilding2);
        g2d.setColor(Color.decode("#d6d6d6"));
        g2d.fill(backBuilding3);
        g2d.fill(backBuilding4);
        g2d.fill(backBuilding5);
        g2d.setColor(Color.decode("#b6b6b6"));
        g2d.fill(backBuilding6);
        g2d.fill(backBuilding7);
        g2d.setColor(Color.decode("#a1a7ad"));
        g2d.fill(middleGround);
        g2d.setColor(Color.decode("#6c7a89"));
        g2d.fill(foreGround);

        TrashCan trashCan1 = new TrashCan(706.5, 308, 0.52, Color.decode("#6c7a89"));
        TrashCan trashCan2 = new TrashCan(-158.8, 253.3, 2.6, Color.decode("#242424"));
        trashCan1.draw(g2d);
        trashCan2.draw(g2d);

        ArrayList<DrawingObject> drawingObjects = sceneCanvas.getDrawingObjects();

        if (areCatsFighting){
            AngryCat enemyCat = new AngryCat(519.5, 377.6, 1.10, Color.decode("#242424"));
            enemyCat.draw(g2d);
        } 
        else if (isDoneFighting){
            drawingObjects.add(new WalkingCat(519.5, 377.6, 1, 0, Color.decode("#242424")));
        } else {
            SittingCat enemyCat = new SittingCat(519.5, 377.6, 1.10, Color.decode("#242424"));
            enemyCat.draw(g2d);
        } 
    }

    @Override
    public void setColor(Color color) {};
}