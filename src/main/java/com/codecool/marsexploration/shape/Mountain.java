package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.map.MapGenerator;

public class Mountain extends Shape{

    public Mountain(Coordinate topLeft, int area, char[][] map) {
        super(topLeft, area, map, '^');
    }

    @Override
    public boolean isOverlapping(Shape shape) {
        // Implementation of the logic to check if this mountain shape is overlapping with another shape
        // This logic could be based on checking the coordinates and/or areas of the two shapes
        // and determining if they intersect in any way
        // TODO
        return false;
    }
}
