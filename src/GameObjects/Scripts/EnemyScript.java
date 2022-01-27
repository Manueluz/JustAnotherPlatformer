package GameObjects.Scripts;

import Game.Game;
import GameObjects.Components.Tick.Script;
import GameObjects.Components.Tick.Speed;
import GameObjects.Components.Util.Position;
import GameObjects.CustomObjects.Entities.Player;
import GameObjects.GameObject;
import World.Coordinate;

public class EnemyScript extends Script {
    @Override
    public void tick(double delta) {
        Player player = null;

        for(GameObject object : Game.getGame().getWorld().getAllObjects()){
            if(object instanceof Player){
                player = (Player)object;
                break;
            }
        }

        if(player!=null){
            double xPlayer = ((Position)player.getComponent("Position")).getPosition().x();
            double xEnemy = ((Position)getObject().getComponent("Position")).getPosition().x();

            double dir = 4;

            if(xEnemy-xPlayer >= 0){
                dir *= -1;
            }

            ((Speed)getObject().getComponent("Speed")).setSpeedVec(new Coordinate(dir*delta,0));
        }
    }
}
