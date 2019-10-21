package com.shonan.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shonan.entity.Blog;
import com.shonan.entity.Condition;
import com.shonan.service.BlogService;
import com.shonan.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {
  private static final String LIST = "admin/blogs";
  private static final String INPUT = "admin/blogs-input";
  private static final String REDIRECT_LIST = "redirect:/admin/blogs";
  @Autowired
  private BlogService blogService;
  @Autowired
  private TypeService typeService;

  @GetMapping("/blogs")
  public String blogs(Model model, @RequestParam(defaultValue="1", value="pageNum")Integer pageNum) {
    PageHelper.startPage(pageNum, 2);
    List<Blog> blogList = blogService.getAllBlog();
    PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogList);
    model.addAttribute("blogPageInfo", pageInfo);
    model.addAttribute("types", typeService.getAllType());
    return LIST;
  }

  @PostMapping("/blogs/search")
  public String search(Model model, Condition condition) {
    PageHelper.startPage(1, 10);
    PageInfo<Blog>  pageInfo = new PageInfo<>(blogService.getBlogOn(condition));
    model.addAttribute("blogPageInfo", pageInfo);
    return "admin/blogs :: blogList";   //返回blogList（局部数据）
  }
  /*@PostMapping("/blogs/search")
  public String search(Model model, Condition condition) {
    String xialak = request.getAttribute("xialak").toString();
    String keyWord = request.getAttribute("keyWord").toString();
    String keyWord = condition.getKeyWord();
    String typeName = condition.getTypeName();
    PageHelper.startPage(1, 5);
    List<Blog> blogOn = blogService.getBlogOn(condition);
    PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogOn);
    model.addAttribute("blogPageInfo", pageInfo);
    return "redirect:/admin/blogs";
  }*/
  @GetMapping("/blogs/input")
  public String input(Model model) {
    model.addAttribute("blog", new Blog());
    loadType(model);
    return INPUT;
  }

  @PostMapping("/blogs")
  public String post(Blog blog, RedirectAttributes redirectAttributes) {
//    User user = (User) httpSession.getAttribute("user");
    int res;
    if(blog.getId() == null) {
      res = blogService.addNewBlog(blog);
    } else {
      res = blogService.updateBlog(blog.getId(), blog);
    }
    if(res > 0) {
      redirectAttributes.addFlashAttribute("message", "Successful operation !!!");
    }else {
      redirectAttributes.addFlashAttribute("message", "Failed operation !!!");
    }
    return REDIRECT_LIST;
  }

  @GetMapping("/blogs/{id}/input")    //此处不能是Post
  public String editInput(@PathVariable Long id, Model model) {
    model.addAttribute("blog", blogService.getBlogById(id));
    loadType(model);
    return INPUT;
  }

  @GetMapping("/blogs/{id}/delete")
  public String deleteBlogById(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    blogService.deleteBlog(id);
    redirectAttributes.addFlashAttribute("message", "删除成功");
    return REDIRECT_LIST;
  }

  private void loadType(Model model) {
    model.addAttribute("types", typeService.getAllType());
  }
}
