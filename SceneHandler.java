import java.awt.*;
import java.util.ArrayList;

public class SceneHandler {
    
    private SceneCanvas sceneCanvas;
    private ArrayList<DrawingObject> drawingObjects;
    private int width;
    private int height;

    public SceneHandler(SceneCanvas sceneCanvas, ArrayList<DrawingObject> drawingObjects, int w, int h){
        this.sceneCanvas = sceneCanvas;
        this.drawingObjects = drawingObjects;
        width = w;
        height = h;
        
        // Start with Scene1 and a SleepingCat
        drawingObjects.add(new Scene1(width, height));
        drawingObjects.add(new SleepingCat(400, 488.6, 0.66, Color.decode("#242424")));
    }

    public void changeScene(int sceneCount){
        switch (sceneCount){
            case 1:
                drawingObjects.set(0, new Scene1(width, height));
                break;
            case 2:
                drawingObjects.set(0, new Scene2(width, height));
                break;
            case 3:
                drawingObjects.set(0, new Scene3(width, height));
                break;
            case 4:
                drawingObjects.set(0, new Scene4(sceneCanvas, width, height, false, false));
                break;
            case 5:
                drawingObjects.set(0, new Scene5(width, height));
                break;
            case 6:
                drawingObjects.set(0, new Scene6(width, height));
                break;
            case 7:
                drawingObjects.set(0, new Scene7(width, height));
                break;
            case 8:
                drawingObjects.set(0, new Scene8(width, height));
                break;
            case 9:
                drawingObjects.set(0, new Scene9(width, height));
                break;
        }
    }
}
