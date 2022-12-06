package agh.ics.oop;

import agh.ics.oop.MapTypes.AbstractWorldMap;
import agh.ics.oop.MapTypes.GrassField;
import agh.ics.oop.MapTypes.RectangularMap;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.List;



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
        }
    }
    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

}
