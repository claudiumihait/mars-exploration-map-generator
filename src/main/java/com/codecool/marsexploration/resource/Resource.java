package com.codecool.marsexploration.resource;

import com.codecool.marsexploration.data.Coordinate;

abstract class Resource {

    protected char symbol;
    protected Coordinate location;

    public Resource(char symbol, Coordinate location) {
        this.symbol = symbol;
        this.location = location;
    }

    public char getSymbol() {
        return symbol;
    }

    public Coordinate getLocation() {
        return location;
    }
}
