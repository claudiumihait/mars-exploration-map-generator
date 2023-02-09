package com.codecool.marsexploration.config;

import com.codecool.marsexploration.resource.Mineral;
import com.codecool.marsexploration.resource.Resource;
import com.codecool.marsexploration.resource.Water;
import com.codecool.marsexploration.shape.Mountain;
import com.codecool.marsexploration.shape.Pit;
import com.codecool.marsexploration.shape.Shape;
import com.codecool.marsexploration.utils.Display;

import java.util.List;

public class MapConfiguration {

    private final String fileName;
    private final int width;
    private final List<Resource> resourceList;
    private final List<Shape> shapeList;
    private final int numberOfRandomMaps;
    private final boolean isConfigValid;

    public MapConfiguration(String fileName, int width, List<Shape> shapeList,List<Resource> resourceList, int numberOfRandomMaps) {
        this.fileName = fileName;
        this.width = width;
        this.shapeList = shapeList;
        this.resourceList = resourceList;
        this.numberOfRandomMaps = numberOfRandomMaps;
        this.isConfigValid = validate();
    }

    public List<Resource> getResources() {
        return resourceList;
    }

    public List<Shape> getShapes() {
        return shapeList;
    }

    public String getFileName() {
        return fileName;
    }

    public int getWidth() {
        return width;
    }
    public int getNumberOfRandomMaps() { return numberOfRandomMaps; }

    public boolean validate(){
        ConfigurationValidator validator = new ConfigurationValidator(this, new Display());
        return validator.validate();
    }

    public int[] getShapesCount(){
        int[] shapesCount = new int[2];
        int mountainsCount = 0;
        int pitsCount = 0;
        for (Shape shape : shapeList ){
            if (shape instanceof Mountain) mountainsCount++;
            if (shape instanceof Pit) pitsCount++;
        }
        shapesCount[0] = mountainsCount;
        shapesCount[1] = pitsCount;

        return shapesCount;
    }

    public int[] getResourcesCount(){
        int[] resourcesCount = new int[2];
        int watersCount = 0;
        int mineralsCount = 0;
        for (Resource resource : resourceList ){
            if (resource instanceof Mineral) mineralsCount++;
            if (resource instanceof Water) watersCount++;
        }
        resourcesCount[0] = mineralsCount;
        resourcesCount[1] = watersCount;

        return resourcesCount;
    }

    public boolean isConfigValid() {
        return isConfigValid;
    }
}
