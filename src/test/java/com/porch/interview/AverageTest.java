package com.porch.interview;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class AverageTest {

//    @Ignore
    @Test
    public void testNewAverage(){
        Average avg = new Average(1);
        assertEquals(1, avg.average(), 0);
    }

//    @Ignore
    @Test
    public void testAverageSameValue(){
        Average avg = new Average(1);
        avg.update(1);
        assertEquals(1, avg.average(), 0);
    }

//    @Ignore
    @Test
    public void testAverageTwoValues(){
        Average avg = new Average(1);
        avg.update(2);
        assertEquals(1.5, avg.average(), 0);
    }

    @Test
    public void testAverageThreeValues(){
        Average avg = new Average(1);
        avg.update(2);
        avg.update(3);
        assertEquals(2, avg.average(), 0);
    }

    @Test
    public void testComplicatedAverage(){
        Average avg = new Average(50);
        avg.update(25);
        avg.update(25);
        avg.update(31);
        avg.update(2);
        avg.update(60);
        avg.update(71);
        avg.update(52);
        assertEquals(39.625, avg.average(), 3);
    }

    @Test
    public void testComplicatedAverage2(){
        Average avg = new Average(5);
        avg.update(5);
        avg.update(4);
        avg.update(4);
        avg.update(4);
        avg.update(3);
        avg.update(2);
        avg.update(1);
        assertEquals(3.5, avg.average(), 0);
    }

    @Test
    public void testExample(){
        Average avg = new Average(1);
        avg.update(2);
        avg.update(2);
        assertEquals(1.666, avg.average(), 3);
    }

    @Test
    public void testExample2(){
        Average avg = new Average(1);
        avg.update(2);
        avg.update(2);
        avg.update(2);
        assertEquals(1.75, avg.average(), 0);
    }

}