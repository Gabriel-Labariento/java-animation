import java.awt.*;
import java.awt.geom.*;

public class WalkingCat implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private int walkFrame;
    private Color color;

    public WalkingCat(double xPosition, double yPosition, double size, int walkFrame, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        if (walkFrame > 3) this.walkFrame = 3;
        else this.walkFrame = walkFrame;
        this.color = color;
    }

    public void draw(Graphics2D g2d){
        drawSnout(g2d);
        drawHead(g2d, walkFrame);
        drawBody(g2d, walkFrame);
        drawLegs(g2d, walkFrame);
        drawTail(g2d, walkFrame);
    }


    private void drawSnout(Graphics2D g2d){
        Point2D.Double[] snoutPoints = new Point2D.Double[4];
        snoutPoints[0] = new Point2D.Double(size*(x+200.9), size*(y+45.4));
        snoutPoints[1] = new Point2D.Double(size*(x+218.2), size*(y+30));
        snoutPoints[2] = new Point2D.Double(size*(x+224.9), size*(y+43.1));
        snoutPoints[3] = new Point2D.Double(size*(x+211.8), size*(y+53.4));
        Trapezoid snout = new Trapezoid(snoutPoints, color, true);
        snout.draw(g2d);
    }

    private void drawHead(Graphics2D g2d, int walkFrame){

        Ellipse2D.Double head = new Ellipse2D.Double();
        Point2D.Double[] earOnePoints = new Point2D.Double[3];
        Point2D.Double[] earTwoPoints = new Point2D.Double[3];

        if (walkFrame == 0){
            head.setFrame(size*(x+190.7), size*(y+14.3), size*34.7, size*34);
            earOnePoints[0] = new Point2D.Double(size*(x+195.2), size*(y+16.8));
            earOnePoints[1] = new Point2D.Double(size*(x+217.4), size*(y+7));
            earOnePoints[2] = new Point2D.Double(size*(x+213.4), size*(y+30.5));
            earTwoPoints[0] = new Point2D.Double(size*(x+190.7), size*(y+20.5));
            earTwoPoints[1] = new Point2D.Double(size*(x+202.2), size*(y));
            earTwoPoints[2] = new Point2D.Double(size*(x+214), size*(y+20.9));
        } else if (walkFrame == 1){
            head.setFrame(size*(x+183.4), size*(y+14.2), size*32.6, size*32);
            earOnePoints[0] = new Point2D.Double(size*(x+180.1), size*(y+19.3));
            earOnePoints[1] = new Point2D.Double(size*(x+190.9), size*(y));
            earOnePoints[2] = new Point2D.Double(size*(x+201.6), size*(y+20));
            earTwoPoints[0] = new Point2D.Double(size*(x+188.1), size*(y+16.4));
            earTwoPoints[1] = new Point2D.Double(size*(x+208.8), size*(y+7));
            earTwoPoints[2] = new Point2D.Double(size*(x+204.5), size*(y+28.9));
        } else if (walkFrame == 2){
            head.setFrame(size*(x+180.8), size*(y+15), size*29.9, size*29.3);
            earOnePoints[0] = new Point2D.Double(size*(x+182.9), size*(y+13.7));
            earOnePoints[1] = new Point2D.Double(size*(x+201.5), size*(y+5.4));
            earOnePoints[2] = new Point2D.Double(size*(x+197.7), size*(y+25.5));
            earTwoPoints[0] = new Point2D.Double(size*(x+178.1), size*(y+19.2));
            earTwoPoints[1] = new Point2D.Double(size*(x+187.9), size*(y+1.3));
            earTwoPoints[2] = new Point2D.Double(size*(x+197.6), size*(y+19.2));
        }

        Triangle earOne = new Triangle(earOnePoints, Color.BLACK, true);
        Triangle earTwo = new Triangle(earTwoPoints, Color.BLACK, true);

        g2d.fill(head);
        earOne.draw(g2d);
        earTwo.draw(g2d);
    }
    
    private void drawBody(Graphics2D g2d, int walkFrame){
        AffineTransform reset = g2d.getTransform();

        if (walkFrame == 0){
            Ellipse2D.Double e1 = new Ellipse2D.Double(size*(x+130.5), size*(y+10.4), size*76.8, size*30.1);
            Ellipse2D.Double e2 = new Ellipse2D.Double(size*(x+86.4), size*(y+18.4), size*114.1, size*40.4);
            Ellipse2D.Double e3 = new Ellipse2D.Double(size*(x+99), size*(y+12.1), size*76.8, size*30.1);
            Ellipse2D.Double e4 = new Ellipse2D.Double(size*(x+45.2), size*(y+6), size*104.3, size*40.4);
            Ellipse2D.Double e5 = new Ellipse2D.Double(size*(x+196.8), size*(y+31), size*41.4, size*30.1);
            
            g2d.fill(e1);
            g2d.fill(e2);
            g2d.fill(e3);
            g2d.fill(e4);

            g2d.rotate(Math.toRadians(108), e5.getX(), e5.getY());
            g2d.fill(e5);

            g2d.setTransform(reset);
        } 
    }

    private void drawLegs(Graphics2D g2d, int walkFrame){
        AffineTransform reset = g2d.getTransform();
        
        if (walkFrame == 0){
            // First leg, backmost
            Ellipse2D.Double hindEllipse1 = new Ellipse2D.Double(size*(x+51.6), size*(y+66.7), size*47.5, size*16.3);
            Ellipse2D.Double hindEllipse2 = new Ellipse2D.Double(size*(x+45.2), size*(y+66), size*47.5, size*16.3);

            g2d.rotate(Math.toRadians(-83.5), hindEllipse1.getX(), hindEllipse1.getY());
            g2d.fill(hindEllipse1);
            g2d.setTransform(reset);

            g2d.rotate(Math.toRadians(-32.6), hindEllipse2.getX(), hindEllipse2.getY());
            g2d.fill(hindEllipse2);
            g2d.setTransform(reset);

            Point2D.Double[] trapPoints = new Point2D.Double[4];
            trapPoints[0] = new Point2D.Double(size*(x+40.6), size*(y+65.3));
            trapPoints[1] = new Point2D.Double(size*(x+86.4), size*(y+23.8));
            trapPoints[2] = new Point2D.Double(size*(x+99.7), size*(y+39.7));
            trapPoints[3] = new Point2D.Double(size*(x+52), size*(y+65.2));
            Trapezoid hindTrapUpperOne = new Trapezoid(trapPoints, color, true);
            hindTrapUpperOne.draw(g2d);

            Rectangle2D.Double lowerOne = new Rectangle2D.Double(size*(x+50.5), size*(y+62.2), size*34.6, size*8.4);
            g2d.rotate(Math.toRadians(83.5), lowerOne.getX(), lowerOne.getY());
            g2d.fill(lowerOne);
            g2d.setTransform(reset);

            Ellipse2D.Double foot = new Ellipse2D.Double(size*(x+44.7), size*(y+94.4), size*15.1, size*8.4);
            g2d.fill(foot);

            // Second leg from the left
            trapPoints[0] = new Point2D.Double(size*(x+66.7), size*(y+76.4));
            trapPoints[1] = new Point2D.Double(size*(x+96.5), size*(y+21.7));
            trapPoints[2] = new Point2D.Double(size*(x+114.8), size*(y+32.1));
            trapPoints[3] = new Point2D.Double(size*(x+79.2), size*(y+84.2));
            Trapezoid hindTrapUpperTwo = new Trapezoid(trapPoints, color, true);
            hindTrapUpperTwo.draw(g2d);

            Rectangle2D.Double lowerTwo = new Rectangle2D.Double(size*(x+71.1), size*(y+73), size*36.3, size*6.9);
            g2d.rotate(Math.toRadians(39.8), lowerTwo.getX(), lowerTwo.getY());
            g2d.fill(lowerTwo);
            g2d.setTransform(reset);

            foot = new Ellipse2D.Double(size*(x+93.3), size*(y+94.8), size*15.1, size*8.4);
            g2d.rotate(Math.toRadians(4.8), foot.getX(), foot.getY());
            g2d.fill(foot);

            // Third leg from the left
            trapPoints[0] = new Point2D.Double(size*(x+115.4), size*(y+98.1));
            trapPoints[1] = new Point2D.Double(size*(x+137.4), size*(y+38.6));
            trapPoints[2] = new Point2D.Double(size*(x+153.1), size*(y+46.1));
            trapPoints[3] = new Point2D.Double(size*(x+127), size*(y+100.8));
            Trapezoid frontTrapOne = new Trapezoid(trapPoints, color, true);
            frontTrapOne.draw(g2d);

            Rectangle2D.Double lowerThree = new Rectangle2D.Double(size*(x+130), size*(y+51.9), size*36.3, size*6.9);
            g2d.rotate(Math.toRadians(-13.5), lowerThree.getX(), lowerThree.getY());
            g2d.fill(lowerThree);
            g2d.setTransform(reset);

            foot = new Ellipse2D.Double(size*(x+115), size*(y+94.8), size*19.1, size*11.9);
            g2d.rotate(Math.toRadians(4.8), foot.getX(), foot.getY());
            g2d.fill(foot);
            g2d.setTransform(reset);

            // Last leg 
            trapPoints[0] = new Point2D.Double(size*(x+155.7), size*(y+47.7));
            trapPoints[1] = new Point2D.Double(size*(x+172.7), size*(y+42.5));
            trapPoints[2] = new Point2D.Double(size*(x+193.4), size*(y+100.6));
            trapPoints[3] = new Point2D.Double(size*(x+179.5), size*(y+104.1));
            Trapezoid frontTrapTwo = new Trapezoid(trapPoints, color, true);
            frontTrapTwo.draw(g2d);

            foot = new Ellipse2D.Double(size*(x+179.5), size*(y+97.2), size*22.5, size*11.9);
            g2d.rotate(Math.toRadians(4.8), foot.getX(), foot.getY());
            g2d.fill(foot);
            g2d.setTransform(reset);
        }
    };

    private void drawTail(Graphics2D g2d, int walkFrame){
        AffineTransform reset = g2d.getTransform();

        if (walkFrame == 0){
            Ellipse2D.Double e1 = new Ellipse2D.Double(size*(x+28), size*(y+50), size*43, size*14.9);
            g2d.rotate(Math.toRadians(-59.9), e1.getX(), e1.getY());
            g2d.fill(e1);
            g2d.setTransform(reset);

            Ellipse2D.Double e2 = new Ellipse2D.Double(size*(x+19.8), size*(y+59.7), size*43, size*14.9);
            g2d.rotate(Math.toRadians(-54.6), e2.getX(), e2.getY());
            g2d.fill(e2);
            g2d.setTransform(reset);

            Ellipse2D.Double e3 = new Ellipse2D.Double(size*(x+9.4), size*(y+67.4), size*43, size*14.9);
            g2d.rotate(Math.toRadians(-45), e3.getX(), e3.getY());
            g2d.fill(e3);
            g2d.setTransform(reset);

            Ellipse2D.Double e4 = new Ellipse2D.Double(size*(x), size*(y+72.4), size*43, size*14.9);
            g2d.rotate(Math.toRadians(-37.1), e4.getX(), e4.getY());
            g2d.fill(e4);
            g2d.setTransform(reset);

        }
    };

}