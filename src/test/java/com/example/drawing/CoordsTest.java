package com.example.drawing;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoordsTest {


    @Test
    public void testCoordsToString() {

        Coords a = new Coords(5, 6);
        String expectedString = String.format("Coords{x=%d, y=%d}", 5, 6);
        assertEquals(expectedString, a.toString());
    }

    @Test
    public void testCoordsEquality() {

        Coords a = new Coords(3, 7);
        Coords b = new Coords(3, 7);
        assertEquals(a, b);
    }

    @Test
    public void testCoordsInequality() {

        Coords a = new Coords(3, 7);
        Coords b = new Coords(3, 8);
        assertNotEquals(a, b);
    }

    @Test
    public void testCoordsHashCodeEquality() {

        Coords pt1 = new Coords(3, 7);
        Coords pt2 = new Coords(3, 7);

        Map<Coords,String> map = new HashMap<>();
        map.put(pt1, "x");

        assertTrue(map.containsKey(pt2));
    }

    @Test
    public void testCoordsHashCodeInequality() {

        Coords pt1 = new Coords(3, 7);
        Coords pt2 = new Coords(5, 8);

        Map<Coords,String> map = new HashMap<>();
        map.put(pt1, "x");

        assertFalse(map.containsKey(pt2));
    }

}
