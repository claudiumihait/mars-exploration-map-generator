package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;

import java.util.List;

public class MountainGenerator extends ShapeGenerator{

    public MountainGenerator(List<Coordinate> coordinates, int area) {
        super(coordinates,area);
    }

    @Override
    public Shape generate() {
        List<Coordinate> coordinates = generateCoordinates();
        return new Mountain(coordinates);
    }
}
