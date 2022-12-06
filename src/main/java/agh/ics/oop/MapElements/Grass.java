package agh.ics.oop.MapElements;

import agh.ics.oop.MapElements.AbstractWorldMapElement;
import agh.ics.oop.Vector2d;

public class Grass extends AbstractWorldMapElement {
    public Grass(Vector2d grassPosition){
        super(grassPosition);
    }

    @Override
    public String toString(){
        return "*";
    }
}
