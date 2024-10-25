package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class FloorMapperTest {
    @Autowired
    FloorMapper floorMapper;

    @Test
    public void testFindAllFloor() {
        System.out.println(floorMapper.findAllFloor("2"));
    }
}
