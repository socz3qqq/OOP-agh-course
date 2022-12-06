package agh.ics.oop;

import agh.ics.oop.MapElements.Animal;
import agh.ics.oop.MapElements.Grass;
import agh.ics.oop.MapTypes.GrassField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void isOccupiedTest(){
        GrassField grassField = new GrassField(10);

        Animal animal1 = new Animal(grassField, new Vector2d(3, 3) );
        grassField.place(animal1);
        assertTrue(grassField.isOccupied(animal1.getPosition()));

        Grass grass = new Grass(new Vector2d(1, 1));
        grassField.addGrassTile(grass);
        assertTrue(grassField.isOccupied(new Vector2d(1, 1)));

    }

    @Test
    public void placeTest(){
        GrassField grassField = new GrassField(10);

        Animal animal1 = new Animal(grassField, new Vector2d(1, 1) );
        Animal animal2 = new Animal(grassField, new Vector2d(0, 0));
        Animal animal3 = new Animal(grassField, new Vector2d(6, 7));
        grassField.place(animal1);
        grassField.place(animal2);
        grassField.place(animal3);

        assertTrue(grassField.getAnimals().containsValue(animal1));
        assertTrue(grassField.getAnimals().containsValue(animal2));
        assertTrue(grassField.getAnimals().containsValue(animal3));
    }
    @Test
    public void objectAtTest(){
        GrassField grassField = new GrassField(10);

        Grass grass = new Grass(new Vector2d(1, 1));
        grassField.addGrassTile(grass);
        assertEquals(grassField.objectAt(new Vector2d(1, 1)), grass);

        Animal animal1 = new Animal(grassField, new Vector2d(1, 1) );
        grassField.place(animal1);
        assertEquals(grassField.objectAt(animal1.getPosition()), animal1);
    }
    @Test
    public void canMoveToTest(){
        GrassField grassField = new GrassField(10);

        Animal animal1 = new Animal(grassField, new Vector2d(1, 1) );
        Animal animal2 = new Animal(grassField, new Vector2d(0, 0));
        Animal animal3 = new Animal(grassField, new Vector2d(6, 7));

        grassField.place(animal1);
        grassField.place(animal2);
        grassField.place(animal3);

        assertFalse(grassField.canMoveTo(new Vector2d(0, 0)));
        assertTrue(grassField.canMoveTo(new Vector2d( 4, 4)));
        assertFalse(grassField.canMoveTo(new Vector2d(6, 7)));
    }
}
