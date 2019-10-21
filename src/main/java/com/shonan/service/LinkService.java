package com.shonan.service;

import com.shonan.entity.BlogLink;
import com.shonan.util.PageQueryUtil;
import com.shonan.util.PageResult;

import java.util.List;
import java.util.Map;

public interface LinkService {
    /**
     * 查询友链的分页数据
     * @param pageUtil
     */
    PageResult getBlogLinkPage(PageQueryUtil pageUtil);

    int getTotalLinks();

    Boolean saveLink(BlogLink link);

    BlogLink selectById(Integer id);

    Boolean updateLink(BlogLink tempLink);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回友链页面所需的所有数据
     */
    Map<Byte, List<BlogLink>> getLinksForLinkPage();
}
