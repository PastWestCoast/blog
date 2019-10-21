package com.shonan.entity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class Type {
  private Long id;          //主键
  @NotBlank(message = "分类名称不能为空")
  private String name;      //分类名称
  private List<Blog> blogList;
  public Type() {
  }
}
