//package com.github.davidmoten.geo;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Iterator;
//import java.util.Set;
//import java.util.TreeSet;
//
//import static org.junit.Assert.*;
//
//public class CoverageTest {
//
//    Coverage coverage;
//    Coverage coverageWithLongs;
//    Set<String> hashes;
//
//    @Before
//    public void setUp() throws Exception {
//        hashes = new TreeSet<String>();
//        hashes.add("wsqqmx4");
//        hashes.add("wsqqmx3");
//        coverage = new Coverage(hashes,0.5);
//    }
//
//    @Test
//    public void constructWithGeohashSet() {
//        assertEquals("Coverage [hashes=[wsqqmx3, wsqqmx4], ratio=0.5]", coverage.toString());
//    }
//}