package agh.ics.oop.MapTypes;

import agh.ics.oop.IPositionChangeObserver;
import agh.ics.oop.MapBoundary;
import agh.ics.oop.MapElements.Animal;
import agh.ics.oop.MapVisualizer;
import agh.ics.oop.Vector2d;

import java.util.HashMap;

public abstract class AbstractWorldMap  implements IWorldMap, IPositionChangeObserver{
    protected HashMap<Vector2d, Animal> animals = new HashMap<>();

    protected MapBoundary mapBounds = new MapBoundary();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected Vector2d lowerBoundary = new Vector2d(0, 0);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerBoundary) && position.precedes(mapBounds.getUpperMapBoundary()) && !isOccupiedByAnimal(position);
    }
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);

            animal.addObserver(this);
            this.mapBounds.addElement(animal.getPosition());
            return true;
        }
        else throw new IllegalArgumentException("Pole: " +  animal.getPosition() + " jest już zajęte przez inne zwierzę :(");
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
        return mapVisualizer.draw(this.mapBounds.getLowerMapBoundary(), this.mapBounds.getUpperMapBoundary());
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition, animal);
        animals.put(newPosition, animal);
        mapBounds.positionChanged(oldPosition, newPosition);
    }
    public boolean isOccupiedByAnimal(Vector2d position){
        return this.animals.containsKey(position);
    }

    public MapBoundary getMapBounds(){
        return this.mapBounds;
    }
    public HashMap<Vector2d, Animal> getAnimals(){
        return this.animals;
    }
}
