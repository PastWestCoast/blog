package com.shonan.service;

import com.shonan.entity.Blog;
import com.shonan.entity.Condition;
//import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface BlogService {

  //查询博客
  public Blog getBlogById(Long id);

  //新增博客
  public int addNewBlog(Blog blog);

  //修改博客(先查，后赋值)
  public int updateBlog(Long id, Blog blog);

  //删除博客
  public void deleteBlog(Long id);

  public List<Blog> getAllBlog();

  public List<Blog> getBlogOn(Condition condition);

  public List<Blog> topBlogList();

  public List<Blog> getSearchedBlogs(String query);

  public List<Blog> getBlogByTypeId(Long typeId);

  public Blog getAndConvertBlogById(Long id);

  public Map<String, List<Blog>> archiveBlog();

  public Long blogCount();

  public List<Blog> top3Blogs();

  public int likesCnt(int blogId);

  public int viewCountIncrement(Long blogId);

  public Long visitCount();

  public List<Blog> new5BlogList();

  List<String> getDates();
//  JSONObject findArchiveNameAndArticleNum();
//  JSONObject findArticleByArchive(String archive, int rows, int pageNum);
  /**
   * 计算该归档日期文章的数目
   * @param archive 归档日期
   * @return 该归档日期下文章的数目
   */
//  int countArticleArchiveByArchive(String archive);

}
