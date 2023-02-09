package com.codecool.marsexploration.config;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.resource.Resource;
import com.codecool.marsexploration.shape.Shape;
import com.codecool.marsexploration.utils.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConfigurationValidator {

    private final Display display;
    private final double MAX_MAP_COVERAGE_PERCENTAGE = 0.7;
    private final int MIN_WIDTH = 10;
    private final int MAX_WIDTH = 100;
    private final MapConfiguration config;

    public ConfigurationValidator(MapConfiguration config, Display display) {
        this.config = config;
        this.display = display;
    }

    public boolean validate(){
        return checkWidth() && checkTotalCoveredArea() &&  checkFileName();
    }

    private boolean checkWidth(){
       if(!(config.getWidth() <= MAX_WIDTH && config.getWidth() >= MIN_WIDTH)){
           display.errorMessage("Width must be between " + MIN_WIDTH + " and " + MAX_WIDTH);
           return false;
       };
       return true;
    }

    private boolean checkTotalCoveredArea(){
        List<Shape> shapes = config.getShapes();
        List<Resource> resources = config.getResources();

        double totalCoveredArea = shapes.stream().map(shape->shape.getCoordinates().size()).reduce(0, Integer::sum) +
                resources.size();

        double mapArea = config.getWidth() * config.getWidth();
        double maxAllowedCoveredArea = MAX_MAP_COVERAGE_PERCENTAGE * mapArea;

        if(!(totalCoveredArea <= maxAllowedCoveredArea)){
            display.errorMessage("Total covered area ( " + totalCoveredArea + " ) cannot be higher than 70% of map area ( " + maxAllowedCoveredArea + " ).");
            return false;
        };
        return true;
    }

    private boolean checkFileName(){
        String fileName = config.getFileName();
        String allowedFileNameChars = "[a-zA-Z0-9._-]+";
        if(!fileName.matches(allowedFileNameChars)){
            display.errorMessage("Invalid file name for file: " + config.getFileName());
            return false;
        }
        return true;
    }

    private boolean checkShapesCoordinatesNotOverlapping(){
        List<Coordinate> takenSpots = new ArrayList<>();

        for(Shape shape : config.getShapes()){
            takenSpots.addAll(shape.getCoordinates());
        }

        for(Resource resource : config.getResources()){
            takenSpots.add(resource.getLocation());
        }

        return takenSpots.stream().filter(Objects::nonNull)
                .noneMatch(c1 -> takenSpots.stream().filter(Objects::nonNull).anyMatch(c2 -> c1 != c2 && c1.x() == c2.x() && c1.y() == c2.y()));
    }
}
