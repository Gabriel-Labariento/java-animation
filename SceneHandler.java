import java.awt.Color;
import java.util.ArrayList;

public class SceneHandler {
    
    private ArrayList<DrawingObject> drawingObjects;

    public SceneHandler(ArrayList<DrawingObject> drawingObjects){
        this.drawingObjects = drawingObjects;
    }

    // public void startSceneOne(){
    //     drawingObjects.add(new WalkingCat(0, 0, 0, 0, Color.BLACK));
    // } 

    // public void changeScene(int sceneCount){
    //     if (sceneCount == 2){
    //         // sceneTwo();
    //     }
    // }

    // private void sceneTwo(){
    //     // POPULATE THE ARRAYLIST WITH OBJECTS IN SCENE 2
    //     drawingObjects.clear();
    //     drawingObjects.add(new Circle(50, 50, 250, Color.BLACK));
    // }
}
