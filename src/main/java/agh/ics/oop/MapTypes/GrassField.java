package agh.ics.oop.MapTypes;

import agh.ics.oop.MapElements.Grass;
import agh.ics.oop.MapTypes.AbstractWorldMap;
import agh.ics.oop.Vector2d;

import java.util.Map;
import java.util.Random;
import static java.lang.Math.sqrt;
import java.util.HashMap;

public class GrassField extends AbstractWorldMap {
    private final int grassBound;

    private final Random rand = new Random();
    protected final Map<Vector2d, Grass> grassTiles = new HashMap<>();

    public GrassField(int count){
        grassBound = (int) sqrt(count*10);

        for (int i = 0; i < count; i++){
            placeGrassRandomly();
        }
    }

    private void placeGrassRandomly(){
        int x;
        int y;
        do{
            x = rand.nextInt(grassBound);
            y = rand.nextInt(grassBound);
        }
        while(isOccupied(new Vector2d(x, y)));

        Vector2d grassPosition = new Vector2d(x, y);
        Grass grass = new Grass(grassPosition) ;
        this.grassTiles.put(grassPosition, grass);
        this.mapBounds.addElement(grassPosition);
    }

    @Override
    public boolean isOccupied(Vector2d pos){
        return grassTiles.containsKey(pos) || super.isOccupied(pos);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object animal = super.objectAt(position);
        return (animal == null) ? grassTiles.getOrDefault(position, null):animal;
    }
    public void addGrassTile(Grass grass){
        this.grassTiles.put(grass.getPosition(), grass);
    }
}