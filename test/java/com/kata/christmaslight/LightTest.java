package com.kata.christmaslight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LightTest {

    private Light light;

    protected void setUp(){
        light = new Light();
        light.turnOffEveryLight();
    }

    private int numberOfLights(int state) {
        int numberOfLights = 0;
        for(int line = 0; line < light.getLights().length; line++){
            for (int column = 0; column < light.getLights().length; column++){
                if(state == light.getLight(line, column)) {
                    if( state == Light.TOGGLE_PART2 )
                        numberOfLights += Light.TOGGLE_PART2;
                    else
                        numberOfLights += 1;
                }
            }
        }
        return numberOfLights;
    }

    private int numberOfLightsBrightness() {
        int numberOfLights = 0;
        for(int line = 0; line < light.getLights().length; line++){
            for (int column = 0; column < light.getLights().length; column++){
                numberOfLights += light.getLight(line, column);
            }
        }
        return numberOfLights;
    }

    @Test
    public void testTurnOnEveryLight() {
        light.turnOnEveryLight();
        assertEquals(1000000, numberOfLights(light.SWITCH_ON));
    }

    @Test
    public void testToggleFirstLine(){
        light.turnOnOneLight(0,0);
        light.turnOnOneLight(8,0);
        light.turnOnOneLight(9,0);
        light.turnOnOneLight(18,0);
        light.turnOnOneLight(19,0);
        light.toggleLine(0);
        assertEquals(1003, numberOfLights(light.SWITCH_ON));
    }

    @Test
    public void testTurnOff4Lights() {
        light.turnOnEveryLight();
        light.changeLight(499, 500, 499, 500, light.SWITCH_OFF);
        assertEquals(4, numberOfLights(light.SWITCH_OFF));
    }

    @Test
    public void testScenario(){
        light.turnOnEveryLight();
        light.toggleLine(0);
        light.changeLight(499, 500, 499, 500, Light.SWITCH_OFF);
        assertEquals(998996, numberOfLights(Light.SWITCH_ON));
    }

    @Test
    public void testTogglePart2(){
        light.changeLightPart2(0, 999, 0, 999, Light.TOGGLE_PART2);
        assertEquals(2000000, numberOfLights(Light.TOGGLE_PART2));
    }

    @Test
    public void testScenarioPart2(){
        light.turnOnEveryLight();
        light.toggleLinePart2(0);
        light.changeLight(499, 500, 499, 500, Light.SWITCH_OFF);
        assertEquals(1000996, numberOfLightsBrightness());
    }
}
