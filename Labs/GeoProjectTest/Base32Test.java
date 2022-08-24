package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Base32Test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
// ================= Lab1 ==========================
//    @Test
//    public void encodeBase32T1() throws Exception {
//        String encode = Base32.encodeBase32(-32769, 7);
//        assertEquals("-0001001", encode);
//    }
//
//    @Test
//    public void encodeBase32T2() throws Exception {
//        String encode = Base32.encodeBase32(-1252921504606846975L, -2);
//        assertEquals("-12su5g1fsmzzz", encode);
//    }
//
//    @Test
//    public void decodeBase32T1() throws Exception {
//        long hash = Base32.decodeBase32("");
//        assertEquals(0, hash);
//    }
//
//    @Test
//    public void decodeBase32T2() throws Exception {
//        long hash = Base32.decodeBase32("-12su5g1fsmzzz");
//        assertEquals(-1252921504606846975L, hash);
//    }
//
//    @Test
//    public void getValidCharIndex() throws Exception {
//        int idx = Base32.getCharIndex('z');
//        assertEquals(31, idx);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void getInvalidCharIndex() throws Exception {
//        int idx = Base32.getCharIndex('o');
//    }
    // ================= Lab3 ==========================
    @Test
    public void encodeBase32T1() throws Exception {
        String encode = Base32.encodeBase32(-30, 5);
        assertEquals("-0000y", encode);
    }

    @Test
    public void encodeBase32T2() throws Exception {
        String encode = Base32.encodeBase32(30, 5);
        assertEquals("0000y", encode);
    }

    @Test
    public void encodeBase32T3() throws Exception {
        String encode = Base32.encodeBase32(-60, 5);
        assertEquals("-0001w", encode);
    }

    @Test
    public void encodeBase32T4() throws Exception {
        String encode = Base32.encodeBase32(60, 5);
        assertEquals("0001w", encode);
    }

    @Test
    public void decodeBase32T1() throws Exception {
        long hash = Base32.decodeBase32("");
        assertEquals(0, hash);
    }

    @Test
    public void decodeBase32T2() throws Exception {
        long hash = Base32.decodeBase32("0001001");
        assertEquals(32769, hash);
    }

    @Test
    public void decodeBase32T3() throws Exception {
        long hash = Base32.decodeBase32("-0001001");
        assertEquals(-32769, hash);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decodeBase32T4() throws Exception {
        long hash = Base32.decodeBase32("a");
    }

    @Test
    public void padLeftWithZerosToLengthT1() throws Exception {
        String hash = Base32.padLeftWithZerosToLength("wsqqm", 5);
        assertEquals("wsqqm", hash);
    }

    @Test
    public void padLeftWithZerosToLengthT2() throws Exception {
        String hash = Base32.padLeftWithZerosToLength("wsqqm", 7);
        assertEquals("00wsqqm", hash);
    }
}