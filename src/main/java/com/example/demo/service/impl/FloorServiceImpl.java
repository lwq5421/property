package com.example.demo.service.impl;

import com.example.demo.mapper.BuildingMapper;
import com.example.demo.mapper.FloorMapper;
import com.example.demo.pojo.Floor;
import com.example.demo.pojo.PageResult;
import com.example.demo.service.FloorService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
      FloorMapper floorMapper;
    @Autowired
     BuildingMapper buildingMapper;
    @Override
    public PageResult<Floor> pageOfFloor(Integer current,
                                         Integer size, String number) {
        PageHelper.startPage(current, size);
        Page<Floor> floors = floorMapper.findAllFloor(number);
        floors.stream().forEach(floor ->
                floor.setBuilding_name(buildingMapper.queryById(floor.getBelong_building()))
        );
        return PageResult.restPage(floors);
    }
}
