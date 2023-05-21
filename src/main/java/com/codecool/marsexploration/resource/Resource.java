package com.codecool.marsexploration.resource;

import com.codecool.marsexploration.data.Coordinate;

public abstract class Resource {

	protected char symbol;
	private final char preference;
	protected Coordinate location;

	public char getPreference() {
		return preference;
	}

	public Resource(char symbol, char preference) {
		this.symbol = symbol;
		this.preference = preference;
	}

	public char getSymbol() {
		return symbol;
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setCoordinate(int x, int y) {
		this.location = new Coordinate(x, y);
	}
}
