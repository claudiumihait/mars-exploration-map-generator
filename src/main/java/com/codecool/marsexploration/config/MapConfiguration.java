package com.codecool.marsexploration.config;

import com.codecool.marsexploration.resource.Mineral;
import com.codecool.marsexploration.resource.Water;
import com.codecool.marsexploration.shape.Mountain;
import com.codecool.marsexploration.shape.Pit;

import java.util.List;

public class MapConfiguration {

    private final String fileName;
    private final int width;
    private final List<List<Mountain>> mountainAreas;
    private final List<List<Pit>> pitAreas;
    private final List<Water> waters;
    private final List<Mineral> minerals;
    private final boolean isConfigValid;

    public MapConfiguration(String fileName, int width, List<List<Mountain>> mountainAreas, List<List<Pit>> pitAreas, List<Water> waters, List<Mineral> minerals) {
        this.fileName = fileName;
        this.width = width;
        this.mountainAreas = mountainAreas;
        this.pitAreas = pitAreas;
        this.waters = waters;
        this.minerals = minerals;
        this.isConfigValid = validate();
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

    public List<List<Mountain>> getMountainAreas() {
        return mountainAreas;
    }

    public List<List<Pit>> getPitAreas() {
        return pitAreas;
    }

    public List<Water> getWaters() {
        return waters;
    }

    public List<Mineral> getMinerals() {
        return minerals;
    }

    public boolean isConfigValid() {
        return isConfigValid;
    }
}
