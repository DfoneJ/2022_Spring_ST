//package com.github.davidmoten.geo;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class LatLongTest {
//
//    LatLong latlon = new LatLong(25.0438604, 121.5339717);
//
//    @Test
//    public void getLat() {
//        assertEquals(25.0438604, latlon.getLat(), 0.01);
//    }
//
//    @Test
//    public void getLon() {
//        assertEquals(121.5339717, latlon.getLon(), 0.01);
//    }
//
//    @Test
//    public void add() {
//        LatLong chengedlatlon = latlon.add(10, 10);
//        assertEquals(35.0438604, chengedlatlon.getLat(), 0.01);
//        assertEquals(131.5339717, chengedlatlon.getLon(), 0.01);
//    }
//
//    @Test
//    public void testToString() {
//        assertEquals("LatLong [lat=25.0438604, lon=121.5339717]", latlon.toString());
//
//    }
//}