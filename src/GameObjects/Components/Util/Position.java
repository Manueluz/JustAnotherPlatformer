package GameObjects.Components.Util;

import GameObjects.Components.GameComponent;
import GameObjects.GameObject;
import World.Coordinate;

public class Position extends GameComponent {

    private Coordinate position;

    public Position(GameObject object, Coordinate position) {
        super(object);
        this.position = position;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void addPosition(Coordinate pos){
        position = position.add(pos);
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    @Override
    public boolean isRendereable() {
        return false;
    }

    @Override
    public boolean isTicked() {
        return false;
    }

    @Override
    public String getName() {
        return "Position";
    }
}
