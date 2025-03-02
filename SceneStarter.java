/**
        The SceneStarter class contains the program's main method.
        It instantiates a new frame with the specified width, height,
        and title, and then calls the setUpGUI method on it.
   
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

import javax.sound.sampled.*;
import java.io.*;

public class SceneStarter{


    /**
     * Instantiates a new SceneFrame object and calls its setUpGUI method
     * @param args the arguments in the command line upon running the program, no arguments are to be provided
     * @throws UnsupportedAudioFileException when the audio file used is not supported See: http://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/UnsupportedAudioFileException.html
     * @throws IOException when an Input-Output error has occured. See: https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html
     * @throws LineUnavailableException when a line cannot be opened. See: https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/LineUnavailableException.html
     */
    public static void main(String[] args) throws UnsupportedAudioFileException,IOException, LineUnavailableException{
        SceneFrame sf = new SceneFrame(800, 600, "Midterm Project - Cabrera - Labariento");
        sf.setUpGUI();
    }
} 
