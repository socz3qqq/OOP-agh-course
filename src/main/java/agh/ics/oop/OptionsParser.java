package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] moves){
        List<MoveDirection> directionMoves = new ArrayList<>();
        for(String move: moves){
            switch (move) {
                case "f", "forward" -> directionMoves.add(MoveDirection.FORWARD);
                case "b", "backward" -> directionMoves.add(MoveDirection.BACKWARD);
                case "r", "right" -> directionMoves.add(MoveDirection.RIGHT);
                case "l", "left" -> directionMoves.add(MoveDirection.LEFT);
                default -> {

                }
            }
        }
        return directionMoves;
    }
}
