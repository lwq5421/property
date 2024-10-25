package com.example.demo.service;

import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Room;

public interface RoomService {


    PageResult<Room> PageOfRoom(Integer current, Integer size, String room_code);
}
