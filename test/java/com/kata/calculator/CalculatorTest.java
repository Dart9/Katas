package com.kata.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldReturn0IfInputsIsEmptyString(){
        assertEquals(0, calculator.add(""));
    }

    @Test
    void shouldReturnNumberIfInputsIsOneNumber(){
        assertEquals(5, calculator.add("5"));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsIsTwoNumbers(){
        assertEquals(11, calculator.add("5,6"));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsContainsFirstEmptyNumber(){
        assertEquals(6, calculator.add(",6"));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsContainsSecondEmptyNumber(){
        assertEquals(5, calculator.add("5, "));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsContainsManyNumbers(){
        assertEquals(1673, calculator.add("1,2,5,15,50,100,1500, "));
    }

    @Test
    void shouldReturnSumOfNumbersIfInputsContainsLineJump(){
        assertEquals(8, calculator.add("1\n2,5"));
    }

    @Test
    void shouldReturnNotOKIfInputsContainsCommaAndLineJump(){
        assertEquals(-1, calculator.add("1,\n"));
    }

//    @Test
//    void shouldReturnSumOfNumbersIfInputsSemiCommaSeparator(){
//        assertEquals(8, calculator.add("1;2;5"));
//    }
}