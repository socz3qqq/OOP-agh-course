package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap  implements IWorldMap{
    protected ArrayList<Animal> animals = new ArrayList<>();
    protected Vector2d lowerLeftBound = new Vector2d(0, 0);
    protected Vector2d upperRightBound;
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(this.upperRightBound) && position.follows(this.lowerLeftBound) && !isOccupied(position);
    }
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal: animals){
            if(animal.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.lowerLeftBound, this.upperRightBound);
    }
}
