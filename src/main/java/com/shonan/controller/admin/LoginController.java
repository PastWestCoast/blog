package com.shonan.controller.admin;

import com.shonan.entity.User;
import com.shonan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

  @Autowired
  private UserService userService;

  @GetMapping()     //访问admin跳转到loinPage
  public String loginPage() {
    return "admin/login";
  }

  /*@PostMapping("/login")
  public String login(@RequestParam String username,
                      @RequestParam String password,
                      HttpSession httpSession,
                      RedirectAttributes redirectAttributes) {
    User user = userService.checkUser(username, password);
    if(username.equals(user.getUserName()) && password.equals(user.getPassword()) ) {
      user.setPassword(null);   //避免传递密码
      httpSession.setAttribute("user", user);   //如果session有user对象，则证明登录过了
      return "admin/index";
    } else {
      //return "admin/login"; 不要这样写，再次登录会出问题
      redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
      //此处不能用 model 来存数据！因为是重定向
      return "redirect:/admin";   //nameOrPassword错误，返回登录页面
    }
  }*/

  @PostMapping("/login")
  public String login(@RequestParam String username,
                      @RequestParam String password,
                      @RequestParam("verifyCode") String verifyCode,
                      HttpSession httpSession,
                      RedirectAttributes redirectAttributes) {
    if(StringUtils.isEmpty(verifyCode)) {
      httpSession.setAttribute("errorMsg", "验证码不能为空");
      return "admin/login";
    }
    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
      httpSession.setAttribute("errorMsg", "用户名或密码不能为空");
      return "admin/login";
    }
    String kaptchaCode = httpSession.getAttribute("verifyCode") + "";
    if(StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
      httpSession.setAttribute("errorMsg", "验证码错误");
      return "admin/login";
    }
    User user = userService.checkUser(username, password);
      if(user == null) {
        httpSession.setAttribute("message", "用户名或密码错误");
        return "admin/login";
      }
      if(username.equals(user.getUserName()) && password.equals(user.getPassword()) ) {
        user.setPassword(null);   //避免传递密码
        httpSession.setAttribute("user", user);   //如果session有user对象，则证明登录过了
        return "redirect:/admin/index";
      } else {
        //return "admin/login"; 不要这样写，再次登录会出问题
        redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
        //此处不能用 model 来存数据！因为是重定向
        return "redirect:/admin";   //nameOrPassword错误，返回登录页面
      }
  }

  @GetMapping("/login")
  public String login(){
    return "admin/login";
  }
  @GetMapping("/logout")
  public String logout(HttpSession httpSession) {
    //注销后把session的内容清空
    httpSession.removeAttribute("user");
    httpSession.removeAttribute("message");
    httpSession.removeAttribute("errorMsg");
//    return "redirect:/admin";
    return "admin/login";
  }

  @GetMapping("/index")
  public String index(){
    return "admin/index";
  }
}
