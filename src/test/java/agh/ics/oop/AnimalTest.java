package agh.ics.oop;

import agh.ics.oop.MapElements.Animal;
import agh.ics.oop.MapTypes.GrassField;
import agh.ics.oop.MapTypes.RectangularMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    static GrassField grassField1 = new GrassField(10);
    static GrassField grassField2 = new GrassField(5);
    static Animal testAnimal0_1 = new Animal(grassField1, new Vector2d(0,0));
    static Animal testAnimal0_2 = new Animal(grassField1, new Vector2d(2, 0));
    static Animal testAnimal0_3 = new Animal(grassField1, new Vector2d(1,0 ));
    static Animal testAnimal1_1 = new Animal(grassField2, new Vector2d(0, 0));
    static Animal testAnimal1_2 = new Animal(grassField2, new Vector2d(1, 1));
    static Animal testAnimal1_3 = new Animal(grassField2, new Vector2d(2, 5));
    static String[] strMoves1 = {"f", "f", "l"};
    static List<MoveDirection> moves1 = OptionsParser.parse(strMoves1);
    static String[] strMoves2 = {"f", "r", "r", "r", "r", "f", "f", "left", "f", "f"};
    static List<MoveDirection> moves2 = OptionsParser.parse(strMoves2);
    static String[] strMoves3 = {"f", "left", "left", "f", "f", "left", "l", "b", "b"};
    static List<MoveDirection> moves3 = OptionsParser.parse(strMoves3);
    static String[] strMoves4 = {"left", "f", "f", "f", "f", "right", "right"};
    static List<MoveDirection> moves4 = OptionsParser.parse(strMoves4);
    static String[] strMoves5 = {"f", "f", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
    static List<MoveDirection> moves5 = OptionsParser.parse(strMoves5);

    @BeforeAll
    static void prepare() {
        for (MoveDirection move : moves1) {
            testAnimal0_2.move(move);
        }
        for (MoveDirection move : moves2) {
            testAnimal0_3.move(move);
        }
        for (MoveDirection move : moves3) {
            testAnimal1_1.move(move);
        }
        for (MoveDirection move : moves4) {
            testAnimal1_2.move(move);
        }
        for (MoveDirection move : moves5) {
            testAnimal1_3.move(move);
        }
    }
    @Test
    void testOrientation(){
        assertEquals(testAnimal0_1.getDirection(), MapDirection.NORTH);
        assertEquals(testAnimal0_2.getDirection(), MapDirection.WEST);
        assertEquals(testAnimal0_3.getDirection(), MapDirection.WEST);
        assertEquals(testAnimal1_1.getDirection(), MapDirection.NORTH);
        assertEquals(testAnimal1_2.getDirection(), MapDirection.EAST);
        assertEquals(testAnimal1_3.getDirection(), MapDirection.SOUTH);
    }
    @Test
    void testPosition(){
        assertTrue(testAnimal0_1.isAt(new Vector2d(0,0)));
        assertTrue(testAnimal0_2.isAt(new Vector2d(2,2)));
        assertTrue(testAnimal0_3.isAt(new Vector2d(0,3)));
    }
    @Test
    void testBounds(){
        assertTrue(testAnimal1_1.isAt(new Vector2d(0,0)));
        assertTrue(testAnimal1_2.isAt(new Vector2d(0,1)));
        assertEquals(testAnimal1_3.getPosition(), new Vector2d(2,0));

    }
}
