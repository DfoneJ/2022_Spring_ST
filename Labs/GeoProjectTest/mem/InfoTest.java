package com.github.davidmoten.geo.mem;

import com.github.davidmoten.geo.mem.Info;
import com.google.common.base.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InfoTest {

    Info<String, String> info;

    @Before
    public void setUp() throws Exception {
        info = new Info(25.0438604, 21.5339717, 1646110492, "value", Optional.of("1105980"));
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void id() throws Exception {
//        assertEquals("1105980", info.id().get());
//    }
//
//    @Test
//    public void lat() throws Exception {
//        assertEquals(25.0438604, info.lat(), 0.01);
//    }
//
//    @Test
//    public void lon() throws Exception {
//        assertEquals(21.5339717, info.lon(), 0.01);
//    }
//
//    @Test
//    public void time() throws Exception {
//        assertEquals(1646110492, info.time());
//    }
//
//    @Test
//    public void value() throws Exception {
//        assertEquals("value", info.value());
//    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Info [lat=25.0438604, lon=21.5339717, time=1646110492, value=value, id=Optional.of(1105980)]", info.toString());
    }
}