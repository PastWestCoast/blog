package com.shonan.controller;

import com.shonan.service.ArchiveService;
import com.shonan.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*归档展示*/
@Controller
public class ArchiveShowController {
  @Autowired
  private BlogService blogService;
  @Autowired
  private ArchiveService archiveService;

  @GetMapping("/archives2")
  public String archives(Model model){/*, @RequestParam(defaultValue = "1", value = "pageNum")Integer pageNum*/
//    PageHelper.startPage(pageNum, 5);
    model.addAttribute("archiveMap", blogService.archiveBlog());
    model.addAttribute("blogCount", blogService.blogCount());
    return "timeline";
  }

  /*@RequestMapping("/archives/{id}")
  public String archivesById(@PathVariable Long id, Model model, @RequestParam(defaultValue = "1", value = "pageNum")Integer pageNum){
    List<String> archivesList = archiveService.findArchiveNameAndArticleNum();
    if(id == -1) {

    }
    PageHelper.startPage(pageNum, 5);
    model.addAttribute("dateList", blogService);
    model.addAttribute("archiveMap", blogService.archiveBlog());
    model.addAttribute("blogCount", blogService.blogCount());
    return "archives";
  }*/

  /*@RequestMapping("/types/{id}")
  public String types(@PathVariable Long id, Model model,
                      @RequestParam(defaultValue = "1", value = "pageNum")Integer pageNum) {
    List<Type> types = typeService.getAllType();
    if(id == -1) {
      id = types.get(0).getId();
    }
    List<Blog> blogList = blogService.getBlogByTypeId(id);   //对应page

    model.addAttribute("blogList", blogList); *//*全部博客*//*
    model.addAttribute("types", types);     *//*全部分类*//*
    model.addAttribute("activeTypeId", id); *//*分类被点击的状态*//*
    PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
    PageHelper.startPage(pageNum, 5);
    model.addAttribute("blogPageInfo", pageInfo); *//*分类对应的分页队形*//*
    return "types";
  }*/
}
