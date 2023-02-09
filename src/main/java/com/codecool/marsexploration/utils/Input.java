package com.codecool.marsexploration.utils;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private final Display display;

    public Input(Display display) {
        this.display = display;
    }

    public int getNumericUserInput(String s){
        int choice = -1;

        try{
            display.message(s);
            while(choice < 0){
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            }
        }catch (InputMismatchException e){
            display.errorMessage("Invalid input");
        }
        return choice;
    }
}
