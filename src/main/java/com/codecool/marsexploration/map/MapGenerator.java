package com.codecool.marsexploration.map;

import com.codecool.marsexploration.config.MapConfiguration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.resource.Mineral;
import com.codecool.marsexploration.resource.Water;
import com.codecool.marsexploration.shape.Mountain;
import com.codecool.marsexploration.shape.Pit;

import java.util.List;

public class MapGenerator {

    private final MapConfiguration config;

    public MapGenerator(MapConfiguration config) {
        this.config = config;
    }

    public void generate(){
        Character[][] map = new Character[config.getWidth()][config.getWidth()];
        //generates a random map based on config and saves file
        if(config.isConfigValid()){
            addResources(config.getWaters(), config.getMinerals(), map);

            for(List<Mountain> mountainAreas : config.getMountainAreas())
                setShapeOnMap(mountainAreas, null, map);

            for (List<Pit> pitArea : config.getPitAreas())
                setShapeOnMap(null, pitArea, map);
            return map;
        } else {
            System.out.println("Provided config can not generate a valid map");
            //TODO - handle not valid config
        }
        return null;
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
}
