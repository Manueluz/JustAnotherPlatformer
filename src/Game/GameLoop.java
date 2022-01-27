package Game;


import IO.Keyboard;
import Rendering.Camera;
import Rendering.Display;


import java.time.Instant;


public class GameLoop implements Runnable {

    private static int TARGET_FPS = 60;
    private static int GAME_WINDOW_SIZE = 20;

    private Camera camera;
    private final Display display;

    public GameLoop(int w, int h){

        display = new Display(w,h);

        //Start IO
        display.addKeyListener(Keyboard.getListener());
    }

    long lastFrame = 0;
    @Override
    public void run() {
        lastFrame = Instant.now().toEpochMilli();
        while (true) {
            if(Instant.now().toEpochMilli() - lastFrame >= 1000/TARGET_FPS){

                long millisPerFrame = Instant.now().toEpochMilli() - lastFrame;
                lastFrame = Instant.now().toEpochMilli();

                //Tick
                Game.getGame().getWorld().tick((double) millisPerFrame/1000);

                //Render
                display.setNextFrame(camera.render(Game.getGame().getWorld(), display.getW(), display.getH(), GAME_WINDOW_SIZE));

            }
        }
    }
    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
