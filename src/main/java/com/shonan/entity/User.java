package com.shonan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
  private Long id;          //主键
  private String nickname;  //昵称
  private String userName;  //用户名
  private String password;
  private String email;
  private String avatar;    //头像
  private Integer type;     //用户的类型（博主/普通用户）
  private Date createTime;  //创建时间
  private Date updateTime;  //更新时间
  List<Blog> blogList = new ArrayList<>();  //用户的blog 多方是关系的维护方

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

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public List<Blog> getBlogList() {
    return blogList;
  }

  public void setBlogList(List<Blog> blogList) {
    this.blogList = blogList;
  }
}
