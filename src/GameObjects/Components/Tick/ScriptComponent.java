package GameObjects.Components.Tick;

import GameObjects.Components.GameComponent;
import GameObjects.GameObject;

import java.util.ArrayList;

public class ScriptComponent extends GameComponent {

    private ArrayList<Script> scripts = new ArrayList<>();

    public ScriptComponent(GameObject object) {
        super(object);
    }

    public void addScript(Script script){
        script.setGameObject(getObject());
        scripts.add(script);
    }

    @Override
    public void tick(double delta) {
        super.tick(delta);
        scripts.forEach(script -> script.tick(delta));
    }

    @Override
    public boolean isRendereable() {
        return false;
    }

    @Override
    public boolean isTicked() {
        return true;
    }

    @Override
    public String getName() {
        return "ScriptComponent";
    }
}
