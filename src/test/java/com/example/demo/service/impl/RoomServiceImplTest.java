package com.example.demo.service.impl;

import com.example.demo.pojo.Floor;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Room;
import com.example.demo.service.FloorService;
import com.example.demo.service.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

@RunWith(SpringRunner.class)
class RoomServiceImplTest {
    @Autowired
    RoomService roomService;

    @Test
    void pageOfRoom() {
        PageResult<Room> result=roomService.PageOfRoom(1,36,"");
        assertEquals(new Long(36), result.getTotal());
        assertEquals(36,result.getList().size());
        assertEquals(1,result.getList().get(0).getRoom_id());


//        result = roomService.PageOfRoom(1, 36, "1-8-3");
//        assertEquals(new Long(36), result.getTotal());
//        assertEquals(1, result.getList().size());
//        assertEquals(new Integer(1), result.getList().get(23).getRoom_id());
    }
}