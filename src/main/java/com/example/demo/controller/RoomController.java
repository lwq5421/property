package com.example.demo.controller;

import com.example.demo.pojo.*;
import com.example.demo.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "房屋相关接口")
@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;
    @ApiOperation( value="查询楼层分页信息",
            response =Room.class,
            responseContainer = "list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name="current",value = "当前页数",defaultValue = "1",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name="size",value = "页面行数",dataType = "Integer",paramType = "query",defaultValue = "10"),
            @ApiImplicitParam(name="room_code",value="楼层编号",dataType = "String",paramType = "query")
    })
    @GetMapping("/page/room")
    public ResponsePojo<PageResult<Room>> pageOfRoom(
            @RequestParam(defaultValue = "1") Integer current,
            String room_code,
            @RequestParam(defaultValue = "10") Integer size) {
        PageResult<Room> result = roomService.PageOfRoom(current, size,room_code);
        return ResponsePojo.success(result);
    }

}
