package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] moves){
        MoveDirection[] directionMoves = new MoveDirection[moves.length];
        for(int i = 0; i < moves.length; i ++){
            switch(moves[i]){
                case "f":
                case "forward":
                    directionMoves[i] = MoveDirection.FORWARD;
                    break;
                case "b":
                case "backward":
                    directionMoves[i] = MoveDirection.BACKWARD;
                    break;
                case "r":
                case "right":
                    directionMoves[i] = MoveDirection.RIGHT;
                    break;
                case "l":
                case "left":
                    directionMoves[i] = MoveDirection.LEFT;
                    break;
                default:
                    break;
            }
            System.out.println(directionMoves[i]);
        }
        return directionMoves;
    }
}
