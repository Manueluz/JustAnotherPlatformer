package World;

import GameObjects.Components.Tick.Speed;
import GameObjects.Components.Util.HitBox;
import GameObjects.Components.Util.HitBoxComponent;
import GameObjects.Components.Util.Position;
import GameObjects.GameObject;
import GameObjects.Premade.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class World {

    private final HashSet<GameObject> gameObjects = new HashSet<>();
    private final HashMap<Coordinate, Tile> tiles = new HashMap<>();

    public void tick(double delta){
        gameObjects.forEach(gameObject -> gameObject.tick(delta));
        tiles.values().forEach(tile -> tile.tick(delta));
    }


    public ArrayList<Tile> collidesWithTiles(GameObject object){
        HitBoxComponent hitBox = object.getComponent("HitBox");
        Speed speed = object.getComponent("Speed");
        Position position = object.getComponent("Position");

        if(hitBox == null || speed == null || position == null){return new ArrayList<>();}

        ArrayList<Tile> tilesHit = new ArrayList<>();

        for(Tile tile : tiles.values()){
            HitBox hB =((HitBoxComponent)tile.getComponent("HitBox")).getHitBox();
            Coordinate coords = ((Position)tile.getComponent("Position")).getPosition();
            if(HitBox.collide(hitBox.getHitBox(), position.getPosition().add(speed.getSpeedVec()),hB,coords)){
                tilesHit.add(tile);
            }
        }

        return tilesHit;
    }

    public void addObject(GameObject object){
        if(object instanceof Tile){
            tiles.put(((Position)object.getComponent("Position")).getPosition(), (Tile) object);
        }else {
            gameObjects.add(object);
        }
    }

    public Tile getTileAt(Coordinate coordinate){return tiles.get(coordinate);}

    public HashSet<GameObject> getAllObjects() {
        HashSet<GameObject> allObjects = new HashSet<>(gameObjects);
        allObjects.addAll(tiles.values());
        return allObjects;
    }
}
