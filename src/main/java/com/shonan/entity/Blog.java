package com.shonan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Blog {
  private Long id;
  private String title;
  //可懒加载此处
  private String content;               //博客内容
  private String flag;                  //转载/原创
  private Integer viewCount;            //浏览次数
  private Boolean appreciationSwitch;   //赞赏开关
  private Boolean shareStatementSwitch; //转载声明开关
  private Boolean commentSwitch;        //评论开关
  private Boolean publishSwitch;        //发布开关
  private Date createdTime;             //创建时间
  private Date updatedTime;             //更新时间
  private Long typeId;                  //分类id
  private String typeName;              //分类类型  一对多
  private List<BlogComment> commentList = new ArrayList<>();
  private String description;           //描述
  private Type type;
  private String types;
//  private int likes = 0;
  //private String firstPicture;          //首图
  /*private List<Tag> tagList = new ArrayList<>();  //多对多*/
  /*private Boolean recommendSwitch;      //推荐开关(是否)*/
  public Blog() {}

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public List<BlogComment> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<BlogComment> commentList) {
    this.commentList = commentList;
  }

/*  public List<Tag> getTagList() {
    return tagList;
  }

  public void setTagList(List<Tag> tagList) {
    this.tagList = tagList;
  }*/

  @Override
  public String toString() {
    return "Blog{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", flag='" + flag + '\'' +
            ", viewCount=" + viewCount +
            ", appreciationSwitch=" + appreciationSwitch +
            ", shareStatementSwitch=" + shareStatementSwitch +
            ", commentSwitch=" + commentSwitch +
            ", publishSwitch=" + publishSwitch +
            ", createdTime=" + createdTime +
            ", updatedTime=" + updatedTime +
            '}';
  }

  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Integer getViewCount() {
    return viewCount;
  }

  public void setViewCount(Integer viewCount) {
    this.viewCount = viewCount;
  }

  public Boolean getAppreciationSwitch() {
    return appreciationSwitch;
  }

  public void setAppreciationSwitch(Boolean appreciationSwitch) {
    this.appreciationSwitch = appreciationSwitch;
  }

  public Boolean getShareStatementSwitch() {
    return shareStatementSwitch;
  }

  public void setShareStatementSwitch(Boolean shareStatementSwitch) {
    this.shareStatementSwitch = shareStatementSwitch;
  }

  public Boolean getCommentSwitch() {
    return commentSwitch;
  }

  public void setCommentSwitch(Boolean commentSwitch) {
    this.commentSwitch = commentSwitch;
  }

  public Boolean getPublishSwitch() {
    return publishSwitch;
  }

  public void setPublishSwitch(Boolean publishSwitch) {
    this.publishSwitch = publishSwitch;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
