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

    public abstract boolean isOverlapping(Character[][] map, int offsetX, int offsetY);

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
