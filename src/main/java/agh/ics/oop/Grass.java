package agh.ics.oop;

public class Grass implements IMapElement{
    Vector2d position;
    public Grass(Vector2d grassPosition){
        position = grassPosition;
    }
    @Override
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String toString(){
        return "*";
    }
}
