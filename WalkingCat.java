/**
        The WalkingCat class creates a WalkingCat object and has 
        methods for drawing it as it implements DrawingObject.
        The WalkingCat object also implements the Cat interface 
        to support the cat's movement with methods adjustX and
        changeFrame.
   
        @author Niles Tristan V. Cabrera (240828)
        @author Gabriel Matthew P. Labariento (242425)
        @version 03 March 2025

        We have not discussed the Java language code in my program
        with anyone other than my instructor or the teaching assistants
        assigned to this course.
        We have not used Java language code obtained from another student,
        or any other unauthorized source, either modified or unmodified.
        If any Java language code or documentation used in our program
        was obtained from another source, such as a textbook or website,
        that has been clearly noted with a proper citation in the comments
        of our program.
**/

import java.awt.*;
import java.awt.geom.*;

public class WalkingCat implements DrawingObject, Cat {

    private double x;
    private double y;
    private double size;
    private int walkFrame;
    private Color color;
    private double catLength;
    private boolean isLimping;

    /**
     * Initializes the object's field values to the arguments provided. When the WalkingCat is constructed, it is not limping.
     * @param xPosition the object's x-coordinate
     * @param yPosition the object's y-coordinate
     * @param size the scaling applied to the object. If size = 1, the framing rectangle is 220.8px by 110.6px when walkFrame is 0.
     * Scaling is approximately similar regardless of walkFrame
     * @param walkFrame an integer specifying which of three walkFrames the cat is drawn in. These frames are necessary to illustrate movement
     * @param color the object's color
     */
    public WalkingCat(double xPosition, double yPosition, double size, int walkFrame, Color color){
        x = xPosition;
        y = yPosition;
        this.size = size;
        if (walkFrame > 2) this.walkFrame = 2;
        else this.walkFrame = walkFrame;
        this.color = color;
        catLength = size * 220;
        isLimping = false;
    }

    @Override
    public void adjustX(double distance){
        x += distance;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);
        g2d.scale(size, size);

