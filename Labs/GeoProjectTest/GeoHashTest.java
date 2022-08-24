package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class GeoHashTest {

    Direction direction;
    Double LAT;
    Double LON;
    LatLong latlon;

    @Before
    public void setUp() throws Exception {
        LAT = 25.04386042;
        LON = 121.53397182;
        latlon = new LatLong(LAT, LON);
    }

    @After
    public void tearDown() throws Exception {
    }
//  ========================================== TESTS ARE BELOW THIS LINE ==========================================
/*
    @Test
    public void adjacentHash() {
        Direction direction = Direction.RIGHT;
        assertEquals("wsqqmx5", GeoHash.adjacentHash("wsqqmx4", direction));
    }

    @Test
    public void right() {
        String ToTheRight = GeoHash.right("wsqqmx4");
        assertEquals("wsqqmx5", ToTheRight);
    }

    @Test
    public void left() {
        String ToTheRight = GeoHash.left("wsqqmx4");
        assertEquals("wsqqmx1", ToTheRight);
    }

    @Test
    public void top() {
        String ToTheRight = GeoHash.top("wsqqmx4");
        assertEquals("wsqqmx6", ToTheRight);
    }

    @Test
    public void bottom() {
        String ToTheRight = GeoHash.bottom("wsqqmx4");
        assertEquals("wsqqmwf", ToTheRight);
    }

    @Test
    public void encodeHashWithLatAndLon() {
        String encode = GeoHash.encodeHash(LAT, LON);
        assertEquals("wsqqmx474ccw", encode);
    }

    @Test
    public void encodeHashWithLatAndLonAndLength() {
        String encode = GeoHash.encodeHash(LAT, LON, 10);
        assertEquals("wsqqmx474c", encode);
    }

    @Test
    public void encodeHashWithLatLon() {
        LatLong ll = new LatLong(25.040309, 121.572583);
        String encode = GeoHash.encodeHash(ll);
        assertEquals("wsqqqqqqqebj", encode);
    }

    @Test
    public void encodeHashWithLatLonAndLength() {
        String encode = GeoHash.encodeHash(latlon, 10);
        assertEquals("wsqqmx474c", encode);
    }

    @Test
    public void neighbours() {
        List<String> neighbors = GeoHash.neighbours("wsqqmx4");
        String allNeighbors = "[";
        for (String s : neighbors) {
            allNeighbors = allNeighbors + s + ", ";
        }
        allNeighbors += "]";
        assertEquals("[wsqqmx1, wsqqmx5, wsqqmx6, wsqqmwf, wsqqmx3, wsqqmwc, wsqqmx7, wsqqmwg, ]", allNeighbors);
    }

    @Test
    public void decodeHash() {
        LatLong latLong = GeoHash.decodeHash("wsqqmx474ccw");
        assertEquals(25.04386042, latLong.getLat(), 0.001);
        assertEquals(121.53397182, latLong.getLon(), 0.001);
    }

    @Test
    public void hashLengthToCoverBoundingBox() {
        int len = GeoHash.hashLengthToCoverBoundingBox(25.0516, 121.503, 25.0406, 121.525);
        // are of geohash "wsqq" can includes area of geohash : "wsqqsb", "wsqqmq"
        assertEquals(4, len);
    }

    @Test
    public void hashContains() {
        // area of geohash "wsqqmx4" can contains (25.04386042, 121.53397182), which geohash is "wsqqmx474ccw"
        assertTrue(GeoHash.hashContains("wsqqmx4", LAT, LON));
    }

    @Test
    public void coverBoundingBox() {
        Coverage coverage = GeoHash.coverBoundingBox(25.0516, 121.503, 25.0406, 121.536);
        // from "wsqqsb" to "wsqqmw" contains the total of 12 geohashes with the MAX LENGTH between them (which is 6)
        assertEquals(6, coverage.getHashLength());
        // I CANT UNDERSTAND HOW TO CALCULATE RATIO
    }

    @Test
    public void heightDegrees() {
        // Same length of geohashes will have same heightDegrees
        double WidthDegreeWithLen9 = GeoHash.heightDegrees(9);
        assertEquals(180.0/Math.pow(2,22), WidthDegreeWithLen9, 0.01f);
        double WidthDegreeWithLen10 = GeoHash.heightDegrees(10);
        assertEquals(180.0/Math.pow(2,25), WidthDegreeWithLen10, 0.01f);
        double WidthDegreeWithLen13 = GeoHash.heightDegrees(13);
        assertEquals(180.0/Math.pow(2,32), WidthDegreeWithLen13, 0.01f);
    }

    @Test
    public void widthDegrees() {
        // Same length of geohashes will have same widthDegrees
        double WidthDegree = GeoHash.widthDegrees(10);
        assertEquals(180.0/Math.pow(2,24), WidthDegree, 0.01f);
        double WidthDegreeWithLen13 = GeoHash.widthDegrees(13);
        assertEquals(180.0/Math.pow(2,32), WidthDegreeWithLen13, 0.01f);
    }

    @Test
    public void gridAsString() {
        Set<String> highlight = new TreeSet<String>();
        highlight.add("wsqq");
        String Grid = GeoHash.gridAsString("wsqq",1, highlight);
        assertEquals("wsqp wsqr wsqx \n" + "wsqn WSQQ wsqw \n" + "wsqj wsqm wsqt \n", Grid);

//        wsqp  wsqr  wsqx
//        wsqn  WSQQ wsqw
//        wsqj  wsqm  wsqt

    }

    @Test
    public void gridAsStringNoHighlight() {
        String Grid = GeoHash.gridAsString("wsqq",-1, -1, 1, 2);
        assertEquals("wsqp wsqr wsqx \n" + "wsqn wsqq wsqw \n" + "wsqj wsqm wsqt \n" + "wsqh wsqk wsqs \n", Grid);

//        wsqp  wsqr  wsqx
//        wsqn  wsqq  wsqw
//        wsqj  wsqm  wsqt
//        wsqh  wsqk  wsqs

    }

    @Test
    public void gridAsStringHighlightCorner() {
        Set<String> highlight = new TreeSet<String>();
        highlight.add("wsqp");
        highlight.add("wsqx");
        highlight.add("wsqh");
        highlight.add("wsqs");
        String Grid = GeoHash.gridAsString("wsqq",-1, -1, 1, 2, highlight);
        assertEquals("WSQP wsqr WSQX \n" + "wsqn wsqq wsqw \n" + "wsqj wsqm wsqt \n" + "WSQH wsqk WSQS \n", Grid);

//        WSQP  wsqr  WSQX
//        wsqn  wsqq  wsqw
//        wsqj  wsqm  wsqt
//        WSQH  wsqk  WSQS
    }

    @Test
    public void adjacentHashWithStep() {
        Direction direction = Direction.TOP;
        assertEquals("wsqqmxd", GeoHash.adjacentHash("wsqqmx4", direction, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromLongToString() {
        String stringHash;
        stringHash = GeoHash.fromLongToString(13089388739600L);
    }
*/
//  ========================================== LAL3 ==========================================

    @Test
    public void adjacentHashT1() {
        Direction direction = Direction.TOP;
        assertEquals("b", GeoHash.adjacentHash("u", direction));
    }

    @Test
    public void adjacentHashT2() {
        Direction direction = Direction.TOP;
        assertEquals("wsqqt", GeoHash.adjacentHash("wsqqm", direction));
    }

    @Test
    public void adjacentHashT3() {
        Direction direction = Direction.BOTTOM;
        assertEquals("zsqrmx1thhsz", GeoHash.adjacentHash("zsqrmx1thhub", direction));
    }

    @Test(expected = IllegalArgumentException.class)
    public void adjacentHashT4() {
        Direction direction = Direction.TOP;
        assertEquals("", GeoHash.adjacentHash("", direction));
    }

    @Test
    public void adjacentHashWithStepsT1() {
        Direction direction = Direction.TOP;
        assertEquals("wsqqj", GeoHash.adjacentHash("wsqqm", direction, -1));
    }

    @Test
    public void adjacentHashWithStepsT2() {
        Direction direction = Direction.TOP;
        assertEquals("st", GeoHash.adjacentHash("st", direction, 0));
    }

    @Test
    public void adjacentHashWithStepsT3() {
        Direction direction = Direction.TOP;
        assertEquals("wsqqt", GeoHash.adjacentHash("wsqqm", direction, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void adjacentHashWithStepsT4() {
        Direction direction = Direction.TOP;
        assertEquals("", GeoHash.adjacentHash("", direction, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromLongToStringT1() {
        String geohash = GeoHash.fromLongToString(13089388739600L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromLongToStringT2() {
        String geohash = GeoHash.fromLongToString(0);
    }

    @Test
    public void fromLongToStringT3() {
        assertEquals("000000000003", GeoHash.fromLongToString(60));
    }
}