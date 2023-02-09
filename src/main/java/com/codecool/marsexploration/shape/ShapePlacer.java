package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.map.MapGenerator;
import com.codecool.marsexploration.utils.Display;

import java.util.List;
import java.util.Random;

public class ShapePlacer {

    private void placeShape(Shape shape, Character[][] map, int[] areasIndexes){
        Random rand = new Random();
        Display display = new Display();
        List<Coordinate> coordinates = shape.getCoordinates();
        int offsetX = rand.nextInt(map.length - shape.getMaxX());
        int offsetY = rand.nextInt(map.length - shape.getMaxY());
        int retries = 0;
        while(offsetX + shape.getMaxX() > map.length || offsetY + shape.getMaxY() > map.length || shape.isAdjacentToExistingShape(map, offsetX, offsetY)){
            retries++;
            if(retries == 1000){
                if (shape instanceof Mountain){
                    display.errorMessage("Failed to place mountain shape number -" + areasIndexes[0] + "- of size -" + shape.getCoordinates().size() + "- after 1000 attempts. Maximum number of retries reached.");
                    System.exit(0);
                }else{
                    display.errorMessage("Failed to place pit shape number -" + areasIndexes[1] + "- of size -" + shape.getCoordinates().size() + "- after 1000 attempts. Maximum number of retries reached.");
                    System.exit(0);
                }
            }

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
        //mountain index at 0, pit index at 1
        int[] areasIndexes = {0,0};
        for(int i = 0 ; i < shapes.size(); i++){
            if (shapes.get(i) instanceof  Mountain) areasIndexes[0]++;
            else areasIndexes[1]++;

            placeShape(shapes.get(i), map, areasIndexes);
        }
    }
}
