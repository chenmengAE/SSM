package com.hkd.service;

import com.hkd.pojo.User;

public interface UserService {
   public void register(String username,String password);

    User login(String username, String password);
}
