package agh.ics.oop;

import agh.ics.oop.MapElements.Animal;
import agh.ics.oop.MapTypes.IWorldMap;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private List<MoveDirection> animalMoves;
    private IWorldMap map;
    List<Animal> animals = new ArrayList<>();
    public SimulationEngine(List<MoveDirection> moves, IWorldMap map, Vector2d[] animalPositions){
        this.animalMoves = moves;
        this.map = map;
        for(Vector2d animalPosition: animalPositions){
            Animal animal = new Animal(this.map, animalPosition);
            this.animals.add(animal);
            this.map.place(animal);
        }
        System.out.println(map.toString());
    }
    @Override
    public void run() {
        int i  = 0;
        while(i < animalMoves.size()){
            for(Animal animal: animals){
                if(i < animalMoves.size()) {
                    animal.move(animalMoves.get(i));
                    i += 1;
                    System.out.println(map.toString());
                }
                else break;
            }
        }
    }
}
