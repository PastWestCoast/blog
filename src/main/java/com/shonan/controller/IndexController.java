package com.shonan.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shonan.entity.Blog;
import com.shonan.entity.Type;
import com.shonan.service.BlogService;
import com.shonan.service.CommentService;
import com.shonan.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
  @Autowired
  private BlogService blogService;
  @Autowired
  private TypeService typeService;
  @Autowired
  private CommentService commentService;
  @GetMapping("/")
  public String index(Model model , @RequestParam(defaultValue="1", value="pageNum")Integer pageNum) {
    List<Type> typeListTop = typeService.typeListTop();
//    model.addAttribute("blogList", blogList); //所有文章
    /*model.addAttribute("topBlogList", topBlogList);           //热门文章
    model.addAttribute("topTypeList", typeListTop);*/
    model.addAttribute("new5BlogList", blogService.new5BlogList());
    model.addAttribute("toptypePageInfo", new PageInfo<Type>(typeListTop));
    List<Blog> topBlogList = blogService.topBlogList();
    model.addAttribute("topBlogList", topBlogList);
    model.addAttribute("topBlogPageInfo", new PageInfo<Blog>(topBlogList));             //这个是热门文章的展示
    PageHelper.startPage(pageNum, 10);
    List<Blog> blogList = blogService.getAllBlog();
    /*ArrayList<Blog> list = new ArrayList<>(blogList);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i).getType().toString());
    }*/
    model.addAttribute("blogPageInfo", new PageInfo<Blog>(blogList));   //这个是首页的展示
    model.addAttribute("typeCount", typeService.typeCount());
    model.addAttribute("blogCount", blogService.blogCount());
    model.addAttribute("viewCount", blogService.visitCount());
    return "index";
  }

  /*@PostMapping("/myBlogs")
  public PageInfo<Blog> myBlogs(@RequestParam("pageNum") String pageNum) {
    PageHelper.startPage(Integer.parseInt(pageNum), 7);
    List<Blog> blogList = blogService.getAllBlog();
    PageInfo<Blog>blogPageInfo = new PageInfo<>(blogList);
    return blogPageInfo;
  }*/

  /*这里是POST请求，会在下一页（GET）请求中出错*/
  @PostMapping("/search")
  public String search(Model model, @RequestParam String query, @RequestParam(defaultValue="1", value="pageNum")Integer pageNum) {
    PageHelper.startPage(pageNum, 2);
    List<Blog> searchedBlogs = blogService.getSearchedBlogs(query);
    PageInfo<Blog> searchedBlogInfo = new PageInfo<Blog>(searchedBlogs);
    model.addAttribute("searchedBlogInfo", searchedBlogInfo);
    return "search";
  }

  @GetMapping("/blog/{id}")
  public String blog(@PathVariable Long id, Model model, HttpServletRequest request, @RequestParam(value = "commentPage", required = false, defaultValue = "1") Integer commentPage) {
    model.addAttribute("blog", blogService.getAndConvertBlogById(id));
    request.setAttribute("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(id, commentPage));
    return "blog";
  }

  /*@GetMapping("/footer/hitBlog")
  public String hitBlogList(Model model) {
    List<Blog> top3List = blogService.top3Blogs();
    model.addAttribute("top3List", top3List);
    return "_fragments :: hitBlogList";
  }*/
}
