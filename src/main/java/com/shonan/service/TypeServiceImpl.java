package com.shonan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shonan.entity.Type;
import com.shonan.exception.NotFoundException;
import com.shonan.mapper.TypeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
  @Autowired
  private TypeMapper typeMapper;
  /*@Override
  public Type saveType(Type type) {
    return typeMapper.saveType(type);
  }*/
  @Override
  @Transactional
  public int saveType(Type type) {
    return typeMapper.saveType(type);
  }

  @Override
  public Type getType(Long id) {
    return typeMapper.getType(id);
  }

  @Override
  public List<Type> getAllType() {
    return typeMapper.getAllType();
  }

  @Override
  @Transactional
  public int updateType(Long id, Type type) {
    Type t = typeMapper.getType(id);
    if(t == null) {
      throw new NotFoundException("不存在该分类");
    }
    return typeMapper.updateType(id, type);
  }
  /*@Override
  public Type updateType(Long id, Type type) {
    Type type1 = typeMapper.getType(id);
    if(type1 == null) {
      throw new NotFoundException("不存在该分类");
    }
    BeanUtils.copyProperties(type, type1);
    return typeMapper.updateType(id, type);
  }*/

  @Override
  @Transactional
  public void deleteType(Long id) {
    typeMapper.deleteType(id);
  }

  @Override
  public List<Type> typeListTop() {
    return typeMapper.getTopType();
  }

  @Override
  public Long typeCount() {
    return typeMapper.typeCount();
  }
}
