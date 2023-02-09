package com.codecool.marsexploration.map;

import com.codecool.marsexploration.config.MapConfiguration;
import com.codecool.marsexploration.resource.ResourcePlacer;
import com.codecool.marsexploration.shape.*;
import com.codecool.marsexploration.utils.Display;
import com.codecool.marsexploration.utils.FileSaver;

public class MapGenerator {

    private final MapConfiguration config;
    private final FileSaver writer;

    public MapGenerator(MapConfiguration config, FileSaver writer) {
        this.config = config;
        this.writer = writer;
    }

    public void generate(){
        Character[][] map = new Character[config.getWidth()][config.getWidth()];
        handleNullSpots(map);
        Display display = new Display();
        if(config.isConfigValid()){
            int numberOfRandomMaps = config.getNumberOfRandomMaps();
            ShapePlacer shapePlacer = new ShapePlacer();
            ResourcePlacer resourcePlacer = new ResourcePlacer();
            while(numberOfRandomMaps > 0){
                shapePlacer.placeShapes(config.getShapes(), map);
                resourcePlacer.placeResources(config.getResources(), map);
                display.displayGenerated(config, map);
                writer.saveFile(config.getFileName(), map);
                map = new Character[config.getWidth()][config.getWidth()];
                handleNullSpots(map);
                numberOfRandomMaps--;
                //config.getNumberOfRandomMaps()--;
            }
        } else {
            display.errorMessage("Provided config can not generate a valid map");
            System.exit(0);
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
