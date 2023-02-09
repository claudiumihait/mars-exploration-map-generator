package com.codecool.marsexploration.config;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.resource.Resource;
import com.codecool.marsexploration.shape.Mountain;
import com.codecool.marsexploration.shape.Pit;
import com.codecool.marsexploration.shape.Shape;
import com.codecool.marsexploration.shape.ShapeGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConfigurationValidator {

    private final double MAX_MAP_COVERAGE_PERCENTAGE = 0.7;
    private final int MIN_WIDTH = 10;
    private final int MAX_WIDTH = 100;
    private final MapConfiguration config;

    public ConfigurationValidator(MapConfiguration config) {
        this.config = config;
    }

    public boolean validate(){
        return checkWidth() && checkTotalCoveredArea() &&  checkFileName();
    }

    private boolean checkWidth(){
        return config.getWidth() <= MAX_WIDTH && config.getWidth() >= MIN_WIDTH;
    }

    private boolean checkTotalCoveredArea(){
        List<Shape> shapes = config.getShapes();
        List<Resource> resources = config.getResources();

        double totalCoveredArea = shapes.stream().map(shape->shape.getCoordinates().size()).reduce(0, Integer::sum) +
                resources.size();

        double mapArea = config.getWidth() * config.getWidth();
        double maxAllowedCoveredArea = MAX_MAP_COVERAGE_PERCENTAGE * mapArea;

        return totalCoveredArea <= maxAllowedCoveredArea;
    }

    private boolean checkFileName(){
        String fileName = config.getFileName();
        String allowedFileNameChars = "[a-zA-Z0-9._-]+";
        return fileName.matches(allowedFileNameChars);
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
