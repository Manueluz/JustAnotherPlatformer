package GameObjects.Scripts;

import Game.Game;
import GameObjects.Components.Tick.Script;
import GameObjects.Components.Tick.Speed;
import GameObjects.Components.Util.Position;
import IO.Keyboard;
import World.Coordinate;

import java.awt.event.KeyEvent;
import java.util.Stack;

public class MovementScript extends Script {

    final boolean playerScript;
    public MovementScript(boolean player){
        playerScript = player;
    }

    boolean grounded = false;
    Stack<Integer> spaceStack = new Stack<>();
    int stackTime = 0;

    @Override
    public void tick(double delta) {
        double speed = 2.5d;
        double friction = 1 - 0.10d;
        double g = 1.75;
        double jump = 0.65;

        Game.getGame().getCamera().setCameraPosition(((Position)getObject().getComponent("Position")).getPosition());

        double ySpeed=((Speed)getObject().getComponent("Speed")).getSpeedVec().y();
        double xSpeed=((Speed)getObject().getComponent("Speed")).getSpeedVec().x();

        if(playerScript) {
            if (Keyboard.isKeyPressed(KeyEvent.VK_A)) {
                xSpeed += -speed * delta;
            }
            if (Keyboard.isKeyPressed(KeyEvent.VK_D)) {
                xSpeed += speed * delta;
            }

            ((Speed) getObject().getComponent("Speed")).setSpeedVec(new Coordinate(0, 0.01));
            grounded = !Game.getGame().getWorld().collidesWithTiles(getObject()).isEmpty();

            if ((Keyboard.isKeyPressed(KeyEvent.VK_SPACE) && spaceStack.size() < 1) && stackTime > 25) {
                stackTime = 10;
                spaceStack.push(1);
            }

            if (stackTime > 30) {
                spaceStack.clear();
            }

            stackTime++;
            if (!spaceStack.isEmpty() && grounded) {
                spaceStack.pop();
                ySpeed -= jump;
                grounded = false;
            }
        }

        //Apply friction
        xSpeed *= friction;
        ySpeed *= friction;

        ySpeed += g*delta;

        //Apply Speed
        ((Speed)getObject().getComponent("Speed")).setSpeedVec(new Coordinate(xSpeed,ySpeed));

        //If there is collision modify speed
        if(!Game.getGame().getWorld().collidesWithTiles(getObject()).isEmpty()) {
            ((Speed) getObject().getComponent("Speed")).setSpeedVec(new Coordinate(xSpeed, 0));
            while (!Game.getGame().getWorld().collidesWithTiles(getObject()).isEmpty()) {
                xSpeed *= friction;
                //Update speed
                ((Speed) getObject().getComponent("Speed")).setSpeedVec(new Coordinate(xSpeed, 0));
            }
            ((Speed) getObject().getComponent("Speed")).setSpeedVec(new Coordinate(0, ySpeed));
            while (!Game.getGame().getWorld().collidesWithTiles(getObject()).isEmpty()) {
                ySpeed *= friction;
                //Update speed
                ((Speed) getObject().getComponent("Speed")).setSpeedVec(new Coordinate(0, ySpeed));
            }
            ((Speed)getObject().getComponent("Speed")).setSpeedVec(new Coordinate(xSpeed,ySpeed));
        }
    }
}
