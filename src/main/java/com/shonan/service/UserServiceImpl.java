package com.shonan.service;

import com.shonan.entity.User;
import com.shonan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public User checkUser(String username, String password) {
    User user = userMapper.findByUsernameAndPassword(username, password);
    return user;
  }
}
