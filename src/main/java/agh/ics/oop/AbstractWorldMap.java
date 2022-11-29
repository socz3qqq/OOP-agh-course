package agh.ics.oop;

import java.util.HashMap;

public abstract class AbstractWorldMap  implements IWorldMap, IPositionChangeObserver{
    protected HashMap<Vector2d, Animal> animals = new HashMap<>();
    protected Vector2d lowerLeftBound = new Vector2d(0, 0);
    protected Vector2d upperRightBound;
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(this.upperRightBound) && position.follows(this.lowerLeftBound) && !isOccupiedByAnimal(position);
    }
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);

            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }
    @Override
    public Object objectAt(Vector2d position) {
        return animals.getOrDefault(position, null);
    }
    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.lowerLeftBound, this.upperRightBound);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition, animal);
        animals.put(newPosition, animal);
    }
    public boolean isOccupiedByAnimal(Vector2d position){
        return this.animals.containsKey(position);
    }
}
