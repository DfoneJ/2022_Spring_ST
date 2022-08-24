//package com.github.davidmoten.geo;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class CoverageLongsTest {
//
//    long[] LongHashes = new long[] {30893887395L, 30893887396L};
//    long[] EmptyLongHashes = new long[] {};
//
//    @Test
//    public void CoverageLongsT1() throws Exception {
//        CoverageLongs longCoverage = new CoverageLongs(LongHashes, LongHashes.length, 5);
//        long[] res = longCoverage.getHashes();
//        String strHashes = "[" + String.valueOf(res[0])+", "+String.valueOf(res[1])+"], ";
//        strHashes += String.valueOf(longCoverage.getCount())+", "+String.valueOf(longCoverage.getRatio());
//        assertEquals("[30893887395, 30893887396], 2, 5.0", strHashes);
//    }
//
//    @Test(expected = ArrayIndexOutOfBoundsException.class)
//    public void CoverageLongsT2() throws Exception {
//        CoverageLongs longCoverage = new CoverageLongs(LongHashes, 3, -5);
//        long[] res = longCoverage.getHashes();
//    }
//
//    @Test(expected = ArrayIndexOutOfBoundsException.class)
//    public void CoverageLongsT3() throws Exception {
//        CoverageLongs longCoverage = new CoverageLongs(EmptyLongHashes, 2, 0);
//        long[] res = longCoverage.getHashes();
//    }
//
//}