package ru.kdv.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    public void compareTwoSamePoint(){
        Point a = new Point(1,1);
        Point b = new Point(1,1);
        assertEquals(a,b);
    }

    @Test
    public void compareTwoNotSamePoint(){
        Point a = new Point(1,2);
        Point b = new Point(1,1);
        assertNotEquals(a,b);
    }

}