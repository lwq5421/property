package com.example.demo.service.impl;

import com.example.demo.pojo.Floor;
import com.example.demo.pojo.PageResult;
import com.example.demo.service.FloorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

@RunWith(SpringRunner.class)
class FloorServiceImplTest {
    @Autowired
    FloorService floorService;
    @Test
    void pageOfFloor() {
        PageResult<Floor> result=floorService.pageOfFloor(1,2,"");
        assertEquals(new Long(14), result.getTotal());
        assertEquals(2,result.getList().size());
        assertEquals(1,result.getList().get(0).getFloor_id());
       // 测试分页大小为0的情况：当分页大小为0时，应该返回一个空列表。
//        result = floorService.pageOfFloor(1, 0, "");
//        assertEquals(new Long(14), result.getTotal());
//        assertEquals(0, result.getList().size());

        System.out.println(floorService.pageOfFloor(1,5,""));
    }
    void pageOfFloorWithZeroSize() {
        PageResult<Floor> result = floorService.pageOfFloor(1, 0, "");
        assertEquals(new Long(14), result.getTotal());
        assertEquals(0, result.getList().size());
    }

}