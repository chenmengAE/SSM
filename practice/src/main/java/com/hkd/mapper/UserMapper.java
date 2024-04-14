package com.hkd.mapper;

import com.hkd.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    void insertUser(User user);

    User selectUserByNameAndPassword(@Param("userName") String username, @Param("password") String password);



}
