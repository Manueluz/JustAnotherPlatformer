package IO;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Keyboard {
    private static HashMap<Integer,Boolean> pressedKeys = new HashMap<>();

    public static boolean isKeyPressed(int key){
        return pressedKeys.getOrDefault(key, false);

    }
    public static keyListener getListener(){
        return new keyListener();
    }

    private static class keyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            pressedKeys.put(e.getKeyCode(),true);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            pressedKeys.put(e.getKeyCode(),false);
        }
    }
}
