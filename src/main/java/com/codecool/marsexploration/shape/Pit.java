package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.map.MapGenerator;

import java.util.List;

public class Pit extends Shape{

    public Pit(List<Coordinate> coordinates, int area, char[][] map) {
        super(coordinates, area, map,'*');
    }

    @Override
    public boolean isOverlapping(Shape shape) {
        //TODO
        return false;
    }
}
