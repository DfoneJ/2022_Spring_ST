//package com.github.davidmoten.geo;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class DirectionTest {
//
//    Direction direction;
//
//    @Test
//    public void Leftopposite() {
//        direction = Direction.LEFT;
//        assertEquals(Direction.RIGHT, direction.opposite());
//    }
//
//    @Test
//    public void Rightopposite() {
//        direction = Direction.RIGHT;
//        assertEquals(Direction.LEFT, direction.opposite());
//    }
//
//    @Test
//    public void Topopposite() {
//        direction = Direction.TOP;
//        assertEquals(Direction.BOTTOM, direction.opposite());
//    }
//
//    @Test
//    public void BOTTOMopposite() {
//        direction = Direction.BOTTOM;
//        assertEquals(Direction.TOP, direction.opposite());
//    }
//}