package GameObjects.Components.Tick;

import GameObjects.Components.GameComponent;
import GameObjects.Components.Util.Position;
import GameObjects.GameObject;
import World.Coordinate;

public class Speed extends GameComponent {

    Coordinate speedVec;

    public Speed(GameObject object) {
        super(object);
        speedVec = new Coordinate(0,0);
    }

    @Override
    public void tick(double delta) {
        super.tick(delta);
        Position pos = getObject().getComponent("Position");
        pos.addPosition(speedVec);
    }

    public Coordinate getSpeedVec() {
        return speedVec;
    }

    public void addSpeedVec(Coordinate speedVec) {
        this.speedVec = this.speedVec.add(speedVec);
    }

    public void setSpeedVec(Coordinate speedVec) {
        this.speedVec = speedVec;
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
        return "Speed";
    }
}
