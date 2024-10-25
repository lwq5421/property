package com.example.demo.pojo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FloorTest {
    @Test
    public void testFloor(){
        Floor floor = new Floor();
        floor.setFloor_id(1);
        floor.setFloor_number(Short.parseShort("4"));
        System.out.println(floor);
    }
}
