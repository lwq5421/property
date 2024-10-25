package com.example.demo.mapper;

import com.example.demo.pojo.Building;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingMapper {
    Page<Building> findAllBuilding(@Param("number") String number);
    @Select("select building_name from building where building_id = #{id}")
    String queryById(Integer belong_building);
    @Select("select building_name from building where building_id = #{id}")
    String queryCode(String buildingCode);
//    @Select("select building_name from building where building_id = #{id}")
//     String queryCode(String room_code);
//        @Select("SELECT building_name FROM building WHERE building_code = #{buildingCode}")
//       String queryBuildingNameByBuildingCode(String buildingCode);



}
