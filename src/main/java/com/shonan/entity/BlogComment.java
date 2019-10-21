package com.shonan.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BlogComment {
//  private Long id;
//  private String nickname;  //昵称
//  private String content;   //评论内容
//  private String avatar;    //头像(图片的链接地址)
//  private Date createTime;  //评论时间
//  private Long blogId;
//  private List<BlogComment> replyComments = new ArrayList<BlogComment>();  //回复的评论
////  private Integer replyCommentId;
//  private BlogComment parentComment;    //父级评论
//  private Long parentCommentId;
//  private Boolean adminComment;

  private Long commentId;

  private Long blogId;

  private String commentator;

  private String email;

  private String websiteUrl;

  private String commentBody;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date commentCreateTime;

  private String commentatorIp;

  private String replyBody;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date replyCreateTime;

  private Byte commentStatus;

  private Byte isDeleted;

  /*public Boolean getAdminComment() {
    return adminComment;
  }

  public void setAdminComment(Boolean adminComment) {
    this.adminComment = adminComment;
  }

  public List<BlogComment> getReplyComments() {
    return replyComments;
  }

  public void setReplyComments(List<BlogComment> replyComments) {
    this.replyComments = replyComments;
  }

  public Integer getReplyCommentId() {
    return replyCommentId;
  }

  public void setReplyCommentId(Integer replyCommentId) {
    this.replyCommentId = replyCommentId;
  }

  public Long getParentCommentId() {
    return parentCommentId;
  }

  public void setParentCommentId(Long parentCommentId) {
    this.parentCommentId = parentCommentId;
  }

  public BlogComment getParentComment() {
    return parentComment;
  }

  public void setParentComment(BlogComment parentComment) {
    this.parentComment = parentComment;
  }

  public Blog getBlog() {
    return blog;
  }

  public void setBlog(Blog blog) {
    this.blog = blog;
  }

  public Long getBlogId() {
    return blogId;
  }

  public void setBlogId(Long blogId) {
    this.blogId = blogId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }*/
}
