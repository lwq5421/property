package com.example.demo.pojo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data

@ApiModel(value = "用户信息，包含管理员、物业人员和住户")
public class User extends LoginUser{
    @ApiModelProperty(value = "用户 id")
    private Integer userid;
    @ApiModelProperty(value = "用户性别")
    private Short gender;
    @ApiModelProperty(value = "用户年龄")
    private Short age;
    @ApiModelProperty(value = "用户状态")
    private Short user_status;
    @ApiModelProperty(value = "用户头像保存路径")

    private String user_avatar;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", gender=" + gender +
                ", age=" + age +
                ", user_status=" + user_status +
                ", user_roomid=" + user_roomid +

//                ", user_avatar=" + user_avatar +

                ", idcard='" + idcard + '\'' +
                '}';
    }
    @ApiModelProperty(value = "用户所属房屋id")
    private Short user_roomid;
    @ApiModelProperty(value = "身份证号")
    private String idcard;

    public static User toUser(LoginUser user){
        User u = new User();
        u.setAccount(user.getAccount());
        u.setToken(user.getToken());
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());
        u.setUser_type(user.getUser_type());

//        u.setUser_avatar(user.getUser_avatar());

        return u;
    }

    public ResUser toResLogin(){
        ResUser u = new ResUser();
        u.setAccount(this.getAccount());
        u.setUsername(this.getUsername());
        u.setUser_type(this.getUser_type());

//        u.setUser_avatar(this.getUser_avatar());

        u.setToken(UUID.randomUUID().toString());//生成唯一 token

        return u;
    }


    public void setUser_avatar(String fileName) {
    }
}