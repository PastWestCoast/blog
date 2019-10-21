package com.shonan.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //session是同一个浏览器共享，所以当
    if (request.getSession().getAttribute("user") == null) {
      //没登录，先去登录！
      response.sendRedirect("/admin");
      return false;
    }
    return true;
  }
}
