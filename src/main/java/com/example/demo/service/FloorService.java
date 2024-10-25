package com.example.demo.service;

import com.example.demo.pojo.Floor;
import com.example.demo.pojo.PageResult;

public interface FloorService {
    PageResult<Floor> pageOfFloor(Integer current, Integer
            size, String number);
}
