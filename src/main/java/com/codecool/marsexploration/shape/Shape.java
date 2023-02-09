package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;

import java.util.List;

public abstract class Shape {

    //The protected keyword makes the field accessible from within the same package as well as from subclasses.
    // If you declare it as private, it would only be accessible from within the class, and not from subclasses.

    //If you declare it as private final, it means that the field is not intended to be changed and its value is set
    //when the object is created and cannot be changed afterwards.

    //In this case, the topLeft and area fields are used in the subclasses, so they need to be accessible from the subclasses.
    //However, you still want to restrict the access to these fields to only the package and subclasses,
    //which is why protected is used.

    //naming them only private, and not private final??? -> the child classes won't be able to access them directly,
    // which may affect the implementation of the isOverlapping method.

    protected List<Coordinate> coordinates;
    protected char symbol;

    public Shape(List<Coordinate> coordinates, char symbol){
        this.coordinates = coordinates;
        this.symbol = symbol;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public char getSymbol(){return symbol;}

    protected boolean isAdjacentToExistingShape(Character[][] map, int offsetX, int offsetY) {
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (Coordinate c : coordinates) {
            int x = c.x() + offsetX;
            int y = c.y() + offsetY;
            if (x >= map.length || y >= map[0].length || map[x][y] != null && map[x][y] != ' ') {
                return true;
            }

            for(int i = 0; i < 8; i++){
                int neighborX = x + dx[i];
                int neighborY = y + dy[i];
                if (neighborX >= 0 && neighborX < map.length && neighborY >= 0 && neighborY < map[0].length &&
                        map[neighborX][neighborY] != null && map[neighborX][neighborY] != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    protected int getMaxX() {
        int maxX = Integer.MIN_VALUE;
        for (Coordinate c : coordinates){
            if (c.x() > maxX) maxX = c.x();
        }
        return maxX;
    }

    protected int getMaxY() {
        int maxY = Integer.MIN_VALUE;
        for (Coordinate c : coordinates){
            if (c.y() > maxY) maxY = c.y();
        }
        return maxY;
    }
}
