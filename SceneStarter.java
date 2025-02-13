public class SceneStarter{

    public static void main(String[] args){
        int width = 800;
        int height = 600;
        SceneFrame gui = new SceneFrame();
        gui.setUpGUI(width, height);
        gui.setUpButtonListeners();
    }
} 
