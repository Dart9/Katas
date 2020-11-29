package com.kata.conwaysequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConwaySequenceTest {

    private ConwaySequence conwaySequence;

    @BeforeEach
    void setUp() {
        conwaySequence = new ConwaySequence();
    }

    @Test
    public void readOffOne1Return11(){
        assertEquals("11", conwaySequence.readMember("1"));
    }

    @Test
    public void readOffTwo1Return21(){
        assertEquals("21", conwaySequence.readMember("11"));
    }

    @Test
    public void readOffThree1Return31(){
        assertEquals("31", conwaySequence.readMember("111"));
    }

    @Test
    public void readOffOne2Return12(){
        assertEquals("12", conwaySequence.readMember("2"));
    }

    @Test
    public void readOffTwo2Return22(){
        assertEquals("22", conwaySequence.readMember("22"));
    }

    @Test
    public void readOffThree4Return34(){
        assertEquals("34", conwaySequence.readMember("444"));
    }

    @Test
    public void readOffOne2One1TwoReturn1211(){
        assertEquals("1211", conwaySequence.readMember("21"));
    }

    @Test
    public void readOffOne1One2Two1Return111221(){
        assertEquals("111221", conwaySequence.readMember("1211"));
    }

    @Test
    public void readOffThree1Two2One1Return312211(){
        assertEquals("312211", conwaySequence.readMember("111221"));
    }

}