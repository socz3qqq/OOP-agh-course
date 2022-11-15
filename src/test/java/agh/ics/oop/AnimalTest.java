package agh.ics.oop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    static Animal testAnimal0 = new Animal();
    static Animal testAnimal1 = new Animal();
    static Animal testAnimal2 = new Animal();
    static Animal testAnimal3 = new Animal();
    static Animal testAnimal4 = new Animal();
    static Animal testAnimal5 = new Animal();
    static String[] strMoves1 = {"f", "f", "l"};
    static List<MoveDirection> moves1 = OptionsParser.parse(strMoves1);
    static String[] strMoves2 = {"f", "r", "r", "r", "r", "f", "left", "f", "f"};
    static List<MoveDirection> moves2 = OptionsParser.parse(strMoves2);
    static String[] strMoves3 = {"f", "left", "left", "f", "f", "left", "l", "b", "b"};
    static List<MoveDirection> moves3 = OptionsParser.parse(strMoves3);
    static String[] strMoves4 = {"left", "f", "f", "f", "f", "right", "right"};
    static List<MoveDirection> moves4 = OptionsParser.parse(strMoves4);
    static String[] strMoves5 = {"f", "f", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};
    static List<MoveDirection> moves5 = OptionsParser.parse(strMoves5);

    @BeforeAll
    static void prepare() {
        for (MoveDirection move : moves1) {
            testAnimal1.move(move);
        }
        for (MoveDirection move : moves2) {
            testAnimal2.move(move);
        }
        for (MoveDirection move : moves3) {
            testAnimal3.move(move);
        }
        for (MoveDirection move : moves4) {
            testAnimal4.move(move);
        }
        for (MoveDirection move : moves5) {
            testAnimal5.move(move);
        }
    }
    @Test
    void testOrientation(){
        assertEquals(testAnimal0.getDirection(), MapDirection.NORTH);
        assertEquals(testAnimal1.getDirection(), MapDirection.WEST);
        assertEquals(testAnimal2.getDirection(), MapDirection.WEST);
        assertEquals(testAnimal3.getDirection(), MapDirection.NORTH);
        assertEquals(testAnimal4.getDirection(), MapDirection.EAST);
        assertEquals(testAnimal5.getDirection(), MapDirection.SOUTH);
    }
    @Test
    void testPosition(){
        assertTrue(testAnimal0.isAt(new Vector2d(2,2)));
        assertTrue(testAnimal1.isAt(new Vector2d(2,4)));
        assertTrue(testAnimal2.isAt(new Vector2d(0,4)));
    }
    @Test
    void testBounds(){
        assertTrue(testAnimal4.isAt(new Vector2d(0,2)));
        assertTrue(testAnimal5.isAt(new Vector2d(2,0)));
        assertEquals(testAnimal3.getPosition(), new Vector2d(2,0));

    }
}
