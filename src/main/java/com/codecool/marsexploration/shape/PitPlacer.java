package com.codecool.marsexploration.shape;

import java.util.List;

public class PitPlacer extends ShapePlacer{

    public void placeShapes(List<Pit> shapes, Character[][] map) {
        for (Shape shape : shapes)
            placeShape(shape, map);
    }
}
