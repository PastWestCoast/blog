package com.shonan.controller;

import com.shonan.entity.Blog;
import com.shonan.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class textController {
  @Autowired
  BlogService blogService;

  @RequestMapping("/cache/{id}")
  Blog getBlogbyId(@PathVariable(name = "id")Long id){
    return blogService.getBlogById(id);
  }
}
