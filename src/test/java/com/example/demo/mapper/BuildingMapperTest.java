package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BuildingMapperTest {
    @Autowired
    BuildingMapper buildingMapper;

    @Test
    void findAllBuilding() {
        System.out.println(buildingMapper.findAllBuilding("xfjy01"));
    }
}