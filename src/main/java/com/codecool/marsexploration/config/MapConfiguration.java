package com.codecool.marsexploration.config;

import java.util.List;

public class MapConfiguration {

    private final String fileName;
    private final int width;
    private final List<Integer> mountainAreas;
    private final List<Integer> pitAreas;
    private final int waterCount;
    private final int mineralCount;

    public MapConfiguration(String fileName, int width, List<Integer> mountainAreas, List<Integer> pitAreas, int waterCount, int mineralCount) {
        this.fileName = fileName;
        this.width = width;
        this.mountainAreas = mountainAreas;
        this.pitAreas = pitAreas;
        this.waterCount = waterCount;
        this.mineralCount = mineralCount;
    }

    public void validate(){

    }

}
