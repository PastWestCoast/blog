package com.shonan;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class BlogApplicationTests {
/*
  @Autowired
  private BlogService blogService;

  @Test
  @Cacheable("blog")
  public void getBlogById() {
    System.out.println("查询数据库");
    blogService.getBlogById((long) 14);
  }*/
}
