package com.shonan.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shonan.entity.Blog;
import com.shonan.entity.Type;
import com.shonan.service.BlogService;
import com.shonan.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeShowController {

  @Autowired
  private TypeService typeService;
  @Autowired
  private BlogService blogService;
  //默认是-1（代表各个分类的id），当id为-1，默认选中第一个分类
  @RequestMapping("/types/{id}")
  public String types(@PathVariable Long id, Model model,
                      @RequestParam(defaultValue = "1", value = "pageNum")Integer pageNum) {
    List<Type> types = typeService.getAllType();
    if(id == -1) {
      id = types.get(0).getId();
    }
    List<Blog> blogList = blogService.getBlogByTypeId(id);   //对应page

    model.addAttribute("blogList", blogList); /*全部博客*/
    model.addAttribute("types", types);     /*全部分类*/
    model.addAttribute("activeTypeId", id); /*分类被点击的状态*/
    PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
    PageHelper.startPage(pageNum, 5);
    model.addAttribute("blogPageInfo", pageInfo); /*分类对应的分页队形*/
    return "types";
  }
}
