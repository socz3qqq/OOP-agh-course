package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    private final Vector2d vec0 = new Vector2d(0, 0);
    private final Vector2d vec1 = new Vector2d(1, 2);
    private final Vector2d vec2 = new Vector2d(1, 2);
    private final Vector2d vec3 = new Vector2d(1, 1);
    private final Vector2d vec4 = new Vector2d(0, 4);
    private final Vector2d vec5 = new Vector2d(-5, -5);
    @Test
    void testEquals(){
        assertEquals(vec1, vec2);
        assertEquals(vec1.hashCode(), vec2.hashCode());
        assertNotEquals(vec3, vec1);
        assertNotEquals(vec1, vec3);
        assertNotEquals(vec1.hashCode(), vec3.hashCode());
    }
    @Test
    void testToString(){
        assertEquals("(1,2)", vec1.toString());
        assertNotEquals("(1, 2)", vec2.toString());
        assertEquals("(0,0)", vec0.toString());
        assertEquals(vec1.toString(), vec2.toString());
        assertEquals("(-5,-5)", vec5.toString());
    }
    @Test
    void testPrecedes(){
        assertFalse(vec1.precedes(vec0));
        assertTrue(vec1.precedes(vec1));
        assertTrue(vec1.precedes(vec2));
        assertTrue(vec3.precedes(vec1));
        assertFalse(vec1.precedes(vec3));
        assertFalse(vec4.precedes(vec1));
        assertFalse(vec1.precedes(vec4));
        assertTrue(vec5.precedes(vec0));
    }
    @Test
    void testFollows(){
        assertTrue(vec1.follows(vec0));
        assertTrue(vec1.follows(vec1));
        assertTrue(vec1.follows(vec2));
        assertFalse(vec3.follows(vec1));
        assertTrue(vec1.follows(vec3));
        assertFalse(vec4.follows(vec1));
        assertFalse(vec1.follows(vec4));
        assertFalse(vec5.follows(vec0));
    }
    @Test
    void testUpperRight(){
        assertEquals(new Vector2d(1, 2), vec1.upperRight(vec2));
        assertEquals(new Vector2d(1, 4), vec4.upperRight(vec1));
        assertEquals(vec1, vec0.upperRight(vec1));
        assertEquals(vec1, vec5.upperRight(vec1));
        assertEquals(vec1.upperRight(vec4), vec4.upperRight(vec1));
    }
    @Test
    void testLowerLeft(){
        assertEquals(new Vector2d(1, 2),
                vec1.upperLeft(vec2));
        assertEquals(vec0, vec0.upperLeft(vec1));
        assertEquals(new Vector2d(0, 2), vec4.upperLeft(vec1));
        assertEquals(vec5, vec5.upperLeft(vec1));
        assertEquals(vec5.upperLeft(vec0), vec0.upperLeft(vec5));
    }
    @Test
    void testAdd(){
        assertEquals(new Vector2d(2, 3), vec1.add(vec3));
        assertEquals(new Vector2d(-5, -1), vec5.add(vec4));
        assertEquals(vec1, vec1.add(vec0));
    }
    @Test
    void testSubtract(){
        assertEquals(new Vector2d(0, 0), vec1.subtract(vec2));
        assertEquals("(5,9)", vec4.subtract(vec5).toString());
        assertEquals("(-5,-9)", vec5.subtract(vec4).toString());
        assertEquals(vec1, vec1.subtract(vec0));
    }
    @Test
    void testOpposite(){
        assertEquals("(-1,-2)", vec1.opposite().toString());
        assertEquals("(5,5)", vec5.opposite().toString());
        assertEquals("(0,-4)", vec4.opposite().toString());
        assertEquals(vec0, vec0.opposite());
    }
}