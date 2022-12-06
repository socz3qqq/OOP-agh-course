package agh.ics.oop;

import agh.ics.oop.MapElements.IMapElement;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    SortedSet<Vector2d> objectsSetX = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
        }
    });
    SortedSet<Vector2d> objectsSetY = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            return o1.y != o2.y ? o1.y - o2.y : o1.x - o2.x;
        }
    });

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        objectsSetX.add(newPosition);
        objectsSetY.add(newPosition);
        objectsSetY.remove(oldPosition);
        objectsSetY.remove(oldPosition);
    }
    public Vector2d getLowerMapBoundary(){
        return new Vector2d(objectsSetX.first().x, objectsSetY.first().y);
    }
    public Vector2d getUpperMapBoundary(){
        return new Vector2d(objectsSetX.last().x, objectsSetY.last().y);
    }
    public void addElement(Vector2d position){
        objectsSetX.add(position);
        objectsSetY.add(position);
    }
}