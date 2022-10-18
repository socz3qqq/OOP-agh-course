package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//musisz zrobić refactor tego assertequals - pozamieniać kolejność
class Vector2dTest {
    private Vector2d vec1 = new Vector2d(1, 2);
    private Vector2d vec2 = new Vector2d(1, 2);
    private Vector2d vec3 = new Vector2d(1, 1);
    private Vector2d vec4 = new Vector2d(0, 4);
    private Vector2d vec5 = new Vector2d(-5, -5);
    @Test
    void testEquals(){
        assertTrue(vec1.equals(vec2));
        assertEquals(vec1.hashCode(), vec2.hashCode());
        assertFalse(vec3.equals(vec1));
        assertFalse(vec1.equals(vec3));
        assertNotEquals(vec1.hashCode(), vec3.hashCode());
    }
    @Test
    void testToString(){
        assertEquals(vec1.toString(), "(1,2)");
        assertNotEquals(vec2.toString(), "(1, 2)");
    }
    @Test
    void testPrecedes(){
        assertTrue(vec1.precedes(vec1));
        assertTrue(vec1.precedes(vec2));
        assertTrue(vec3.precedes(vec1));
        assertFalse(vec1.precedes(vec3));
        assertFalse(vec4.precedes(vec1));
        assertFalse(vec1.precedes(vec4));
    }
    @Test
    void testFollows(){
        assertTrue(vec1.follows(vec1));
        assertTrue(vec1.follows(vec2));
        assertFalse(vec3.follows(vec1));
        assertTrue(vec1.follows(vec3));
        assertFalse(vec4.follows(vec1));
        assertFalse(vec1.follows(vec4));
    }
    @Test
    void testUpperRight(){
        assertEquals(vec1.upperRight(vec2), new Vector2d(1, 2));
        assertEquals(vec4.upperRight(vec1), new Vector2d(1, 4));
        assertEquals(vec5.upperRight(vec1), vec1);
    }
    @Test
    void testLowerLeft(){
        assertEquals(vec1.upperLeft(vec2), new Vector2d(1, 2));
        assertEquals(vec4.upperLeft(vec1), new Vector2d(0, 2));
        assertEquals(vec5.upperLeft(vec1), vec5);
    }
    @Test
    void testAdd(){
        assertEquals(vec1.add(vec3), new Vector2d(2, 3));
        assertEquals(vec5.add(vec4), new Vector2d(-5, -1));
    }
    @Test
    void testSubtract(){
        assertEquals(vec1.subtract(vec2), new Vector2d(0, 0));
        assertEquals(vec4.subtract(vec5).toString(), "(5,9)");
        assertEquals(vec5.subtract(vec4).toString(), "(-5,-9)");
    }
    @Test
    void testOpposite(){
        assertEquals(vec1.opposite().toString(), "(-1,-2)");
        assertEquals(vec5.opposite().toString(), "(5,5)");
        assertEquals(vec4.opposite().toString(), "(0,-4)");
    }
}