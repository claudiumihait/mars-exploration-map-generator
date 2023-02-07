package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PitGenerator extends ShapeGenerator {

    public PitGenerator(List<Coordinate> coordinates, int area) {
        super(coordinates, area);
    }

    @Override
    public Shape generate() {
        List<Coordinate> coordinates = generateCoordinates();
        return new Pit(coordinates);
    }
}
