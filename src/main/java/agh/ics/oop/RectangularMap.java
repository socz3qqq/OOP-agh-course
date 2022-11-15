package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private final int mapWidth;
    private final int mapHeight;
    private final Vector2d upperRight;
    private final Vector2d lowerLeft = new Vector2d(0,0);
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        mapWidth = width;
        mapHeight = height;
        upperRight = new Vector2d(width-1, height-1);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(this.upperRight) && position.follows(this.lowerLeft) && !isOccupied(position);
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
        return mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }
}
