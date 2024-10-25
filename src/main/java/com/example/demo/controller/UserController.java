package com.example.demo.controller;

import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.ResponsePojo;
import com.example.demo.pojo.user.LoginUser;
import com.example.demo.pojo.user.ResUser;
import com.example.demo.pojo.user.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Api(tags = "用户相关api")
@RestController

public class UserController{
    @Autowired
    UserService userService;
    //33333333333
    @ApiOperation(value = "根据账号和密码进行登录操作，只需账号和密码返回个人信息和token字符串",
            notes = "<span style='color:red'>模拟操作，密码为明文密码 </span>",
            produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", type = "String", required = true),
            @ApiImplicitParam(name = "password", type = "String", required = true)
    })
    @ApiParam
    @PostMapping("/admin/login")
    public ResponsePojo<ResUser> login(@ApiIgnore LoginUser user) {
        user.setUser_type((short) 1);
        ResUser result = userService.login(user);
        if (Optional.ofNullable(result).isPresent()) {
            return ResponsePojo.success(result);
        } else {
            return ResponsePojo.fail(null, "验证失败");
        }
    }

//    、11111111111
    @GetMapping("Page/user")
    @ApiOperation(value = "返回用户分页数据")
    @ApiParam
    @ApiImplicitParams({
            @ApiImplicitParam(name="current",value ="当前页面",dataType = "Integer",paramType = "query",defaultValue = "1"),
            @ApiImplicitParam(name="size",value = "页面行数",dataType = "Integer",paramType = "query",defaultValue = "10"),
            @ApiImplicitParam(name="condition",value = "姓名或身份证的查询关键字员； ",dataType = "String" ,paramType = "query"),
            @ApiImplicitParam(name="user_type",value = "用户类型(1、管理 2、物业；3、业主；)",dataType = "Integer",required = true)
    })
    public ResponsePojo<PageResult<User>> getPage(
            @RequestParam(defaultValue = "1") Integer current,
            String condition,@RequestParam(defaultValue = "10")
            Integer size,
            @RequestParam(required = true) Integer user_type){
        PageResult<User> users =
                userService.pageOfUser(current,size,condition,user_type);
        ResponsePojo<PageResult<User>> res =
                ResponsePojo.success(users);
        return res;
    }

//222222222222222222
    @GetMapping("/admin/byid")
    @ApiOperation( value="根据 id 查找单个用户",
            notes="<span style='color:red'>根据用户id查询用户信息 </span>",
            response = User.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({ //非实体类参数
            @ApiImplicitParam(name="id",value ="用户 id",dataType = "int",paramType = "query")
    })
    @ApiParam
    //实体类参数
    public ResponsePojo<User> queryById(@RequestParam(required = true) Integer id){
        User u = userService.searchById(id);
        return ResponsePojo.success(u);
    }

    //44444444444444444444444

    @PostMapping("/updateAvatar")
    @ApiOperation( value="上传图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name="multipartFile",value ="上传的文件",dataType = "_file",
                    dataTypeClass = MultipartFile.class,required = true)
    })
    public ResponsePojo<Map<String,String>> updateAvatar(
           // @RequestParam 或 @RequestPart 注解来指定参数名
            @RequestPart MultipartFile multipartFile,
            //MultipartFile 是 Spring 框架中的一个接口，
            // 用于处理 HTTP 请求中的文件上传。它提供了一些方法，用于获取上传文件的元数据（如文件名、文件大小等）和文件内容。
            @RequestParam("id") Integer id, HttpServletRequest req){
        //获取全局对象
        ServletContext app = req.getServletContext();
        //声明返回值
        //这行代码创建了一个 map 对象，用于存储返回给客户端的信息。
        Map<String,String> map = new HashMap<String,String>();
        //获取文件名，不同浏览器可能获得完整路径
        String fileName = multipartFile.getOriginalFilename();
        fileName = fileName.split("\\\\")[0]; //行代码处理了文件名，确保文件名不包含路径信息。

        //String path = app.getRealPath("/static/");//获得服务器文件夹的

        String path = "D:\\shangyeclass\\xiangmu\\demo\\target\\classes\\static\\"; //
        String sufName = fileName.substring(fileName.lastIndexOf('.')+1);//这行代码获取了文件的后缀名。
        //判断后缀名
        if(!("png".equals(sufName) || "svg".equals(sufName) ||
                "gif".equals(sufName) || "jpg".equals(sufName))){
            map.put("message","不是图片文件");
            return ResponsePojo.fail(map,"后缀名不是常见图片格式");
        }
        if(multipartFile.getSize() > 500 * 1024){
            map.put("message","文件体积太大");
            return ResponsePojo.fail(map,"文件超过 500k");
        }
        //确保唯一性，将文件保存时将重命名
        //这段代码的作用是确保文件名的长度不超过 3 个字符。如果文件名的长度大于 3，则截取前 3 个字符；如果文件名的长度不大于 3，则保持文件名不变。
        fileName = fileName.length() > 3 ?fileName.substring(0,3) : fileName ;
        //这行代码为文件名添加了时间戳和随机数，确保文件名的唯一性。
        fileName = fileName + System.currentTimeMillis() + new Random().nextInt(1000) + "." + sufName;

        try {
            multipartFile.transferTo(new
                    File(path+"img"+File.separator,fileName));
        } catch (IOException e) {
            e.printStackTrace();
            map.put("message","IO 异常");
            return ResponsePojo.fail(map,e.getMessage());
        }
//根据路径保存到数据库
        User user = new User();
        user.setUserid(id);
        user.setUser_avatar(fileName);
        userService.updateAvatar(user);
        map.put("message","保存成功");
        return ResponsePojo.success(map);
        //处理路径，获得文件名
    }


}
