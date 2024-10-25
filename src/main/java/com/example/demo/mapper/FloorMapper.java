package com.example.demo.mapper;

import com.example.demo.pojo.Floor;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorMapper {

    Page<Floor> findAllFloor(@Param("number") String number);
    @Select("select floor_id,belong_building,floor_number from floor where floor_id = #{id}")
    Floor queryById(Integer id);
}
