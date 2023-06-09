package com.codecool.marsexploration.shape;

import com.codecool.marsexploration.data.Coordinate;

import java.util.List;

public class PitGenerator extends ShapeGenerator {

	public PitGenerator(int area) {
		super(area);
	}

	public Pit generate() {
		List<Coordinate> coordinates = generateCoordinates();
		return new Pit(coordinates);
	}
}
