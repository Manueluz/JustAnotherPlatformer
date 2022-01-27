package Rendering;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Display extends JFrame {
    Canvas canvas;
    public Display(int w, int h){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        canvas = new Canvas(w,h);
        setIconImage(TextureLoader.loadTexture("Player/player.png"));
        setTitle("Just Another Platformer");
        add(canvas);
        pack();

    }

    public int getW(){
        return canvas.getWidth();
    }

    public int getH(){
        return canvas.getHeight();
    }

    public void setNextFrame(BufferedImage image){
        canvas.updateNextFrame(image);
    }

    private class Canvas extends JPanel{

        public BufferedImage nextFrame;

        public Canvas(int w, int h){
            Dimension dim = new Dimension(w,h);
            setPreferredSize(dim);
            setMaximumSize(dim);
            setMinimumSize(dim);

        }
        public void updateNextFrame(BufferedImage image){
            nextFrame = image;
            this.update(getGraphics());
        }
        public void paintComponent(Graphics g){
            if(nextFrame != null){
                g.drawImage(nextFrame,0,0,null);
            }
        }
    }
}
