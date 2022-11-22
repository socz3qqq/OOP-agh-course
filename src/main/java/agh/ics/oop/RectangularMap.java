package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    public RectangularMap(int width, int height){
        super();
        upperRightBound = new Vector2d(width-1, height-1);
    }
//    public static List<Animal> getAnimals(){
//        return animals;
//    }
}
