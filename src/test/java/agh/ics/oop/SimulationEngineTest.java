package agh.ics.oop;

import agh.ics.oop.MapTypes.IWorldMap;
import agh.ics.oop.MapTypes.RectangularMap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SimulationEngineTest {

    @Test
    void testRun() {
//      given
        String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        List<MoveDirection> directions = new OptionsParser().parse(moves);
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

//      when
        Vector2d position0 = engine.animals.get(0).getPosition();
        Vector2d position1 = engine.animals.get(1).getPosition();
        MapDirection direction0 = engine.animals.get(0).getDirection();
        MapDirection direction1 = engine.animals.get(1).getDirection();

//      then
        assertEquals(new Vector2d(2, 0), position0);
        assertEquals(new Vector2d(3, 4), position1);
        assertEquals(MapDirection.NORTH, direction1);
        assertEquals(MapDirection.SOUTH, direction0);
    }
}