package GameObjects.Components.Util;

import GameObjects.Components.GameComponent;
import GameObjects.GameObject;



public class HitBoxComponent extends GameComponent {

    private HitBox hitBox;

    public HitBoxComponent(GameObject object, HitBox hitBox) {
        super(object);
        this.hitBox = hitBox;
    }

    public HitBox getHitBox() {return hitBox;}

    public void setHitBox(HitBox hitBox) {this.hitBox = hitBox;}

    @Override
    public boolean isRendereable() {return false;}

    @Override
    public boolean isTicked() {return false;}

    @Override
    public String getName() {return "HitBox";}
}
