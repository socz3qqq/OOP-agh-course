package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] moves){
        MoveDirection[] directionMoves = new MoveDirection[moves.length];
        for(int i = 0; i < moves.length; i ++){
            switch (moves[i]) {
                case "f", "forward" -> directionMoves[i] = MoveDirection.FORWARD;
                case "b", "backward" -> directionMoves[i] = MoveDirection.BACKWARD;
                case "r", "right" -> directionMoves[i] = MoveDirection.RIGHT;
                case "l", "left" -> directionMoves[i] = MoveDirection.LEFT;
                default -> {

                }
            }
        }
        return directionMoves;
    }
}
