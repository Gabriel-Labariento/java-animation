import java.awt.*;
import java.awt.event.*;

public class KeyControls implements KeyListener {
    
    SceneCanvas sceneCanvas;

    public KeyControls(SceneCanvas sceneCanvas){
        this.sceneCanvas = sceneCanvas;
    }

    @Override
    public void keyTyped(KeyEvent event){};

    @Override
    public void keyPressed(KeyEvent event){
        final int SPACEBARKEYCODE = 32;
        if (event.getKeyCode() == SPACEBARKEYCODE){
            WalkingCat wc = sceneCanvas.getWalkingCat();
            wc.adjustX(5);
            wc.changeFrame();
            sceneCanvas.repaint();
        }
    };
 
    @Override
    public void keyReleased(KeyEvent event){};
}
