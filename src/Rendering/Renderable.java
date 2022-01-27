package Rendering;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Renderable {
    void render(Graphics2D g);
    BufferedImage getTexture();
    void setTexture(BufferedImage image);
    int getDepth();
    void setDepth(int depth);
}
