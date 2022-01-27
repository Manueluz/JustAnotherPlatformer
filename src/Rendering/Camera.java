package Rendering;

import GameObjects.Components.GameComponent;
import GameObjects.Components.Render.Sprite;
import GameObjects.GameObject;
import World.Coordinate;
import World.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;

public class Camera{

    Coordinate cameraCoordinate;

    public Camera(int x, int y){
        cameraCoordinate = new Coordinate(x,y);
    }

    public Coordinate getCameraPosition() {return cameraCoordinate;}
    public void setCameraPosition(Coordinate cameraCoordinate) {this.cameraCoordinate = cameraCoordinate;}

    public BufferedImage render(World world, int width, int height, int zoom){

        ArrayList<Renderable> renderables = new ArrayList<>();

        for(GameObject object : world.getAllObjects()){
            for(GameComponent component : object.getComponents()){
                if(component.isRendereable()){
                    renderables.add((Renderable) component);
                }
            }
        }

        BufferedImage image = new BufferedImage(zoom* Sprite.BLOCK_SIZE,zoom*Sprite.BLOCK_SIZE,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.translate((zoom/2- cameraCoordinate.x())*Sprite.BLOCK_SIZE,(zoom/2- cameraCoordinate.y())*Sprite.BLOCK_SIZE);

        //Order based on depth
        renderables.sort(Comparator.comparingInt(Renderable::getDepth));

        //Render everything
        renderables.forEach(renderable -> renderable.render(g));

        //Move the camera
        image.getGraphics().drawImage(image,0,0, width, height,null);

        return image;
    }
}
