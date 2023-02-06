package com.codecool.marsexploration.shape;

import java.util.List;

public abstract class ShapeGenerator {

    protected int area;

    public ShapeGenerator(int area) {
        this.area = area;
    }

    public int getArea(){
        return area;
    }

    public abstract List<Shape> generate();
        //generates a shape(mountain/pit) with specified area(pixels)
        //returns a list of possible shapes (eg. if area is 20, possible shapes are 5/4, 4/5 10/2, 2/10);
        // TODO

}
