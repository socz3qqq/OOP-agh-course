package agh.ics.oop;

public class World {
    public static void run(Direction[] elements){
//        int elementsLen = elements.length;
        for (Direction element : elements) {
            switch (element) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie to tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                default -> {
                }
            }
//            System.out.print(elements[i]);
//            if (i != elementsLen - 1) {
//                System.out.print(",");
//            }
//            else{
//                System.out.print("\n");
//            }
        }
    }
    public static void main(String[] args) {
        System.out.println("system wystartował");
        int argsLen = args.length;
        Direction[] message = new Direction[argsLen];
        for(int i = 0; i < argsLen; i++) {
            message[i] = switch (args[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.BAD_DIRECTION;
            };
        }
        run(message);
        System.out.print("system zakończył działanie\n");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection dir = MapDirection.EAST;
        System.out.println(dir.next());
        System.out.println(dir.previous());
        System.out.println(dir.toUnitVector());
        System.out.println(dir.toString());
    }

}
