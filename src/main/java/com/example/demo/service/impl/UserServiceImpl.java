package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.user.LoginUser;
import com.example.demo.pojo.user.ResUser;
import com.example.demo.pojo.user.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override //根据账号和密码进行登录操作，只需账号和密码返回个人信息和token字符串
    public ResUser login(LoginUser user){
        List<User> users = userMapper.queryOnCondition(User.toUser(user));
        return users.size() == 1 ? users.get(0).toResLogin() : null;
    }

    @Override //1返回用户分页数据
    public PageResult<User> pageOfUser(Integer current,Integer
            size,String condition,Integer user_type){
        PageHelper.startPage(current,size);
        // 返回ArrayList子类Page
        Page<User> users =
                userMapper.findUsersByType(condition,user_type);
        //PageInfo<User> pageInfo = new PageInfo<User>(users);
        //System.out.println("pageInfo------
//        "+String.valueOf(pageInfo));
        return PageResult.restPage(users);
    }

    @Override
    public User searchById(int id) {//2根据 id 查找单个用户
        return userMapper.selectById(id);
    }

//    @Override
//    public Integer updateAvatar(User user) {
//        return null;
//    }

    @Override
    public Integer updateAvatar(User user) {//上传图片
        return userMapper.updateAvatar(user);
    }


}
