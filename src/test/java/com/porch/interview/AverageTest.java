package com.porch.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class AverageTest {

//    @Ignore
    @Test
    public void testNewAverage(){
        LimitedRunningAverage avg = new LimitedRunningAverage(1);
        assertEquals(1, avg.average(), 0);
        assertEquals(1, avg.num_reviews());
    }

//    @Ignore
    @Test
    public void testAverageSameValue(){
        LimitedRunningAverage avg = new LimitedRunningAverage(1);
        avg.update(1);
        assertEquals(1, avg.average(), 0);
        assertEquals(2, avg.num_reviews());
    }

//    @Ignore
    @Test
    public void testAverageTwoValues(){
        LimitedRunningAverage avg = new LimitedRunningAverage(1);
        avg.update(2);
        assertEquals(1.5, avg.average(), 0);
        assertEquals(2, avg.num_reviews());
    }

    @Test
    public void testAverageThreeValues(){
        LimitedRunningAverage avg = new LimitedRunningAverage(1);
        avg.update(2);
        avg.update(3);
        assertEquals(2, avg.average(), 0);
        assertEquals(3, avg.num_reviews());
    }

    @Test
    public void testComplicatedAverage(){
        LimitedRunningAverage avg = new LimitedRunningAverage(50);
        avg.update(25);
        avg.update(25);
        avg.update(31);
        avg.update(2);
        avg.update(60);
        avg.update(71);
        avg.update(52);
        assertEquals(39.625, avg.average(), 3);
        assertEquals(8, avg.num_reviews());
    }

    @Test
    public void testComplicatedAverage2(){
        LimitedRunningAverage avg = new LimitedRunningAverage(5);
        avg.update(5);
        avg.update(4);
        avg.update(4);
        avg.update(4);
        avg.update(3);
        avg.update(2);
        avg.update(1);
        assertEquals(3.5, avg.average(), 0);
        assertEquals(8, avg.num_reviews());
    }

    @Test
    public void testExample(){
        LimitedRunningAverage avg = new LimitedRunningAverage(1);
        avg.update(2);
        avg.update(2);
        assertEquals(1.666, avg.average(), 3);
        assertEquals(3, avg.num_reviews());
    }

    @Test
    public void testExample2(){
        LimitedRunningAverage avg = new LimitedRunningAverage(1);
        avg.update(2);
        avg.update(2);
        avg.update(2);
        assertEquals(1.75, avg.average(), 0);
        assertEquals(4, avg.num_reviews());
    }

    @Test
    public void testLimit(){
        LimitedRunningAverage avg = new LimitedRunningAverage(1);
        for(int i = 1; i <= 100; i++){
            avg.update(1);
        }
        assertEquals(1.000, avg.average(), .001);
        for(int i = 200; i <= 300; i++){
            avg.update(5);
        }
        assertEquals(5.000, avg.average(), .001);
    }

}