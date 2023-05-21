package com.codecool.marsexploration.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResourcePlacer {

	public void placeResources(List<Resource> resources, Character[][] map) {
		Random rand = new Random();
		for (Resource resource : resources) {
			boolean isPlaced = false;
			while (!isPlaced) {
				int x = rand.nextInt(map.length);
				int y = rand.nextInt(map.length);

				if (map[x][y] == resource.getPreference()) {

					List<int[]> neighbors = getAvailableNeighbors(x, y, map);

					if (!neighbors.isEmpty()) {
						int[] placedAt = neighbors.get(rand.nextInt(neighbors.size()));
						map[placedAt[0]][placedAt[1]] = resource.getSymbol();
						resource.setCoordinate(placedAt[0], placedAt[1]);
						isPlaced = true;
					}
				}
			}
		}
	}

	private List<int[]> getAvailableNeighbors(int x, int y, Character[][] map) {
		List<int[]> neighbors = new ArrayList<>();

		int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

		for (int i = 0; i < 8; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length &&
					(map[newX][newY] == null || map[newX][newY] == ' ')) {
				neighbors.add(new int[]{newX, newY});
			}
		}

		return neighbors;
	}
}
