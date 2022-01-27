package GameObjects.Components.Util;

import World.Coordinate;

public record HitBox(double offSetX, double offSetY, double sizeX, double sizeY){
    public static boolean collide(HitBox hitBox1, Coordinate coord1, HitBox hitBox2, Coordinate coord2){
        
        double L1X = coord1.x() + hitBox1.offSetX();
        double R1Y = coord1.y() + hitBox1.offSetY();
        
        double R1X = L1X + hitBox1.sizeX();
        double L1Y = R1Y + hitBox1.sizeY();

        double L2X = coord2.x() + hitBox2.offSetX();
        double R2Y = coord2.y() + hitBox2.offSetY();

        double R2X = L2X + hitBox2.sizeX();
        double L2Y = R2Y + hitBox2.sizeY();


        if (L1X >= R2X || L2X >= R1X){
            return false;
        }

        if (R1Y >= L2Y || R2Y >= L1Y){
            return false;
        }

        return true;
    }
}