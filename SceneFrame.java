/**
        The SceneFrame class extends the JFrame object from java Swing.
        Its main purpose it to serve as the container for SceneCanvas.
   
        @author Niles Tristan V. Cabrera ()
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
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class SceneFrame extends JFrame {

    private int width;
    private int height;
    private String title;

    /**
     * Initializes the object's field values to the provided arguments
     * @param w the frame's width
     * @param h the frame's height
     * @param t the frame's title
     */
    public SceneFrame(int w, int h, String t){
        width = w;
        height = h;
        title = t;
    }

    /**
     * Sets up the animation's GUI by instantiating a new SceneCanvas and placing it in the content pane.
     * It also creates a new KeyControls instance, associates it with SceneCanvas and itself.
     * @throws UnsupportedAudioFileException when the audio file used is not supported See: http://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/UnsupportedAudioFileException.html
     * @throws IOException when an Input-Output error has occured. See: https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html
     * @throws LineUnavailableException when a line cannot be opened. See: https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/LineUnavailableException.html
     */
    public void setUpGUI() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        Container contentPane = getContentPane();
        SceneCanvas sceneCanvas = new SceneCanvas(width, height);
        setTitle(title);
        contentPane.add(sceneCanvas, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        KeyControls keyControls = new KeyControls(sceneCanvas);
        addKeyListener(keyControls);
    }
}