package com.example.demo.pojo.user;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 public class LoginUserTest {
    @Test
    public void testLogin(){
        List<LoginUser> list = Arrays.asList(new LoginUser(),new User());
        list.get(0).setUsername("resUser");
        list.get(1).setPassword("e10adc3949ba59abbe56e057f20f883e");
        System.out.println(list);
    }


    @Test
    void testToString() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }
}