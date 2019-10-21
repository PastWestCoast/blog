package com.shonan.service;

import com.shonan.entity.Blog;
import com.shonan.entity.Condition;
import com.shonan.exception.NotFoundException;
import com.shonan.mapper.BlogMapper;
import com.shonan.util.MarkdownUtils;
import com.shonan.util.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.shonan.component.StringAndArray;
//import com.shonan.mapper.ArchiveMapper;
/*import net.sf.json.JSONArray;
import net.sf.json.JSONObject;*/

@Service
@EnableCaching
public class BlogServiceImpl implements BlogService {
  @Autowired
  private BlogMapper blogMapper;
  /*@Autowired
  BlogService blogService;*/
//  @Autowired
//  ArchiveService archiveService;

  //------------------------------------------------------------------------------------

  //前端其实是通过传递一个id来确定的博客，而不是直接通过名字！
  @Override
//  @Cacheable(value = "myBlogCache")
  public Blog getBlogById(Long id) {
//    System.out.println("查询数据库");
    return blogMapper.getBlogById(id);
  }

  @Override
  @Transactional
  public int addNewBlog(Blog blog) {
    if(blog.getId() == null) {
      blog.setCreatedTime(new Date());
      blog.setViewCount(0);
    }else {
      //blog.setViewCount(blog.getViewCount() + 1);
      blog.setUpdatedTime(new Date());
    }
    return blogMapper.addNewBlog(blog);
  }

  @Override
  @Transactional
//  @CachePut(value = "myBlogCache", key = "#id")/*指定更新博客后的对象的key*/
  public int updateBlog(Long id, Blog blog) {
    Blog blog1 = blogMapper.getBlogById(id);
    if(blog1 == null) {
      throw  new NotFoundException("该博客没有出现在你的博客星球，快去书写吧！");
    }
    //此处做出优化（修改）
    BeanUtils.copyProperties(blog, blog1, MyBeanUtils.getNullPropertyNames(blog));
    blog.setUpdatedTime(new Date());
    return blogMapper.updateBlog(id, blog1);
  }

  @Override
  @Transactional
//  @CacheEvict(value = "myBlogCache", key = "#id") /*删除缓存中key为#id的blog对象*/
  public void deleteBlog(Long id) {
    blogMapper.deleteBlogById(id);
  }

  public List<Blog> getAllBlog() {
    return blogMapper.blogList();
  }

  @Override
  public List<Blog> getBlogOn(Condition condition) {
    return blogMapper.searchOn(condition);
  }

  @Override
//  @Cacheable(value = "myBlogCache")
  public List<Blog> topBlogList() {
    return blogMapper.topBlogList();
  }

  @Override
  public List<Blog> getBlogByTypeId(Long typeId) {
    return blogMapper.getBlogByTypeId(typeId);
  }

  @Override
  public List<Blog> getSearchedBlogs(String query) {
    return blogMapper.search(query);
  }

  @Override
  public Blog getAndConvertBlogById(Long id) {
    Blog blog = blogMapper.getAndConvertBlogById(id);
    if(blog == null) {
      throw new NotFoundException("该博客尚未发布，作者很快写完！");
    }
    viewCountIncrement(blog.getId());
    blog.setViewCount(blog.getViewCount()+1);
    Blog b = new Blog();
    BeanUtils.copyProperties(blog, b);
    String content = b.getContent();
    b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
    b.setViewCount(blog.getViewCount());
    return b;
  }

  @Override
  public Long blogCount() {
    return blogMapper.countBlog();
  }

  @Override
  public List<Blog> top3Blogs() {
    return blogMapper.top3Blogs();
  }

  @Override
  public int likesCnt(int blogId) {
    return blogMapper.likesCnt(blogId);
  }

  @Override
  @Transactional
  public int viewCountIncrement(Long blogId) {
    return blogMapper.viewCountIncrement(blogId);
  }

  @Override
  public Long visitCount() {
    return blogMapper.visitCount();
  }

  @Override
  public List<Blog> new5BlogList() {
    return blogMapper.new5BlogList();
  }

//  /*归档操作*/
  @Override
  public Map<String, List<Blog>> archiveBlog() {
    List<String> dates = blogMapper.getDates();
    HashMap<String, List<Blog>> map = new HashMap<>();
    for (String date : dates) {
      map.put(date, blogMapper.archiveBlog(date));
    }
    return map;
  }

  @Override
  public List<String> getDates() {
    return blogMapper.getDates();
  }


}
