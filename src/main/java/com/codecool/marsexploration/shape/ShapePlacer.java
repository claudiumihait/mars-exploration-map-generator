package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.map.MapGenerator;

import java.util.List;
import java.util.Random;

public class ShapePlacer {

    private void placeShape(Shape shape, Character[][] map){
        Random rand = new Random();
        List<Coordinate> coordinates = shape.getCoordinates();
        int offsetX = rand.nextInt(map.length - shape.getMaxX());
        int offsetY = rand.nextInt(map.length - shape.getMaxY());

        while(offsetX + shape.getMaxX() > map.length || offsetY + shape.getMaxY() > map.length || shape.isAdjacentToExistingShape(map, offsetX, offsetY)){
            offsetX = rand.nextInt(map.length - shape.getMaxX());
            offsetY = rand.nextInt(map.length - shape.getMaxY());
        }

        for(int i = 0; i < coordinates.size(); i ++){
            Coordinate c = coordinates.get(i);
            Coordinate newC = new Coordinate(c.x() + offsetX, c.y() + offsetY);
            coordinates.set(i, newC);
            map[newC.x()][newC.y()] = shape.getSymbol();
        }
    }

    public void placeShapes(List<Shape> shapes, Character[][] map) {
        for(Shape shape : shapes)
            placeShape(shape, map);
    }
}
