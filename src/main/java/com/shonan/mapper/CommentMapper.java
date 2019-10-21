package com.shonan.mapper;

import com.shonan.entity.BlogComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
  //按评论的创建时间排序(倒序)
  public List<BlogComment> findByBlogId(Long id);

  public BlogComment findOne(Long id);

  public Integer saveComment(BlogComment comment);
}
