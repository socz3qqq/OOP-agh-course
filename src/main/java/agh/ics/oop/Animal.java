package agh.ics.oop;

public class Animal{
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;
    public Animal(){

    }
    Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    @Override
    public String toString() {
        switch (direction) {
            case NORTH -> {
                return "N";
            }
            case EAST -> {
                return "E";
            }
            case SOUTH ->{
                return "S";
            }
            case WEST -> {
                return "W";
            }
            default -> {
                return "BŁĘDNA ORIENTACJA";
            }
        }
    }
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
    public Vector2d getPosition(){return position;}
    public MapDirection getDirection(){return direction;}

    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d forwardPosition = this.direction.toUnitVector().add(this.position);
//                if (forwardPosition.precedes(new Vector2d(4, 4)) && forwardPosition.follows(new Vector2d(0, 0))) {
//                    this.position = forwardPosition;
//                }
                if (this.map.canMoveTo(forwardPosition)) {
                    this.position = forwardPosition;
                }

            }
            case BACKWARD -> {
                Vector2d backwardPosition = this.position.subtract(this.direction.toUnitVector());
                if (this.map.canMoveTo(backwardPosition)) {
                    this.position = backwardPosition;
                }
            }
            default -> {
            }
        }
    }
}
