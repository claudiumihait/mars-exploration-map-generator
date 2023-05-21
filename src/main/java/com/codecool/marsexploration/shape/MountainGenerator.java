package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;

import java.util.List;

public class MountainGenerator extends ShapeGenerator {

	public MountainGenerator(int area) {
		super(area);
	}

	public Mountain generate() {
		List<Coordinate> coordinates = generateCoordinates();
		return new Mountain(coordinates);
	}
}
