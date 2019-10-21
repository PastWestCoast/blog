package com.shonan.mapper;

import com.shonan.entity.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {
  /*@Insert("Insert into t_type(id, name) VALUES(99, #{name})")
  Type saveType(Type type);*/
  @Insert("Insert into t_type set name=#{name}")
  int saveType(Type type);

  @Select("select * from t_type where id = #{id}")
  Type getType(Long id);

//  @Select("select * from t_type")
  List<Type> getAllType();

  List<Type> getTopType();
  /*@Update("update t_type set name = #{name} where id=#{id}")
  Type updateType(Long id, Type type);*/
  //这里咬写type.name，为什么？
  @Update("update t_type set name=#{type.name} where id=#{id}")
  int updateType(Long id, Type type);

  @Delete("delete from t_type where id=#{id}")
  void deleteType(Long id);

  @Select("select Count(*) from t_type")
  Long typeCount();
}
