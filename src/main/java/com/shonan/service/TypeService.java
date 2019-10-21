package com.shonan.service;

import com.shonan.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
  //Type saveType(Type type);
  public int saveType(Type type);

  public Type getType(Long Id);

  public List<Type> getAllType();

 /* Type updateType(Long id, Type type);*/
  public int updateType(Long id, Type type);
  public void deleteType(Long id);

  public List<Type> typeListTop();

  public Long typeCount();
}
