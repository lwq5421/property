package com.example.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("房屋信息")
public class Room {
    @ApiModelProperty("房屋的唯一标识")
    private Integer room_id;
    @ApiModelProperty("房屋所属楼层的标识 id")
    private Integer room_floor_id;
    @ApiModelProperty("建筑面积")
    private Short built_up_area;
    @ApiModelProperty("房屋状态，1、自助; 2,出租; 3、未居住;4、未出售; 5、公共空间")
    private Short room_status;
    @ApiModelProperty("房务编号，1-3-2 表示 1 号楼 3层 2号 2号房")
    private String room_code;
    @ApiModelProperty("该房间所属楼栋")
    private String building_name;
    @ApiModelProperty("房屋所属楼层的标识 id")
    private Integer floor_number;

}
