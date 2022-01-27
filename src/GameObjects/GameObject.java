package GameObjects;

import GameObjects.Components.GameComponent;
import GameObjects.Components.Tick.Script;
import GameObjects.Components.Tick.ScriptComponent;

import java.util.ArrayList;
import java.util.Collection;

public abstract class GameObject {

    private Collection<GameComponent> components = new ArrayList<>();

    public void tick(double delta){
        for (GameComponent component : components) {
            if(component.isTicked()){
                component.tick(delta);
            }
        }
    }

    public void addScript(Script script){
        if(getComponent("ScriptComponent") == null){
            this.addComponent(new ScriptComponent(this));
        }
        ((ScriptComponent)getComponent("ScriptComponent")).addScript(script);
    }

    public void addComponent(GameComponent component) {
        components.add(component);
    }

    public <T extends GameComponent> T getComponent(String name){
        for (GameComponent component : components) {
            if(component.getName().equals(name)){
                return (T) component;
            }
        }
        return null;
    }

    public Collection<GameComponent> getComponents(){
        return components;
    }
}
