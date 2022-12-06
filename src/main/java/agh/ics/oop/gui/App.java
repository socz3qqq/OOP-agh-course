package agh.ics.oop.gui;

import agh.ics.oop.*;
import agh.ics.oop.MapTypes.AbstractWorldMap;
import agh.ics.oop.MapTypes.GrassField;
import agh.ics.oop.MapTypes.RectangularMap;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.util.List;

public class App extends Application {
    private AbstractWorldMap map;
    @Override
    public void start(Stage primaryStage) throws Exception {
        final int width = 40;
        final int height = 40;
        primaryStage.setTitle("Zwierzątka i trawa ^^");

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        Vector2d lowerBound = this.map.getMapBounds().getLowerMapBoundary();
        Vector2d upperBound = this.map.getMapBounds().getUpperMapBoundary();

        Label chartTitle = new Label("y/x");
        gridPane.add(chartTitle, 0, 0, 1, 1);
        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));
        GridPane.setHalignment(chartTitle, HPos.CENTER);

        for (int i = lowerBound.x; i <= upperBound.x ; i++) {
            Label tile = new Label(""+ i);
            gridPane.add(tile, i - lowerBound.x + 1, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            GridPane.setHalignment(tile, HPos.CENTER);
        }
        for (int i = lowerBound.y; i <= upperBound.y ; i++) {
            Label tile = new Label(i+ "");
            gridPane.add(tile, 0, upperBound.y - i + 1, 1, 1);
            gridPane.getRowConstraints().add(new RowConstraints(height));
            GridPane.setHalignment(tile, HPos.CENTER);
        }

        for (int i = lowerBound.x; i <= upperBound.x ; i++) {
            for (int j = lowerBound.y; j <= upperBound.y ; j++) {
                Vector2d position = new Vector2d(i, j);
                if(map.isOccupied(position)){
                    Label object = new Label(map.objectAt(position).toString());
                    gridPane.add(object, position.x - lowerBound.x + 1, upperBound.y - position.y + 1 , 1, 1);
                    GridPane.setHalignment(object, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void init() throws Exception {
        super.init();
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            List<MoveDirection> directions = new OptionsParser().parse(args);
//          map = new RectangularMap(10, 5);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException ex){
            System.out.println(ex);
        }
    }
}
