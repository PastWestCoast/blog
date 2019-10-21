package com.shonan.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice //拦截标记有Controller注解类
public class ControllerExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  //request：获取访问的url
  @ExceptionHandler(Exception.class) //作为Controller异常时做出处理的Handler，exception级别的信息会被拦截
  public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
    ///记录异常信息 {}占位符
    logger.error("Request URL: {}", request.getRequestURL());
    System.out.println(e.getMessage());
    System.out.println(e);
    //因为该Handler会把Controller的所有异常捕获到，所以要区分哪些是自己处理的一次
    if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
      throw e;  //让SpringBoot处理
    }
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("url", request.getRequestURL());
    modelAndView.addObject("exception", e);
    modelAndView.setViewName("error/error");
    return modelAndView;
  }
}
