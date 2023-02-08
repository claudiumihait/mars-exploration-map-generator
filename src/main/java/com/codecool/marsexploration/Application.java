package com.codecool.marsexploration;

import com.codecool.marsexploration.config.MapConfiguration;
import com.codecool.marsexploration.map.MapGenerator;
import com.codecool.marsexploration.resource.Mineral;
import com.codecool.marsexploration.resource.Resource;
import com.codecool.marsexploration.resource.ResourcePlacer;
import com.codecool.marsexploration.resource.Water;
import com.codecool.marsexploration.shape.*;
import com.codecool.marsexploration.utils.FileSaver;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide width: ");
        int width = scanner.nextInt();

        System.out.println("How many mountains? ");
        int mountainsCount = scanner.nextInt();
        List<List<Mountain>> mountainAreas = new ArrayList<>();
        for (int i = 0; i < mountainsCount; i++) {
            System.out.println("For mountain number " + i + " - how much should the area be? ");
            int mountainSize = scanner.nextInt();
            List<Mountain> mountains = new ArrayList<>();
            for (int j = 0; j < mountainAreas.size(); j++) {
                MountainGenerator mountainGenerator = new MountainGenerator(mountainSize);
                Mountain newMountain = mountainGenerator.generate();
                mountains.add(newMountain);
            }
            mountainAreas.add(mountains);
        }

        System.out.println("How many pit areas? ");
        int pitsCount = scanner.nextInt();
        List<List<Pit>> pitAreas = new ArrayList<>();
        for (int i = 0; i < pitsCount; i++) {
            System.out.println("For pit area number " + i + " - how many pits? ");
            int pitSize = scanner.nextInt();
            PitGenerator pitGenerator = new PitGenerator(pitSize);
            List<Pit> pits = new ArrayList<>();
            for (int j = 0; j < pitSize; j++) {
                Pit pit = pitGenerator.generate();
                pits.add(pit);
            }
            pitAreas.add(pits);
        }

        System.out.println("How many water resources? ");
        int waterResourcesCount = scanner.nextInt();
        List<Resource> waters = new ArrayList<>();
        for (int i = 0; i < waterResourcesCount; i++) {
            Water water = new Water();
            waters.add(water);
        }

        System.out.println("How many mineral resources? ");
        int mineralResourcesCount = scanner.nextInt();
        List<Resource> minerals = new ArrayList<>();
        for (int i = 0; i < mineralResourcesCount; i++) {
            Mineral mineral = new Mineral();
            minerals.add(mineral);
        }

        MapConfiguration config = new MapConfiguration("map.txt", width, mountainAreas, pitAreas, waters, minerals);
        MountainPlacer mountainPlacer = new MountainPlacer();
        PitPlacer pitPlacer = new PitPlacer();
        ResourcePlacer resourcePlacer = new ResourcePlacer();
        FileSaver saver = new FileSaver();
        MapGenerator generator = new MapGenerator(config,saver, mountainPlacer, pitPlacer, resourcePlacer);
        generator.generate();
    }


}
