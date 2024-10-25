package com.example.demo.pojo;

import com.example.demo.service.BuildingService;
import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@ApiModel

public class ResponsePojo<T> {

    BuildingService buildingService;
    @ApiModelProperty(value = "响应的数据")
    private  T data;
    @ApiModelProperty("响应的说明信息")
    private String message;
    @ApiModelProperty("响应状态码,1:成功，2:失败")
    private int code;
    private ResponsePojo(T t) {
        this.data = t;
        this.code = 1;
        this.message = "";
    }
    public int getCode() {
        return this.code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    private ResponsePojo(T t, String message, int code){
        this.data = t;
        this.code = code;
        this.message = message;
    }
    public static <T>ResponsePojo<T> success(T t){
        return new ResponsePojo(t);
    }
    public static <T>ResponsePojo<T> fail(T t,String message){
        return new ResponsePojo(t,message,2);
    }


}
