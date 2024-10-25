package com.example.demo.pojo.user;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReUserTest {
    @Test
    public void testUsers(){
        List<ResUser> list = Arrays.asList(new ResUser(),new
                LoginUser(),new User());
        list.get(0).setUsername("resUser");
        list.get(1).setUsername("loginUser");
        list.get(2).setUsername("user");
        System.out.println(list);
    }


    @Test
    void getAccount() {
    }

    @Test
    void getToken() {
    }

    @Test
    void getUsername() {
    }

    @Test
    void getUser_type() {
    }

    @Test
    void setAccount() {
    }

    @Test
    void setToken() {
    }

    @Test
    void setUsername() {
    }

    @Test
    void setUser_type() {
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

    @Test
    void testToString() {
    }
}