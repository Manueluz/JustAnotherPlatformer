package GameObjects.Premade;

import GameObjects.Components.Render.Sprite;
import GameObjects.Components.Tick.ScriptComponent;
import GameObjects.Components.Util.Position;
import GameObjects.GameObject;
import World.Coordinate;

public abstract class Entity extends GameObject {

    public Entity(){
        this.addComponent(new Position(this, new Coordinate(0,0)));
        this.addComponent(new Sprite(this,1,1,null));
    }

    @Override
    public void tick(double delta) {
        super.tick(delta);
    }
}
