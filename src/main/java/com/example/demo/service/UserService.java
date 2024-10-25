package com.example.demo.service;

import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.user.LoginUser;
import com.example.demo.pojo.user.ResUser;
import com.example.demo.pojo.user.User;

public interface UserService {
    ResUser login(LoginUser user);//根据账号和密码进行登录操作，只需账号和密码返回个人信息和token字符串
    public PageResult<User> pageOfUser(Integer current, Integer
            size, String condition, Integer user_type);    //1返回用户分页数据

    User searchById(int id);//2根据 id 查找单个用户

    Integer updateAvatar(User user);//上传图片

}
