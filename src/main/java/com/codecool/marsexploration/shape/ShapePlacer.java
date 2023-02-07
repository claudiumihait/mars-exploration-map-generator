package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.map.MapGenerator;

import java.util.List;

public abstract class ShapePlacer {

    // TODO - need map here ??
    public abstract void placeShapes(List<Shape> shapes, Character[][] map);
}
