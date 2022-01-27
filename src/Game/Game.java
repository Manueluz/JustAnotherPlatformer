package Game;

import Rendering.Camera;
import World.World;

public class Game {
    private static Game game;

    public static void init(int w, int h){
        if(game!=null){return;}
        game = new Game(w,h);
    }

    public static Game getGame() {
        return game;
    }

    public World getWorld() {
        return world;
    }

    public Camera getCamera() {
        return camera;
    }

    private GameLoop gameLoop;
    private Camera camera;
    private World world;

    public Game(int w, int h){
        camera = new Camera(0,0);
        world = new World();
        gameLoop = new GameLoop(w, h);
        gameLoop.setCamera(camera);

        //Start The Thread
        Thread gameThread = new Thread(gameLoop);
        gameThread.start();
    }
}
