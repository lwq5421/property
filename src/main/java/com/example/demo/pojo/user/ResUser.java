package com.example.demo.pojo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用于返回前端作为登录验证的用户类")
public class ResUser{
    @ApiModelProperty("用户账号")
    private String account;
    @ApiModelProperty("用户 token")
    private String token;
    @ApiModelProperty("用户姓名")
    private String username;
    @ApiModelProperty(value = "用户类型")
    private Short user_type;

//    private String user_avatar;


}
