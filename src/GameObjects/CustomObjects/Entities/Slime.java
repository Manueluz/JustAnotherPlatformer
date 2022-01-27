package GameObjects.CustomObjects.Entities;

import GameObjects.Components.Render.Sprite;
import GameObjects.Components.Tick.Speed;
import GameObjects.Components.Util.HitBox;
import GameObjects.Components.Util.HitBoxComponent;
import GameObjects.Components.Util.Position;
import GameObjects.Premade.Entity;
import GameObjects.Scripts.EnemyScript;
import GameObjects.Scripts.MovementScript;
import Rendering.TextureLoader;
import World.Coordinate;

import java.awt.*;

public class Slime extends Entity {
    public Slime(int x, int y){
        super();
        ((Position)getComponent("Position")).setPosition(new Coordinate(x,y));
        ((Sprite)getComponent("Sprite")).setTexture(TextureLoader.loadTexture("Enemies/Slime/slime.png"));
        addComponent(new HitBoxComponent(this, new HitBox(0,0,1,(double) 1-(2d/16))));
        addComponent(new Speed(this));
        addScript(new EnemyScript());
        addScript(new MovementScript(false));
    }
    @Override
    public void tick(double delta) {
        super.tick(delta);

    }
}
