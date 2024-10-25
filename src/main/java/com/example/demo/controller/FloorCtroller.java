package com.example.demo.controller;

import com.example.demo.pojo.Floor;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.ResponsePojo;
import com.example.demo.service.FloorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "楼层相关接口")
@RestController
public class FloorCtroller {
    @Autowired
    private FloorService floorService;
    @GetMapping("/page/floor")
    @ApiOperation( value="查询楼层分页信息",
            response = Floor.class,
            responseContainer = "list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name="current",value = "当前页数",defaultValue = "1",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name="size",value = "页面行数",dataType = "Integer",paramType = "query",defaultValue = "10"),
            @ApiImplicitParam(name="number",value="房屋编号",dataType = "String",paramType = "query")
    })
    public ResponsePojo<PageResult<Floor>> pageOfFloor(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            String number){
        PageResult<Floor> floors =
                floorService.pageOfFloor(current,size,number);
        return ResponsePojo.success(floors);
            }
}

