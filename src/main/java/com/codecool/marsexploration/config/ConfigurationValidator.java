package com.codecool.marsexploration.config;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.resource.Resource;
import com.codecool.marsexploration.shape.Mountain;
import com.codecool.marsexploration.shape.Pit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConfigurationValidator {

    private final double MAX_MAP_COVERAGE_PERCENTAGE = 0.7;
    private final MapConfiguration config;

    public ConfigurationValidator(MapConfiguration config) {
        this.config = config;
    }


    public boolean validate(){
        return checkAreaCoveredByShapes() && checkShapesCoordinatesNotOverlapping() && checkFileName();
    }

    private boolean checkAreaCoveredByShapes(){
        List<List<Pit>> pitAreas = config.getPitAreas();
        List<List<Mountain>> mountainAreas = config.getMountainAreas();

        double totalCoveredArea = pitAreas.stream().mapToInt(List::size).sum() +
                mountainAreas.stream().mapToInt(List::size).sum() +
                config.getMinerals().size() +
                config.getWaters().size();

        double mapArea = config.getWidth() * config.getWidth();
        double maxAllowedCoveredArea = MAX_MAP_COVERAGE_PERCENTAGE * mapArea;

        return totalCoveredArea <= maxAllowedCoveredArea;
    }

    private boolean checkShapesCoordinatesNotOverlapping(){
        List<Coordinate> takenSpots = new ArrayList<>();

        for(Resource water : config.getWaters()){
            takenSpots.add(water.getLocation());
        }

        for(Resource mineral : config.getMinerals()){
            takenSpots.add(mineral.getLocation());
        }

        for(List<Pit> pitArea : config.getPitAreas()){
            for (Pit pit : pitArea){
                takenSpots.addAll(pit.getCoordinates());
            }
        }

        for(List<Mountain> mountainArea : config.getMountainAreas()){
            for(Mountain mountain : mountainArea){
                takenSpots.addAll(mountain.getCoordinates());
            }
        }
        return takenSpots.stream().filter(Objects::nonNull)
                .noneMatch(c1 -> takenSpots.stream().filter(Objects::nonNull).anyMatch(c2 -> c1 != c2 && c1.x() == c2.x() && c1.y() == c2.y()));
    }

    private boolean checkFileName(){
        String fileName = config.getFileName();
        String allowedFileNameChars = "[a-zA-Z0-9._-]+";
        return fileName.matches(allowedFileNameChars);
    }
}
