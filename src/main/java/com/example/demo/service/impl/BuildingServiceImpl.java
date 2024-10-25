package com.example.demo.service.impl;

import com.example.demo.mapper.BuildingMapper;
import com.example.demo.pojo.Building;
import com.example.demo.pojo.PageResult;
import com.example.demo.service.BuildingService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
     BuildingMapper buildingMapper;
    @Override
    public PageResult<Building> PageOfBuilding(Integer current,
                                               Integer size,String number) {
        PageHelper.startPage(current,size);
        // 返回ArrayList子类Page
        Page<Building> buildings =
                buildingMapper.findAllBuilding(number);
        return PageResult.restPage(buildings);
    }

}