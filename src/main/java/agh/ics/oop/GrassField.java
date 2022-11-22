package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private final int grassBound;

    private final Random rand = new Random();
    private ArrayList<Grass> grassTiles = new ArrayList<>();

    public GrassField(int count){
        grassBound = (int) sqrt(count*10);
        upperRightBound = new Vector2d(grassBound, grassBound);

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
        } while(isOccupied(new Vector2d(x, y)));
        Grass grass = new Grass(new Vector2d(x, y)) ;
        this.grassTiles.add(grass);
    }

    @Override
    public boolean isOccupied(Vector2d position){
        for (Grass grass:grassTiles){
            if(grass.getPosition().equals(position)){
                return true;
            }
        }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object o = super.objectAt(position);
        if (o == null){
            for(Grass grass: this.grassTiles){
                if(grass.getPosition().equals(position)){
                    return grass;
                }
            }
        }
        return o;
    }
}
