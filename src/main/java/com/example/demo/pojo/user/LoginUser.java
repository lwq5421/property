package com.example.demo.pojo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Data
@ApiModel("用于登录的用户类")
public class LoginUser extends ResUser{
    @ApiModelProperty("用户密码")
    private String password;
//    private String user_avatar;

    @Override
    public String toString() {
        return "LoginUser{" +
//                "user_avatar=" + user_avatar +

                ", password='" + password + '\'' +
                '}';
    }
    public void setPassword(String password) {
        if (password.length() != 32){
            //MD5 加密密码后查询数据库
            this.password =
                    DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        }else{
            this.password = password;
        }
    }


}


