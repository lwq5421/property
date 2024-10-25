package com.example.demo.controller;

import com.example.demo.pojo.Building;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.ResponsePojo;
import com.example.demo.service.BuildingService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "楼栋相关接口")
@RestController
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

        @ApiOperation( value="查询楼栋分页信息",
            response = Building.class,
            responseContainer = "list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name="current", value="当前页数", defaultValue="1", dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="size", value="页面行数", dataType="Integer", paramType="query", defaultValue="10"),
            @ApiImplicitParam(name="number", value="楼栋编号", dataType="String", paramType="query")
    })

    @GetMapping("/page/building")
    public ResponsePojo<PageResult<Building>> pageOfBuilding(
            @RequestParam(defaultValue = "1") Integer current,
            String number,
            @RequestParam(defaultValue = "10") Integer size) {
        PageResult<Building> result = buildingService.PageOfBuilding(current, size,number);
        return ResponsePojo.success(result);
    }

}
