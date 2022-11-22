package agh.ics.oop;

import agh.ics.oop.Vector2d;

public abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    public AbstractWorldMapElement(Vector2d position) {
        this.position = position;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }
    @Override
    public abstract String toString();
}