package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement{
    private MapDirection direction;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.map = map;
        this.direction = MapDirection.NORTH;
//        addObserver((IPositionChangeObserver) map);
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
    @Override
    public Vector2d getPosition(){return position;}
    public MapDirection getDirection(){return direction;}
    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : this.observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
    public void changePosition(Vector2d newPosition){
        this.position = newPosition;
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d forwardPosition = this.direction.toUnitVector().add(this.position);
                if (this.map.canMoveTo(forwardPosition)) {
                    this.positionChanged(this.getPosition(), forwardPosition);
                    this.changePosition(forwardPosition);
                }

            }
            case BACKWARD -> {
                Vector2d backwardPosition = this.position.subtract(this.direction.toUnitVector());
                if (this.map.canMoveTo(backwardPosition)) {
                    this.positionChanged(this.getPosition(), backwardPosition);
                    this.changePosition(backwardPosition);
                }
            }
            default -> {
            }
        }
    }
}
