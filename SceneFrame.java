import java.awt.*;
import java.awt.event.*;
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

    public void setUpGUI(){
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

    
    
    // public void setUpListeners(){
    //     ActionListener keyListener = new ActionListener(){
    //     @Override
    //     public void actionPerformed(ActionEvent ae){
    //         Object o = ae.getSource();
    //         if (o == defaultStart){
    //             // Start Animation
    //         }


    //     }
    // };
    //     //Assign an event handler for all of the buttons
    //     defaultStart.addActionListener(buttonListener);
    // }
}