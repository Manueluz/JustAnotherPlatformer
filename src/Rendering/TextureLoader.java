package Rendering;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class TextureLoader {

    private final static TextureLoader instance = new TextureLoader();
    private final static HashMap<String,BufferedImage> alreadyLoadedImages = new HashMap<>();

    public static BufferedImage loadTexture(String dir){
        if(alreadyLoadedImages.containsKey(dir)){
            return alreadyLoadedImages.get(dir);
        }
        try {
            BufferedImage image = ImageIO.read(instance.getClass().getResource("/Textures/" + dir));
            alreadyLoadedImages.put(dir, image);
            return image;
        } catch (IOException e) {
            return new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }
    }
}
