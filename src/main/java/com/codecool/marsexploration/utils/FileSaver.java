package com.codecool.marsexploration.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {
    private final String FILE_PATH = "src/main/resources/";
    public static int fileIndex = 1;


    public void saveFile(String fileName, Character[][] map){
        String content = processMap(map);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH + fileName + "-" + fileIndex++ + ".map"))){
            bw.write(content);
        }catch(IOException e){
            System.out.println("An error occurred while trying to write the file.\n Error message: " + e.getMessage());
        }
    }

    private String processMap(Character[][] map){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i ++){
            for(int j = 0; j < map.length; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
