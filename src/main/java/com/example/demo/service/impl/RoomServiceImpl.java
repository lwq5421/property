package com.example.demo.service.impl;

import com.example.demo.mapper.BuildingMapper;
import com.example.demo.mapper.FloorMapper;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.pojo.Floor;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Room;
import com.example.demo.service.RoomService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    BuildingMapper buildingMapper;
    @Autowired
    FloorMapper floorMapper;

    @Override
    public PageResult<Room> PageOfRoom(Integer current, Integer size, String room_code) {
        try (Page<Room> rooms = PageHelper.startPage(current, size).doSelectPage(() -> roomMapper.findAllRoom(room_code))) {
            rooms.stream().forEach(room -> {
                String roomCode = room.getRoom_code();
                String buildingCode = roomCode.split("-")[0]; // 获取第一个数字作为楼栋编号
                String buildingName = buildingMapper.queryCode(buildingCode);
                room.setBuilding_name(buildingName);
                Floor floor = floorMapper.queryById(room.getRoom_floor_id());
                room.setFloor_number(floor.getFloor_number().intValue());
                room.setBuilding_name(buildingMapper.queryById(floor.getBelong_building()));
//                room.setBuilding_name(buildingMapper.queryById(floor.getBelong_building()));
            });
            return PageResult.restPage(rooms);
        }
    }
}
//    String roomCode = room.getRoom_code();
//    String buildingCode = roomCode.split("-")[0]; // 获取第一个数字作为楼栋编号
//    String buildingName = buildingMapper.queryCode(buildingCode);
//                room.setBuilding_name(buildingName);

//    Floor floor = floorMapper.queryById(room.getRoom_floor_id());
//                room.setFloor_number(floor.getFloor_number().intValue());
//                room.setBuilding_name(buildingMapper.queryById(floor.getBelong_building()));
//                room.setBuilding_name(buildingMapper.queryCode(room.getRoom_code()))