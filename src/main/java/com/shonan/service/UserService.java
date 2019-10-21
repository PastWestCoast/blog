package com.shonan.service;

import com.shonan.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
  User checkUser(String username, String password);
}
