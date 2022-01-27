package World;

public record Coordinate(double x, double y) {
    public Coordinate add(Coordinate p){
        return new Coordinate(x+p.x(),y+p.y());
    }
}
