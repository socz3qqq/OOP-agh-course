package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class OptionsParserTest {
    @Test
    public void testMoveParserWithCorrectInput() {
        String[] toParse = {"f", "left", "forward", "r", "b", "right"};

        List<MoveDirection> expected = List.of(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD,
                MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.RIGHT);

        Assertions.assertEquals(expected, OptionsParser.parse(toParse));
    }

    @Test
    public void testMoveParserWithIncorrectInput() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] toParse = {"b", "left", "f", "unexpected", "r", "x", "right", "y", "z", "backward"};
            OptionsParser.parse(toParse);
        });
        Assertions.assertEquals("unexpected is not legal move specification", exception.getMessage());
    }

    @Test
    public void testMoveParserWithAllIncorrectInput() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] toParse = {"x", "unexpected", "y", "z", "surprise"};
            OptionsParser.parse(toParse);
        });
        Assertions.assertEquals("x is not legal move specification", exception.getMessage());
    }

    @Test
    public void testMoveParserWithEmptyInput() {
        String[] toParse = {};

        List<MoveDirection> expected = List.of();

        Assertions.assertEquals(expected, OptionsParser.parse(toParse));
    }
}
