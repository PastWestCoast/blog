package com.shonan.mapper;

import com.shonan.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface TagMapper {

  @Transactional
  public int saveTag(Tag tag);

  @Transactional
  public int deleteTagById(Long id);

  @Transactional
  @Update("UPDATE t_tag SET name=#{tag.tagName} where id=#{id}")
  public int updateTag(Long id, Tag tag);

  public Tag getTagById(Long id);

  public List<Tag> getAllTag();


  //-------------------先不做
  public List<Long> getTagIdByTagsName(@Param("tagNames") String[] tagNames);

  public int saveTags2ArticleTag(@Param("tagIds") List<Long> tagIds, @Param("aid") Long aid);
}
