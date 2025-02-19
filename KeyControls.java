import java.awt.event.*;

public class KeyControls implements KeyListener {
    
    @Override
    public void keyTyped(KeyEvent event){
        System.out.println("Key Typed");
    };

    @Override
    public void keyPressed(KeyEvent event){
        final int SPACEBARKEYCODE = 32;
        if (event.getKeyCode() == SPACEBARKEYCODE){
            System.out.println("Spacebar clicked.");
        }
    };
 
    @Override
    public void keyReleased(KeyEvent event){
        System.out.println("Key Released");
    };
}
