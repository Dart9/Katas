package com.kata.christmaslight;

public class Light {

    private static int LINE_NUMBER = 1000;
    private static int COLUMN_NUMBER = 1000;
    private int lights[][] = new int[LINE_NUMBER][COLUMN_NUMBER];
    public static int SWITCH_ON = 1;
    public static int SWITCH_OFF = 0;
    public static int TOGGLE = -1;
    public static int TOGGLE_PART2 = 2;

    public void turnOnEveryLight() {
        changeLight(0, Light.LINE_NUMBER-1, 0, Light.COLUMN_NUMBER-1, SWITCH_ON);
    }

    public void turnOffEveryLight() {
        changeLight(0, Light.LINE_NUMBER-1, 0, Light.COLUMN_NUMBER-1, SWITCH_OFF);
    }

    private void toggleLight(int line, int column) {
        if(lights[line][column] == SWITCH_OFF) {
            lights[line][column] = SWITCH_ON;
        }
        else {
            lights[line][column] = SWITCH_OFF;
        }
    }

    public void turnOnOneLight(int line, int column) {
        lights[line][column] = SWITCH_ON;
    }

    public void turnOnOffLight(int line, int column) {
        lights[line][column] = SWITCH_OFF;
    }

    public void toggleLine(int line) {
        changeLight(line, line, 0, lights.length-1, Light.TOGGLE);
    }

    public void changeLight(int startLineNumber, int endLineNumber, int startColumnNumber, int endColumnNumber, int lightState) {
        for(int line=startLineNumber; line <= endLineNumber; line++) {
            for (int column = startColumnNumber; column <= endColumnNumber; column++) {
                if (lightState == TOGGLE) {
                    toggleLight(line, column);
                } else {
                    lights[line][column] = lightState;
                }
            }
        }
    }

    public void toggleLinePart2(int line) {
        changeLight(line, line, 0, lights.length-1, Light.TOGGLE_PART2);
    }

    public void changeLightPart2(int startLineNumber, int endLineNumber, int startColumnNumber, int endColumnNumber, int lightState) {
        for(int line=startLineNumber; line <= endLineNumber; line++) {
            for (int column = startColumnNumber; column <= endColumnNumber; column++) {
                    lights[line][column] = lightState;
            }
        }
    }

    public int[][] getLights() {
        return lights;
    }

    public int getLight(int line, int column) {
        return lights[line][column];
    }
}
