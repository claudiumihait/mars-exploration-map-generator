package com.codecool.marsexploration.utils;

public class Display {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_DEFAULT = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_ORANGE = "\u001B[38;5;208m";
    public void message(String s) {
        System.out.println(s);
    }

    public void errorMessage(String s) {
        message(ANSI_RED + s + ANSI_DEFAULT);
    }

}
