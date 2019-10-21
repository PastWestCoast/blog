package com.shonan.service;

import com.shonan.entity.BlogComment;
import com.shonan.util.PageQueryUtil;
import com.shonan.util.PageResult;

public interface CommentService {

//  public List<BlogComment> listCommentByBlogId(Long id);

//  public Integer saveComment(BlogComment comment);
  public int getTotalComments();

  public Boolean addComment(BlogComment blogComment);

  /**
   * 后台管理系统中评论分页功能
   */
  public PageResult getCommentsPage(PageQueryUtil pageUtil);
  /**
   * 批量审核
   * @param ids
   */
  public Boolean checkDone(Integer[] ids);
  /**
   * 批量删除
   * @param ids
   */
  public Boolean deleteBatch(Integer[] ids);

  /**
   * 添加回复
   * @param commentId
   * @param replyBody
   * @return
   */
  public Boolean reply(Long commentId, String replyBody);

  /**
   * 根据文章id和分页参数获取文章的评论列表
   * @param blogId
   * @param page
   */
  public PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page);
}
