package com.hkd.service.impl;


import com.hkd.mapper.UserMapper;
import com.hkd.pojo.User;
import com.hkd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void register(String username, String password) {
        userMapper.insertUser(new User(null,username,password));
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectUserByNameAndPassword(username,password);
        return user;
    }
}
