package com.example.demo.service;

import com.example.demo.mapper.BuildingMapper;
import com.example.demo.pojo.Building;
import com.example.demo.pojo.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public interface BuildingService {


    public PageResult<Building> PageOfBuilding(Integer current,
                                               Integer size,String number);

}
