package GameObjects.CustomObjects.Tiles;

import GameObjects.Components.Render.Sprite;
import GameObjects.Components.Util.Position;
import GameObjects.Premade.Tile;
import Rendering.TextureLoader;
import World.Coordinate;

public class DirtTile extends Tile {

    public DirtTile(int x, int y){
        super();
        ((Position)getComponent("Position")).setPosition(new Coordinate(x,y));
        ((Sprite)getComponent("Sprite")).setTexture(TextureLoader.loadTexture("Tiles/dirt.png"));
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
