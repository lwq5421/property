package com.example.demo.interceptor;

import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginInterceptor  extends HandlerInterceptorAdapter {
@Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
    String token=request.getHeader("Authorization");
    if (Optional.ofNullable(token).isPresent()){
        return true;
    }else{
        response.sendError(403,"Authorization无信息，未登录");
        return  false;
    }
}
}
