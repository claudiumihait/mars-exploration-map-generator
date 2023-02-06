package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.map.MapGenerator;

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

    protected Coordinate topLeft;
    protected int area;

    protected char[][] map;
    protected char symbol;

    public Shape(Coordinate topLeft, int area, char[][] map /* TODO - need the map???*/, char symbol){
        this.topLeft = topLeft;
        this.area = area;
        this.map = map;
        this.symbol = symbol;
    }

    public Coordinate getTopLeft() {
        return topLeft;
    }

    public int getArea() {
        return area;
    }

    public char[][] getMap() {
        return map;
    }

    public char getSymbol(){return symbol;}

    public abstract boolean isOverlapping(Shape shape);
}
