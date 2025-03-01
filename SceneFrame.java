import java.awt.*;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class SceneFrame extends JFrame {

    private int width;
    private int height;
    private String title;

    public SceneFrame(int w, int h, String t){
        width = w;
        height = h;
        title = t;
    }

    public void setUpGUI() throws UnsupportedAudioFileException,IOException, LineUnavailableException{
        Container contentPane = getContentPane();
        SceneCanvas sceneCanvas = new SceneCanvas(width, height, Color.WHITE);
        setTitle(title);
        contentPane.add(sceneCanvas, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        KeyControls keyControls = new KeyControls(sceneCanvas);
        addKeyListener(keyControls);
    }
}