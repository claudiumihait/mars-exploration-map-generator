package com.codecool.marsexploration.utils;

import com.codecool.marsexploration.config.MapConfiguration;
import com.codecool.marsexploration.shape.Mountain;
import com.codecool.marsexploration.shape.Pit;

import java.util.Map;

public class Display {

    private static final char MOUNTAIN_SYMBOL = '^';
    private static final char PIT_SYMBOL = '#';
    private static final char WATER_SYMBOL = '~';
    private static final char MINERAL_SYMBOL = '*';
    private static final char EMPTY_SPACE = ' ';
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_DEFAULT = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_MAGENTA = "\u001B[35m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_WHITE = "\u001B[47m";

    private static final Map<Character, String> SYMBOL_COLOR_MAP = Map.of(
            MOUNTAIN_SYMBOL, ANSI_MAGENTA,
            PIT_SYMBOL, ANSI_YELLOW,
            WATER_SYMBOL, ANSI_BLUE,
            MINERAL_SYMBOL, ANSI_RED,
            EMPTY_SPACE, ANSI_BLACK + ANSI_WHITE
    );

    public void message(String s) {
        System.out.println(s);
    }

    public void errorMessage(String s) {
        message(ANSI_RED + s + ANSI_DEFAULT);
    }

    private void displayConfig(MapConfiguration config){
        displayFileName(config);
        displayMapWidth(config);
        displayMountainAreas(config);
        displayPitAreas(config);
        displayResourcesCount(config);
    }

    private void displayFileName(MapConfiguration config){
        System.out.println();
        message(ANSI_GREEN + "File name: " + ANSI_DEFAULT);
        message(ANSI_RED + config.getFileName() + ANSI_DEFAULT + ANSI_RED + ".txt" + ANSI_DEFAULT );
    }

    private void displayMapWidth(MapConfiguration config){
        System.out.println();
        message(ANSI_GREEN + "Map width: " + ANSI_DEFAULT);
        message(ANSI_RED + config.getWidth() + ANSI_DEFAULT);
    }

    private void displayMountainAreas(MapConfiguration config){
        System.out.println();
        message(ANSI_GREEN + "Mountain areas: " + ANSI_DEFAULT + ANSI_RED + config.getShapesCount()[0] + ANSI_DEFAULT);
        int areaNumber = 1;
        for(int i = 0 ; i < config.getShapes().size(); i++){
            if (config.getShapes().get(i) instanceof Mountain){
                message(ANSI_GREEN + "Area (" + ANSI_DEFAULT + ANSI_RED + (areaNumber++) + ANSI_DEFAULT + ANSI_GREEN + ") size: " + ANSI_DEFAULT + ANSI_RED + config.getShapes().get(i).getCoordinates().size() + ANSI_DEFAULT);
            }
        }
    }

    private void displayPitAreas(MapConfiguration config){
        System.out.println();
        message(ANSI_GREEN + "Pit areas: " + config.getShapesCount()[1] + ANSI_DEFAULT);
        int areaNumber = 1;
        for(int i = 0 ; i < config.getShapes().size(); i++){
            if (config.getShapes().get(i) instanceof Pit){
                message(ANSI_GREEN + "Area (" + ANSI_DEFAULT + ANSI_RED + (areaNumber++) + ANSI_DEFAULT + ANSI_GREEN + ") size: " + ANSI_DEFAULT + ANSI_RED + config.getShapes().get(i).getCoordinates().size() + ANSI_DEFAULT);
            }
        }
    }

    private void displayResourcesCount(MapConfiguration config){
        System.out.println();
        message(ANSI_GREEN + "Mineral resources: " + ANSI_DEFAULT + ANSI_RED + config.getResourcesCount()[0] + ANSI_DEFAULT);
        message(ANSI_GREEN + "Water resources: "  + ANSI_DEFAULT + ANSI_RED + config.getResourcesCount()[1] + ANSI_DEFAULT);
    }

    private void displayMap(Character[][] map){
        for(int i = -1; i <= map.length; i++){
            for(int j = -1; j <= map.length; j++){
                if (i == -1 || i == map.length || j == -1 || j == map.length) {
                    System.out.print(ANSI_GREEN + "*" + ANSI_DEFAULT);
                } else {
                    System.out.print(SYMBOL_COLOR_MAP.getOrDefault(map[i][j], ANSI_DEFAULT) + map[i][j] + ANSI_DEFAULT);
                }
            }
            System.out.println();
        }
    }

    public void displayGenerated(MapConfiguration config, Character[][] map){
        displayConfig(config);
        System.out.println();
        displayMap(map);
    }
}
