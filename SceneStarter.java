import javax.sound.sampled.*;
import java.io.*;

public class SceneStarter{

    public static void main(String[] args) throws UnsupportedAudioFileException,IOException, LineUnavailableException{
        SceneFrame sf = new SceneFrame(800, 600, "Midterm Project - Cabrera - Labariento");
        sf.setUpGUI();
    }
} 
