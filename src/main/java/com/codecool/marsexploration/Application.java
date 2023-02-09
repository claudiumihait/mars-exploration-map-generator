package com.codecool.marsexploration;

import com.codecool.marsexploration.config.ConfigGenerator;
import com.codecool.marsexploration.config.MapConfiguration;
import com.codecool.marsexploration.map.MapGenerator;
import com.codecool.marsexploration.utils.Display;
import com.codecool.marsexploration.utils.FileSaver;
import com.codecool.marsexploration.utils.Input;

public class Application {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input(display);
        FileSaver writer = new FileSaver();
        ConfigGenerator configGenerator = new ConfigGenerator(input);
        configGenerator.init();
        MapConfiguration config = new MapConfiguration(configGenerator.getFileName(), configGenerator.getWidth(), configGenerator.getShapeList(),configGenerator.getResourceList());
        MapGenerator generator = new MapGenerator(config, writer);
        generator.generate();
    }
}