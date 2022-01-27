package GameObjects.CustomObjects.Entities;

import GameObjects.Components.Render.Sprite;
import GameObjects.Components.Tick.Speed;
import GameObjects.Components.Util.HitBox;
import GameObjects.Components.Util.HitBoxComponent;
import GameObjects.Premade.Entity;
import GameObjects.Scripts.MovementScript;
import Rendering.TextureLoader;

public class Player extends Entity {
    public Player(){
        super();
        ((Sprite)getComponent("Sprite")).setTexture(TextureLoader.loadTexture("Player/player.png"));
        addComponent(new HitBoxComponent(this, new HitBox(0,0,1,1)));
        addComponent(new Speed(this));
        addScript(new MovementScript(true));
    }
    @Override
    public void tick(double delta) {
        super.tick(delta);

    }
}
