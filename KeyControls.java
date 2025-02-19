import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class KeyControls implements KeyListener {
    
    private SceneCanvas sceneCanvas;
    private Timer timer;
    private TimerTask timerTask;
    private final int SPACEBARKEYCODE = 32;
    private final int STEPSIZE = 20;
    private final int FRAMEDELAY = 200;
    private WalkingCat wc;
    private boolean isAnimating;

    public KeyControls(SceneCanvas sceneCanvas){
        this.sceneCanvas = sceneCanvas;
        wc = sceneCanvas.getWalkingCat();
        isAnimating = false;
    }

    @Override
    public void keyTyped(KeyEvent event){};

    @Override
    public void keyPressed(KeyEvent event){
        if ((event.getKeyCode() == SPACEBARKEYCODE) && !isAnimating){
            timer = new Timer();
            timerTask = new TimerTask(){
                @Override
                public void run(){
                    startAnimation();
                }
            };
            timer.scheduleAtFixedRate(timerTask, 0, FRAMEDELAY);
            isAnimating = true;
        }
    };
 
    @Override
    public void keyReleased(KeyEvent event){
        if (event.getKeyCode() == SPACEBARKEYCODE){
            timer.cancel();
            timer.purge();
            isAnimating = false;
        }
    };

    private void startAnimation(){
        wc.adjustX(STEPSIZE);
        wc.changeFrame();
        sceneCanvas.repaint();
        if (wc.getX() >= sceneCanvas.getWidth()){
            wc.adjustX(-(sceneCanvas.getWidth() + wc.getCatLength()));
        }
    }
}
