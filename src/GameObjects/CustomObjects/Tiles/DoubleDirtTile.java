package GameObjects.CustomObjects.Tiles;

import GameObjects.Components.Render.Sprite;
import GameObjects.Components.Util.HitBox;
import GameObjects.Components.Util.HitBoxComponent;
import Rendering.TextureLoader;

public class DoubleDirtTile extends DirtTile{
    public DoubleDirtTile(int x, int y) {
        super(x, y);
        ((Sprite)getComponent("Sprite")).setTexture(TextureLoader.loadTexture("Tiles/dirt_double.png"));
        ((Sprite)getComponent("Sprite")).setSize(2,1);
        ((HitBoxComponent)getComponent("HitBox")).setHitBox(new HitBox(0,0,2,1));
    }
}
