package com.shonan.mapper;

import com.shonan.entity.Blog;
import com.shonan.entity.Condition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BlogMapper {
  //@Insert("Insert into t_blog set title=#{title}")
  public int addNewBlog(Blog blog);          //新增博客

  @Update("update t_blog set title=#{blog.title} where id=#{id}")
  public int updateBlog(Long id, Blog blog); //修改博客

  @Delete("delete from t_blog where id = #{id}")
  public int deleteBlogById(Long id);  //删除博客

  //@Select("select * from t_blog")
  public List<Blog> blogList();

  public List<Blog> topBlogList();

  @Select("Select * from t_blog where id=#{id}")
  public Blog getBlogById(Long id);

  @Select("select Count(*) from t_blog")
  public Long countBlog();             //博客总数

  public int viewCountIncrement(Long blogId);

  public List<Blog> searchOn(Condition condition);

  public List<Blog> search(String query);

  public List<Blog> getBlogByTypeId(Long typeId);

  public Blog getAndConvertBlogById(Long id);

  public List<String> getDates();

  /*String：日期，List：对应的blog集合*/
   List<Blog> archiveBlog(String year);

   List<Blog> top3Blogs();

   //点赞计数器
   //@Update("update t_blog set likes=likes+1 where id=#{blogId}")
   int likesCnt(int blogId);

   @Select("select sum(viewCount) from t_blog")
   Long visitCount();

   List<Blog> new5BlogList();

}
