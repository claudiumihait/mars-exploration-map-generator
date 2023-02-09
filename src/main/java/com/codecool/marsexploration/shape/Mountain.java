package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;

import java.util.List;

public class Mountain extends Shape{

    public Mountain(List<Coordinate> coordinates) {
        super(coordinates, '^');
    }
}
