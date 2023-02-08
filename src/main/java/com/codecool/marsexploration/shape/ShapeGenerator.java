package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;

import java.util.*;

public abstract class ShapeGenerator {

    protected int area;

    public ShapeGenerator(int area) {
        this.area = area;
    }

    public int getArea(){
        return area;
    }

    //public abstract Shape generate();

    protected List<Coordinate> generateCoordinates(){
        Set<Coordinate> coordinatesSet = new HashSet<>();
        Random random = new Random();

        int x = 0;
        int y = 0;
        for(int i = 0; i < area; i++){

            int dx = random.nextInt(3) - 1;
            int dy = random.nextInt(3) - 1;

            while((x + dx == x && y + dy == y) || (x + dx < 0 || y + dy < 0)){
                dx = random.nextInt(3) - 1;
                dy = random.nextInt(3) - 1;
            }

            x+=dx;
            y+=dy;

            Coordinate coordinate = new Coordinate(x,y);
            if(coordinatesSet.contains(coordinate)){
                i--;
                continue;
            }
            coordinatesSet.add(coordinate);
        }
        return new ArrayList<>(coordinatesSet);
    }
}
