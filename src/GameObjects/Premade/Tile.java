package GameObjects.Premade;

import GameObjects.Components.Render.Sprite;
import GameObjects.Components.Util.HitBox;
import GameObjects.Components.Util.HitBoxComponent;
import GameObjects.Components.Util.Position;
import GameObjects.GameObject;
import World.Coordinate;

public abstract class Tile extends GameObject {
    public Tile(){
        this.addComponent(new Position(this, new Coordinate(0,0)));
        this.addComponent(new HitBoxComponent(this,new HitBox(0,0,1,1)));
        this.addComponent(new Sprite(this,1,1,null));
    }

    @Override
    public void tick(double delta) {
        super.tick(delta);
    }

    public abstract boolean isSolid();
}
