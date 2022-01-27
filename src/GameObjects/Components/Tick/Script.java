package GameObjects.Components.Tick;

import GameObjects.GameObject;

public abstract class Script {

    private GameObject gameObject;

    public abstract void tick(double delta);

    public GameObject getObject(){
        return gameObject;
    }

    void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
