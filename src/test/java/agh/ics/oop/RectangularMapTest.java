package agh.ics.oop;

import agh.ics.oop.MapElements.Animal;
import agh.ics.oop.MapTypes.RectangularMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void testCanMoveTo() {
//      given
        RectangularMap map = new RectangularMap(8, 8);
        Animal animal1 = new Animal(map, new Vector2d(1, 1));
        Animal animal2 = new Animal(map, new Vector2d(8, 8));
        Animal animal3 = new Animal(map, new Vector2d(0, 0));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

//      when
        boolean move1 = map.canMoveTo(new Vector2d(1, 1));
        boolean move2 = map.canMoveTo(new Vector2d(9, 10));
        boolean move3 = map.canMoveTo(new Vector2d(0, 0));
        boolean move4 = map.canMoveTo(new Vector2d(7,7));

//      then
        assertFalse(move1);
        assertFalse(move2);
        assertFalse(move3);
        assertTrue(move4);
    }

    @Test
    void testPlace() {
//      given
        RectangularMap map = new RectangularMap(8, 8);
        Animal animal1 = new Animal(map, new Vector2d(1, 1));
        Animal animal2 = new Animal(map, new Vector2d(1, 1));
        Animal animal3 = new Animal(map, new Vector2d(8, 8));
        Animal animal4 = new Animal(map, new Vector2d(0, 0));

//      when
        boolean placed1 = map.place(animal1);
        boolean placed2 = map.place(animal2);
        boolean placed3 = map.place(animal3);
        boolean placed4 = map.place(animal4);

//      then
        assertTrue(placed1);
        assertFalse(placed2);
        assertFalse(placed3);
        assertTrue(placed4);
    }

    @Test
    void testIsOccupied() {
//      given
        RectangularMap map = new RectangularMap(8, 8);
        Animal animal1 = new Animal(map, new Vector2d(1, 1));
        Animal animal2 = new Animal(map, new Vector2d(8, 8));
        Animal animal3 = new Animal(map, new Vector2d(0, 0));
        map.place(animal1);
        map.place(animal2);

//      when
        boolean position1 = map.isOccupied(animal1.getPosition());
        boolean position2 = map.isOccupied(animal2.getPosition());
        boolean position3 = map.isOccupied(animal3.getPosition());

//      then
        assertTrue(position1);
        assertFalse(position2);
        assertFalse(position3);
    }

    @Test
    void testObjectAt() {
//      given
        RectangularMap map = new RectangularMap(8, 8);
        Animal animal1 = new Animal(map, new Vector2d(1, 1));
        Animal animal2 = new Animal(map, new Vector2d(8, 8));
        Animal animal3 = new Animal(map, new Vector2d(0, 0));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

//      when
        Object object1 = map.objectAt(animal1.getPosition());
        Object object2 = map.objectAt(animal2.getPosition());
        Object object3 = map.objectAt(animal3.getPosition());

//      then
        assertEquals(animal1, object1);
        assertNotEquals(animal2, object2);
        assertNotEquals(animal3, map.objectAt( new Vector2d(5, 5)));
        assertEquals(animal3, object3);

    }
}