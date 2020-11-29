package com.kata.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciSequenceTest {

    private FibonacciSequence fibonacciSequence ;

    @BeforeEach
    void setUp() {
        fibonacciSequence = new FibonacciSequence();
    }

    @Test
    public void shouldIteration1Return0(){
        assertEquals("0", fibonacciSequence.generate(1));
    }

    @Test
    public void shouldIteration2Return01(){
        assertEquals("0, 1", fibonacciSequence.generate(2));
    }

    @Test
    public void shouldIteration3Return011(){
        assertEquals("0, 1, 1", fibonacciSequence.generate(3));
    }

    @Test
    public void shouldIteration4Return0112(){
        assertEquals("0, 1, 1, 2", fibonacciSequence.generate(4));
    }

    @Test
    public void shouldIteration13ReturnFibonacciSequence(){
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144",
                fibonacciSequence.generate(13));
    }
}