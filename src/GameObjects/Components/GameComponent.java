package GameObjects.Components;

import GameObjects.GameObject;

import java.awt.*;

public abstract class GameComponent {

    private final GameObject Object;

    public GameComponent(GameObject object){
        Object = object;
    }

    public GameObject getObject() {return Object;}

    public abstract boolean isRendereable();
    public abstract boolean isTicked();
    public abstract String getName();

    public void tick(double delta){};
    public void render(Graphics2D g){};
}
