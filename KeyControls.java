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
    private WalkingCat walkingCat;
    private boolean isAnimating;
    private static int sceneCount = 1;
    private SceneHandler sceneHandler;

    public KeyControls(SceneCanvas sceneCanvas){
        this.sceneCanvas = sceneCanvas;
        walkingCat = sceneCanvas.getWalkingCat();
        isAnimating = false;
        sceneHandler = sceneCanvas.getSceneHandler();
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
        walkingCat.adjustX(STEPSIZE);
        walkingCat.changeFrame();
        sceneCanvas.repaint();
        
        if (walkingCat.getX() >= sceneCanvas.getWidth()){
            walkingCat.adjustX(-(sceneCanvas.getWidth() + walkingCat.getCatLength()));
            sceneCount++;
            // sceneHandler.changeScene(sceneCount);
        }
    }

    public int getSceneCount(){
        return sceneCount;
    }
}
