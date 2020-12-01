package com.kata.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void shouldReturn0IfInputsIsEmptyString(){
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void shouldReturnNumberIfInputsIsOneNumber(){
        assertEquals(5, stringCalculator.add("5"));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsIsTwoNumbers(){
        assertEquals(11, stringCalculator.add("5,6"));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsContainsFirstEmptyNumber(){
        assertEquals(6, stringCalculator.add(",6"));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsContainsSecondEmptyNumber(){
        assertEquals(5, stringCalculator.add("5, "));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsContainsManyNumbers(){
        assertEquals(1673, stringCalculator.add("1,2,5,15,50,100,1500, "));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsContainsLineJump(){
        assertEquals(8, stringCalculator.add("1\n2,5"));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsSemiCommaSeparator(){
        assertEquals(8, stringCalculator.add("//;\n1;2;5"));
    }

    @Test
    void shouldReturnExceptionIfAllInputsAreNegative(){
        assertThrows(NumberFormatException.class, () -> {
            stringCalculator.add("//;\n-1;-2;-5");
        });
    }

    @Test
    void shouldReturnExceptionIfOneInputsIsNegative(){
        assertThrows(NumberFormatException.class, () -> {
                stringCalculator.add("//;\n1;-2;5");
        });
    }
}