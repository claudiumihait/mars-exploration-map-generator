package com.codecool.marsexploration.config;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.resource.Resource;
import com.codecool.marsexploration.shape.Mountain;
import com.codecool.marsexploration.shape.Pit;
import com.codecool.marsexploration.shape.Shape;
import com.codecool.marsexploration.shape.ShapeGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConfigurationValidator {

    private final double MAX_MAP_COVERAGE_PERCENTAGE = 0.7;
    private final MapConfiguration config;

    public ConfigurationValidator(MapConfiguration config) {
        this.config = config;
    }


    public boolean validate(){
        //FIXME - checkShapesCoordinatesNotOverlapping() method
        //metoda verifica coordonatele imediat dupa generare-VEZI TERMINAL LA RUN APP
        //metoda trebuie sa parcurga lista de coordonate + offset pt fiecare(mai complicat)
        //sau sa verifice pt fiecare semn(ˆ#˜*) cate sunt pe harta si cate ar trebui sa fie. Daca numerele sunt egale, nu s-a facut overlap si tootul este bine.

        if(!checkAreaCoveredByShapes()){
            System.out.println("checkAreaCoveredByShapes = FALSE");
        }
        if(!checkShapesCoordinatesNotOverlapping()){
            System.out.println("checkShapesCoordinatesNotOverlapping == FALSE");
        }
        if(!checkFileName()){
            System.out.println("checkFileName() = FALSE");
        }
//        return checkAreaCoveredByShapes() && checkShapesCoordinatesNotOverlapping() && checkFileName();
        return true;
    }

    private boolean checkAreaCoveredByShapes(){
//        List<List<Pit>> pitAreas = config.getPitAreas();
//        List<List<Mountain>> mountainAreas = config.getMountainAreas();
        List<Shape> shapes = config.getShapes();
        List<Resource> resources = config.getResources();

        double totalCoveredArea = shapes.stream().map(shape->shape.getCoordinates().size()).reduce(0,(a,b)->a+b) +
                resources.size();
        System.out.println("VERIFICARE!!!! "+ totalCoveredArea);

        double mapArea = config.getWidth() * config.getWidth();
        double maxAllowedCoveredArea = MAX_MAP_COVERAGE_PERCENTAGE * mapArea;

        return totalCoveredArea <= maxAllowedCoveredArea;
    }

    private boolean checkShapesCoordinatesNotOverlapping(){
        List<Coordinate> takenSpots = new ArrayList<>();

        for(Shape shape : config.getShapes()){
            takenSpots.addAll(shape.getCoordinates());
        }

        for(Resource resource : config.getResources()){
            takenSpots.add(resource.getLocation());
        }

//        for(Resource mineral : config.getMinerals()){
//            takenSpots.add(mineral.getLocation());
//        }

//        for(List<Pit> pitArea : config.getPitAreas()){
//            for (Pit pit : pitArea){
//                takenSpots.addAll(pit.getCoordinates());
//            }
//        }

//        for(List<Mountain> mountainArea : config.getMountainAreas()){
//            for(Mountain mountain : mountainArea){
//                takenSpots.addAll(mountain.getCoordinates());
//            }
//        }
        System.out.println("VERIFICARE IN CONFIGURATION VALIDATOR");
        System.out.println("VERIFICARE LISTA TAKENSPOTS: ");
        for(Coordinate c:takenSpots){
            System.out.println(c);
        }
        return takenSpots.stream().filter(Objects::nonNull)
                .noneMatch(c1 -> takenSpots.stream().filter(Objects::nonNull).anyMatch(c2 -> c1 != c2 && c1.x() == c2.x() && c1.y() == c2.y()));
    }

    private boolean checkFileName(){
        String fileName = config.getFileName();
        String allowedFileNameChars = "[a-zA-Z0-9._-]+";
        return fileName.matches(allowedFileNameChars);
    }
}
