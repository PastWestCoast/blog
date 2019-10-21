package com.shonan.mapper;

import com.shonan.entity.BlogLink;
import com.shonan.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BlogLinkMapper {
    int insert(BlogLink record);

    int deleteByPrimaryKey(Integer linkId);

    int insertSelective(BlogLink record);

    BlogLink selectByPrimaryKey(Integer linkId);

    int updateByPrimaryKeySelective(BlogLink record);

    int updateByPrimaryKey(BlogLink record);

    List<BlogLink> findLinkList(PageQueryUtil pageUtil);

    int getTotalLinks(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);
}