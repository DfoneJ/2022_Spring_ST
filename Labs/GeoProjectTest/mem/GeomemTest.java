package com.github.davidmoten.geo.mem;

import com.google.common.base.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GeomemTest {

    Geomem<String, String> mem;
    Info<String, String> info;
    double LAT = 25.04;
    double LON = 121.53;
    long timestamp = 1647265758L;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
//  ========================================== TESTS ARE BELOW THIS LINE ==========================================

    @Test
    public void addByInfo() {
        mem = new Geomem();
        info = new Info(LAT, LON, timestamp, "SID", Optional.of("8087"));
        mem.add(info);
        Iterable<Info<String, String>> findInfo = mem.find(26, 121, 25, 122, 1647265750L, 1647265760L);
//        assertEquals("[Info [lat=25.04, lon=121.53, time=1647265758, value=SID, id=Optional.of(8087)]]", findInfo.toString());
        assertEquals(info, findInfo.iterator().next());
    }

    @Test
    public void find() {
        mem = new Geomem();
        info = new Info(LAT, LON, timestamp, "SID", Optional.of("8087"));
        mem.add(info);
        Iterable<Info<String, String>> findInfo = mem.find(26, 121, 25, 122, 1647265750L, 1647265760L);
        assertEquals(info, findInfo.iterator().next());
    }
}