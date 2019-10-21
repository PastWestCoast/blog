package com.shonan.controller;

import com.shonan.entity.BlogComment;
import com.shonan.entity.BlogLink;
import com.shonan.service.BlogService;
import com.shonan.service.CommentService;
import com.shonan.service.LinkService;
import com.shonan.util.MyBlogUtils;
import com.shonan.util.PatternUtil;
import com.shonan.util.Result;
import com.shonan.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class BlogController2 {
  @Autowired
  private BlogService blogService;
  @Autowired
  private LinkService linkService;
  @Autowired
  private CommentService commentService;

  @GetMapping({"/friendlylink"})
  public String link(HttpServletRequest request) {
    request.setAttribute("pageName", "友情链接");
    Map<Byte, List<BlogLink>> linkMap = linkService.getLinksForLinkPage();
    if (linkMap != null) {
      //判断友链类别并封装数据 0-友链 1-推荐 2-个人网站
      if (linkMap.containsKey((byte) 0)) {
        request.setAttribute("favoriteLinks", linkMap.get((byte) 0));
      }
      if (linkMap.containsKey((byte) 1)) {
        request.setAttribute("recommendLinks", linkMap.get((byte) 1));
      }
      if (linkMap.containsKey((byte) 2)) {
        request.setAttribute("personalLinks", linkMap.get((byte) 2));
      }
    }
//    request.setAttribute("configurations", configService.getAllConfigs());
    return "friendlylink";
  }
  /**评论操作*/
  @PostMapping("/blog/comment")
  @ResponseBody
  public Result comment(HttpServletRequest request, HttpSession session, Model model,
                        @RequestParam Long blogId, @RequestParam String verifyCode,
                        @RequestParam String commentator, @RequestParam String email,
                        @RequestParam String websiteUrl, @RequestParam String commentBody) {
    if (StringUtils.isEmpty(verifyCode)) {
      return ResultGenerator.genFailResult("验证码不能为空");
    }
    String kaptchaCode = session.getAttribute("verifyCode") + "";
    if (StringUtils.isEmpty(kaptchaCode)) {
      return ResultGenerator.genFailResult("非法请求");
    }
    if (!verifyCode.equals(kaptchaCode)) {
      return ResultGenerator.genFailResult("验证码错误");
    }
    String ref = request.getHeader("Referer");
    if (StringUtils.isEmpty(ref)) {
      return ResultGenerator.genFailResult("非法请求");
    }
    if (null == blogId || blogId < 0) {
      return ResultGenerator.genFailResult("非法请求");
    }
    if (StringUtils.isEmpty(commentator)) {
      return ResultGenerator.genFailResult("请输入称呼");
    }
    if (StringUtils.isEmpty(email)) {
      return ResultGenerator.genFailResult("请输入邮箱地址");
    }
    if (!PatternUtil.isEmail(email)) {
      return ResultGenerator.genFailResult("请输入正确的邮箱地址");
    }
    if (StringUtils.isEmpty(commentBody)) {
      return ResultGenerator.genFailResult("请输入评论内容");
    }
    if (commentBody.trim().length() > 200) {
      return ResultGenerator.genFailResult("评论内容过长");
    }
    BlogComment comment = new BlogComment();
    comment.setBlogId(blogId);
    comment.setCommentator(MyBlogUtils.cleanString(commentator));
    comment.setEmail(email);
    if (PatternUtil.isURL(websiteUrl)) {
      comment.setWebsiteUrl(websiteUrl);
    }
    comment.setCommentBody(MyBlogUtils.cleanString(commentBody));
    Result result = ResultGenerator.genSuccessResult(commentService.addComment(comment));
    return result;
  }

  /*@PostMapping("/blog/comment")
  @ResponseBody
  public String comment(HttpServletRequest request, HttpSession session,
                        @RequestParam Long blogId, @RequestParam String verifyCode,
                        @RequestParam String commentator, @RequestParam String email,
                        @RequestParam String websiteUrl, @RequestParam String commentBody) {
    if (StringUtils.isEmpty(verifyCode)) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("验证码不能为空"));
    }
    String kaptchaCode = session.getAttribute("verifyCode") + "";
    if (StringUtils.isEmpty(kaptchaCode)) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("非法请求"));
    }
    if (!verifyCode.equals(kaptchaCode)) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("验证码错误"));
    }
    String ref = request.getHeader("Referer");
    if (StringUtils.isEmpty(ref)) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("非法请求"));
    }
    if (null == blogId || blogId < 0) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("非法请求"));
    }
    if (StringUtils.isEmpty(commentator)) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("请输入称呼"));
    }
    if (StringUtils.isEmpty(email)) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("请输入邮箱地址"));
    }
    if (!PatternUtil.isEmail(email)) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("请输入正确的邮箱地址"));
    }
    if (StringUtils.isEmpty(commentBody)) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("请输入评论内容"));
    }
    if (commentBody.trim().length() > 200) {
      return JSONArray.toJSONString(ResultGenerator.genFailResult("评论内容过长"));
    }
    BlogComment comment = new BlogComment();
    comment.setBlogId(blogId);
    comment.setCommentator(MyBlogUtils.cleanString(commentator));
    comment.setEmail(email);
    if (PatternUtil.isURL(websiteUrl)) {
      comment.setWebsiteUrl(websiteUrl);
    }
    comment.setCommentBody(MyBlogUtils.cleanString(commentBody));
    Result result = ResultGenerator.genSuccessResult(commentService.addComment(comment));
    return JSONArray.toJSONString(result);
  }*/
}
