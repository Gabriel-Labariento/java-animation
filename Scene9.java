import java.awt.*;
import java.awt.geom.*;

public class Scene9 implements DrawingObject {
    private double width;
    private double height;

    public Scene9(int w, int h){
        width = w;
        height = h;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();

        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(Color.decode("#eb5a3c"));
        g2d.fill(background);

        Circle sun = new Circle(119.5, 322.8, 63.6, Color.decode("#edf4c2"));
        sun.draw(g2d);

        Color sceneBlack = Color.decode("#1f2020");
        Cloud c1 = new Cloud(522.9, 90.5, 1.03, sceneBlack);
        Cloud c2 = new Cloud(575, 39.3, 1.33, sceneBlack);
        Cloud c3 = new Cloud(654.7, 82.1, 1.33, sceneBlack);
        Cloud c4 = new Cloud(281.3, 198.4, 0.45, sceneBlack);
        Cloud c5 = new Cloud(268.5, 194, 0.31, sceneBlack);
        Cloud c6 = new Cloud(254.7, 202.2, 0.31, sceneBlack);
        Cloud c7 = new Cloud(85, 338.8, 0.34, sceneBlack);
        c1.draw(g2d);
        c2.draw(g2d);
        c3.draw(g2d);
        c4.draw(g2d);
        c5.draw(g2d);
        c6.draw(g2d);
        c7.draw(g2d);

        Rectangle2D.Double backMountain1 = new Rectangle2D.Double(-121.8, 466.8, 180, 180);
        g2d.setColor(Color.decode("#fae9a6"));
        g2d.rotate(Math.toRadians(-69.3), backMountain1.getX(), backMountain1.getY());
        g2d.fill(backMountain1);
        g2d.setTransform(reset);

        Rectangle2D.Double middleGround = new Rectangle2D.Double(0, 355.6, 800, 244.4);
        g2d.setColor(Color.decode("#e7d283"));
        g2d.fill(middleGround);

        Ellipse2D.Double river1 = new Ellipse2D.Double(55.4, 354.6, 219.9, 119.6);
        g2d.setColor(Color.decode("#edf4c2"));
        g2d.fill(river1);

        Ellipse2D.Double river2 = new Ellipse2D.Double(78, 352.4, 220.3, 120.7);
        g2d.setColor(Color.decode("#e7d283"));
        g2d.fill(river2);

        Ellipse2D.Double backMountain2 = new Ellipse2D.Double(194.3, 345.3, 407.3, 17.3);
        g2d.setColor(Color.decode("#fae9a6"));
        g2d.fill(backMountain2);

        Ellipse2D.Double middleMountain1 = new Ellipse2D.Double(245.1, 375.9, 396.6, 31.8);
        g2d.setColor(Color.decode("#edf4c2"));
        g2d.fill(middleMountain1);

        Point2D.Double[] triPoints = new Point2D.Double[3];
        triPoints[0] = new Point2D.Double(246.1, 392.4);
        triPoints[1] = new Point2D.Double(399.7, 391.8);
        triPoints[2] = new Point2D.Double(322.4, 313.1);
        Triangle middleMountain2 = new Triangle(triPoints, Color.decode("#edf4c2"), true);
        middleMountain2.draw(g2d);

        triPoints[0] = new Point2D.Double(385.7, 288.2);
        triPoints[1] = new Point2D.Double(265.9, 382.6);
        triPoints[2] = new Point2D.Double(504.8, 382.6);
        Triangle middleMountain3 = new Triangle(triPoints, Color.decode("#edf4c2"), true);
        middleMountain3.draw(g2d);

        Ellipse2D.Double middleMountain4 = new Ellipse2D.Double(398.1, 281, 67.3, 26.4);
        g2d.rotate(Math.toRadians(60.2), middleMountain4.getX(), middleMountain4.getY());
        g2d.setColor(Color.decode("#edf4c2"));
        g2d.fill(middleMountain4);
        g2d.setTransform(reset);

        Ellipse2D.Double middleMountain5 = new Ellipse2D.Double(335.1, 305.8, 67.3, 26.4);
        g2d.rotate(Math.toRadians(60.2), middleMountain5.getX(), middleMountain5.getY());
        g2d.setColor(Color.decode("#edf4c2"));
        g2d.fill(middleMountain5);
        g2d.setTransform(reset);

        Ellipse2D.Double frontMountain1 = new Ellipse2D.Double(318.3, 352.4, 1385.5, 153.3);
        g2d.setColor(Color.decode("#ebda9b"));
        g2d.fill(frontMountain1);

        Point2D.Double[] quadPoints = new Point2D.Double[4];
        quadPoints[0] = new Point2D.Double(611.6, 186.7);
        quadPoints[1] = new Point2D.Double(391.6, 378.9);
        quadPoints[2] = new Point2D.Double(800, 378.9);
        quadPoints[3] = new Point2D.Double(800, 351.5);
        Quadrilateral frontMountain2 = new Quadrilateral(quadPoints, Color.decode("#ebda9b"), true);
        frontMountain2.draw(g2d);

        triPoints[0] = new Point2D.Double(456, 288.2);
        triPoints[1] = new Point2D.Double(315.6, 431.2);
        triPoints[2] = new Point2D.Double(596.2, 431.2);
        Triangle frontMountain3 = new Triangle(triPoints, Color.decode("#ebda9b"), true);
        frontMountain3.draw(g2d);

        Ellipse2D.Double frontMountain4 = new Ellipse2D.Double(672.1, 151.3, 195, 125);
        g2d.rotate(Math.toRadians(60.2), frontMountain4.getX(), frontMountain4.getY());
        g2d.setColor(Color.decode("#ebda9b"));
        g2d.fill(frontMountain4);
        g2d.setTransform(reset);

        triPoints[0] = new Point2D.Double(585.7, 324.3);
        triPoints[1] = new Point2D.Double(800, 324.3);
        triPoints[2] = new Point2D.Double(800, 168.4);
        Triangle frontMountain5 = new Triangle(triPoints, Color.decode("#ebda9b"), true);
        frontMountain5.draw(g2d);

        Ellipse2D.Double frontMountain6 = new Ellipse2D.Double(493.4, 265.9, 195, 76.5);
        g2d.rotate(Math.toRadians(60.2), frontMountain6.getX(), frontMountain6.getY());
        g2d.setColor(Color.decode("#ebda9b"));
        g2d.fill(frontMountain6);
        g2d.setTransform(reset);

        Ellipse2D.Double frontMountain7 = new Ellipse2D.Double(-314.8, 431.2, 509.1, 126.6);
        g2d.setColor(Color.decode("#ebda9b"));
        g2d.fill(frontMountain7);

        Tree tree = new Tree(561.9, 265.3, 0.87, sceneBlack);
        tree.draw(g2d);

        Grass g1 = new Grass(294.3, 427.4, 0.65, sceneBlack);
        Grass g2 = new Grass(110.2, 459.1, 0.65, sceneBlack);
        g1.draw(g2d);
        g2.draw(g2d);

        Ellipse2D.Double foreground = new Ellipse2D.Double(-356.2, 459.1, 1681.6, 428.9);
        g2d.setColor(Color.decode("#edf4c2"));
        g2d.fill(foreground);

        Ellipse2D.Double tree2 = new Ellipse2D.Double(471.1, 565.6, 621.3, 242.6);
        g2d.setColor(sceneBlack);
        g2d.fill(tree2);

        Rectangle2D.Double tree3 = new Rectangle2D.Double(778.7, 0, 180, 597.4);
        g2d.setColor(sceneBlack);
        g2d.rotate(Math.toRadians(4), tree3.getX(), tree3.getY());
        g2d.fill(tree3);
        g2d.setTransform(reset);

        Grass g3 = new Grass(-117, 370.1, 1.87, sceneBlack);
        Grass g4 = new Grass(650.6, 431.2, 1.32, sceneBlack);
        Grass g5 = new Grass(353.3, 499.9, 0.94, sceneBlack);
        g3.draw(g2d);
        g4.draw(g2d);
        g5.draw(g2d);
    }
}