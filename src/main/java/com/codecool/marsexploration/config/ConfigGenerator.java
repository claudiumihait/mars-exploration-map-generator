package com.codecool.marsexploration.config;

import com.codecool.marsexploration.resource.Mineral;
import com.codecool.marsexploration.resource.Resource;
import com.codecool.marsexploration.resource.Water;
import com.codecool.marsexploration.shape.MountainGenerator;
import com.codecool.marsexploration.shape.PitGenerator;
import com.codecool.marsexploration.shape.Shape;
import com.codecool.marsexploration.utils.Input;

import java.util.ArrayList;
import java.util.List;

public class ConfigGenerator {

    private final Input input;
    private String fileName;
    private int width;
    private int numberOfRandomMaps;
    private List<Shape> shapeList;
    private List<Resource> resourceList;

    public ConfigGenerator(Input input) {
        this.input = input;
        this.shapeList = new ArrayList<>();
        this.resourceList = new ArrayList<>();
    }

    public void init() {
        this.fileName = input.getUserInput("Enter file name: ");
        this.width = input.getNumericUserInput("Enter map width: ");

        int numberOfMountainAreas = input.getNumericUserInput("Enter number of mountain areas: ");
        for (int i = 0; i < numberOfMountainAreas; i++) {
            int mountainAreaSize = input.getNumericUserInput("Enter mountain area " + (i+1) + " size: ");
            this.shapeList.add(new MountainGenerator(mountainAreaSize).generate());
        }

        int numberOfPitAreas = input.getNumericUserInput("Enter number of pit areas: ");
        for (int i = 0; i < numberOfPitAreas; i++) {
            int pitAreaSize = input.getNumericUserInput("Enter pit area " + (i+1) + " size: ");
            this.shapeList.add(new PitGenerator(pitAreaSize).generate());
        }

        int numberOfMineralResources = input.getNumericUserInput("Enter number of mineral resources: ");
        for (int i = 0; i < numberOfMineralResources; i++) {
            this.resourceList.add(new Mineral());
        }

        int numberOfWaterResources = input.getNumericUserInput("Enter number of water resources: ");
        for (int i = 0; i < numberOfWaterResources; i++) {
            this.resourceList.add(new Water());
        }

        this.numberOfRandomMaps = input.getNumericUserInput("How many random maps you want to generate with configuration?");
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public String getFileName() {
        return fileName;
    }

    public int getWidth() {
        return width;
    }

    public int getNumberOfRandomMaps() { return numberOfRandomMaps; }
}