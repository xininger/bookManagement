package com.aaa.service.impl;

import com.aaa.service.UserService;
import com.aaa.domain.User;
import com.aaa.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Dear Zhang
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2023-03-10 11:30:25
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public int regist(String username, String password) {
        return userMapper.regist(username,password);
    }
}
