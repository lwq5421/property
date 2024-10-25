package com.example.demo.mapper;

import com.example.demo.pojo.Building;
import com.example.demo.pojo.Room;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
    Page<Room> findAllRoom(@Param("RoomCode") String room_code);
}
