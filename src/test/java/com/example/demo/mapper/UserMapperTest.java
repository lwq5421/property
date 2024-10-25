package com.example.demo.mapper;

import com.example.demo.pojo.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.nio.file.Files.size;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void queryOnConditionTest(){
        User user = new User();
        user.setAccount("admin");
        user.setPassword("e10adc3949ba59abbe56e057f20f883e");
        System.out.println(userMapper.queryOnCondition(user));
        List<User> result=userMapper.queryOnCondition(user);

        assertEquals(1,result.size());
        assertEquals("admin",result.get(0).getAccount());
    }

    @Test
    public void findByTypeTest(){
        System.out.println(userMapper.findUsersByType("三",1));
    }
    @Test
    public void updateAvatarTest(){
        User user = new User();
        user.setUserid(1);
        user.setUser_avatar("img/123.jpg");
        System.out.println(userMapper.updateAvatar(user));
    }


//    @Test
//    public  void testMybatisTest(){
//     // 调用userMapper中的testMybatis方法，并打印返回结果
// System.out.println(userMapper.testMybatis());
//    }
}
