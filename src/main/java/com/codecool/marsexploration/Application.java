package com.codecool.marsexploration;

import com.codecool.marsexploration.config.MapConfiguration;
import com.codecool.marsexploration.map.MapGenerator;
import com.codecool.marsexploration.resource.Mineral;
import com.codecool.marsexploration.resource.Resource;
import com.codecool.marsexploration.resource.ResourcePlacer;
import com.codecool.marsexploration.resource.Water;
import com.codecool.marsexploration.shape.*;
import com.codecool.marsexploration.utils.FileSaver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();


        //COD DE PROBA

        List<Shape> shapeList = new ArrayList<>();
            shapeList.add(new MountainGenerator(30).generate());
            shapeList.add(new MountainGenerator(25).generate());
            shapeList.add(new MountainGenerator(20).generate());
            shapeList.add(new PitGenerator(10).generate());
            shapeList.add(new PitGenerator(15).generate());
            shapeList.add(new PitGenerator(8).generate());
        List<Resource> resourceList = new ArrayList<>();
            resourceList.add(new Water());
            resourceList.add(new Water());
            resourceList.add(new Water());
            resourceList.add(new Mineral());
            resourceList.add(new Mineral());
            resourceList.add(new Mineral());


        MapConfiguration mapConfiguration = new MapConfiguration("My-Map",50,shapeList,resourceList);
        MapGenerator mapGenerator = new MapGenerator(mapConfiguration, new FileSaver());
        mapGenerator.generate();


        //COD DE PROBA
    }
}
