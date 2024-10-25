package com.example.demo.mapper;

import com.example.demo.pojo.user.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //    public int testMybatis();
    @Select("<script>" +
            "select * from user\n" +
            "<where>\n" +
            "<if test=\"userid != null\">\n" +
            "and userid = #{userid}\n" +
            "</if>\n" +
            "<if test=\"account != null and account != ''\">\n" +
            "and account = #{account}\n" +
            "</if>\n" +
            "<if test=\"idcard != null and idcard != ''\">\n" +
            "and idcard = #{idcard}\n" +
            "</if>\n" +
            "<if test=\"password != null and password != ''\">\n" +
            "and password = #{password}\n" +
            "</if>\n" +
            "<if test=\"username != null and username != ''\">\n" +
            "and username = #{username}\n" +
            "</if>\n" +
            "<if test=\"gender != null\">\n" +
            "and gender = #{gender}\n" +
            "</if>\n" +
            "<if test=\"age != null\">\n" +
            "and age = #{age}\n" +
            "</if>\n" +
            "<if test=\"user_type != null\">\n" +
            "and user_type = #{user_type}\n" +
            "</if>\n" +
            "<if test=\"user_status != null\">\n" +
            "and user_status = #{user_status}\n" +
            "</if>\n" +
            "<if test=\"user_roomid != null\">\n" +
            "and user_roomid = #{user_roomid}\n" +
            "</if>\n" +
            "</where>" +
            "</script>")
    List<User> queryOnCondition(User user);


//    Page<User> findUsersByType(@Param("condition")String condition, @Param("user_type")Integer user_type);
//    User selectById(Integer id);

    @Select("<script>select userid,username,account,idcard,gender,age,user_type,user_status,user_roomid" +
            " from user where user_type = #{user_type} <if test='condition != null and condition !=\"\"'>" +
            "and (username like concat('%',#{condition},'%') " +
            "or idcard like concat('%',#{condition},'%'))</if></script>")
    Page<User> findUsersByType(@Param("condition")String condition, @Param("user_type")Integer user_type);

    @Select("select userid,username,account,idcard,gender,age,user_type,user_status,user_roomid " +
            "from user where userid = #{id}")
    User selectById(Integer id);


    @Update("update user set user_avatar = #{user_avatar} where userid = #{userid}")
    Integer updateAvatar(User user);

//    @Update("update set user_avatar = #{user_avatar} where userid = #{userid}")
//            Integer updateAvatar(User user);
}




