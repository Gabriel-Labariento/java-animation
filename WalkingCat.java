import java.awt.*;
import java.awt.geom.*;

public class WalkingCat implements DrawingObject {

    private Color color;

    public WalkingCat(Color color){
        this.color = color;
    }

    public void draw(Graphics2D g2d){
        drawSnout(g2d);
        drawHead(g2d);

        
    }


    private void drawSnout(Graphics2D g2d){
        Point2D.Double[] snoutPoints = new Point2D.Double[4];
        snoutPoints[0] = new Point2D.Double(278.4, 439.1);
        snoutPoints[1] = new Point2D.Double(293.4, 431.4);
        snoutPoints[2] = new Point2D.Double(295.6, 444.1);
        snoutPoints[3] = new Point2D.Double(286, 448.1);
        Trapezoid snout = new Trapezoid(snoutPoints, color, true);
        snout.draw(g2d);
    }

    private void drawHead(Graphics2D g2d){
        Circle head = new Circle(262.1, 409.9, 37.1, Color.BLACK);
        head.draw(g2d);

        Point2D.Double[] earOnePoints = new Point2D.Double[3];
        earOnePoints[0] = new Point2D.Double(272.4, 407);
        earOnePoints[1] = new Point2D.Double(288.5, 398);
        earOnePoints[2] = new Point2D.Double(284.5, 415.1);
        Triangle earOne = new Triangle(earOnePoints, Color.BLACK, true);

        Point2D.Double[] earTwoPoints = new Point2D.Double[3];
        earTwoPoints[0] = new Point2D.Double(266.7, 417);
        earTwoPoints[1] = new Point2D.Double(269.6, 393.5);
        earTwoPoints[2] = new Point2D.Double(285.1, 407);
        Triangle earTwo = new Triangle(earTwoPoints, Color.BLACK, true);

        earOne.draw(g2d);
        earTwo.draw(g2d);
    }
    
    // private void drawBody(Graphics2D g2d){
    //     Ellipse2D.Double e1 = new Ellipse2D.
    // }

}