/*
package com.shonan.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ArchiveMapper {

    @Select("select archiveName from t_archives order by a_id desc")
    List<String> findArchives();

    @Insert("insert into t_archives(archiveName) values(#{archiveName})")
    void addArchiveName(@Param("archiveName") String archiveName);

    @Select("select IFNULL(max(a_id), 0) from t_archives where archiveName=#{archiveName}")
    int findArchiveNameByArchiveName(@Param("archiveName") String archiveName);
}
*/