        drawSnout(g2d);
        drawHead(g2d, walkFrame);
        drawBody(g2d, walkFrame);
        drawLegs(g2d, walkFrame);
        drawTail(g2d, walkFrame);
        g2d.setTransform(reset);
    }

    @Override
    public void changeFrame(){
        if (!isLimping){
            if (this.walkFrame == 2) this.walkFrame = 1;
            else walkFrame += 1;
        } else {
            switch (this.walkFrame) {
                case 2:
                    this.walkFrame = 0;
                    break;
                case 0:
                    this.walkFrame = 1;
                    break;
                default:
                    this.walkFrame = 0;
                    break;
            }
        }

        
    }        

    @Override
    public double getX(){
        return x;
    }

    /**
     * Gets the y-coordinate of the WalkingCat
     * @return the WalkingCat's y-coordinate
     */
    public double getY(){
        return y;
    }

    @Override
    public double getCatLength(){
        return catLength;
    }

    @Override
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * Factors out drawing the WalkingCat's snout
     * @param g2d the object to manipulate geometric shapes
     */
    private void drawSnout(Graphics2D g2d){
        Point2D.Double[] snoutPoints = new Point2D.Double[4];
        switch (walkFrame) {
            case 0:
                snoutPoints[0] = new Point2D.Double((192.8), (42.6));
                snoutPoints[1] = new Point2D.Double((208.8), (29));
                snoutPoints[2] = new Point2D.Double((214.8), (40.8));
                snoutPoints[3] = new Point2D.Double((203.2), (50.2));
                break;
            case 1:
                if (isLimping) {
                    snoutPoints[0] = new Point2D.Double((212.1), (41.9));
                    snoutPoints[1] = new Point2D.Double((228.1), (28));
                    snoutPoints[2] = new Point2D.Double((233.2), (40.1));
                    snoutPoints[3] = new Point2D.Double((222.5), (49.7));
                } else {
                    snoutPoints[0] = new Point2D.Double((200.9), (45.4));
                    snoutPoints[1] = new Point2D.Double((218.2), (30));
                    snoutPoints[2] = new Point2D.Double((224.9), (43.1));
                    snoutPoints[3] = new Point2D.Double((211.8), (53.4));
                }   break;
            case 2:
                snoutPoints[0] = new Point2D.Double((189.5), (40.9));
                snoutPoints[1] = new Point2D.Double((204.1), (28.5));
                snoutPoints[2] = new Point2D.Double((209.1), (39.3));
                snoutPoints[3] = new Point2D.Double((199.2), (47.9));
                break;
            default:
                break;
        }
        Quadrilateral snout = new Quadrilateral(snoutPoints, color, true);
        snout.draw(g2d);
    }

    /**
     * Factors out drawing the WalkingCat's head
     * @param g2d the object to manipulate geometric shapes
     * @param walkFrame one of three frames of WalkingCat
     */
    private void drawHead(Graphics2D g2d, int walkFrame){

        Ellipse2D.Double head = new Ellipse2D.Double();
        Point2D.Double[] earOnePoints = new Point2D.Double[3];
        Point2D.Double[] earTwoPoints = new Point2D.Double[3];

        if (walkFrame == 0){
            head.setFrame((183.4), (14.2), 32.6, 32);
            earOnePoints[0] = new Point2D.Double((180.1), (20));
            earOnePoints[1] = new Point2D.Double((190.9), 0);
            earOnePoints[2] = new Point2D.Double((201.6), (20));
            earTwoPoints[0] = new Point2D.Double((188.1), (16.4));
            earTwoPoints[1] = new Point2D.Double((208.8), (7));
            earTwoPoints[2] = new Point2D.Double((204.5), (28.9));
        } else if (walkFrame == 1){
            if (isLimping){
                g2d.setColor(color);
                
                head.setFrame((202.3),(13.9), 31.8, 31.1);
        
                earOnePoints[0] = new Point2D.Double((199.1), (19.2));
                earOnePoints[1] = new Point2D.Double((209.6), 0);
                earOnePoints[2] = new Point2D.Double((220.1), (19.5));
                
                earTwoPoints[0] = new Point2D.Double((206.8), (16.4));
                earTwoPoints[1] = new Point2D.Double((226.5), (7.8));
                earTwoPoints[2] = new Point2D.Double((224.1), (28.8));
            } else {
                head.setFrame((190.7), (14.3), 34.7, 34);
                earOnePoints[0] = new Point2D.Double((195.2), (16.8));
                earOnePoints[1] = new Point2D.Double((217.4), (7));
                earOnePoints[2] = new Point2D.Double((213.4), (30.5));
                earTwoPoints[0] = new Point2D.Double((190.7), (20.5));
                earTwoPoints[1] = new Point2D.Double((202.2), 0);
                earTwoPoints[2] = new Point2D.Double((214), (20.9));
            }
        } else if (walkFrame == 2){
            head.setFrame((180.8), (15), 29.9, 29.3);
            earOnePoints[0] = new Point2D.Double((182.9), (13.7));
            earOnePoints[1] = new Point2D.Double((201.5), (5.4));
            earOnePoints[2] = new Point2D.Double((197.7), (25.5));
            earTwoPoints[0] = new Point2D.Double((178.1), (19.2));
            earTwoPoints[1] = new Point2D.Double((187.9), (1.3));
            earTwoPoints[2] = new Point2D.Double((197.6), (19.2));
        }

        Triangle earOne = new Triangle(earOnePoints, color, true);
        Triangle earTwo = new Triangle(earTwoPoints, color, true);

        g2d.fill(head);
        earOne.draw(g2d);
        earTwo.draw(g2d);
    }
    
    /**
     * Factors out drawing the WalkingCat's body
     * @param g2d the object to manipulate geometric shapes
     * @param walkFrame one of three frames of WalkingCat
     */
    private void drawBody(Graphics2D g2d, int walkFrame){
        AffineTransform reset = g2d.getTransform();
        switch (walkFrame) {
            case 0:
                {
                    Ellipse2D.Double e1 = new Ellipse2D.Double((37.6), (21.7), 72, 44.3);
                    Ellipse2D.Double e2 = new Ellipse2D.Double((46.1), (16.9), 94.3, 36.6);
                    Ellipse2D.Double e3 = new Ellipse2D.Double((67.7), (39.3), 110.1, 24.2);
                    Ellipse2D.Double e4 = new Ellipse2D.Double((111.6), (15.2), 88.1, 36.6);
                    Ellipse2D.Double e5 = new Ellipse2D.Double((92.3), (18), 94.3, 36.6);
                    Ellipse2D.Double e6 = new Ellipse2D.Double((147.6), (62.2), 50.6, 29.3);
                    g2d.fill(e1);
                    g2d.fill(e2);
                    g2d.fill(e3);
                    g2d.fill(e4);
                    g2d.fill(e5);
                    g2d.rotate(Math.toRadians(-57), e6.getX(), e6.getY());
                    g2d.fill(e6);
                    g2d.setTransform(reset);
                    break;
                }
            case 1:
                if (isLimping){
                    g2d.setColor(color);
                    
                    Ellipse2D.Double e = new Ellipse2D.Double((107), (6.6), 113.1, 39.1);
                    g2d.fill(e);
                    
                    e = new Ellipse2D.Double((43.7), (7.7), 155.4, 50.5);
                    g2d.fill(e);
                    
                    e = new Ellipse2D.Double((136.2), (22.2), 55.2, 39.1);
                    g2d.fill(e);
                    
                    e = new Ellipse2D.Double((80.6), (20.1), 42.2, 34.2);
                    g2d.rotate(Math.toRadians(46.9), e.getX(), e.getY());
                    g2d.fill(e);
                    g2d.setTransform(reset);
                    
                    e = new Ellipse2D.Double((36.4), (65.9), 45.8, 25.6);
                    g2d.rotate(Math.toRadians(-60.4), e.getX(), e.getY());
                    g2d.fill(e);
                    g2d.setTransform(reset);
                } else {
                    Ellipse2D.Double e1 = new Ellipse2D.Double((130.5), (10.4), 76.8, 30.1);
                    Ellipse2D.Double e2 = new Ellipse2D.Double((86.4), (18.4), 114.1, 40.4);
                    Ellipse2D.Double e3 = new Ellipse2D.Double((99), (12.1), 76.8, 30.1);
                    Ellipse2D.Double e4 = new Ellipse2D.Double((45.2), (6), 104.3, 40.4);
                    Ellipse2D.Double e5 = new Ellipse2D.Double((196.8), (31), 41.4, 30.1);
                    
                    g2d.fill(e1);
                    g2d.fill(e2);
                    g2d.fill(e3);
                    g2d.fill(e4);
                    
                    g2d.rotate(Math.toRadians(108), e5.getX(), e5.getY());
                    g2d.fill(e5);
                    
                    g2d.setTransform(reset);
                }   break;
            case 2:
                {
                    Ellipse2D.Double e1 = new Ellipse2D.Double((43.1), (6.2), 130.5, 47.6);
                    Ellipse2D.Double e2 = new Ellipse2D.Double((124.1), (4.9), 42.9, 36.8);
                    Ellipse2D.Double e3 = new Ellipse2D.Double((110.7), (7.9), 97, 36.8);
                    Ellipse2D.Double e4 = new Ellipse2D.Double((126.7), (22.2), 52, 36.8);
                    Ellipse2D.Double e5 = new Ellipse2D.Double((77.9), (19.2), 39.8, 32.2);
                    g2d.fill(e1);
                    g2d.fill(e2);
                    g2d.fill(e3);
                    g2d.fill(e4);
                    g2d.rotate(Math.toRadians(46.9), e5.getX(), e5.getY());
                    g2d.fill(e5);
                    g2d.setTransform(reset);
                    break;
                }
            default:
                break;
        }
    }

    /**
     * Factors out drawing the WalkingCat's legs
     * @param g2d the object to manipulate geometric shapes
     * @param walkFrame one of three frames of WalkingCat
     */
    private void drawLegs(Graphics2D g2d, int walkFrame){
        AffineTransform reset = g2d.getTransform();
        
        switch (walkFrame) {
            case 0:
                {
                    // First leg from the left
                    Ellipse2D.Double hindUpperOne = new Ellipse2D.Double((13.2), (76.6), 62.3, 22.6);
                    Ellipse2D.Double hindUpperTwo = new Ellipse2D.Double((12.6), (68.1), 62.3, 23.5);
                    g2d.rotate(Math.toRadians(-56.8), hindUpperOne.getX(), hindUpperOne.getY());
                    g2d.fill(hindUpperOne);
                    g2d.setTransform(reset);
                    g2d.rotate(Math.toRadians(-25.8), hindUpperTwo.getX(), hindUpperTwo.getY());
                    g2d.fill(hindUpperTwo);
                    g2d.setTransform(reset);
                    Ellipse2D.Double hindLowerOne = new Ellipse2D.Double((8), (104), 32.6, 12);
                    g2d.rotate(Math.toRadians(-70.8), hindLowerOne.getX(), hindLowerOne.getY());
                    g2d.fill(hindLowerOne);
                    g2d.setTransform(reset);
                    Ellipse2D.Double foot = new Ellipse2D.Double((11.7), (100.5), 18.1, 6.7);
                    g2d.fill(foot);
                    // Second leg from the left
                    Ellipse2D.Double hindUpperThree = new Ellipse2D.Double((77.1), (26.7), 39.5, 32);
                    g2d.rotate(Math.toRadians(46.9), hindUpperThree.getX(), hindUpperThree.getY());
                    g2d.fill(hindUpperThree);
                    g2d.setTransform(reset);
                    Point2D.Double[] quadPoints = new Point2D.Double[4];
                    quadPoints[0] = new Point2D.Double((58.4), (83.5));
                    quadPoints[1] = new Point2D.Double((71.7), (53.4));
                    quadPoints[2] = new Point2D.Double((90.7), (65.3));
                    quadPoints[3] = new Point2D.Double((71.7), (91.5));
                    Quadrilateral hindUpperFour = new Quadrilateral(quadPoints, color, true);
                    hindUpperFour.draw(g2d);
                    quadPoints[1] = new Point2D.Double((66.9), (77.3));
                    quadPoints[2] = new Point2D.Double((81.1), (103));
                    quadPoints[3] = new Point2D.Double((77.3), (105.9));
                    Quadrilateral hindLowerTwo = new Quadrilateral(quadPoints, color, true);
                    hindLowerTwo.draw(g2d);
                    foot = new Ellipse2D.Double((77.1), (101.3), 15.5, 7.2);
                    g2d.rotate(Math.toRadians(8), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    // Third foot from the left
                    quadPoints[0] = new Point2D.Double((140.5), (51.8));
                    quadPoints[1] = new Point2D.Double((156.1), (53));
                    quadPoints[2] = new Point2D.Double((150.3), (100.5));
                    quadPoints[3] = new Point2D.Double((140.5), (100.1));
                    Quadrilateral thirdLeg = new Quadrilateral(quadPoints, color, true);
                    thirdLeg.draw(g2d);
                    foot = new Ellipse2D.Double((141.1), (96.3), 20, 10.5);
                    g2d.rotate(Math.toRadians(9), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    // Fourth leg from the left
                    Square upperFront = new Square((160.3), (58), 23, color);
                    upperFront.draw(g2d);
                    quadPoints[0] = new Point2D.Double((160.3), (79.4));
                    quadPoints[1] = new Point2D.Double((168.5), (66.1));
                    quadPoints[2] = new Point2D.Double((207.2), (94.7));
                    quadPoints[3] = new Point2D.Double((201.6), (103));
                    Quadrilateral frontLower = new Quadrilateral(quadPoints, color, true);
                    frontLower.draw(g2d);
                    foot = new Ellipse2D.Double((197), (93.1), 19.5, 11.6);
                    g2d.rotate(Math.toRadians(5.9), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    break;
                }
            case 1:
                if (isLimping) {
                    g2d.setColor(color);
                    
                    // First leg from the back
                    Point2D.Double[] quadPoints = new Point2D.Double[4];
                    quadPoints[0] = new Point2D.Double((25.7), (73.5));
                    quadPoints[1] = new Point2D.Double((50.4), (56.9));
                    quadPoints[2] = new Point2D.Double((56.9), (70.8));
                    quadPoints[3] = new Point2D.Double((28.9), (81));
                    Quadrilateral upperHindOne = new Quadrilateral(quadPoints, color, true);
                    upperHindOne.draw(g2d);
                    
                    Rectangle2D.Double lowerHindOne = new Rectangle2D.Double((35.5), (73.7), 25.2, 10.1);
                    g2d.rotate(Math.toRadians(90), lowerHindOne.getX(), lowerHindOne.getY());
                    g2d.fill(lowerHindOne);
                    g2d.setTransform(reset);
                    
                    Ellipse2D.Double foot = new Ellipse2D.Double((25.5), (95.3), 17.7, 9.3);
                    g2d.rotate(Math.toRadians(-2), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    
                    // Second leg from the back
                    Rectangle2D.Double upperHindTwo = new Rectangle2D.Double((72.7), (83), 38.6, 12);
                    g2d.rotate(Math.toRadians(-100), upperHindTwo.getX(), upperHindTwo.getY());
                    g2d.fill(upperHindTwo);
                    g2d.setTransform(reset);
                    
                    Rectangle2D.Double lowerHindTwo = new Rectangle2D.Double((89.9), (101.7), 25.2, 10.1);
                    g2d.rotate(Math.toRadians(-135), lowerHindTwo.getX(), lowerHindTwo.getY());
                    g2d.fill(lowerHindTwo);
                    g2d.setTransform(reset);
                    
                    Rectangle2D.Double lowerHindThree = new Rectangle2D.Double((72.2), (75.9), 37, 14.8);
                    g2d.rotate(Math.toRadians(-56.7), lowerHindThree.getX(), lowerHindThree.getY());
                    g2d.fill(lowerHindThree);
                    g2d.setTransform(reset);
                    
                    foot = new Ellipse2D.Double((88.2), (94.3), 20.9, 9.9);
                    g2d.rotate(Math.toRadians(-2.2), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    
                    // Third leg from the back
                    quadPoints[0] = new Point2D.Double((151.4), (42.3));
                    quadPoints[1] = new Point2D.Double((171.4), (42.3));
                    quadPoints[2] = new Point2D.Double((167.4), (87.6));
                    quadPoints[3] = new Point2D.Double((154.8), (87.6));
                    Quadrilateral frontUpperOne = new Quadrilateral(quadPoints, color, true);
                    frontUpperOne.draw(g2d);
                    
                    quadPoints[0] = new Point2D.Double((154.8), (87.6));
                    quadPoints[1] = new Point2D.Double((167), (87));
                    quadPoints[2] = new Point2D.Double((166.6), (103.9));
                    quadPoints[3] = new Point2D.Double((160.8), (104.7));
                    Quadrilateral frontLowerOne = new Quadrilateral(quadPoints, color, true);
                    frontLowerOne.draw(g2d);
                    
                    foot = new Ellipse2D.Double((160.4), (98.9), 21, 10);
                    g2d.rotate(Math.toRadians(-2.2), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    
                    // Fourth leg from the back, first from the front
                    Rectangle2D.Double frontLeg = new Rectangle2D.Double((142.8), (50.8), 14.4, 55.6);
                    g2d.rotate(Math.toRadians(-47.9), frontLeg.getX(), frontLeg.getY());
                    g2d.fill(frontLeg);
                    g2d.setTransform(reset);
                    
                    foot = new Ellipse2D.Double((171.1), (90.4), 26.2, 11.8);
                    g2d.rotate(Math.toRadians(-40.7), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                } else {
                    // First leg, backmost
                    Ellipse2D.Double hindEllipse1 = new Ellipse2D.Double((51.6), (66.7), 47.5, 16.3);
                    Ellipse2D.Double hindEllipse2 = new Ellipse2D.Double((45.2), (66), 47.5, 16.3);
                    
                    g2d.rotate(Math.toRadians(-83.5), hindEllipse1.getX(), hindEllipse1.getY());
                    g2d.fill(hindEllipse1);
                    g2d.setTransform(reset);
                    
                    g2d.rotate(Math.toRadians(-32.6), hindEllipse2.getX(), hindEllipse2.getY());
                    g2d.fill(hindEllipse2);
                    g2d.setTransform(reset);
                    
                    Point2D.Double[] quadPoints = new Point2D.Double[4];
                    quadPoints[0] = new Point2D.Double((40.6), (65.3));
                    quadPoints[1] = new Point2D.Double((86.4), (23.8));
                    quadPoints[2] = new Point2D.Double((99.7), (39.7));
                    quadPoints[3] = new Point2D.Double((52), (65.2));
                    Quadrilateral hindQuadUpperOne = new Quadrilateral(quadPoints, color, true);
                    hindQuadUpperOne.draw(g2d);
                    
                    Rectangle2D.Double lowerOne = new Rectangle2D.Double((50.5), (62.2), 34.6, 8.4);
                    g2d.rotate(Math.toRadians(83.5), lowerOne.getX(), lowerOne.getY());
                    g2d.fill(lowerOne);
                    g2d.setTransform(reset);
                    
                    Ellipse2D.Double foot = new Ellipse2D.Double((44.7), (94.4), 15.1, 8.4);
                    g2d.fill(foot);
                    
                    // Second leg from the left
                    quadPoints[0] = new Point2D.Double((66.7), (76.4));
                    quadPoints[1] = new Point2D.Double((96.5), (21.7));
                    quadPoints[2] = new Point2D.Double((114.8), (32.1));
                    quadPoints[3] = new Point2D.Double((79.2), (84.2));
                    Quadrilateral hindQuadUpperTwo = new Quadrilateral(quadPoints, color, true);
                    hindQuadUpperTwo.draw(g2d);
                    
                    Rectangle2D.Double lowerTwo = new Rectangle2D.Double((71.1), (73), 36.3, 6.9);
                    g2d.rotate(Math.toRadians(39.8), lowerTwo.getX(), lowerTwo.getY());
                    g2d.fill(lowerTwo);
                    g2d.setTransform(reset);
                    
                    foot = new Ellipse2D.Double((93.3), (94.8), 15.1, 8.4);
                    g2d.rotate(Math.toRadians(4.8), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    
                    // Third leg from the left
                    quadPoints[0] = new Point2D.Double((115.4), (98.1));
                    quadPoints[1] = new Point2D.Double((137.4), (38.6));
                    quadPoints[2] = new Point2D.Double((153.1), (46.1));
                    quadPoints[3] = new Point2D.Double((127), (100.8));
                    Quadrilateral frontQuadOne = new Quadrilateral(quadPoints, color, true);
                    frontQuadOne.draw(g2d);
                    
                    Rectangle2D.Double lowerThree = new Rectangle2D.Double((130), (51.9), 36.3, 6.9);
                    g2d.rotate(Math.toRadians(-13.5), lowerThree.getX(), lowerThree.getY());
                    g2d.fill(lowerThree);
                    g2d.setTransform(reset);
                    
                    foot = new Ellipse2D.Double((115), (94.8), 19.1, 11.9);
                    g2d.rotate(Math.toRadians(4.8), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    
                    // Last leg
                    quadPoints[0] = new Point2D.Double((155.7), (47.7));
                    quadPoints[1] = new Point2D.Double((172.7), (42.5));
                    quadPoints[2] = new Point2D.Double((193.4), (100.6));
                    quadPoints[3] = new Point2D.Double((179.5), (104.1));
                    Quadrilateral frontQuadTwo = new Quadrilateral(quadPoints, color, true);
                    frontQuadTwo.draw(g2d);
                    
                    foot = new Ellipse2D.Double((179.5), (97.2), 22.5, 11.9);
                    g2d.rotate(Math.toRadians(4.8), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                }   break;
            case 2:
                {
                    // First leg from the left
                    Ellipse2D.Double hindUpperOne = new Ellipse2D.Double((17.8), (64.4), 62.7, 22.8);
                    g2d.rotate(Math.toRadians(-56.8), hindUpperOne.getX(), hindUpperOne.getY());
                    g2d.fill(hindUpperOne);
                    g2d.setTransform(reset);
                    Ellipse2D.Double hindUpperTwo = new Ellipse2D.Double((17.8), (58.7), 62.7, 22.8);
                    g2d.rotate(Math.toRadians(-24.5), hindUpperTwo.getX(), hindUpperTwo.getY());
                    g2d.fill(hindUpperTwo);
                    g2d.setTransform(reset);
                    Rectangle2D.Double lowerOne = new Rectangle2D.Double((33.8), (58.4), 36.3, 8.7);
                    g2d.rotate(Math.toRadians(94.5), lowerOne.getX(), lowerOne.getY());
                    g2d.fill(lowerOne);
                    g2d.setTransform(reset);
                    lowerOne = new Rectangle2D.Double((26.6), (74.6), 23.3, 7.3);
                    g2d.rotate(Math.toRadians(-41.6), lowerOne.getX(), lowerOne.getY());
                    g2d.fill(lowerOne);
                    g2d.setTransform(reset);
                    Ellipse2D.Double foot = new Ellipse2D.Double((23.3), (89), 18.1, 9.4);
                    g2d.rotate(Math.toRadians(6), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    // Second leg from the left
                    Point2D.Double[] quadPoints = new Point2D.Double[4];
                    quadPoints[0] = new Point2D.Double((66.8), (81.8));
                    quadPoints[1] = new Point2D.Double((90.2), (35.2));
                    quadPoints[2] = new Point2D.Double((105), (44.7));
                    quadPoints[3] = new Point2D.Double((76.4), (87.4));
                    Quadrilateral hindUpperThree = new Quadrilateral(quadPoints, color, true);
                    hindUpperThree.draw(g2d);
                    quadPoints[1] = new Point2D.Double((73.6), (74.9));
                    quadPoints[2] = new Point2D.Double((93.9), (97.5));
                    quadPoints[3] = new Point2D.Double((91), (100.5));
                    Quadrilateral lowerTwo = new Quadrilateral(quadPoints, color, true);
                    lowerTwo.draw(g2d);
                    foot = new Ellipse2D.Double((88.1), (94.2), 16.6, 8.8);
                    g2d.rotate(Math.toRadians(-2), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    // Third leg from the left
                    Rectangle2D.Double frontUpperOne = new Rectangle2D.Double((126.9), (45.1), 15.9, 47);
                    g2d.rotate(Math.toRadians(-35.2), frontUpperOne.getX(), frontUpperOne.getY());
                    g2d.fill(frontUpperOne);
                    g2d.setTransform(reset);
                    Rectangle2D.Double lowerThree = new Rectangle2D.Double((167), (83.4), 29.1, 9);
                    g2d.rotate(Math.toRadians(149.2), lowerThree.getX(), lowerThree.getY());
                    g2d.fill(lowerThree);
                    g2d.setTransform(reset);
                    foot = new Ellipse2D.Double((128.3), (90.6), 18.1, 11.1);
                    g2d.rotate(Math.toRadians(-15.1), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    // Fourth leg from the left
                    quadPoints[0] = new Point2D.Double((151.2), (53.3));
                    quadPoints[1] = new Point2D.Double((167), (55.2));
                    quadPoints[2] = new Point2D.Double((163.8), (96.7));
                    quadPoints[3] = new Point2D.Double((154.3), (96.7));
                    Quadrilateral fourthLeg = new Quadrilateral(quadPoints, color, true);
                    fourthLeg.draw(g2d);
                    foot = new Ellipse2D.Double((155.3), (92.6), 19.6, 9.4);
                    g2d.rotate(Math.toRadians(5.9), foot.getX(), foot.getY());
                    g2d.fill(foot);
                    g2d.setTransform(reset);
                    break;
                }
            default:
                break;
        }
    };

    /**
     * Factors out drawing the WalkingCat's tail
     * @param g2d the object to manipulate geometric shapes
     * @param walkFrame one of three frames of WalkingCat
     */
    private void drawTail(Graphics2D g2d, int walkFrame){
        AffineTransform reset = g2d.getTransform();

        switch (walkFrame) {
            case 0:
                {
                    Ellipse2D.Double e1 = new Ellipse2D.Double(0, (73.1), 32.6, 12);
                    g2d.rotate(Math.toRadians(-5), e1.getX(), e1.getY());
                    g2d.fill(e1);
                    g2d.setTransform(reset);
                    break;
                }
            case 1:
                if (isLimping){
                    g2d.setColor(color);
                    
                    Ellipse2D.Double e = new Ellipse2D.Double((14.2), (62.9), 56, 10.9);
                    g2d.rotate(Math.toRadians(-51.3), e.getX(), e.getY());
                    g2d.fill(e);
                    g2d.setTransform(reset);
                    
                    e = new Ellipse2D.Double((8.7), (65.7), 27.1, 8.9);
                    g2d.rotate(Math.toRadians(-41.4), e.getX(), e.getY());
                    g2d.fill(e);
                    g2d.setTransform(reset);
                    
                    e = new Ellipse2D.Double(0, (66.7), 27.1, 8.9);
                    g2d.rotate(Math.toRadians(-22.8), e.getX(), e.getY());
                    g2d.fill(e);
                    g2d.setTransform(reset);
                } else {
                    Ellipse2D.Double e1 = new Ellipse2D.Double((28), (50), 43, 14.9);
                    g2d.rotate(Math.toRadians(-59.9), e1.getX(), e1.getY());
                    g2d.fill(e1);
                    g2d.setTransform(reset);
                    
                    Ellipse2D.Double e2 = new Ellipse2D.Double((19.8), (59.7), 43, 14.9);
                    g2d.rotate(Math.toRadians(-54.6), e2.getX(), e2.getY());
                    g2d.fill(e2);
                    g2d.setTransform(reset);
                    
                    Ellipse2D.Double e3 = new Ellipse2D.Double((9.4), (67.4), 43, 14.9);
                    g2d.rotate(Math.toRadians(-45), e3.getX(), e3.getY());
                    g2d.fill(e3);
                    g2d.setTransform(reset);
                    
                    Ellipse2D.Double e4 = new Ellipse2D.Double(0, (72.4), 43, 14.9);
                    g2d.rotate(Math.toRadians(-37.1), e4.getX(), e4.getY());
                    g2d.fill(e4);
                    g2d.setTransform(reset);
                }   break;
            case 2:
                {
                    Ellipse2D.Double e1 = new Ellipse2D.Double(3, (69.4), 47.3, 13.4);
                    Ellipse2D.Double e2 = new Ellipse2D.Double(0, (67.2), 25.5, 12.6);
                    g2d.rotate(Math.toRadians(-32), e1.getX(), e1.getY());
                    g2d.fill(e1);
                    g2d.setTransform(reset);
                    g2d.rotate(Math.toRadians(-16.7), e2.getX(), e2.getY());
                    g2d.fill(e2);
                    g2d.setTransform(reset);
                    break;
                }
            default:
                break;
        }
    };

    @Override
    public void setIsLimping(boolean isLimping){
        this.isLimping = isLimping;
    }
}