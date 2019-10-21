package com.shonan.aspect;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
@Aspect     //切面类
@Component  //作为组件
public class LogAspect {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Pointcut("execution(* com.shonan.controller.*.*(..))")    //execution规定拦截哪些类
  public void log() { }

  @Before("log()")  //在log()之前执行，又因为log指定了controller又指定了在哪些类的方法执行之前执行！
  public void doBefore(JoinPoint joinPoint) {//一可以用于获取拦截方法名的对象
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    String url = request.getRequestURL().toString();
    String remoteAddr = request.getRemoteAddr();
    String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    RequestLog requestLog = new RequestLog(url, remoteAddr, methodName, args);
    logger.info("Request ：{}", requestLog);
    /*Request ：RequestLog{url='http://localhost:8080/1/he', ip='0:0:0:0:0:0:0:1',
      methodName='com.shonan.controller.IndexController.index', args=[1, he]}*/
  }

 /* @After("log()")
  public void doAfter() {
    logger.info("======doAfter====");
  }*/

 /* @AfterReturning(returning = "result", pointcut = "log()") //捕获拦截方法返回的内容
  public void doAfterReturn(Object result) {
    logger.info("Result : {}", result);
  }*/

  private class RequestLog {
    private String url;
    private String ip;
    private String methodName;
    private Object[] args;

    public RequestLog(String url, String ip, String methodName, Object[] args) {
      this.url = url;
      this.ip = ip;
      this.methodName = methodName;
      this.args = args;
    }

    @Override
    public String toString() {
      return "RequestLog{" +
              "url='" + url + '\'' +
              ", ip='" + ip + '\'' +
              ", methodName='" + methodName + '\'' +
              ", args=" + Arrays.toString(args) +
              '}';
    }
  }
}
