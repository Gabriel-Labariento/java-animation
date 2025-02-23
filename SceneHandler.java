import java.util.ArrayList;

public class SceneHandler {
    
    private ArrayList<DrawingObject> drawingObjects;
    private int width;
    private int height;

    public SceneHandler(ArrayList<DrawingObject> drawingObjects, int w, int h){
        this.drawingObjects = drawingObjects;
        width = w;
        height = h;
        drawingObjects.add(new Scene1(width, height));
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
                drawingObjects.set(0, new Scene4(width, height));
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
