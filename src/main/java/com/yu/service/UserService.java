package com.yu.service;

import com.yu.dao.UserMapper;
import com.yu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User SelectUserById(int userId) {
        return userMapper.SelectUserById(userId);
    }

    public User SelectUserByName(String userName) {
        return userMapper.SelectUserByName(userName);
    }

    public String SelectNickName(String userName){
        return userMapper.SelectNickName(userName);
    }

    public int InsertUser(User user){
        return userMapper.InsertUser(user);
    }

}
