package com.codecool.marsexploration.config;

import com.codecool.marsexploration.resource.Resource;
import com.codecool.marsexploration.shape.Mountain;
import com.codecool.marsexploration.shape.Pit;
import com.codecool.marsexploration.shape.Shape;

import java.util.List;

public class MapConfiguration {

    private final String fileName;
    private final int width;



    //    private final List<List<Mountain>> mountainAreas;
//    private final List<List<Pit>> pitAreas;
//    private final List<Resource> waters;
//    private final List<Resource> minerals;
    private final List<Resource> resourceList;
    private final List<Shape> shapeList;
    private final boolean isConfigValid;
//TODO-mapConfiguration(conform JOURNEY) trebuie sa ia ca paramentru (din input) cati munti/vai/ape/minerale sa aiba
    //TODO-Try to include these strategies into the configuration object as well.(PROCENT OCUPARE)
    public MapConfiguration(String fileName, int width, List<Shape> shapeList,List<Resource> resourceList) {
        this.fileName = fileName;
        this.width = width;
//        this.mountainAreas = mountainAreas;
//        this.pitAreas = pitAreas;
//        this.waters = waters;
//        this.minerals = minerals;
        this.shapeList = shapeList;
        this.resourceList = resourceList;
        this.isConfigValid = validate();
    }

    public List<Resource> getResources() {
        return resourceList;
    }

    public List<Shape> getShapes() {
        return shapeList;
    }

    public boolean validate(){
        ConfigurationValidator validator = new ConfigurationValidator(this);
        return validator.validate();
    }

    public String getFileName() {
        return fileName;
    }

    public int getWidth() {
        return width;
    }

//    public List<List<Mountain>> getMountainAreas() {
//        return mountainAreas;
//    }
//
//    public List<List<Pit>> getPitAreas() {
//        return pitAreas;
//    }
//
//    public List<Resource> getWaters() {
//        return waters;
//    }
//
//    public List<Resource> getMinerals() {
//        return minerals;
//    }


    public boolean isConfigValid() {
        return isConfigValid;
    }
}
