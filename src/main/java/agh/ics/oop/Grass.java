package agh.ics.oop;
public class Grass extends AbstractWorldMapElement {
    public Grass(Vector2d grassPosition){
        super(grassPosition);
    }

    @Override
    public String toString(){
        return "*";
    }
}
