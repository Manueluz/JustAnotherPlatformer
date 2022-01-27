package GameObjects.Components.Render;

import GameObjects.Components.GameComponent;
import GameObjects.Components.Util.Position;
import GameObjects.GameObject;
import Rendering.Camera;
import Rendering.Renderable;
import Rendering.TextureLoader;
import World.Coordinate;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends GameComponent implements Renderable {

    public static final int BLOCK_SIZE = 64;

    private BufferedImage texture;
    private int depth;

    private int sizeX;
    private int sizeY;

    public Sprite(GameObject object, int sizeX, int sizeY, BufferedImage texture) {
        super(object);
        this.texture = texture;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    @Override
    public void render(Graphics2D g) {
        Position pos = getObject().getComponent("Position");

        if(pos == null){return;}

        Coordinate coords = pos.getPosition();

        g.drawImage(getTexture(),(int)(coords.x()*BLOCK_SIZE),(int)(coords.y()*BLOCK_SIZE),sizeX*BLOCK_SIZE,sizeY*BLOCK_SIZE,null);
    }

    @Override
    public BufferedImage getTexture() {
        if(texture == null){
            return TextureLoader.loadTexture("missing.png");
        }
        return texture;
    }

    @Override
    public void setTexture(BufferedImage image) {
        texture = image;
    }

    @Override
    public int getDepth() {
        return depth;
    }

    @Override
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setSize(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }



    @Override
    public boolean isRendereable() {
        return true;
    }

    @Override
    public boolean isTicked() {
        return false;
    }

    @Override
    public String getName() {
        return "Sprite";
    }
}
