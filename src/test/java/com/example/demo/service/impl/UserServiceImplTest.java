package com.example.demo.service.impl;

import com.example.demo.pojo.user.LoginUser;
import com.example.demo.pojo.user.ResUser;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void pageOfUserTest(){
        //测试分页
        System.out.println(userService.pageOfUser(1,1,null,1));
        //测试姓名的模糊查询
        System.out.println(userService.pageOfUser(1,5,"四",1));
        //测试用户分类的查询
        System.out.println(userService.pageOfUser(1,5,null,2));
        //测试身份证的模糊查询
        System.out.println(userService.pageOfUser(1,5,"2",1));
    }

    @Test
    void login() {
        LoginUser u = new LoginUser();
        u.setAccount("admin");
        u.setPassword("e10adc3949ba59abbe56e057f20f883e");

// 1
        ResUser resultUser = userService.login(u);
        assertNotNull(resultUser);
        //查到用户 login()方法没查到会返回null
        assertEquals("admin", resultUser.getAccount());


//2测试用户不存在
        u.setAccount("no-exist");
        u.setPassword("e10adc3949ba59abbe56e057f20f883e");
        resultUser=userService.login(u);
        assertNull(resultUser);//查到用户 login（）没查到用户返回null
//3
        u.setAccount("admin");
        u.setPassword("11111111111");
        resultUser=userService.login(u);
        assertNull(resultUser);//查到用户 login（）没查到用户返回null

    }
}