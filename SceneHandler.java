import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.sound.sampled.*;

public class SceneHandler {
    
    private ArrayList<DrawingObject> drawingObjects;
    private int width;
    private int height;
    private ArrayList<File> files;
    private ArrayList<AudioInputStream> streams;
    private ArrayList<Clip> clips;
    private AudioInputStream audioInputStream;
    private Clip clip;
    private Boolean hasPlayed;

    public SceneHandler(ArrayList<DrawingObject> drawingObjects, int w, int h) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        this.drawingObjects = drawingObjects;
        width = w;
        height = h;
        hasPlayed = false;
        files = new ArrayList<>();
        streams = new ArrayList<>();
        clips = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            files.add(new File(String.format("%d.wav", i+1)));
            streams.add(AudioSystem.getAudioInputStream(files.get(i)));
            clips.add(AudioSystem.getClip());
        }

        drawingObjects.add(new Scene0(width, height));
        drawingObjects.add(new SleepingCat(400, 488.6, 0.66, Color.decode("#242424")));
    }

    public void changeScene(int sceneCount) throws IOException, LineUnavailableException{
        if (!(sceneCount == 0)){
            //Check if music has been played before, if it hasnt stop the currently playing music
            if (hasPlayed){
                clip.stop();
                clip.close();
            }
            else hasPlayed = true;

            clip = clips.get(sceneCount-1);
            clip.open(streams.get(sceneCount-1));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

        switch (sceneCount){
            case 0:
                drawingObjects.set(0, new Scene0(width, height));
                break;
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
