package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.map.MapGenerator;

public class Pit extends Shape{

    public Pit(Coordinate topLeft, int area, char[][] map) {
        super(topLeft, area, map,'*');
    }

    @Override
    public boolean isOverlapping(Shape shape) {
        //TODO
        return false;
    }
}
