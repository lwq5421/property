package com.example.demo.service.impl;

import com.example.demo.pojo.Building;
import com.example.demo.pojo.PageResult;
import com.example.demo.service.BuildingService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
  class BuildingServiceImplTest {
    @Autowired
    BuildingService buildingService;

    @Test
    public void pageOfBuilding() {

        PageResult<Building> result = buildingService.PageOfBuilding(1, 10, "xfjy01");
        assertEquals(new Long(2), result.getTotal());
        assertEquals(2, result.getList().size());
//       //预期排序
//        result = buildingService.PageOfBuilding(1, 10);
//        assertEquals(new Long(2), result.getTotal());
//        assertEquals(2, result.getList().size());
//        assertEquals(new Integer(1), result.getList().get(0).getBuilding_id());
//        assertEquals("xfjy01", result.getList().get(0).getBuilding_code());
//        assertEquals("幸福家园1号楼", result.getList().get(0).getBuilding_name());
//        //请求的页码小于1时返回第一页的数据。
//        result = buildingService.PageOfBuilding(0, 10);
//        assertEquals(new Long(2), result.getTotal());
//        assertEquals(0, result.getList().size());
//        assertEquals(new Integer(1), result.getList().get(0).getBuilding_id());


        result = buildingService.PageOfBuilding(1, 1, "xfjy01");
        assertEquals(new Long(2), result.getTotal());
        assertEquals(1, result.getList().size());
        assertEquals(new Integer(1), result.getList().get(0).getBuilding_id());
//        assertEquals("8", result.getList().get(3).getBuilding_floors());

        result = buildingService.PageOfBuilding(2, 1, "xfjy01");
        assertEquals(new Long(2), result.getTotal());
        assertEquals(1, result.getList().size());
        assertEquals(new Integer(2), result.getList().get(0).getBuilding_id());


//   void pageOfBuilding() {
//        System.out.println(buildingService.PageOfBuilding(1,10));
//
//        System.out.println(buildingService.PageOfBuilding(1,1));
//    }

    }
}