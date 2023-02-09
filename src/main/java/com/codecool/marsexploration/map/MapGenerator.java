package com.codecool.marsexploration.map;

import com.codecool.marsexploration.config.MapConfiguration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.resource.Mineral;
import com.codecool.marsexploration.resource.ResourcePlacer;
import com.codecool.marsexploration.resource.Water;
import com.codecool.marsexploration.shape.*;
import com.codecool.marsexploration.utils.FileSaver;

import java.util.List;

public class MapGenerator {

    private final MapConfiguration config;
    private final FileSaver writer;
//    private final MountainPlacer mountainPlacer;
//    private final PitPlacer pitPlacer;
//    private final ResourcePlacer resourcePlacer;

    public MapGenerator(MapConfiguration config, FileSaver writer) {
        this.config = config;
        this.writer = writer;
//        this.mountainPlacer = mountainPlacer;
//        this.pitPlacer = pitPlacer;
//        this.resourcePlacer = resourcePlacer;
    }

    public void generate(){
        Character[][] map = new Character[config.getWidth()][config.getWidth()];
        handleNullSpots(map);
        ShapePlacer shapePlacer = new ShapePlacer();
        ResourcePlacer resourcePlacer = new ResourcePlacer();

        if(config.isConfigValid()){

//            for(Shape shape : config.getShapes())
                shapePlacer.placeShapes(config.getShapes(), map);

//            for (List<Pit> pitArea : config.getPitAreas())
//                pitPlacer.placeShapes(pitArea, map);

            resourcePlacer.placeResources(config.getResources(), map);
//            resourcePlacer.placeResources(config.getWaters(), map);


            writer.saveFile(config.getFileName(), map);
        } else {
            System.out.println("Provided config can not generate a valid map");
            System.exit(0);
        }
    }

    private void placeShapes(List<Mountain> mountains, List<Pit> pits, Character[][] map) {
        if (mountains == null){
            for (Pit pit : pits) {
                for (Coordinate c : pit.getCoordinates()) {
                    int x = c.x();
                    int y = c.y();
                    map[x][y] = pit.getSymbol();
                }
            }
        } else {
            for (Mountain mountain : mountains) {
                for (Coordinate c : mountain.getCoordinates()) {
                    int x = c.x();
                    int y = c.y();
                    map[x][y] = mountain.getSymbol();
                }
            }
        }
    }

    private void addResources(List<Water> waters, List<Mineral> minerals, Character[][] map) {
        for(Mineral mineral : minerals){
            int x = mineral.getLocation().x();
            int y = mineral.getLocation().y();
            map[x][y] = mineral.getSymbol();
        }

        for(Water water : waters){
            int x = water.getLocation().x();
            int y = water.getLocation().y();
            map[x][y] = water.getSymbol();
        }
    }

    private void handleNullSpots(Character[][] map){
        for(int i = 0; i< config.getWidth(); i++){
            for (int j = 0; j < config.getWidth(); j++){
                if(map[i][j] == null){
                    map[i][j] = ' ';
                }
            }
        }
    }
}
