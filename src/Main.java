import Game.Game;
import GameObjects.CustomObjects.Entities.Player;
import GameObjects.CustomObjects.Entities.Slime;
import GameObjects.CustomObjects.Tiles.DoubleDirtTile;


public class Main {
    public static void main(String[] args){
        Game.init(800,800);

        Game game = Game.getGame();
        /*
        game.getWorld().addObject(new DirtTile(-6,4));
        game.getWorld().addObject(new DirtTile(-5,4));
        game.getWorld().addObject(new DirtTile(-4,4));
        game.getWorld().addObject(new DirtTile(-3,4));
        game.getWorld().addObject(new DirtTile(-2,4));
        game.getWorld().addObject(new DirtTile(-1,4));
        game.getWorld().addObject(new DirtTile(0,4));
        game.getWorld().addObject(new DirtTile(1,4));
        game.getWorld().addObject(new DirtTile(2,4));
        game.getWorld().addObject(new DirtTile(3,4));
        game.getWorld().addObject(new DirtTile(4,4));
        game.getWorld().addObject(new DirtTile(5,4));
        game.getWorld().addObject(new DirtTile(6,4));
        */
        for(int i = 0;i < 20;i++){
            game.getWorld().addObject(new DoubleDirtTile(2*i,4));
        }


        game.getWorld().addObject(new Slime(3,0));

        game.getWorld().addObject(new Player());

    }
}
