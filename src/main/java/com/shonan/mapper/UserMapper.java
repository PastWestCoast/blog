package com.shonan.mapper;

import com.shonan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("SELECT * FROM t_user WHERE username=#{username} and password=#{password}")
  User findByUsernameAndPassword(@Param("username") String username, @Param("password")String password);
}
