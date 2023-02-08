package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;

import java.util.List;

public class Mountain extends Shape{

    public Mountain(List<Coordinate> coordinates) {
        super(coordinates, '^');
    }

    @Override
    public boolean isOverlapping(Character[][] map, int offsetX, int offsetY) {
        for (Coordinate c : coordinates) {
            int x = c.x() + offsetX;
            int y = c.y() + offsetY;
            if (x >= map.length || y >= map[0].length || map[x][y] != null && map[x][y] != ' ') {
                return true;
            }
        }
        return false;
    }
}
