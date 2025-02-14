import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SceneFrame{
    private JFrame frame;
    private JButton defaultStart;

    public SceneFrame(){
        frame = new JFrame();
        defaultStart = new JButton();
    }

    public void setUpGUI(int width, int height){
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Midterm Project - Cabrera - Labariento");

        SceneCanvas canvas = new SceneCanvas(width, height);
        frame.add(canvas);
    }

    public void setUpButtonListeners(){
        ActionListener buttonListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            Object o = ae.getSource();
            if (o == defaultStart){
                // Start Animation
            }


        }
    };
        //Assign an event handler for all of the buttons
        defaultStart.addActionListener(buttonListener);
    }
}